import java.util.GregorianCalendar;

public class Client extends Personne {
    //déterminer le type du iencli est :
    //P -> particulier
    //E -> Entreprise
    //A -> Administration
    private char type;

    //Constructeur
    public Client(String nom, String prenom, GregorianCalendar date_naiss, char type){
        super(nom, prenom, date_naiss);
        this.type = type;
        this.setNumero();
        System.out.println("Création d'une personne");
    }

    //getter setter
    public char getType() {return this.type;}
    public void setType(char type) {this.type = type;}

    //methode surchargée
    public void affichage(Boolean francais, int c){
        this.affichage(francais);
        System.out.println("Type = "+this.getType());
    }
}