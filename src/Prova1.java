import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Prova1 extends JFrame {
    JButton[] btnNum;
    JPanel panelMain;
    JPanel panelNums;
    JPanel panelNorth;
    JTextArea camp;
    JLabel advertencia;
    static final Font lletra = new Font("Arial",Font.BOLD,50);
    static final Font lletra_petita = new Font("Arial",Font.BOLD,20);


    public Prova1(){
        //JFrame
        setMinimumSize(new Dimension(500,500));
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        //JPanel
        panelMain = new JPanel(new BorderLayout());
        setContentPane(panelMain);

        //Butons
        panelNums = new JPanel(new GridLayout(4,3,5,5));
        initButtons(panelNums);
        panelMain.add(panelNums,BorderLayout.CENTER);

        //TextField
        panelNorth = new JPanel(new BorderLayout());
        initCamp(panelNorth);
        panelMain.add(panelNorth,BorderLayout.NORTH);

    }

    private void initCamp(JPanel panel){
        camp = new JTextArea();
        camp.setFont(lletra);
        camp.addKeyListener(new KeyListener() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c = e.getKeyChar();
                if(!Character.isDigit(c) && c != '+' && c != '-' &&c != '*' && c != '/')
                    e.consume();
                try {
                    String txt = camp.getText();
                    String[] parts = txt.split("\\+");
                    if (parts.length > 1) {
                        camp.setText("" + (Float.parseFloat(parts[0]) + Float.parseFloat(parts[1])));
                        return;
                    }
                    parts = txt.split("\\*");
                    if (parts.length > 1) {
                        camp.setText("" + (Float.parseFloat(parts[0]) * Float.parseFloat(parts[1])));
                        return;
                    }
                    parts = txt.split("-");
                    if (parts.length > 1) {
                        camp.setText("" + (Float.parseFloat(parts[0]) - Float.parseFloat(parts[1])));
                        return;
                    }
                    parts = txt.split("/");
                    if (parts.length > 1) {
                        camp.setText("" + (Float.parseFloat(parts[0]) / Float.parseFloat(parts[1])));
                    }
                    advertencia.setVisible(false);
                }catch (Exception ex){
                    advertencia.setVisible(true);
                }
            }
            @Override
            public void keyPressed(KeyEvent e) {}
            @Override
            public void keyReleased(KeyEvent e) {}
        });

        //Label
        advertencia = new JLabel("Syntax error");
        advertencia.setForeground(Color.red);
        advertencia.setFont(lletra_petita);

        panel.add(camp,BorderLayout.CENTER);
        panel.add(advertencia,BorderLayout.SOUTH);

        advertencia.setVisible(false);
    }

    private void initButtons(JPanel panel){
        //JButton's
        btnNum = new JButton[10];
        for(int i = 9; i>=0;i--){
            final String txt = ""+i;
            btnNum[i] = new JButton(txt);
            btnNum[i].setFont(lletra);
            btnNum[i].addActionListener(e-> camp.append(txt));
            panel.add(btnNum[i]);
        }
    }
    public static void main(){
        new Prova1().setVisible(true);;
    }
}
