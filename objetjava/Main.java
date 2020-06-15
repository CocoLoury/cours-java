import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.GregorianCalendar;


public class Main{
    public static void main(String[] args) {
        //Personne
        Personne p = new Personne();
        p.setNom("Boy");
        p.setPrenom("YOYO");
        p.setDate_naiss(new GregorianCalendar(1998,11,16));
        System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.calculAge());
        Personne p2 = new Personne("M   AN2", "JUL2", new GregorianCalendar(1998,11,16));
        p2.affichage();
        p2.affichage(true);
        p2.affichage(false);
        if(p.getNbInstance() > 1){
            System.out.println(p.getNbInstance()+ " instances de personne on étés créés");
        }
        else{
            System.out.println(p.getNbInstance()+ " instance de personne");
        }
        System.out.println(p.getNumero()+ " est le numéro de la personne");
        System.out.println(p2.getNumero()+ " est le numéro de la personne");

        //iencli
        Client iencli = new Client("nom", "prenom", new GregorianCalendar(1998,11,16), 'P');
        iencli.affichage(true, 1);
        iencli.setPoids(90);
        System.out.println(iencli.getPoids());
        iencli.seDeplacer();
        System.out.println(iencli.getNbInstance());
        
        System.out.println(p.compare(p2));
        lireFichier2("test.txt");
    }

    //Méthode de lecture d'un fichier
    public static void lireFichier(String nomFichier) {
        FileInputStream fichier = null;
        BufferedReader br = null;
        String line = null;
        try {
            fichier = new FileInputStream(nomFichier);
            br = new BufferedReader(new InputStreamReader(fichier));
            line = br.readLine();
            while(line != null){
                System.out.println(line);
                line = br.readLine();
            }
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally{
            if(fichier != null){
                try{
                    fichier.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
            if(br != null){
                try{
                    br.close();
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }
    }
    public static void lireFichier2(String nomFichier){
        try(FileInputStream fichier = new FileInputStream(nomFichier);
            BufferedReader br = new BufferedReader(new InputStreamReader(fichier))){    
                String ligne = br.readLine();
                while(ligne != null){
                    System.out.println(ligne);
                    ligne = br.readLine();
                }
            }catch (FileNotFoundException e){
                e.printStackTrace();
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                System.out.println("Logic done !");
            }
    }
}