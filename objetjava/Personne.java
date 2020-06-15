import java.util.GregorianCalendar;

public class Personne extends EtreVivant implements Classable {
    // variable de class
    private String nom;
    private String prenom;
    private GregorianCalendar date_naiss;
    private static int nbInstance;
    {nbInstance++;}
    private int numero;

    // constructeur basic
    public Personne() {
        System.out.println("Création d'une personne");
        nom = "";
        prenom = "";
        date_naiss = null;
        this.setNumero();
    }
    //constructeur surchargé
    public Personne(String nom, String prenom, final GregorianCalendar date_naiss){
        this.nom = nom;
        this.prenom = prenom;
        this.date_naiss = date_naiss;
        this.setNumero();
    }

    //Destructeur (à ne pas l'ajouter car java le gère avec le garbage collector) 
    public void finalize() throws Throwable{
        System.out.println("Suppréssion de l'objet personne");
    }
    // méthode de class
    public long calculAge(){
        long age;
        date_naiss = this.getDate_naiss();
        age = new GregorianCalendar().getTimeInMillis() - date_naiss.getTimeInMillis();
        age = age/1000/60/60/24/365;
        return age;
    }
    public void affichage(){
        System.out.println("nom : "+ getNom());
        System.out.println("prenom : "+ getPrenom());
        System.out.println("age : "+ calculAge());
    }
    public void affichage(boolean francais){
        if(francais){
            affichage();
        }
        else
        {
            System.out.println("Last name "+ getNom());
            System.out.println("First name "+ getPrenom());
            System.out.println("age "+ calculAge());
        }
    }

    protected void seDeplacer() {
        System.out.println("Je fais quelques pas");
    }

    // getteur setteur
    public String getNom() {
        return this.nom;
    }
    public void setNom(String nom) {
        this.nom = nom.toUpperCase();
    }
    public String getPrenom() {
        return this.prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom.toLowerCase();
    }
    public GregorianCalendar getDate_naiss() {
        return this.date_naiss;
    }
    public void setDate_naiss(GregorianCalendar date_naiss) {
        this.date_naiss = date_naiss;
    }
    public int getNbInstance(){
        return this.nbInstance;
    }
    public void setNumero(){
        while (numero<1000){
            numero = (int)(10000*Math.random());
        }
    }
    public int getNumero(){
        return numero;
    }

    @Override
    public int compare(Object o) {
        Personne p;
        if(o instanceof Personne){
            p = (Personne)o;
        }
        else{
            return  Classable.ERREUR;
        }
        if(getNom().compareTo(p.getNom()) < 0){
            return Classable.INFERIEUR;
        }
        if(getNom().compareTo(p.getNom()) > 0){
            return Classable.SUPERIEUR;
        }
        return Classable.EGAL;
    }
}