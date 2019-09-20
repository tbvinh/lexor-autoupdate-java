/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lexor.autoupdate;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.JOptionPane;
import javax.swing.SwingWorker;

/**
 * Execute file download in a background thread and update the progress.
 *
 * @author www.codejava.net
 *
 */
public class DownloadTask extends SwingWorker<Void, Void> {

    private static final int BUFFER_SIZE = 4096;
    private List<String> _urls;
    private String saveDirectory;
    private SwingFileDownloadHTTP gui;

    public DownloadTask(SwingFileDownloadHTTP gui, List<String> urls, String saveDirectory) {
        this.gui = gui;
        this._urls = urls;
        this.saveDirectory = saveDirectory;
    }

    /**
     * Executed in background thread
     */
    @Override
    protected Void doInBackground() throws Exception {
        
        try {
            
            HTTPDownloadUtil util = new HTTPDownloadUtil();

            
            for (String url : _urls) {
                util.downloadFile(url);

                // set file information on the GUI
                gui.setFileInfo(util.getFileName(), util.getContentLength());
                gui.setUrl(url);
                gui.addLog(url);
                        
                String saveFilePath = saveDirectory + File.separator + util.getFileName();

                InputStream inputStream = util.getInputStream();
                // opens an output stream to save into file
                FileOutputStream outputStream = new FileOutputStream(saveFilePath);

                byte[] buffer = new byte[BUFFER_SIZE];
                int bytesRead = -1;
                long totalBytesRead = 0;
                int percentCompleted = 0;
                long fileSize = util.getContentLength();
                
                
                
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    outputStream.write(buffer, 0, bytesRead);
                    totalBytesRead += bytesRead;
                    percentCompleted = (int) (totalBytesRead * 100 / fileSize);

                    setProgress(percentCompleted);
                }

                outputStream.close();
            }
            util.disconnect();
            setProgress(0);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(gui, "Error downloading file: " + ex.getMessage(),
                    "Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(DownloadTask.class.getName()).log(Level.SEVERE, null, ex);
            setProgress(0);
            cancel(true);
        }
        return null;
    }

    /**
     * Executed in Swing's event dispatching thread
     */
    @Override
    protected void done() {
        if (!isCancelled()) {
            JOptionPane.showMessageDialog(gui,
                    "File has been downloaded successfully!", "Message",
                    JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
