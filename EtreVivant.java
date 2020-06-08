public abstract class EtreVivant{
    private double taille;
    private double poids;

    //Getter Setter
    public double getTaille() {
        return this.taille;
    }

    public void setTaille(double taille) {
        this.taille = taille;
    }

    public double getPoids() {
        return this.poids;
    }

    public void setPoids(double poids) {
        this.poids = poids;
    }

    //Methode abtraite qui doit obligatoirement implémentée dans les classes dérivées
    protected abstract void seDeplacer();

}