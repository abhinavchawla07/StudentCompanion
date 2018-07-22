
package studentcompanion;

import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class changepasswordclient extends javax.swing.JInternalFrame {

    String rollno;
    DataOutputStream dos;
    public changepasswordclient(String rollno,DataOutputStream dos) {
        initComponents();
        this.dos = dos;
        this.rollno = rollno;
    }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pfold = new javax.swing.JPasswordField();
        pfnew = new javax.swing.JPasswordField();
        pfconfirm = new javax.swing.JPasswordField();
        btchange = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Old password");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(53, 47, 173, 49);

        jLabel2.setText("New password");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(53, 188, 110, 45);

        jLabel3.setText("Confirm password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(53, 290, 134, 51);
        getContentPane().add(pfold);
        pfold.setBounds(324, 47, 186, 49);
        getContentPane().add(pfnew);
        pfnew.setBounds(324, 172, 186, 42);
        getContentPane().add(pfconfirm);
        pfconfirm.setBounds(324, 290, 203, 51);

        btchange.setText("Change");
        btchange.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btchangeActionPerformed(evt);
            }
        });
        getContentPane().add(btchange);
        btchange.setBounds(257, 381, 177, 51);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btchangeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btchangeActionPerformed
        String oldp = pfold.getText();
        String newp = pfnew.getText();
        String confirmp = pfconfirm.getText();
        
        if(oldp.equals("") || newp.isEmpty() || confirmp.isEmpty())
        {
            JOptionPane.showMessageDialog(rootPane, "Enter all fields required");
        }
        else if(!newp.equals(confirmp))
        {
            JOptionPane.showMessageDialog(rootPane, "Please watch the input");
        }
        else
        {
            try {
                dos.writeBytes("change password request\r\n");
                dos.writeBytes(rollno+"\r\n");
                dos.writeBytes(oldp+"\r\n");
                dos.writeBytes(newp+"\r\n");
            } catch (IOException ex) {
                Logger.getLogger(changepasswordclient.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        

    }//GEN-LAST:event_btchangeActionPerformed

    
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
            java.util.logging.Logger.getLogger(changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(changepasswordclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
//                new changepasswordclient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btchange;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPasswordField pfconfirm;
    private javax.swing.JPasswordField pfnew;
    private javax.swing.JPasswordField pfold;
    // End of variables declaration//GEN-END:variables
}
