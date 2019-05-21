/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.UserController;
//import MCModels.User;
import java.awt.Color;
import javax.swing.JOptionPane;
import keeptoo.Drag;

/**
 *
 * @author DELL
 */
public class LoginMCView extends javax.swing.JFrame {

    UserController uc = new UserController();
    
    /**
     * Creates new form LoginMCView
     */
    public LoginMCView() {
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

        kLoginPanel = new keeptoo.KGradientPanel();
        usernameTextField = new javax.swing.JTextField();
        userPasswordField = new javax.swing.JPasswordField();
        userNameLabel = new javax.swing.JLabel();
        userNameLabel1 = new javax.swing.JLabel();
        kLoginBtn = new keeptoo.KButton();
        kSignUpBtn = new keeptoo.KButton();
        exitBtn = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kLoginPanel.setkEndColor(new java.awt.Color(123, 239, 178));
        kLoginPanel.setkStartColor(new java.awt.Color(1, 50, 67));
        kLoginPanel.setMinimumSize(new java.awt.Dimension(380, 280));
        kLoginPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kLoginPanelMouseDragged(evt);
            }
        });
        kLoginPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kLoginPanelMousePressed(evt);
            }
        });
        kLoginPanel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kLoginPanelKeyPressed(evt);
            }
        });
        kLoginPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameTextField.setBackground(new Color (0,0,0,0));
        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        usernameTextField.setCaretColor(new java.awt.Color(0, 204, 153));
        usernameTextField.setOpaque(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        kLoginPanel.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 170, 280, -1));

        userPasswordField.setBackground(new Color (0,0,0,0));
        userPasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        userPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        userPasswordField.setOpaque(false);
        kLoginPanel.add(userPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 250, 280, -1));

        userNameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userNameLabel.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel.setText("password");
        kLoginPanel.add(userNameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 220, -1, -1));

        userNameLabel1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        userNameLabel1.setForeground(new java.awt.Color(255, 255, 255));
        userNameLabel1.setText("username");
        kLoginPanel.add(userNameLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(180, 140, -1, -1));

        kLoginBtn.setText("Log In");
        kLoginBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kLoginBtn.setkBackGroundColor(new java.awt.Color(104, 195, 163));
        kLoginBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kLoginBtn.setkHoverStartColor(new java.awt.Color(104, 175, 163));
        kLoginBtn.setkIndicatorColor(new java.awt.Color(104, 195, 163));
        kLoginBtn.setkSelectedColor(new java.awt.Color(104, 195, 163));
        kLoginBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kLoginBtnActionPerformed(evt);
            }
        });
        kLoginPanel.add(kLoginBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 310, 130, 40));

        kSignUpBtn.setText("Sign Up");
        kSignUpBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        kSignUpBtn.setkBackGroundColor(new java.awt.Color(104, 195, 163));
        kSignUpBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kSignUpBtn.setkHoverStartColor(new java.awt.Color(104, 175, 163));
        kSignUpBtn.setkIndicatorColor(new java.awt.Color(104, 195, 163));
        kSignUpBtn.setkSelectedColor(new java.awt.Color(104, 195, 163));
        kSignUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kSignUpBtnActionPerformed(evt);
            }
        });
        kLoginPanel.add(kSignUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 310, 130, 40));

        exitBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        exitBtn.setkBackGroundColor(new java.awt.Color(236, 100, 75));
        exitBtn.setkEndColor(new java.awt.Color(236, 100, 75));
        exitBtn.setkHoverEndColor(new java.awt.Color(236, 100, 75));
        exitBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        exitBtn.setkHoverStartColor(new java.awt.Color(236, 100, 75));
        exitBtn.setkIndicatorColor(new java.awt.Color(236, 100, 75));
        exitBtn.setkPressedColor(new java.awt.Color(217, 30, 24));
        exitBtn.setkSelectedColor(new java.awt.Color(217, 30, 24));
        exitBtn.setkStartColor(new java.awt.Color(236, 100, 75));
        exitBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitBtnActionPerformed(evt);
            }
        });
        kLoginPanel.add(exitBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 20, 20));

        getContentPane().add(kLoginPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void kLoginBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kLoginBtnActionPerformed
        // TODO add your handling code here:
        String email = this.usernameTextField.getText();
        String pass = new String(this.userPasswordField.getPassword());
        
        boolean res = uc.checkLogin(email,pass);
        
        if(res)
        {
            JOptionPane.showMessageDialog(null, "Login successful");
            new mainForm().setVisible(true);
            this.dispose();
            
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Something is wrong");
        }
    }//GEN-LAST:event_kLoginBtnActionPerformed

    private void kSignUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kSignUpBtnActionPerformed
        // TODO add your handling code here:
        new SignUpMCView().setVisible(true);
        this.dispose();
    }//GEN-LAST:event_kSignUpBtnActionPerformed

    private void kLoginPanelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kLoginPanelKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_kLoginPanelKeyPressed

    private void kLoginPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kLoginPanelMouseDragged
        // TODO add your handling code here:
        new Drag(kLoginPanel).moveWindow(evt);
    }//GEN-LAST:event_kLoginPanelMouseDragged

    private void kLoginPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kLoginPanelMousePressed
        // TODO add your handling code here:
        
        new Drag(kLoginPanel).onPress(evt);

    }//GEN-LAST:event_kLoginPanelMousePressed

    private void exitBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_exitBtnActionPerformed

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
            java.util.logging.Logger.getLogger(LoginMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(LoginMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(LoginMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(LoginMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SignUpMCView().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private keeptoo.KButton exitBtn;
    private keeptoo.KButton kLoginBtn;
    private keeptoo.KGradientPanel kLoginPanel;
    private keeptoo.KButton kSignUpBtn;
    private javax.swing.JLabel userNameLabel;
    private javax.swing.JLabel userNameLabel1;
    private javax.swing.JPasswordField userPasswordField;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
