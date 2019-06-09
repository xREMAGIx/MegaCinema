/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.BillFoodController;
import MCControllers.CinemaController;
import MCControllers.SellReportController;
import MCControllers.StorageController;
import MCControllers.UnitController;
import MCControllers.WarehouseController;
import MCModels.ArrayListComboBoxModel;
import MCModels.BillFood;
import MCModels.Cinema;
import MCModels.FoodDetail;
import MCModels.SellReport;
import MCModels.Storage;
import MCModels.Warehouse;
import static MCViews.mainForm.empIdM;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author USER
 */
public class SellProductMCView extends javax.swing.JFrame {

    FoodDetail fc = new FoodDetail();
    private BillFood bill = new BillFood();

    StorageController sc = new StorageController();
    CinemaController cinemaC = new CinemaController();
    UnitController uc = new UnitController();
    BillFoodController bc = new BillFoodController();
    SellReportController rc = new SellReportController();

    private List<String> cinemaList = new ArrayList<>();
    private List<String> productList = new ArrayList<>();
    private List<String> warehouseList = new ArrayList<>();
    private List<FoodDetail> purchaseList = new ArrayList<>();

    private ArrayListComboBoxModel modelCinema;
    private ArrayListComboBoxModel modelProduct;

    
    private final int empIdS = empIdM;

    /**
     * Creates new form SaleProductMCView
     */
    public SellProductMCView() {
        initComponents();
        loadProduct();
        loadCinema();
    }

    public void loadProduct() {
        List<Storage> tempP = null;
        tempP = sc.loadProducts();

        for (int i = 0; i < tempP.size(); i++) {
            productList.add(tempP.get(i).getProductName());
        }

        modelProduct = new ArrayListComboBoxModel((ArrayList<String>) productList);
//        modelStatus.setSelectedItem(modelStatus.getElementAt(0));
        cbProduct.setModel(modelProduct);
    }

    public void loadCinema() {
        WarehouseController warehouseC = new WarehouseController();
        List<Warehouse> temp = null;
        temp = warehouseC.loadWarehouses();

        for (int i = 0; i < temp.size(); i++) {
            warehouseList.add(Integer.toString(temp.get(i).getId()) + " - " + cinemaC.IDtoName(temp.get(i).getCinemaId()));
        }
        modelCinema = new ArrayListComboBoxModel((ArrayList<String>) warehouseList);
        modelCinema.setSelectedItem(modelCinema.getElementAt(0));
        cbCinema.setModel(modelCinema);
    }

