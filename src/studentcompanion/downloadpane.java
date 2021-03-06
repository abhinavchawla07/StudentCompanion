/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentcompanion;

import java.awt.Desktop;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URI;
import javax.swing.JOptionPane;

/**
 *
 * @author anmol singh sethi
 */
public class downloadpane extends javax.swing.JFrame {

    /**
     * Creates new form download pane
     */
    DataInputStream dis;
    DataOutputStream dos;
    int paperid;
    String filesize;

    public downloadpane(int paperid) throws IOException {
        initComponents();
        this.paperid = paperid;
        new Thread(new client()).start();

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
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        lbtitle = new javax.swing.JLabel();
        lbdesc = new javax.swing.JLabel();
        lbupl = new javax.swing.JLabel();
        lbsub = new javax.swing.JLabel();
        lbtyp = new javax.swing.JLabel();
        lbsem = new javax.swing.JLabel();
        lbdat = new javax.swing.JLabel();
        lbyea = new javax.swing.JLabel();
        download = new javax.swing.JButton();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel6 = new javax.swing.JLabel();

        getContentPane().setLayout(null);

        jLabel1.setText("Title: ");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(150, 50, 180, 40);

        jLabel2.setText("Description: ");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(150, 110, 110, 50);

        jLabel3.setText("Subject Code");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(10, 220, 150, 40);

        jLabel4.setText("type");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(10, 260, 170, 50);

        jLabel5.setText("Date of upload");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(10, 360, 140, 30);

        jLabel7.setText("semester");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(10, 320, 100, 20);

        jLabel8.setText("year of examination");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(10, 400, 170, 50);

        jLabel9.setText("uploaded by: ");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(10, 190, 100, 30);

        lbtitle.setText("jLabel10");
        getContentPane().add(lbtitle);
        lbtitle.setBounds(310, 50, 120, 30);

        lbdesc.setText("jLabel10");
        getContentPane().add(lbdesc);
        lbdesc.setBounds(300, 120, 120, 30);

        lbupl.setText("jLabel10");
        getContentPane().add(lbupl);
        lbupl.setBounds(170, 190, 210, 30);

        lbsub.setText("jLabel10");
        getContentPane().add(lbsub);
        lbsub.setBounds(170, 230, 130, 30);

        lbtyp.setText("jLabel10");
        getContentPane().add(lbtyp);
        lbtyp.setBounds(170, 280, 120, 30);

        lbsem.setText("jLabel10");
        getContentPane().add(lbsem);
        lbsem.setBounds(160, 330, 140, 20);

        lbdat.setText("jLabel10");
        getContentPane().add(lbdat);
        lbdat.setBounds(170, 370, 140, 30);

        lbyea.setText("jLabel10");
        getContentPane().add(lbyea);
        lbyea.setBounds(160, 410, 180, 16);

        download.setText("Download");
        download.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                downloadActionPerformed(evt);
            }
        });
        getContentPane().add(download);
        download.setBounds(160, 550, 320, 70);

        jProgressBar1.setToolTipText("");
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(20, 460, 490, 30);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentcompanion/splash.jpg"))); // NOI18N
        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 20, 110, 130);
    }// </editor-fold>//GEN-END:initComponents

    private void downloadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_downloadActionPerformed
        try {
            dos.writeBytes("download file\r\n");
            dos.writeBytes(filesize+"\r\n");
        } catch (Exception e) {
            e.printStackTrace();
        }

// TODO add your handling code here:
    }//GEN-LAST:event_downloadActionPerformed

    class client implements Runnable {

        public void run() {
            try {
                Socket sock
                        = new Socket(Credentials.ip, 9000);
                System.out.println("Connected to Server");
                dis = new DataInputStream(sock.getInputStream());
                dos = new DataOutputStream(sock.getOutputStream());

                dos.writeBytes("hello server\r\n");

                dos.writeBytes("send details\r\n");
                dos.writeInt(paperid);
                while (true) {
                    String s1 = dis.readLine();
                    System.out.println(s1);
                    if (s1.equals("sending response")) {
                        System.out.println("in sending response");
                        lbtitle.setText(dis.readLine());
                        lbdesc.setText(dis.readLine());
                        lbdat.setText(dis.readLine());
                        lbupl.setText(dis.readLine());
                        lbyea.setText(dis.readLine());
                        lbsem.setText(dis.readLine());
                        lbtyp.setText(dis.readLine());
                        lbsub.setText(dis.readLine());
                        filesize =dis.readLine();
                    }
                    else if(s1.equals("Download started"))
                    {
                        String fname = dis.readLine();
                        long len = dis.readLong();
                        File f=new File(System.getProperty("user.home")+"\\Downloads\\StudentCompanion");
                        if(!f.exists())
                            f.mkdir();
                        FileOutputStream fos =new FileOutputStream(System.getProperty("user.home")+"\\Downloads\\StudentCompanion\\"+fname);
                        
                        int count=0;
                        byte b[] = new byte[10000];
                        
                        while(true)
                        {
                            int r = dis.read(b, 0, 10000);
                            count = count+r;
                            fos.write(b, 0, r);
                            long per=(count*100)/len;
                            jProgressBar1.setValue((int)per);
                            jProgressBar1.setString(""+per);
                            if(count==len)
                            {
                                jProgressBar1.setString("Download complete");
                                break;
                            }
                        }
                        fos.close();
                        int ans=JOptionPane.showConfirmDialog(rootPane, "File downloaded successfully to"+f.getPath()+"\nDo you want to open it?");
                        if(ans==JOptionPane.YES_OPTION)
                        {
                            Desktop.getDesktop().open(new File(System.getProperty("user.home")+"\\Downloads\\StudentCompanion\\"+fname));
                        }
                    }

                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton download;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel lbdat;
    private javax.swing.JLabel lbdesc;
    private javax.swing.JLabel lbsem;
    private javax.swing.JLabel lbsub;
    private javax.swing.JLabel lbtitle;
    private javax.swing.JLabel lbtyp;
    private javax.swing.JLabel lbupl;
    private javax.swing.JLabel lbyea;
    // End of variables declaration//GEN-END:variables
}
