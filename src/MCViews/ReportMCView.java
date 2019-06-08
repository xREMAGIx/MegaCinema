/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.SellReportController;
import MCModels.SellReport;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

import javax.swing.JOptionPane;

import org.jfree.ui.ApplicationFrame;

import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.table.DefaultTableModel;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;
import jxl.write.WriteException;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.jfree.data.general.PieDataset;
import org.jfree.ui.ApplicationFrame;
import org.jfree.ui.RefineryUtilities;

/**
 *
 * @author USER
 */

class PieChart_AWT extends JFrame{
    public PieChart_AWT( String title, int product, int ticket ) {
      super( title ); 
      setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

//      addWindowListener(new WindowAdapter(){
//          @Override
//            public void windowClosing(WindowEvent e) {
//                setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
//                
//            }
//      } );
      setContentPane(createDemoPanel(product,ticket));
   }
   
   private static PieDataset createDataset( int product, int ticket) {
      DefaultPieDataset dataset = new DefaultPieDataset( );
      dataset.setValue( "Product" , new Double( product ) );  
      dataset.setValue( "Ticket" , new Double( ticket ) );   
//      dataset.setValue( "MotoG" , new Double( 40 ) );    
//      dataset.setValue( "Nokia Lumia" , new Double( 10 ) );  
      return dataset;         
   }
   
   private static JFreeChart createChart( PieDataset dataset ) {
      JFreeChart chart = ChartFactory.createPieChart(      
         "Total Sales",   // chart title 
         dataset,          // data    
         true,             // include legend   
         true, 
         false);

      return chart;
   }
   
   public static JPanel createDemoPanel( int product, int ticket ) {
      JFreeChart chart = createChart(createDataset(product, ticket) );
      
      return new ChartPanel( chart ); 
   }

   public static void main( String[ ] args ) {
//      PieChart_AWT demo = new PieChart_AWT( "Mobile Sales" );  
//      demo.setSize( 560 , 367 );    
//      RefineryUtilities.centerFrameOnScreen( demo );    
//      demo.setVisible( true ); 
   }
}
public class ReportMCView extends javax.swing.JFrame {