    public boolean checkQuantity(int quan) {
        int warehouseId = cbCinema.getSelectedIndex() + 1;
        int storageId = cbProduct.getSelectedIndex() + 1;
        if (quan <= sc.SelectQuantity(storageId, warehouseId)) {
            return true;
        }
        return false;
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
        tbPurchase = new javax.swing.JTable();
        cbProduct = new javax.swing.JComboBox();
        txtPrice = new javax.swing.JTextField();
        txtQuantity = new javax.swing.JTextField();
        txtId = new javax.swing.JTextField();
        cbCinema = new javax.swing.JComboBox();
        dtTime = new com.github.lgooddatepicker.components.DateTimePicker();
        txtTotal = new javax.swing.JTextField();
        btAdd = new javax.swing.JButton();
        btCheckout = new javax.swing.JButton();
        totalLbl = new javax.swing.JLabel();
        productLbl = new javax.swing.JLabel();
        priceLbl = new javax.swing.JLabel();
        quantityLbl = new javax.swing.JLabel();
        dateTimeLbl = new javax.swing.JLabel();
        cinemaLbl = new javax.swing.JLabel();
        idLbl = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentShown(java.awt.event.ComponentEvent evt) {
                formComponentShown(evt);
            }
        });

        tbPurchase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Product", "Price", "Quantity"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbPurchase);

        cbProduct.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtId.setEditable(false);
        txtId.setText("ID");

        cbCinema.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        txtTotal.setEditable(false);
        txtTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        txtTotal.setText("0");

        btAdd.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/addIcon32px.png"))); // NOI18N
        btAdd.setText("Add");
        btAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAddActionPerformed(evt);
            }
        });

        btCheckout.setIcon(new javax.swing.ImageIcon(getClass().getResource("/MCImage/okIcon32px.png"))); // NOI18N
        btCheckout.setText("Checkout");
        btCheckout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCheckoutActionPerformed(evt);
            }
        });

        totalLbl.setText("Total");
        totalLbl.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N

        productLbl.setText("Product: ");

        priceLbl.setText("Price: ");

        quantityLbl.setText("Quantity:");

        dateTimeLbl.setText("Date & Time:");

        cinemaLbl.setText("Cinema:");

        idLbl.setText("ID:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(productLbl)
                                    .addComponent(priceLbl)
                                    .addComponent(quantityLbl))
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtQuantity)
                                    .addComponent(txtPrice, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(cbProduct, javax.swing.GroupLayout.Alignment.TRAILING, 0, 121, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(totalLbl)
                                    .addComponent(dateTimeLbl)
                                    .addComponent(cinemaLbl)
                                    .addComponent(idLbl))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtTime, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 297, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(cbCinema, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addContainerGap())
                    .addGroup(layout.createSequentialGroup()
                        .addGap(70, 70, 70)
                        .addComponent(btAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btCheckout)
                        .addGap(138, 138, 138))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(productLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtPrice, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(priceLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(quantityLbl))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 29, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btAdd)
                            .addComponent(btCheckout))
                        .addGap(33, 33, 33))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(idLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbCinema, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cinemaLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(dtTime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dateTimeLbl))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(totalLbl))
                        .addGap(94, 94, 94))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAddActionPerformed
        // TODO add your handling code here:
        DefaultTableModel model = (DefaultTableModel) tbPurchase.getModel();
        FoodDetail temp = new FoodDetail();
        temp.setId(fc.getNextID());
        temp.setBillId(bill.getId());
        temp.setPrice(Integer.parseInt(txtPrice.getText()));
        temp.setQuantity(Integer.parseInt(txtQuantity.getText()));
        temp.setProductId(cbProduct.getSelectedIndex() + 1);

        if (checkQuantity(temp.getQuantity())) {

            Object rowData[] = new Object[4];
            rowData[0] = temp.getId();
            rowData[1] = sc.IDtoName(temp.getProductId());
            rowData[2] = temp.getPrice();
            rowData[3] = temp.getQuantity();

            model.addRow(rowData);
            txtTotal.setText(Integer.toString(Integer.parseInt(txtTotal.getText()) + temp.getPrice() * temp.getQuantity()));

            purchaseList.add(temp);
        }
    }//GEN-LAST:event_btAddActionPerformed

    private void formComponentShown(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentShown
        // TODO add your handling code here:
        cbCinema.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tbPurchase.getModel();
                model.setRowCount(0);
                txtTotal.setText("0");

                // xoa list
//                throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        bill.setId(bc.getNextID());
        txtId.setText(Integer.toString(bill.getId()));
        dtTime.datePicker.setDateToToday();
        dtTime.datePicker.setEnabled(false);
        dtTime.timePicker.setTimeToNow();
        dtTime.timePicker.setEnabled(false);
        //dtTime.datePicker
    }//GEN-LAST:event_formComponentShown

    private void btCheckoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCheckoutActionPerformed
        // TODO add your handling code here:
        SellReport report = new SellReport();
        report.setId(rc.getNextID());
        report.setCinemaId(cbCinema.getSelectedIndex() + 1);
        report.setProductTotal(Integer.parseInt(txtTotal.getText()));

        for (int i = 0; i < purchaseList.size(); i++) {
            sc.AddQuantity(cbProduct.getSelectedIndex() + 1, cbCinema.getSelectedIndex() + 1, -purchaseList.get(i).getQuantity());
            fc.Insert(purchaseList.get(i));

        }

        SimpleDateFormat pFormatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat pFormatter2 = new SimpleDateFormat("yyyy-MM-dd");

        String datetime = "";
        datetime += dtTime.datePicker.getDateStringOrEmptyString() + " ";

        try {
            report.setReportDay(pFormatter2.parse(datetime));
        } catch (ParseException ex) {
            Logger.getLogger(SellProductMCView.class.getName()).log(Level.SEVERE, null, ex);
        }

        datetime += dtTime.timePicker.getTimeStringOrEmptyString() + ":00";

        try {
            bill.setTime(pFormatter.parse(datetime));
        } catch (ParseException ex) {
            Logger.getLogger(SellProductMCView.class.getName()).log(Level.SEVERE, null, ex);
        }

        bc.insertBillFood(bill.getId(), empIdS, cbCinema.getSelectedIndex() + 1, bill.getTime(), Integer.parseInt(txtTotal.getText()));

        if (rc.getCurDayID(report.getReportDay()) != -1) {
            rc.updateSellReport(rc.getCurDayID(report.getReportDay()), report.getProductTotal(), 0);
        } else {
            rc.insertSellReport(report.getId(), report.getCinemaId(), report.getReportDay(), report.getProductTotal(), 0);
        }

    }//GEN-LAST:event_btCheckoutActionPerformed

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
            java.util.logging.Logger.getLogger(SellProductMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SellProductMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SellProductMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SellProductMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SellProductMCView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAdd;
    private javax.swing.JButton btCheckout;
    private javax.swing.JComboBox cbCinema;
    private javax.swing.JComboBox cbProduct;
    private javax.swing.JLabel cinemaLbl;
    private javax.swing.JLabel dateTimeLbl;
    private com.github.lgooddatepicker.components.DateTimePicker dtTime;
    private javax.swing.JLabel idLbl;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel priceLbl;
    private javax.swing.JLabel productLbl;
    private javax.swing.JLabel quantityLbl;
    private javax.swing.JTable tbPurchase;
    private javax.swing.JLabel totalLbl;
    private javax.swing.JTextField txtId;
    private javax.swing.JTextField txtPrice;
    private javax.swing.JTextField txtQuantity;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
