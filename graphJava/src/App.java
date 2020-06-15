package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

public class App extends JFrame {

    private static JFrame f; //Instanciation de l'objet JFrame
    private static JButton b1;
    private static JButton b2;
    private static JButton b3;
    private static JButton b4;
    private static JButton b5;
    private static JPanel panneau;
    private static JProgressBar proBar;

    public static void main(String[] args) {
        f = new JFrame(); //Création de l'instance de la classe JFrame
        f.setBounds(0,0,300,400); //modification position et taille de la fenêtre
        f.setTitle("First Windows JAVA"); //Modification du titre
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Fermeture quand on clique sur la croix
        f.setResizable(false); // Interdire de redimensionner la fenêtre

        // Créations des boutons
        b1 = new JButton("ROUGE");
        b1.setBackground(Color.RED);
        b2 = new JButton("BLEU");
        b2.setBackground(Color.BLUE);
        b3 = new JButton("JAUNE");
        b3.setBackground(Color.YELLOW);
        b4 = new JButton("MODIFICATION");
        b5 = new JButton("Autre fenetre");

        // Création d'un event MouseListener
        MouseListener mouseListener = new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getSource() == b1){
                    System.out.println("Click B1");
                }
                if (e.getSource() == b2){
                    b1.setBackground(Color.BLACK);
                }
                if (e.getSource() == b3){
                    b2.setBackground(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
                }
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {
                if (e.getSource() == b2) {
                    System.out.println("Rentre dans b2");
                    b2.setLocation(new Random().nextInt(300),new Random().nextInt(400));
                    if (b2.getX() >= (f.getSize().width -42) || b2.getY() >= (f.getSize().height) -42){
                        System.out.println("erreur "+ b2.getLocation());
                        b2.setLocation(150,200);
                    }
                }
            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        };

        // Ajout du listener au bouton (B1, B2, B3)
        b1.addMouseListener(mouseListener);
        b2.addMouseListener(mouseListener);
        b3.addMouseListener(mouseListener);

        // Création d'un menu avec ces options
        JMenuBar menuBar = new JMenuBar();
        JMenu menu1 = new JMenu("Menu");
        JMenu menu2 = new JMenu("Options");
        JMenu menu3 = new JMenu("Quitter");

        // Ajout des menus dans le conteneur de menu
        menuBar.add(menu1);
        menuBar.add(menu2);
        menuBar.add(menu3);

        // Ajout du menu dans la fenêtre
        f.setJMenuBar(menuBar);

        // Progresse bar
        proBar = new JProgressBar();
        proBar.setBackground(Color.BLACK);
        proBar.setValue(0);
        proBar.setMinimum(0);
        proBar.setMaximum(100);

        // Utilisation d'une méthode anonyme sur le menu3
        menu3.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                System.exit(0);
            }
        });

        // Utilisation d'une méthode anonyme pour B3
        b3.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseExited(MouseEvent e) {
                super.mouseExited(e);
                panneau.setBackground(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
            }
        });

        // Utilisation d'une méthode anonyme pour B4
        b4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                avancementProBar();
            }
        });

        b5.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                Fenetre fen = new Fenetre();
            }
        });


        //Création d'un JPanel (conteneur intermédiaire)
        panneau = new JPanel();
        panneau.setLayout(new GridBagLayout());

        // Ajouter tous les objets au 'panneau'
        /*panneau.add(b1);
        panneau.add(b2);
        panneau.add(b3);
        panneau.add(b4);
        panneau.add(b5);*/

        // Invocation de GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.weightx = 1;
        gbc.weighty = 1;
        gbc.fill = GridBagConstraints.BOTH;

        gbc.gridx = 0;
        gbc.gridheight = 2;
        gbc.gridwidth = 2;
        gbc.gridy = 0;
        panneau.add(b1,gbc);

        gbc.gridx = 0;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        panneau.add(b2,gbc);

        gbc.gridx = 1;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridy = 2;
        panneau.add(b3,gbc);

        gbc.gridx = 2;
        gbc.gridheight = 1;
        gbc.gridwidth = 1;
        gbc.gridy = 1;
        panneau.add(b4,gbc);

        gbc.gridx = 0;
        gbc.gridheight = 3;
        gbc.gridwidth = 3;
        gbc.gridy = 3;
        panneau.add(b5,gbc);

        gbc.gridx = 2;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        gbc.gridheight = 1;
        panneau.add(proBar, gbc);

        // Ajout d'un conteneur inter dans le conteneur de base
        f.getContentPane().add(panneau);

        f.setVisible(true); //Affichage de la fenêtre

    }

    public static void avancementProBar(){
        int i = 0;
        while (i<=100){
            proBar.setValue(i);
            System.out.println(i);
            try {
                Thread.sleep(1000);
                i+=10;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}