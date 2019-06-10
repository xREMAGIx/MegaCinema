/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.BillFoodController;
import MCControllers.EmployeeController;
import MCControllers.FoodDetailController;
import MCControllers.SaleController;
import MCControllers.SaleItemController;
import MCControllers.ScheduleController;
import MCControllers.SeatController;
import MCControllers.StorageController;
import MCControllers.TheaterController;
import MCControllers.TicketController;
import MCModels.BillFood;
import MCModels.FoodDetail;
import MCModels.Sale;
import MCModels.SaleItem;
import MCModels.Storage;
import MCModels.Theater;
import MCModels.Ticket;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author DELL
 */
public class TransactionHistoryView extends javax.swing.JFrame {

    SaleController saleC = new SaleController();
    int ticketIdClicked = -1;
    int billIdClicked = -2;

    /**
     * Creates new form TransactionHistoryView
     */
    public TransactionHistoryView() {
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

        beginDateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        tabPanel = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        ticketTable = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        productTable = new javax.swing.JTable();
        endDateTimePicker = new com.github.lgooddatepicker.components.DateTimePicker();
        okBtn = new javax.swing.JButton();
        detailTabPanel = new javax.swing.JTabbedPane();
        jScrollPane2 = new javax.swing.JScrollPane();
        ticketDetailTable = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        productDetailTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Transaction History");
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tabPanel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ticketTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Employee ", "Time", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ticketTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ticketTableComponentShown(evt);
            }
        });
        jScrollPane1.setViewportView(ticketTable);

        tabPanel.addTab("Ticket Sale", jScrollPane1);

        productTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "cinemaId", "Time", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                productTableComponentShown(evt);
            }
        });
        jScrollPane4.setViewportView(productTable);

        tabPanel.addTab("Product Sale", jScrollPane4);

        okBtn.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/okIcon32px.png"))); // NOI18N
        okBtn.setText("OK");
        okBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                okBtnActionPerformed(evt);
            }
        });

        detailTabPanel.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N

        ticketDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Theater", "Schedule Time", "Seat Row Pos", "Seat Column Pos", "Price"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        ticketDetailTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                ticketDetailTableComponentShown(evt);
            }
        });
        jScrollPane2.setViewportView(ticketDetailTable);

        detailTabPanel.addTab("Ticket Detail", jScrollPane2);

        productDetailTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Product", "Quantity", "Price", "Total"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        productDetailTable.addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                productDetailTableComponentShown(evt);
            }
        });
        jScrollPane3.setViewportView(productDetailTable);

        detailTabPanel.addTab("Product Bill Detail", jScrollPane3);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(tabPanel)
                    .addComponent(detailTabPanel)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addComponent(beginDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)
                        .addComponent(endDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(49, 49, 49)
                        .addComponent(okBtn)
                        .addGap(0, 104, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(beginDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(endDateTimePicker, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(okBtn))
                .addGap(18, 18, 18)
                .addComponent(tabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(detailTabPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 215, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ticketTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ticketTableComponentShown
        // TODO add your handling code here:
        ticketTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) ticketTable.getModel();

        model.setRowCount(0);   //clear data table

        beginDateTimePicker.timePicker.setEnabled(false);
        endDateTimePicker.timePicker.setEnabled(false);

        SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd");

        String datebegin = "";
        datebegin += beginDateTimePicker.datePicker.getDateStringOrEmptyString() + " ";

        String dateend = "";
        dateend += endDateTimePicker.datePicker.getDateStringOrEmptyString() + " ";

        List<Sale> saleList = null;
        try {
            saleList = saleC.select("time >= '" + pFormatter.format(pFormatter.parse(datebegin)) + "' and time <= '" + pFormatter.format(pFormatter.parse(dateend)) + "'");
        } catch (ParseException ex) {
            Logger.getLogger(TransactionHistoryView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object rowData[] = new Object[4];

        for (int i = 0; i < saleList.size(); i++) {
            rowData[0] = saleList.get(i).getId();
            rowData[1] = new EmployeeController().Fetch("id=" + saleList.get(i).getEmpId()).get(0).getName();
            rowData[2] = saleList.get(i).getTime();
            rowData[3] = saleList.get(i).getPayment() - saleList.get(i).getChange();
            model.addRow(rowData);
        }

        ticketTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {

                ticketIdClicked = Integer.parseInt(ticketTable.getValueAt(ticketTable.getSelectedRow(), 0).toString());
                ticketDetailTableComponentShown(null);
            }
        });

    }//GEN-LAST:event_ticketTableComponentShown

    private void okBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_okBtnActionPerformed
        // TODO add your handling code here:
        ticketTableComponentShown(null);
        productTableComponentShown(null);
    }//GEN-LAST:event_okBtnActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        beginDateTimePicker.timePicker.setEnabled(false);
        endDateTimePicker.timePicker.setEnabled(false);
    }//GEN-LAST:event_formComponentShown

    private void productTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_productTableComponentShown
        // TODO add your handling code here:
        productTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) productTable.getModel();

        model.setRowCount(0);   //clear data table

        beginDateTimePicker.timePicker.setEnabled(false);
        endDateTimePicker.timePicker.setEnabled(false);

        SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd");

        String datebegin = "";
        datebegin += beginDateTimePicker.datePicker.getDateStringOrEmptyString() + " ";

        String dateend = "";
        dateend += endDateTimePicker.datePicker.getDateStringOrEmptyString() + " ";

        List<BillFood> billFoodList = null;
        try {
            billFoodList = new BillFoodController().Select("Time >= '" + pFormatter.format(pFormatter.parse(datebegin)) + "' and Time <= '" + pFormatter.format(pFormatter.parse(dateend)) + "'");
        } catch (ParseException ex) {
            Logger.getLogger(TransactionHistoryView.class.getName()).log(Level.SEVERE, null, ex);
        }
        Object rowData[] = new Object[4];

        for (int i = 0; i < billFoodList.size(); i++) {
            rowData[0] = billFoodList.get(i).getId();
            rowData[1] = billFoodList.get(i).getCinemaId();
            rowData[2] = billFoodList.get(i).getTime();
            rowData[3] = billFoodList.get(i).getTotal();
            model.addRow(rowData);
        }
        
        productTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {

                billIdClicked = Integer.parseInt(productTable.getValueAt(productTable.getSelectedRow(), 0).toString());
                productDetailTableComponentShown(null);
            }
        });
    }//GEN-LAST:event_productTableComponentShown

    private void ticketDetailTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_ticketDetailTableComponentShown
        // TODO add your handling code here:
        ticketDetailTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) ticketDetailTable.getModel();

        model.setRowCount(0);   //clear data table

        List<Ticket> ticketList = new LinkedList<Ticket>();

        List<SaleItem> saleItemList = new SaleItemController().select("saleId=" + ticketIdClicked);
        for (int i = 0; i < saleItemList.size(); i++) {
            ticketList.add(new TicketController().select("id=" + saleItemList.get(i).getTicketId()).get(0));
        }

        Object rowData[] = new Object[5];

        for (int i = 0; i < ticketList.size(); i++) {

            rowData[0] = new TheaterController().select("theaterId=" + (new ScheduleController().select(
                    "schedId=" + ticketList.get(i).getScheduleId()).get(0)).getTheaterId()).get(0).getName();

            rowData[1] = new ScheduleController().select("schedId=" + ticketList.get(i).getScheduleId()).get(0).getTime();

            rowData[2] = new SeatController().select("seatId=" + ticketList.get(i).getSeatId()).get(0).getRow();
            rowData[3] = new SeatController().select("seatId=" + ticketList.get(i).getSeatId()).get(0).getColumn();

            rowData[4] = ticketList.get(i).getPrice();
            //rowData[3] = ticketList.get(i).getPayment() - saleList.get(i).getChange();
            model.addRow(rowData);
        }

        ticketDetailTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {

            }
        });
    }//GEN-LAST:event_ticketDetailTableComponentShown

    private void productDetailTableComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_productDetailTableComponentShown
        // TODO add your handling code here:

        productDetailTable.clearSelection();

        DefaultTableModel model = (DefaultTableModel) productDetailTable.getModel();

        model.setRowCount(0);   //clear data table       

        List<FoodDetail> foodDetailList = new FoodDetailController().Select("billId = " + billIdClicked);
