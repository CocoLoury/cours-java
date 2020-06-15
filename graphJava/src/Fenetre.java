package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Fenetre extends JFrame {

    JPanel panneau;
    JTextField text;
    JButton b1;

    public Fenetre() {
        setBounds(0,0,300,400);
        setTitle("Nouvelle fenetre Java");
        setResizable(false);

        panneau = new JPanel();

        b1 = new JButton("test");
        b1.setBounds(50,150,200,30);
        b1.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                JOptionPane jop = new JOptionPane();
                jop.showConfirmDialog(getContentPane(),"click","text exemple", JOptionPane.OK_OPTION);
                text.setText("click OK");
            }
        });

        text = new JTextField();
        text.setBounds(50,100,200,30);
        text.setFont(new Font("Consolas", Font.BOLD,20));

        panneau.add(text);
        panneau.add(b1);
        getContentPane().add(panneau);

        setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
        setVisible(true);
    }
}
