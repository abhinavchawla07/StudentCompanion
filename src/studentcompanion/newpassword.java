/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

/**
 *
 * @author anmol singh sethi
 */
public class newpassword extends javax.swing.JInternalFrame {

    /**
     * Creates new form newpassword
     */
    String username;
    public newpassword( String user) {
        initComponents();
         username=user;
        tfuser.setText(user);
//        this.setSize(500,500);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        tfnew = new javax.swing.JPasswordField();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        tfuser = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        tfold = new javax.swing.JPasswordField();
        jLabel4 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        tfconf = new javax.swing.JPasswordField();
        update = new javax.swing.JButton();

        getContentPane().setLayout(null);

        jLabel2.setFont(new java.awt.Font("Lucida Bright", 0, 36)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Welcome");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(90, 10, 370, 50);
        getContentPane().add(tfnew);
        tfnew.setBounds(280, 232, 300, 50);

        jPanel1.setBackground(new java.awt.Color(0, 153, 153));
        jPanel1.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Username");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(50, 70, 170, 60);

        tfuser.setEditable(false);
        tfuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfuserActionPerformed(evt);
            }
        });
        jPanel1.add(tfuser);
        tfuser.setBounds(280, 70, 300, 50);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(0, 0, 810, 140);

        jPanel2.setBackground(new java.awt.Color(0, 204, 204));
        jPanel2.setLayout(null);

        jLabel3.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Old Password");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(40, 30, 180, 40);

        tfold.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfoldActionPerformed(evt);
            }
        });
        jPanel2.add(tfold);
        tfold.setBounds(280, 20, 300, 50);

        jLabel4.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("New Password");
        jPanel2.add(jLabel4);
        jLabel4.setBounds(40, 100, 200, 40);

        getContentPane().add(jPanel2);
        jPanel2.setBounds(0, 140, 800, 170);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Confirm Password");
        jPanel3.add(jLabel5);
        jLabel5.setBounds(0, 10, 240, 60);

        tfconf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tfconfActionPerformed(evt);
            }
        });
        jPanel3.add(tfconf);
        tfconf.setBounds(280, 20, 300, 50);

        update.setBackground(new java.awt.Color(204, 255, 255));
        update.setFont(new java.awt.Font("Lucida Bright", 0, 24)); // NOI18N
        update.setText("Change");
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update);
        update.setBounds(130, 140, 400, 60);

        getContentPane().add(jPanel3);
        jPanel3.setBounds(0, 300, 870, 330);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed
        String oldpass = tfold.getText();  
        String newpass = tfnew.getText();  
        String confpass = tfconf.getText();
        if(oldpass.isEmpty()|| newpass.isEmpty() || confpass.isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Enter the fields you moron");
           tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
        }
        else
        {
             try
             {
              Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");
            
            Connection conn = DriverManager.getConnection
        ("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");
            
            Statement stmt = conn.createStatement
        (ResultSet.TYPE_SCROLL_SENSITIVE,
                ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");
            
            ResultSet rs = stmt.executeQuery("select * from admin_login where username='"+username+"' and password='"+oldpass+"'");

            if(!newpass.equals(confpass))
            {
             JOptionPane.showMessageDialog(this,"Passwords don't match");   
             tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
            }
            else if(oldpass.equals(newpass))
            {
                JOptionPane.showMessageDialog(this,"Passwords cannot be same as before");
                tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
            }
            else if(rs.next())
                 {
                    // rs.moveToInsertRow();
                     rs.updateString("password", newpass);
                     rs.updateRow();
                     JOptionPane.showMessageDialog(this,"Password Changed Succesfully");
                     dispose();
                     
                 }
                 else
                 {
                     JOptionPane.showMessageDialog(this,"old password not corect");
                     tfold.setText("");
             tfnew.setText("");
             tfconf.setText("");
                 }
                 
                 
             }catch(Exception e)
              {
                 
             }}
// TODO add your handling code here:
    }//GEN-LAST:event_updateActionPerformed
    
    private void tfoldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfoldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfoldActionPerformed

    private void tfuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfuserActionPerformed

    private void tfconfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tfconfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tfconfActionPerformed

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
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(newpassword.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new newpassword().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField tfconf;
    private javax.swing.JPasswordField tfnew;
    private javax.swing.JPasswordField tfold;
    private javax.swing.JTextField tfuser;
    private javax.swing.JButton update;
    // End of variables declaration//GEN-END:variables
}
