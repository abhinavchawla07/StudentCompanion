/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;
import java.awt.Color;
import java.sql.*;

import javax.swing.JOptionPane;

/**
 *
 * @author anmol singh sethi
 */
public class admin_window extends javax.swing.JFrame {

    /**
     * Creates new form admin_window
     */
    public admin_window() {
        initComponents();
    this.setSize(792,547);
    this.setBackground(Color.white);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        tf_password = new javax.swing.JPasswordField();
        bt_login = new javax.swing.JButton();
        tf_username = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));
        setBounds(new java.awt.Rectangle(0, 0, 200, 200));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        jPanel2.setBackground(new java.awt.Color(51, 51, 51));
        jPanel2.setAutoscrolls(true);
        jPanel2.setLayout(null);

        tf_password.setBackground(new java.awt.Color(51, 51, 51));
        tf_password.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        tf_password.setForeground(new java.awt.Color(255, 255, 255));
        tf_password.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        tf_password.setCaretColor(new java.awt.Color(52, 175, 35));
        tf_password.setSelectionColor(new java.awt.Color(52, 175, 35));
        tf_password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_passwordActionPerformed(evt);
            }
        });
        jPanel2.add(tf_password);
        tf_password.setBounds(180, 210, 270, 80);

        bt_login.setBackground(new java.awt.Color(255, 255, 255));
        bt_login.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        bt_login.setForeground(new java.awt.Color(102, 102, 102));
        bt_login.setText("LOGIN");
        bt_login.setBorder(new javax.swing.border.MatteBorder(null));
        bt_login.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bt_loginActionPerformed(evt);
            }
        });
        jPanel2.add(bt_login);
        bt_login.setBounds(90, 390, 320, 80);
        bt_login.getAccessibleContext().setAccessibleName("Login");

        tf_username.setBackground(new java.awt.Color(51, 51, 51));
        tf_username.setFont(new java.awt.Font("Lato", 0, 18)); // NOI18N
        tf_username.setForeground(new java.awt.Color(255, 255, 255));
        tf_username.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(255, 255, 255)));
        tf_username.setCaretColor(new java.awt.Color(52, 175, 38));
        tf_username.setSelectionColor(new java.awt.Color(52, 175, 35));
        tf_username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tf_usernameActionPerformed(evt);
            }
        });
        jPanel2.add(tf_username);
        tf_username.setBounds(180, 110, 270, 60);

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("PASSWORD");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(10, 240, 140, 37);

        jLabel2.setBackground(new java.awt.Color(255, 255, 255));
        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("USERNAME");
        jPanel2.add(jLabel2);
        jLabel2.setBounds(10, 130, 140, 35);

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Lucida Bright", 1, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("LOGIN WINDOW");
        jPanel2.add(jLabel1);
        jLabel1.setBounds(210, 20, 200, 51);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(130, 0, 1140, 780);

        jPanel3.setBackground(new java.awt.Color(0, 0, 0));
        jPanel3.setLayout(null);
        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 0, 310, 780);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bt_loginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bt_loginActionPerformed
        String username=tf_username.getText();
        String password=tf_password.getText();
        if(username.isEmpty()||password.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter Credentials!");
            
                    }
        try {
             Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");
            
            Connection conn = DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");
            
            Statement stmt = conn.createStatement
        (ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");
            
            ResultSet rs = stmt.executeQuery("select * from admin_login where username='"+username+"' and password='"+password+"'");
            if(rs.next())
            {
                JOptionPane.showMessageDialog(this, "Login Successful");
                adminhome adh=new adminhome(username);
                adh.setVisible(true);
                dispose();
                
            }
            else
                JOptionPane.showMessageDialog(this, "Login Failed!");
            
        } catch (Exception e) {
        }
        
// TODO add your handling code here:
    }//GEN-LAST:event_bt_loginActionPerformed

    private void tf_usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_usernameActionPerformed

    private void tf_passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tf_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tf_passwordActionPerformed

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
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_window.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_window().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bt_login;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField tf_password;
    private javax.swing.JTextField tf_username;
    // End of variables declaration//GEN-END:variables
}