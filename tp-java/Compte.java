import java.util.ArrayList;

public class Compte {
    //Variable
    private double solde;
    private String proprietaire;
    private ArrayList<Operation> operations = new ArrayList<Operation>();

    //Constructeur
    public Compte(String proprietaire, double solde){
        this.solde = solde;
        this.proprietaire = proprietaire;
    }

    //Getter Setter
    public double getSolde() {return this.solde;}
    public void setSolde(double solde) {this.solde = solde;}
    public String getProprietaire() {return this.proprietaire;}
    public ArrayList<Operation> getOperations() {return this.operations;}
    public void setOperations(ArrayList<Operation> operations) {this.operations = operations;}
    public void setProprietaire(String proprietaire) {this.proprietaire = proprietaire;} 

    public void Crediter(double somme){
        this.solde += somme;
        this.operations.add(new Operation(somme, 'C'));
    }

    //Méthode surchargée
    public void Crediter(double somme, Compte compte){
        this.solde += somme;
        compte.solde = compte.solde - somme;
        this.operations.add(new Operation(somme, 'C'));
    }

    public void Debiter(double somme){
        this.solde -= somme;
        this.operations.add(new Operation(somme, 'D'));
    }

    //Méthode surchargée
    public void Debiter(double somme, Compte compte){
        this.solde = this.solde - somme;
        compte.solde += somme;
        this.operations.add(new Operation(somme, 'D'));
    }

    public void Afficher(){
        System.out.println("Le résumé du compte de "+ this.getProprietaire() + " : " + this.getSolde()+"€");
    }

}