/**
 * @author aaron [at] aaronhastings [dot] me
 */

package mapreduce.app;

import java.io.File;
import java.util.Iterator;
import java.util.Map;
import javax.swing.JFileChooser;

public class MapReduceGUI extends javax.swing.JFrame {
    
    JFileChooser fileChooser;
    MapReduce mapReduce;
    Map<String, Map<String, Integer>> mapReduceOutput;
    Iterator iterator;

    public MapReduceGUI() {
        initComponents();
        fileChooser = new JFileChooser();
        fileChooser.setMultiSelectionEnabled(true);
        mapReduce = new MapReduce();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        browseButton = new javax.swing.JButton();
        filesToReduceScrollPane = new javax.swing.JScrollPane();
        filesToReduceTextArea = new javax.swing.JTextArea();
        filesToReduceLabel = new javax.swing.JLabel();
        mapReduceOutputScrollPane = new javax.swing.JScrollPane();
        mapReduceOutputTextArea = new javax.swing.JTextArea();
        mapReduceOutputLabel = new javax.swing.JLabel();
        searchButton = new javax.swing.JButton();
        searchTextField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        browseButton.setFont(new java.awt.Font("Arial", 0, 15)); // NOI18N
        browseButton.setText("Browse...");
        browseButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                browseButtonActionPerformed(evt);
            }
        });

        filesToReduceTextArea.setColumns(20);
        filesToReduceTextArea.setRows(5);
        filesToReduceScrollPane.setViewportView(filesToReduceTextArea);

        filesToReduceLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        filesToReduceLabel.setText("Files to reduce");

        mapReduceOutputTextArea.setColumns(20);
        mapReduceOutputTextArea.setLineWrap(true);
        mapReduceOutputTextArea.setRows(5);
        mapReduceOutputScrollPane.setViewportView(mapReduceOutputTextArea);

        mapReduceOutputLabel.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        mapReduceOutputLabel.setText("MapReduce output");

        searchButton.setText("Search");
        searchButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(mapReduceOutputScrollPane)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(mapReduceOutputLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(filesToReduceLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(browseButton))
                            .addComponent(filesToReduceScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 343, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(0, 261, Short.MAX_VALUE)
                                .addComponent(searchButton))
                            .addComponent(searchTextField))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(filesToReduceLabel)
                    .addComponent(browseButton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(filesToReduceScrollPane, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(searchButton)))
                .addGap(18, 18, 18)
                .addComponent(mapReduceOutputLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(mapReduceOutputScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_browseButtonActionPerformed
        int returnVal = fileChooser.showOpenDialog(MapReduceGUI.this);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            for (File f : fileChooser.getSelectedFiles()) {
                mapReduceOutput = mapReduce.mapReduce(f);
                filesToReduceTextArea.append("Reduced: " + f.getName() + "\n");
            }

//            mapReduceOutput = mapReduce.mapReduce(fileChooser.getSelectedFiles());
            mapReduceOutputTextArea.setText(mapReduceOutput.toString());
        }
    }//GEN-LAST:event_browseButtonActionPerformed

    private void searchButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchButtonActionPerformed
        mapReduceOutputTextArea.setText("");
        
        for (Map.Entry<String, Map<String, Integer>> entry : mapReduceOutput.entrySet()) {
            if (entry.getKey().contains(searchTextField.getText())) {
                mapReduceOutputTextArea.append(entry.getKey() + " => " + entry.getValue() + "\n");
            }
        }
    }//GEN-LAST:event_searchButtonActionPerformed

    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MapReduceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MapReduceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MapReduceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MapReduceGUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MapReduceGUI().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton browseButton;
    private javax.swing.JLabel filesToReduceLabel;
    private javax.swing.JScrollPane filesToReduceScrollPane;
    private javax.swing.JTextArea filesToReduceTextArea;
    private javax.swing.JLabel mapReduceOutputLabel;
    private javax.swing.JScrollPane mapReduceOutputScrollPane;
    private javax.swing.JTextArea mapReduceOutputTextArea;
    private javax.swing.JButton searchButton;
    private javax.swing.JTextField searchTextField;
    // End of variables declaration//GEN-END:variables
}
