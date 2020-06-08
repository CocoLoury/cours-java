import java.util.GregorianCalendar;

public class Main{
    public static void main(String[] args){
        //System.out.println("test");
        //Personne
        Personne p = new Personne();
        p.setNom("Boy");
        p.setPrenom("YOYO");
        p.setDate_naiss(new GregorianCalendar(1998,11,16));
        System.out.println(p.getNom()+" "+p.getPrenom()+" "+p.calculAge());
        Personne p2 = new Personne("MAN2", "JUL2", new GregorianCalendar(1998,11,16));
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
    }
}