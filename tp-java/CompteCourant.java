public class CompteCourant extends Compte {
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