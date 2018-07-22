/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package studentcompanion;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.Socket;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Dr Rakesh Chawala
 */
public class signupclient extends javax.swing.JFrame {

    /**
     * Creates new form signupclient
     */
    DataInputStream dis;
    DataOutputStream dos;
    public signupclient() {
        initComponents();
        cbdept.removeAllItems();
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from departments");
            while (rs.next()) {
                String deptname = rs.getString("department");
                cbdept.addItem(deptname);
            }
        } catch (Exception e) {

        }
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cbday = new javax.swing.JComboBox();
        cbmonth = new javax.swing.JComboBox();
        cbyear = new javax.swing.JComboBox();
        cbdept = new javax.swing.JComboBox();
        cbcourse = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tfrollno = new javax.swing.JTextField();
        tfname = new javax.swing.JTextField();
        tffname = new javax.swing.JTextField();
        tfphone = new javax.swing.JTextField();
        tfmail = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbmale = new javax.swing.JRadioButton();
        rbfemale = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        tfphoto = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        getContentPane().setLayout(null);

        jLabel1.setText("Enter Roll No");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(94, 53, 100, 14);

        jLabel2.setText("Enter Name");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(94, 105, 90, 14);

        jLabel3.setText("Enter Fathers name");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(94, 152, 95, 14);

        jLabel4.setText("Phone");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(94, 207, 30, 14);

        jLabel5.setText("Email");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(94, 261, 59, 14);

        jLabel6.setText("dob");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(94, 309, 35, 14);

        cbday.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        getContentPane().add(cbday);
        cbday.setBounds(153, 306, 37, 20);

