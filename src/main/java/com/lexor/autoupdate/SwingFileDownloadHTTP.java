/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.lexor.autoupdate;

import java.awt.event.ActionEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListModel;
import javax.swing.JOptionPane;

/**
 *
 * @author vinh
 */
public class SwingFileDownloadHTTP extends javax.swing.JPanel implements
        PropertyChangeListener{

    List<String> _urls;
    /**
     * Creates new form SwingFileDownloadHTTP
     */
    public SwingFileDownloadHTTP() {
        initComponents();
    }

    public SwingFileDownloadHTTP(List<String> urls) {
        this();
        _urls = urls;
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jLabel1 = new javax.swing.JLabel();
        fieldURL = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        txtSaveInDir = new javax.swing.JTextField();
        buttonDownload = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        fieldFileName = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        fieldFileSize = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        progressBar = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        lstLog = new javax.swing.JList<>();

        setLayout(new java.awt.GridBagLayout());

        jLabel1.setLabelFor(fieldURL);
        jLabel1.setText("Download URL:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.1;
        add(jLabel1, gridBagConstraints);

        fieldURL.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        gridBagConstraints.weightx = 0.8;
        add(fieldURL, gridBagConstraints);

        jLabel2.setLabelFor(txtSaveInDir);
        jLabel2.setText("Save in directory:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel2, gridBagConstraints);

        txtSaveInDir.setEditable(false);
        txtSaveInDir.setText(".");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(txtSaveInDir, gridBagConstraints);

        buttonDownload.setText("Download");
        buttonDownload.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDownloadActionPerformed(evt);
            }
        });
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 2;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(buttonDownload, gridBagConstraints);

        jLabel3.setLabelFor(fieldFileName);
        jLabel3.setText("File name:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel3, gridBagConstraints);

        fieldFileName.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(fieldFileName, gridBagConstraints);

        jLabel4.setLabelFor(fieldFileSize);
        jLabel4.setText("File size (bytes):");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 4;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel4, gridBagConstraints);

        fieldFileSize.setEditable(false);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 4;
        gridBagConstraints.gridwidth = java.awt.GridBagConstraints.RELATIVE;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        add(fieldFileSize, gridBagConstraints);

        jLabel5.setText("Progress:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.EAST;
        add(jLabel5, gridBagConstraints);
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 5;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.insets = new java.awt.Insets(2, 0, 2, 0);
        add(progressBar, gridBagConstraints);

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        jLabel6.setText("Log:");
        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.NORTH;
        add(jLabel6, gridBagConstraints);

        lstLog.setModel(new DefaultListModel());
        jScrollPane1.setViewportView(lstLog);

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 6;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weighty = 1.0;
        add(jScrollPane1, gridBagConstraints);
    }// </editor-fold>//GEN-END:initComponents

    private void clearLog() {
        DefaultListModel listModel = (DefaultListModel) lstLog.getModel();
        listModel.removeAllElements();
    }
    private void buttonDownloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonDownloadActionPerformed
        
        String saveDir = txtSaveInDir.getText();
        
        // validate input first
        if (_urls==null || _urls.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please enter download URL!",
                    "Error", JOptionPane.ERROR_MESSAGE);
            fieldURL.requestFocus();
            return;
        }
 
        if (saveDir.equals("")) {
            JOptionPane.showMessageDialog(this,
                    "Please choose a directory save file!", "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        clearLog();
        
        try {
            progressBar.setValue(0);
 
            DownloadTask task = new DownloadTask(this, _urls, saveDir);
            task.addPropertyChangeListener(this);
            task.execute();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this,
                    "Error executing upload task: " + ex.getMessage(), "Error",
                    JOptionPane.ERROR_MESSAGE);
        }   
    }//GEN-LAST:event_buttonDownloadActionPerformed

    @Override
    public void propertyChange(PropertyChangeEvent evt) {
        if (evt.getPropertyName().equals("progress")) {
            int progress = (Integer) evt.getNewValue();
            progressBar.setValue(progress);
        }
    }

   
 
    void setFileInfo(String name, int size) {
        fieldFileName.setText(name);
        fieldFileSize.setText(String.valueOf(size));
    }
    
    void setUrl(String value) {
        this.fieldURL.setText(value);
    }
    void addLog(String value){
        try{
            DefaultListModel dlm = (DefaultListModel)lstLog.getModel();
            dlm.addElement(value);
            
        }catch(Exception ex){
            Logger.getLogger(SwingFileDownloadHTTP.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDownload;
    private javax.swing.JTextField fieldFileName;
    private javax.swing.JTextField fieldFileSize;
    private javax.swing.JTextField fieldURL;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JList<String> lstLog;
    private javax.swing.JProgressBar progressBar;
    private javax.swing.JTextField txtSaveInDir;
    // End of variables declaration//GEN-END:variables
}
