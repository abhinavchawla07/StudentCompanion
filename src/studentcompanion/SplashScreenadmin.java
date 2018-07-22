package studentcompanion;


import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.UIManager;
import studentcompanion.admin_window;

public class SplashScreenadmin extends javax.swing.JFrame {

    public SplashScreenadmin() {
        try {
            initComponents();
            BufferedImage orgimage = ImageIO.read(getClass().getResource("splash.jpg"));
            BufferedImage resizedImage = resize(orgimage,400,300);
            jLabel1.setIcon(new ImageIcon(resizedImage));
            setSize(400,300);
            //------------------------
            int width = Toolkit.getDefaultToolkit().getScreenSize().width;
            int height = Toolkit.getDefaultToolkit().getScreenSize().height;
            int x = (width/2)-(this.getWidth()/2);
            int y = (height/2)-(this.getHeight()/2);
            setLocation(x, y);
            //--------------------------
           
            jProgressBar1.setForeground(new java.awt.Color(51,153,0));
            new Thread(new progress()).start();
        } catch (IOException ex) {
            Logger.getLogger(SplashScreenadmin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public class progress implements Runnable
    {

        @Override
        public void run() 
        {
            for (int i = 1; i <=100; i++) 
            {
                if(i<30)
                {
                    jLabel2.setText("Initializing..............");
                jProgressBar1.setValue(i);
                }
                else if(i<60)
                {
                    jLabel2.setText("Loading................");
                jProgressBar1.setValue(i);
                }
                else if(i<90)
                {
                    jLabel2.setText("Processing..............");
                jProgressBar1.setValue(i);
                }
                else
                {
                    jLabel2.setText("Launching..............");
                jProgressBar1.setValue(i);
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException ex) {
                    Logger.getLogger(SplashScreenadmin.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            dispose();
            new admin_window().setVisible(true);
        }
        
    }
    
    public static BufferedImage resize(BufferedImage image, int width, int height) 
    {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        return bi;
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel4 = new javax.swing.JLabel();
        jProgressBar1 = new javax.swing.JProgressBar();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        jLabel4.setText("jLabel4");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        getContentPane().setLayout(null);

        jProgressBar1.setBackground(new java.awt.Color(255, 255, 255));
        jProgressBar1.setForeground(new java.awt.Color(255, 51, 51));
        jProgressBar1.setBorderPainted(false);
        getContentPane().add(jProgressBar1);
        jProgressBar1.setBounds(0, 276, 400, 20);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("HAhahahahahahahaha");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(160, 10, 220, 30);

        jLabel2.setText("jLabel2");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 10, 90, 50);

        jLabel5.setText("burshwasoo");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(60, 140, 130, 30);

        jLabel6.setText("jLabel6");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(10, 190, 390, 70);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/studentcompanion/splash.jpg"))); // NOI18N
        jLabel1.setText("jLabel1");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1, -4, 400, 310);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
ex.printStackTrace();
        } catch (InstantiationException ex) {
            ex.printStackTrace();
        } catch (IllegalAccessException ex) {
            ex.printStackTrace();
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            ex.printStackTrace();
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SplashScreenadmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JProgressBar jProgressBar1;
    // End of variables declaration//GEN-END:variables
}
