/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package MCViews;

import MCControllers.UserController;

import java.awt.Color;
import javax.swing.JOptionPane;
import keeptoo.Drag;

/**
 *
 * @author DELL
 */
public class SignUpMCView extends javax.swing.JFrame {

    
    UserController uc = new UserController();
   
    /**
     * Creates new form SignUpMCView
     */
    public SignUpMCView() {
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

        kSignUpPanel = new keeptoo.KGradientPanel();
        usernameLabel = new javax.swing.JLabel();
        emailLabel = new javax.swing.JLabel();
        passwordLabel = new javax.swing.JLabel();
        emailTextField = new javax.swing.JTextField();
        usernameTextField = new javax.swing.JTextField();
        userPasswordField = new javax.swing.JPasswordField();
        signUpBtn = new keeptoo.KButton();
        signUpBtn1 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kSignUpPanel.setkEndColor(new java.awt.Color(123, 239, 178));
        kSignUpPanel.setkStartColor(new java.awt.Color(1, 50, 67));
        kSignUpPanel.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                kSignUpPanelMouseDragged(evt);
            }
        });
        kSignUpPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                kSignUpPanelMousePressed(evt);
            }
        });
        kSignUpPanel.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        usernameLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        usernameLabel.setForeground(new java.awt.Color(255, 255, 255));
        usernameLabel.setText("username");
        kSignUpPanel.add(usernameLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 100, -1, -1));

        emailLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        emailLabel.setForeground(new java.awt.Color(255, 255, 255));
        emailLabel.setText("email");
        kSignUpPanel.add(emailLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 170, -1, -1));

        passwordLabel.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        passwordLabel.setForeground(new java.awt.Color(255, 255, 255));
        passwordLabel.setText("password");
        kSignUpPanel.add(passwordLabel, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 240, -1, -1));

        emailTextField.setBackground(new Color(0,0,0,0));
        emailTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        emailTextField.setForeground(new java.awt.Color(255, 255, 255));
        emailTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        emailTextField.setOpaque(false);
        emailTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailTextFieldActionPerformed(evt);
            }
        });
        kSignUpPanel.add(emailTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, 280, -1));

        usernameTextField.setBackground(new Color(0,0,0,0));
        usernameTextField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        usernameTextField.setForeground(new java.awt.Color(255, 255, 255));
        usernameTextField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        usernameTextField.setOpaque(false);
        usernameTextField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameTextFieldActionPerformed(evt);
            }
        });
        kSignUpPanel.add(usernameTextField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 100, 280, -1));

        userPasswordField.setBackground(new Color(0,0,0,0));
        userPasswordField.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        userPasswordField.setForeground(new java.awt.Color(255, 255, 255));
        userPasswordField.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 2, 0, new java.awt.Color(255, 255, 255)));
        userPasswordField.setOpaque(false);
        kSignUpPanel.add(userPasswordField, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 240, 280, -1));

        signUpBtn.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signUpBtn.setkBackGroundColor(new java.awt.Color(236, 100, 75));
        signUpBtn.setkEndColor(new java.awt.Color(236, 100, 75));
        signUpBtn.setkHoverEndColor(new java.awt.Color(236, 100, 75));
        signUpBtn.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        signUpBtn.setkHoverStartColor(new java.awt.Color(236, 100, 75));
        signUpBtn.setkIndicatorColor(new java.awt.Color(236, 100, 75));
        signUpBtn.setkPressedColor(new java.awt.Color(217, 30, 24));
        signUpBtn.setkSelectedColor(new java.awt.Color(217, 30, 24));
        signUpBtn.setkStartColor(new java.awt.Color(236, 100, 75));
        signUpBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtnActionPerformed(evt);
            }
        });
        kSignUpPanel.add(signUpBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 20, 20, 20));

        signUpBtn1.setText("Sign Up");
        signUpBtn1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        signUpBtn1.setkBackGroundColor(new java.awt.Color(104, 195, 163));
        signUpBtn1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        signUpBtn1.setkHoverStartColor(new java.awt.Color(104, 175, 163));
        signUpBtn1.setkIndicatorColor(new java.awt.Color(104, 195, 163));
        signUpBtn1.setkSelectedColor(new java.awt.Color(104, 195, 163));
        signUpBtn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                signUpBtn1ActionPerformed(evt);
            }
        });
        kSignUpPanel.add(signUpBtn1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 310, 130, 40));

        getContentPane().add(kSignUpPanel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 600, 400));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void emailTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_emailTextFieldActionPerformed

    private void usernameTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameTextFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameTextFieldActionPerformed

    private void signUpBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtnActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_signUpBtnActionPerformed

    private void kSignUpPanelMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kSignUpPanelMouseDragged
        // TODO add your handling code here:
        new Drag(kSignUpPanel).moveWindow(evt);
        
    }//GEN-LAST:event_kSignUpPanelMouseDragged

    private void kSignUpPanelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_kSignUpPanelMousePressed
        // TODO add your handling code here:
        new Drag(kSignUpPanel).onPress(evt);
    }//GEN-LAST:event_kSignUpPanelMousePressed

    private void signUpBtn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_signUpBtn1ActionPerformed
        // TODO add your handling code here:
        String name = this.usernameTextField.getText();
        String email = this.emailTextField.getText();
        String password = new String(this.userPasswordField.getPassword());
        
        int res = uc.createAccount(name,email,password);
        
        if(res>0)
        {
            JOptionPane.showMessageDialog(null, "Saved");
            new LoginMCView().setVisible(true);
            this.dispose();
        }
        else
        {
            JOptionPane.showMessageDialog(null,"Unable to save");
        }
    }//GEN-LAST:event_signUpBtn1ActionPerformed

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
            java.util.logging.Logger.getLogger(SignUpMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SignUpMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SignUpMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SignUpMCView.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
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
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private keeptoo.KGradientPanel kSignUpPanel;
    private javax.swing.JLabel passwordLabel;
    private keeptoo.KButton signUpBtn;
    private keeptoo.KButton signUpBtn1;
    private javax.swing.JPasswordField userPasswordField;
    private javax.swing.JLabel usernameLabel;
    private javax.swing.JTextField usernameTextField;
    // End of variables declaration//GEN-END:variables
}
