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
public class add_dept extends javax.swing.JInternalFrame {

    /**
     * Creates new form add_dept
     */
    public add_dept() {
        initComponents();
        setSize(600, 600);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        tfdept = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tfdesc = new javax.swing.JTextArea();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Department");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(47, 71, 90, 49);

        jLabel2.setText("Description");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(47, 184, 114, 47);
        getContentPane().add(tfdept);
        tfdept.setBounds(190, 80, 310, 80);

        tfdesc.setColumns(20);
        tfdesc.setRows(5);
        jScrollPane1.setViewportView(tfdesc);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(190, 184, 310, 200);

        jButton1.setText("Add Department");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(190, 400, 310, 90);

        jLabel3.setText("ADD DEPARTMENT");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 20, 270, 40);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        String department = tfdept.getText();
        String description = tfdesc.getText();
        if (department.isEmpty() || description.isEmpty()) {
                JOptionPane.showMessageDialog(rootPane,"Fill all credentials, bitch!!");
        } else {
                    
            try {
                Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");

                Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");

                Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                        ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");

                ResultSet rs = stmt.executeQuery("select * from departments where department ='" + department + "'");
                if (rs.next()) {
                        JOptionPane.showMessageDialog(rootPane,"Department already exists \nEnter new Department");
                        tfdesc.setText("");
                        tfdept.setText("");
                } else {
                    rs.moveToInsertRow();
                    rs.updateString("department", department);
                    rs.updateString("description", description);
                    rs.insertRow();
                    JOptionPane.showMessageDialog(rootPane, "Department added successfully");
                    dispose();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(add_dept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(add_dept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(add_dept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(add_dept.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new add_dept().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField tfdept;
    private javax.swing.JTextArea tfdesc;
    // End of variables declaration//GEN-END:variables
}