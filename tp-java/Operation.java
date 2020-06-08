public class Operation {
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