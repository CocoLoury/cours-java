import java.util.ArrayList;

public class Main {
    public static void main(String[] args){
        //Création des comptes
        System.out.println("Création du compte courant de Nicolas avec un découvert autorisé de 2000€");
        CompteCourant compteCourantNicolas = new CompteCourant("Nicolas",0.00,2000.0);
        System.out.println("Création du compte épargne de Nicolas avec un taux de 2%");
        CompteEpargne compteEpargneNicolas = new CompteEpargne("Nicolas",0.00, 0.02);
        System.out.println("Création du compte courant de Jérémie avec un découvert autorisé de 500€");
        CompteCourant compteCourantJeremie = new CompteCourant("Jérémie",0.00,500.0);

        //Opérations
        System.out.println("Nicolas touche son salaire de 100€");
        compteCourantNicolas.Crediter(100.00);
        System.out.println("Il fait le plein de sa voiture 50€");
        compteCourantNicolas.Debiter(50.00);
        System.out.println("Il me de côté sur son compte éparge 20€");
        compteCourantNicolas.Debiter(20.0, compteEpargneNicolas);
        System.out.println("Cadeau de la banque 100€");
        compteCourantNicolas.Crediter(100.00);
        System.out.println("Il remet les 20€ de son compte épargne sur son compte courant");
        compteEpargneNicolas.Debiter(20.0, compteCourantNicolas);
        System.out.println("Jérémie achète un pc 500€");
        compteCourantJeremie.Debiter(500.00);
        System.out.println("Il rembourse ses dettes à Nicolas 200€");
        compteCourantJeremie.Debiter(200.00, compteCourantNicolas);

        //Affichage
        System.out.println("Résumer des comptes :");
        compteCourantNicolas.Afficher();
        for (Operation operation : compteCourantNicolas.getOperations()){
            operation.Afficher();
        }
        compteEpargneNicolas.Afficher();
        for (Operation operation : compteCourantNicolas.getOperations()){
            operation.Afficher();
        }
        compteCourantJeremie.Afficher();
        for (Operation operation : compteCourantNicolas.getOperations()){
            operation.Afficher();
        }
    }
}

class Compte {
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

class CompteCourant extends Compte {
    //Variable
    private Double decouvertAutorise;
    
    //Constructeur
    public CompteCourant(String proprietaire, double solde, double decouvertAutorise){
        super(proprietaire, solde);
        this.decouvertAutorise = decouvertAutorise;
    }

    //Getter
    public Double getDecouvertAutorise(){return this.decouvertAutorise;}

    public void Afficher(){
        System.out.println("Le résumé du compte courant de "+ this.getProprietaire() + " : " + this.getSolde()+"€");
        System.out.println("Le découvert autorisé est de : " + this.getDecouvertAutorise()+"€");
    }
}

class CompteEpargne extends Compte {
    //Variable
    private double taux;
    private static Double MIN_VALUE = 0D;
    private static Double MAX_VALUE = 1D;

    //Constructeur
    public CompteEpargne(String proprietaire, double solde, double taux) {
        super(proprietaire, solde);
        this.taux = taux;
        if(taux > MAX_VALUE){
            this.taux = MAX_VALUE;
        }
        else if(taux < MIN_VALUE){
            this.taux = MIN_VALUE;
        }
    }

    //Getter Setter
    public double getTaux() {return this.taux;}
    public void setTaux(double taux) {this.taux = taux;}

    public void Afficher(){
        System.out.println("Le résumé du compte épargne de "+ this.getProprietaire() + " : " + this.getSolde()+"€");
        System.out.println("Le taux est de : "+this.taux*100+"%");
    }
}

class Operation {
    //Variables
    private double montant;
    private char type;

    //Constructeur
    public Operation(double montant, char type) {
        this.montant = montant;
        this.type = type;
    }


    //Getter Setter
    public double getMontant() {return this.montant;}
    public void setMontant(double montant) {this.montant = montant;}
    public char getType() {return this.type;}
    public void setType(char type) {this.type = type;}

    public void Afficher(){
        if(this.type == 'C'){
            System.out.println("Crédit de "+ this.montant+"€");
        }
        else if (this.type == 'D') {
            System.out.println("Débit de "+ this.montant+"€");
        }
    }
}