//        for (int i = 0; i < foodDetailList.size(); i++) {
//            foodDetailList.add(new FoodController().Select("id=" + saleItemList.get(i).getTicketId()).get(0));
//        }

        Object rowData[] = new Object[4];

        for (int i = 0; i < foodDetailList.size(); i++) {

            rowData[0] = new StorageController().Select("storageId=" + foodDetailList.get(i).getProductId()).get(0).getProductName();
            rowData[1] = foodDetailList.get(i).getPrice();
            rowData[2] = foodDetailList.get(i).getQuantity();
            rowData[3] = foodDetailList.get(i).getPrice() * foodDetailList.get(i).getQuantity();

            model.addRow(rowData);
        }

        ticketDetailTable.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent event) {

            }
        });
    }//GEN-LAST:event_productDetailTableComponentShown

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(TransactionHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransactionHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransactionHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransactionHistoryView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TransactionHistoryView().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.github.lgooddatepicker.components.DateTimePicker beginDateTimePicker;
    private javax.swing.JTabbedPane detailTabPanel;
    private com.github.lgooddatepicker.components.DateTimePicker endDateTimePicker;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JButton okBtn;
    private javax.swing.JTable productDetailTable;
    private javax.swing.JTable productTable;
    private javax.swing.JTabbedPane tabPanel;
    private javax.swing.JTable ticketDetailTable;
    private javax.swing.JTable ticketTable;
    // End of variables declaration//GEN-END:variables
}
