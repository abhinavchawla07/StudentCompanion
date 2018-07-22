package studentcompanion;


import java.awt.Component;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;

public class jtable_test extends JFrame {

    ArrayList<student> al = new ArrayList<>();

    mytable tm;
    JTable jt;
    JScrollPane jsp;
    JButton bt;
    
    public jtable_test() {
        setLayout(null);

        jt = new JTable();
        jsp = new JScrollPane(jt);
        tm = new mytable();
        bt = new JButton("Click");

        jt.setModel(tm);
        jt.getColumnModel().getColumn(8).setCellRenderer(new ImageRenderer());
        jt.setRowHeight(100);
        jsp.setBounds(30, 30, 500, 500);
        bt.setBounds(30, 550, 90, 30);

        add(jsp);
        add(bt);
        
        bt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                al.add(new student(20, "abc", "E:\\one.jpg"));
                tm.fireTableDataChanged();
            }
        });
        
        al.add(new student(1, "abc", "E:\\one.jpg"));
        al.add(new student(2, "def", "E:\\one.jpg"));
        al.add(new student(3, "xyz", "E:\\one.jpg"));
        al.add(new student(4, "mno", "E:\\one.jpg"));

        setSize(500, 500);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    public static void main(String[] args) {
        new jtable_test();
    }

    class student {

        int rn;
        String name, path;

        public student(int rn, String name, String path) {
            this.rn = rn;
            this.name = name;
            this.path = path;
        }
    }

    class mytable extends AbstractTableModel {

        @Override
        public int getRowCount() {
            return al.size();
        }

        @Override
        public int getColumnCount() {
            return 9;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            if (columnIndex == 0) {
                return al.get(rowIndex).name;
            } else if (columnIndex == 1) {
                return al.get(rowIndex).rn;
            } else {
                return null;
            }
        }

    }

    class ImageRenderer extends DefaultTableCellRenderer {

        JLabel lbl = new JLabel();

        public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                boolean hasFocus, int row, int column) {
            try {
                //            lbl.setText((String) value);

                
                BufferedImage image = ImageIO.read(new File(al.get(row).path));

                lbl.setIcon(new ImageIcon(jtable_test.resize(image, 100, 100)));
                lbl.setBounds(0, 0, 100, 100);
                return lbl;
            } catch (IOException ex) {
                Logger.getLogger(jtable_test.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        }
    }

    public static BufferedImage resize(BufferedImage image, int width, int height) {
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TRANSLUCENT);
        Graphics2D g2d = (Graphics2D) bi.createGraphics();
        g2d.addRenderingHints(new RenderingHints(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY));
        g2d.drawImage(image, 0, 0, width, height, null);
        g2d.dispose();
        System.out.println(bi);
        return bi;
    }
}