    SellReportController rc = new SellReportController();
    List <SellReport> temp= new ArrayList <> ();
    /**
     * Creates new form ReportMCView
     */
    public ReportMCView() {
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

        dtEnd = new com.github.lgooddatepicker.components.DateTimePicker();
        dtBegin = new com.github.lgooddatepicker.components.DateTimePicker();
        btOK = new javax.swing.JButton();
        txtProduct = new javax.swing.JTextField();
        txtTicket = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbReport = new javax.swing.JTable();
        btExcel = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        txtTotal = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        btOK.setText("OK");
        btOK.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btOKActionPerformed(evt);
            }
        });

        txtProduct.setEditable(false);
        txtProduct.setText("0");

        txtTicket.setEditable(false);
        txtTicket.setText("0");

        jLabel1.setText("Product");

        jLabel2.setText("Ticket");

        tbReport.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "ID", "Date", "Product", "Ticket"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tbReport);

        btExcel.setText("EXCEL");
        btExcel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcelActionPerformed(evt);
            }
        });

        jLabel3.setText("Total");

        txtTotal.setEditable(false);
        txtTotal.setText("0");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btOK)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtBegin, javax.swing.GroupLayout.PREFERRED_SIZE, 335, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(txtProduct)
                                    .addComponent(txtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(88, 88, 88)
                                        .addComponent(btExcel, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 202, Short.MAX_VALUE))))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(dtBegin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)
                        .addComponent(dtEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42)
                        .addComponent(btOK))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtProduct, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtTicket, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btExcel))
                .addGap(55, 55, 55))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btOKActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btOKActionPerformed
        // TODO add your handling code here:
        
        DefaultTableModel model = (DefaultTableModel) tbReport.getModel();
        
        SimpleDateFormat pFormatter=new SimpleDateFormat("yyyy-MM-dd");
        
        String datebegin ="";
        datebegin+=dtBegin.datePicker.getDateStringOrEmptyString()+" ";
        
        String dateend ="";
        dateend+=dtEnd.datePicker.getDateStringOrEmptyString()+" ";
        
        
        Object rowData[] = new Object[4];
        
        try {
            temp = rc.loadAPeriod(pFormatter.parse(datebegin), pFormatter.parse(dateend));
        } catch (ParseException ex) {
            Logger.getLogger(ReportMCView.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (int i=0; i<temp.size(); i++){
           txtProduct.setText(Integer.toString( Integer.parseInt(txtProduct.getText()) + temp.get(i).getProductTotal() ));
           txtTicket.setText(Integer.toString( Integer.parseInt(txtTicket.getText()) + temp.get(i).getTicketTotal() ));
           
           rowData[0] = temp.get(i).getId();    
            rowData[1] = temp.get(i).getReportDay();
            rowData[2] = temp.get(i).getProductTotal();
            rowData[3] = temp.get(i).getTicketTotal();
            model.addRow(rowData);
        }
        txtTotal.setText(Integer.toString(Integer.parseInt(txtProduct.getText())+ Integer.parseInt(txtTicket.getText())));
        
      PieChart_AWT demo = new PieChart_AWT( "Total Sales", Integer.parseInt(txtProduct.getText()), Integer.parseInt(txtTicket.getText())); 
   
      demo.setSize( 560 , 367 );   
      demo.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);

      RefineryUtilities.centerFrameOnScreen( demo );  
      demo.setVisible( true );
    }//GEN-LAST:event_btOKActionPerformed

    private void btExcelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcelActionPerformed
        // TODO add your handling code here:
        try {
            WritableWorkbook workbook;
            
            Date date = new Date();
            String filename = "Report"+date.getTime()+".xls";
            File f = new File(filename);
            f.createNewFile();
            workbook = Workbook.createWorkbook(f);
            WritableSheet sheet1 = workbook.createSheet("RP", 0);

            try {
                sheet1.addCell(new Label(0, 0, "REPORT"));
                
                sheet1.addCell(new Label(0, 1, "Number of bill"));
                sheet1.addCell(new Label(1, 1, temp.size() + ""));
                sheet1.addCell(new Label(0, 2, "Total income"));
                sheet1.addCell(new Label(1, 2, txtTotal.getText() + ""));
                sheet1.addCell(new Label(0, 3, "ID"));
                sheet1.addCell(new Label(1, 3, "Date"));
                sheet1.addCell(new Label(2, 3, "Product Money"));
                sheet1.addCell(new Label(3, 3, "Ticket Money"));
                

                SimpleDateFormat pFormatter=new SimpleDateFormat("yyyy-MM-dd");
                
                for (int i = 0; i < temp.size(); i++) {
                    String id = Integer.toString(temp.get(i).getId());
                    String time = pFormatter.format(temp.get(i).getReportDay());
                    String product = Integer.toString(temp.get(i).getProductTotal());
                    String ticket = Integer.toString(temp.get(i).getTicketTotal());
                    

                    int row = i + 4;
                    sheet1.addCell(new Label(0, row, id));
                    sheet1.addCell(new Label(1, row, time));
                    sheet1.addCell(new Label(2, row, product));
                    sheet1.addCell(new Label(3, row, ticket));

                }
                workbook.write();
                workbook.close();
                JOptionPane.showMessageDialog(this, "Đã xuất ra file Excel "+filename);
            } catch (WriteException ex) {
                Logger.getLogger(ReportMCView.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(ReportMCView.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (IOException ex) {
            Logger.getLogger(ReportMCView.class.getName()).log(Level.SEVERE, null, ex);
        }

    }//GEN-LAST:event_btExcelActionPerformed

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
            java.util.logging.Logger.getLogger(ReportMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ReportMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ReportMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ReportMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ReportMCView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btExcel;
    private javax.swing.JButton btOK;
    private com.github.lgooddatepicker.components.DateTimePicker dtBegin;
    private com.github.lgooddatepicker.components.DateTimePicker dtEnd;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbReport;
    private javax.swing.JTextField txtProduct;
    private javax.swing.JTextField txtTicket;
    private javax.swing.JTextField txtTotal;
    // End of variables declaration//GEN-END:variables
}
