import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

import static javax.swing.SwingConstants.*;

public class Prova2 extends JFrame {

    JLabel labelPos;
    JPanel panel;
    private MouseMotionListener updCordsListener = new MouseMotionListener() {
        public void mouseDragged(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {updCords(e);}
    };
    public void updCords(MouseEvent e) { labelPos.setText("Cords: [" + e.getXOnScreen() + ", " + e.getYOnScreen() + "]");}

    SpringLayout layoutBotons;
    JPanel panelBotons;

    public Prova2() {
        //JFrame
        setMinimumSize(new Dimension(500, 500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Panel
        panel = new JPanel(new BorderLayout());
        setContentPane(panel);
        addMouseMotionListener(updCordsListener);

        //Components
        initLabel();
        initBotons();
    }

    public void initLabel() {
        labelPos = new JLabel("Hola");
        panel.add(labelPos, BorderLayout.NORTH);
    }
    public void initBotons(){
        layoutBotons = new SpringLayout();
        panelBotons = new JPanel(layoutBotons);

        panel.add(panelBotons,BorderLayout.CENTER);

        for (int i = 0; i < 10; i++){
            JButton btn = new JButton("Boton" + i);
            panelBotons.add(btn);
            layoutBotons.putConstraint(SpringLayout.WEST,btn,30,SpringLayout.EAST,panelBotons);
        }
    }


    public static void main(String[] args) {
        new Prova2().setVisible(true);
    }
}
