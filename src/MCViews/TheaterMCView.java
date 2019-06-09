/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.MovieController;
import MCControllers.TheaterController;
import MCModels.Movie;
import MCModels.Theater;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class TheaterMCView extends javax.swing.JFrame {

    /**
     * Creates new form TheaterMCView
     */
    TheaterController theaterC = new TheaterController();
    //MovieController mc = new MovieController();
    int act = 0;
    boolean tableRowClicked = false;

    public TheaterMCView() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        theaterTable = new javax.swing.JTable();
        addBtn = new javax.swing.JButton();
        modifyBtn = new javax.swing.JButton();
        deleteBtn = new javax.swing.JButton();
        refreshBtn = new javax.swing.JButton();
        javax.swing.JPanel addPanel = new javax.swing.JPanel();
        theaterNameTextField = new javax.swing.JTextField();
        nameText = new javax.swing.JLabel();
        rowText = new javax.swing.JLabel();
        theaterRowTextField = new javax.swing.JTextField();
        availableRB = new javax.swing.JRadioButton();
        notAvailableRB = new javax.swing.JRadioButton();
        statusText = new javax.swing.JLabel();
        saveBtn = new javax.swing.JButton();
        colText = new javax.swing.JLabel();
        theaterColTextField = new javax.swing.JTextField();
        searchTextField = new javax.swing.JTextField();
        searchBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        theaterTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Name", "Seat Rows", "Seat Columns", "Status"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        theaterTable.setColumnSelectionAllowed(true);
        theaterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        theaterTable.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane1.setViewportView(theaterTable);
        theaterTable.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);

        addBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/addIcon32px.png"))); // NOI18N
        addBtn.setText("Add");
        addBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addBtnActionPerformed(evt);
            }
        });

        modifyBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/modifyIcon32px.png"))); // NOI18N
        modifyBtn.setText("Modify");
        modifyBtn.setToolTipText("");
        modifyBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modifyBtnActionPerformed(evt);
            }
        });

        deleteBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/deleteIcon32px.png"))); // NOI18N
        deleteBtn.setText("Delete");
        deleteBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteBtnActionPerformed(evt);
            }
        });

        refreshBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/refeshIcon32px.png"))); // NOI18N
        refreshBtn.setText("Refresh");
        refreshBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshBtnActionPerformed(evt);
            }
        });

        nameText.setText("Name");

        rowText.setText("Seat Rows");

        availableRB.setText("Available");

        notAvailableRB.setText("Not Available");

        statusText.setText("Status");

        saveBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/saveIcon32px.png"))); // NOI18N
        saveBtn.setText("Save");
        saveBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveBtnActionPerformed(evt);
            }
        });

        colText.setText("Seat Columns");

        javax.swing.GroupLayout addPanelLayout = new javax.swing.GroupLayout(addPanel);
        addPanel.setLayout(addPanelLayout);
        addPanelLayout.setHorizontalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, addPanelLayout.createSequentialGroup()
                                .addComponent(nameText)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(theaterNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(addPanelLayout.createSequentialGroup()
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rowText)
                                    .addComponent(statusText))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(theaterRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(addPanelLayout.createSequentialGroup()
                                        .addComponent(availableRB)
                                        .addGap(36, 36, 36)
                                        .addComponent(notAvailableRB))))))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(colText)
                        .addGap(18, 18, 18)
                        .addComponent(theaterColTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(addPanelLayout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addComponent(saveBtn)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        addPanelLayout.setVerticalGroup(
            addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(addPanelLayout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nameText)
                    .addComponent(theaterNameTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rowText)
                    .addComponent(theaterRowTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(colText)
                    .addComponent(theaterColTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(addPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(statusText)
                    .addComponent(availableRB)
                    .addComponent(notAvailableRB))
                .addGap(32, 32, 32)
                .addComponent(saveBtn)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        searchTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        searchBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/searchIcon32px.png"))); // NOI18N
        searchBtn.setText("Search");
        searchBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 267, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(searchBtn))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(addBtn)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(modifyBtn)
                        .addGap(14, 14, 14)
                        .addComponent(deleteBtn)
                        .addGap(18, 18, 18)
                        .addComponent(refreshBtn))
                    .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 593, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(searchTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchBtn))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(addBtn)
                    .addComponent(modifyBtn)
                    .addComponent(deleteBtn)
                    .addComponent(refreshBtn))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(addPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void addBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addBtnActionPerformed
        // TODO add your handling code here:
        //JLayeredPane layeredP = (JLayeredPane) LayeredPane.getLayer();
        theaterNameTextField.setEditable(true);
        theaterRowTextField.setEditable(true);
        theaterColTextField.setEditable(true);

        theaterNameTextField.setText("");
        theaterRowTextField.setText("");
        theaterColTextField.setText("");

        act = 1;  //tell save button to act add
    }//GEN-LAST:event_addBtnActionPerformed

    private void modifyBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modifyBtnActionPerformed
        // TODO add your handling code here:
        if (tableRowClicked == true) {
            theaterNameTextField.setEditable(true);
            theaterRowTextField.setEditable(true);
            theaterColTextField.setEditable(true);

            theaterNameTextField.setText(theaterTable.getValueAt(theaterTable.getSelectedRow(), 1).toString());
            theaterRowTextField.setText(theaterTable.getValueAt(theaterTable.getSelectedRow(), 2).toString());
            theaterColTextField.setText(theaterTable.getValueAt(theaterTable.getSelectedRow(), 3).toString());

            act = 2;  //tell save button to save info modify
        } else {
            JOptionPane.showMessageDialog(null, "Please select a movie");
        }
    }//GEN-LAST:event_modifyBtnActionPerformed

    private void deleteBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteBtnActionPerformed
        // TODO add your handling code here:

        if (tableRowClicked == true) {
            int id = (int) theaterTable.getValueAt(theaterTable.getSelectedRow(), 0);
            int res = theaterC.Delete(id);
            int check = JOptionPane.showConfirmDialog(jScrollPane1, "Are you sure delete this theater?", "Delete", JOptionPane.YES_NO_OPTION);
            if (check == JOptionPane.YES_OPTION) {
                if (res > 0) {
                    JOptionPane.showMessageDialog(null, "Deleted successfully");
                } else if (res == 0) {
                    JOptionPane.showMessageDialog(null, "Unable to delete");
                }

                refreshBtnActionPerformed(evt);
                act = 0;
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a theater");
        }
    }//GEN-LAST:event_deleteBtnActionPerformed

    private void refreshBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshBtnActionPerformed
        // TODO add your handling code here:

        theaterTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) theaterTable.getModel();

        model.setRowCount(0);   //clear data table

        List<Theater> theaterList = theaterC.selectAll();
        Object rowData[] = new Object[5];

        for (int i = 0; i < theaterList.size(); i++) {
            rowData[0] = theaterList.get(i).getId();
            rowData[1] = theaterList.get(i).getName();
            rowData[2] = theaterList.get(i).getRowCount();
            rowData[3] = theaterList.get(i).getRowCount();
            rowData[4] = theaterList.get(i).getStatus();
            model.addRow(rowData);
        }

        theaterNameTextField.setEditable(false);
        theaterRowTextField.setEditable(false);
        theaterColTextField.setEditable(false);

        tableRowClicked = false;

        theaterTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {

                theaterNameTextField.setEditable(false);
                theaterRowTextField.setEditable(false);
                theaterColTextField.setEditable(false);

            }
        });
    }//GEN-LAST:event_refreshBtnActionPerformed

    private void saveBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveBtnActionPerformed
        // TODO add your handling code here:
        if (act == 1) //save add info
        {
            int status;
            if (availableRB.isSelected() == true) {
                status = 0;
            } else {
                status = 1;
            }

            Theater theater = new Theater();

//            movie.setName(movieNameTextField.getText());
//            movie.setDuration(Integer.parseInt(movieDurTextField.getText()));
//            movie.setStatus(status);
            theater.setName(theaterNameTextField.getText());
            theater.setRowCount(Integer.parseInt(theaterRowTextField.getText()));
            theater.setColCount(Integer.parseInt(theaterRowTextField.getText()));
            theater.setStatus(status);

            int res = theaterC.add(theater);
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Saved - add new info");
            } else {
                JOptionPane.showMessageDialog(null, "Unable to save");
            }
            refreshBtnActionPerformed(evt);
            act = 0;
            theaterNameTextField.setEditable(false);
            theaterRowTextField.setEditable(false);
            theaterColTextField.setEditable(false);

        } else if (act == 2) //save modify info
        {
            int id = (int) theaterTable.getValueAt(theaterTable.getSelectedRow(), 0);
            System.out.println("id: " + id);
            String name = theaterNameTextField.getText();
            //int dur = Integer.parseInt(movieDurTextField.getText());
            int row = Integer.parseInt(theaterRowTextField.getText());
            int col = Integer.parseInt(theaterColTextField.getText());

            int status;
            if (availableRB.isSelected() == true) {
                status = 0;
            } else {
                status = 1;
            }

//            Movie movie = new Movie();
//            movie.setId(id);
//            movie.setName(name);
//            movie.setDuration(dur);
//            movie.setStatus(status);
//            movie.setImage(imageFile);
            Theater theater = new Theater();

            theater.setName(theaterNameTextField.getText());
            theater.setRowCount(Integer.parseInt(theaterRowTextField.getText()));
            theater.setColCount(Integer.parseInt(theaterRowTextField.getText()));
            theater.setStatus(status);

            int res = theaterC.modify(theater);
            if (res > 0) {
                JOptionPane.showMessageDialog(null, "Saved info changed");
            } else {
                JOptionPane.showMessageDialog(null, "Unable to save");
            }

            refreshBtnActionPerformed(evt);
            act = 0;
            theaterNameTextField.setEditable(false);
            theaterRowTextField.setEditable(false);
            theaterColTextField.setEditable(false);

        }
    }//GEN-LAST:event_saveBtnActionPerformed

    private void searchBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchBtnActionPerformed
        // TODO add your handling code here:
        theaterTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) theaterTable.getModel();

        model.setRowCount(0);   //clear data table
        List<Theater> theaterList = theaterC.select("theaterName like '%" + searchTextField.getText() + "%'");
        Object rowData[] = new Object[5];

        for (int i = 0; i < theaterList.size(); i++) {
            rowData[0] = theaterList.get(i).getId();
            rowData[1] = theaterList.get(i).getName();
            rowData[2] = theaterList.get(i).getRowCount();
            rowData[3] = theaterList.get(i).getColCount();
            rowData[4] = theaterList.get(i).getStatus();
            model.addRow(rowData);
        }

        theaterTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {
                theaterNameTextField.setEditable(false);
                theaterRowTextField.setEditable(false);
                theaterColTextField.setEditable(false);

            }
        });
    }//GEN-LAST:event_searchBtnActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        refreshBtnActionPerformed(null);
    }//GEN-LAST:event_formComponentShown

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(TheaterMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(TheaterMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(TheaterMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(TheaterMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TheaterMCView().setVisible(true);
            }

        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addBtn;
    private javax.swing.JRadioButton availableRB;
    private javax.swing.JLabel colText;
    private javax.swing.JButton deleteBtn;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton modifyBtn;
    private javax.swing.JLabel nameText;
    private javax.swing.JRadioButton notAvailableRB;
    private javax.swing.JButton refreshBtn;
    private javax.swing.JLabel rowText;
    private javax.swing.JButton saveBtn;
    private javax.swing.JButton searchBtn;
    private javax.swing.JTextField searchTextField;
    private javax.swing.JLabel statusText;
    private javax.swing.JTextField theaterColTextField;
    private javax.swing.JTextField theaterNameTextField;
    private javax.swing.JTextField theaterRowTextField;
    private javax.swing.JTable theaterTable;
    // End of variables declaration//GEN-END:variables
}