        cbmonth.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "jan", "feb", "mar", "apr", "may", "jun", "jul", "aug", "sep", "oct", "nov", "dec" }));
        getContentPane().add(cbmonth);
        cbmonth.setBounds(245, 306, 45, 20);

        cbyear.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "97", "98", "99", "00", "01", "02", "03", "04", "05", "06" }));
        getContentPane().add(cbyear);
        cbyear.setBounds(348, 306, 37, 20);

        cbdept.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbdeptItemStateChanged(evt);
            }
        });
        getContentPane().add(cbdept);
        cbdept.setBounds(726, 66, 80, 20);

        cbcourse.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cbcourseItemStateChanged(evt);
            }
        });
        getContentPane().add(cbcourse);
        cbcourse.setBounds(726, 137, 80, 20);

        jLabel7.setText("Department");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(574, 69, 77, 14);

        jLabel8.setText("Course");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(574, 140, 57, 14);
        getContentPane().add(tfrollno);
        tfrollno.setBounds(278, 50, 123, 20);
        getContentPane().add(tfname);
        tfname.setBounds(278, 102, 123, 20);
        getContentPane().add(tffname);
        tffname.setBounds(278, 149, 123, 20);
        getContentPane().add(tfphone);
        tfphone.setBounds(278, 204, 123, 20);
        getContentPane().add(tfmail);
        tfmail.setBounds(278, 258, 123, 20);

        jLabel9.setText("Gender");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(94, 370, 35, 14);

        buttonGroup1.add(rbmale);
        rbmale.setSelected(true);
        rbmale.setText("Male");
        getContentPane().add(rbmale);
        rbmale.setBounds(278, 366, 47, 23);

        buttonGroup1.add(rbfemale);
        rbfemale.setText("Female");
        rbfemale.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbfemaleActionPerformed(evt);
            }
        });
        getContentPane().add(rbfemale);
        rbfemale.setBounds(433, 366, 59, 23);

        jLabel10.setText("Select photo");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(94, 423, 60, 14);
        getContentPane().add(tfphoto);
        tfphoto.setBounds(278, 420, 123, 20);

        jButton1.setText("Browse...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(433, 419, 110, 23);

        jButton2.setText("Done");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(432, 493, 57, 23);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rbfemaleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rbfemaleActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rbfemaleActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String rno = tfrollno.getText();
        String name = tfname.getText();
        String phone = tfphone.getText();
        String fname = tffname.getText();
        String email = tfmail.getText();
        String dob = (String) (cbday.getSelectedItem() + "-" + cbmonth.getSelectedItem() + "-" + cbyear.getSelectedItem());
        String gender = "";
        String dept = (String)cbdept.getSelectedItem();
        String course = (String)cbcourse.getSelectedItem();
        if (rbmale.isSelected()) {
            gender = "Male";
        } else {
            gender = "Female";
        }

        String password = ((int) (100000 + (999999 - 100000) * Math.random())) + "";
        if(rno.isEmpty()||name.isEmpty()||phone.isEmpty()||fname.isEmpty()||email.isEmpty()||dob.isEmpty()||gender.isEmpty())
        {
            JOptionPane.showMessageDialog(this,"Enter all credentials");
           
        }
        else
        {
          try {
            File f = new File("Student_pics");
            if (!f.exists()) {
                f.mkdir();
            }
            FileOutputStream fos = new FileOutputStream("Student_pics/" + rno + ".jpg");
            FileInputStream fis = new FileInputStream(tfphoto.getText());
            byte b[] = new byte[10000];
            while (true) {
                int r;
                r = fis.read(b, 0, 10000);
                if (r == -1) {
                    break;
                }
                fos.write(b, 0, r);
            }
            fos.close();
            fis.close();
            dos.writeBytes("signup\r\n");
            dos.writeBytes(rno);
            dos.writeBytes(name);
            dos.writeBytes(phone);
            dos.writeBytes(fname);
            dos.writeBytes(email);
            dos.writeBytes(dob);
            dos.writeBytes(gender);
            dos.writeBytes(password);
            dos.writeBytes(tfphoto.getText());
            dos.writeBytes(dept);
            dos.writeBytes(course);
            

        } catch (Exception e) {
            e.printStackTrace();
        }
        
        }
// TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
JFileChooser jf = new JFileChooser();
        int ans = jf.showOpenDialog(this);
        if (ans == JFileChooser.APPROVE_OPTION) {
            String path = jf.getSelectedFile().getPath();
            tfphoto.setText(path);
        }        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void cbdeptItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbdeptItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cbdeptItemStateChanged

    private void cbcourseItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cbcourseItemStateChanged
String s = (String) cbdept.getSelectedItem();
        cbcourse.removeAllItems();
        try {
            Class.forName("com.mysql.jdbc.Driver");
//            System.out.println("Driver Loading done");

            Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/student_companion", "root", "system");
//            System.out.println("Connection Created");

            Statement stmt = conn.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,
                    ResultSet.CONCUR_UPDATABLE);
//            System.out.println("Statement Created");

            ResultSet rs = stmt.executeQuery("select * from courses where department='" + s + "'");
            while (rs.next()) {

                cbcourse.addItem(rs.getString("coursename"));
            }
            stmt.close();
            rs.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }        // TODO add your handling code here:
    }//GEN-LAST:event_cbcourseItemStateChanged

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
            java.util.logging.Logger.getLogger(signupclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(signupclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(signupclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(signupclient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new signupclient().setVisible(true);
            }
        });
    }
class client implements Runnable{

        @Override
        public void run() {
            try {
                 Socket sock
                        = new Socket(Credentials.ip, 9000);
                System.out.println("Connected to Server");
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());
                while(true)
                {
                    String s1=dis.readLine();
                    if(s1.equals("exists"))
                    {
                        JOptionPane.showMessageDialog(rootPane,"Student already exists.. ");
                        tffname.setText("");
                        tfmail.setText("");
                        tfname.setText("");
                        tfphone.setText("");
                        tfphoto.setText("");
                        tfrollno .setText("");
                    }
                    else if(s1.equals("success"))
                    {
                        JOptionPane.showMessageDialog(rootPane, "Signup Successful!");
                        dispose();
                    }
                }
            } catch (Exception e) {
            }
            
        }
    
}
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cbcourse;
    private javax.swing.JComboBox cbday;
    private javax.swing.JComboBox cbdept;
    private javax.swing.JComboBox cbmonth;
    private javax.swing.JComboBox cbyear;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbfemale;
    private javax.swing.JRadioButton rbmale;
    private javax.swing.JTextField tffname;
    private javax.swing.JTextField tfmail;
    private javax.swing.JTextField tfname;
    private javax.swing.JTextField tfphone;
    private javax.swing.JTextField tfphoto;
    private javax.swing.JTextField tfrollno;
    // End of variables declaration//GEN-END:variables
}
