public class CompteEpargne extends Compte {
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