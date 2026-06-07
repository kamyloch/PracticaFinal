import javax.swing.*;
import java.awt.*;

public class Prova1 extends JFrame {
    JButton btn1;
    JPanel panelGran;

    public Prova1(){
        //JFrame
        setMinimumSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        panelGran = new JPanel();
        panelGran.setLayout(new GridLayout());
        setContentPane(panelGran);

        btn1 = new JButton();
        panelGran.add(btn1);

    }

    public static void main(){
        new Prova1().setVisible(true);;
    }
}
