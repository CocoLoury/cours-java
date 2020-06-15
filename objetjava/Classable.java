public interface Classable {
    public static final int INFERIEUR=-1;
    public static final int EGAL=0;
    public static final int SUPERIEUR=1;
    public static final int ERREUR=-99;

    int compare(Object o);
    /*
      Cette methode pourra être appelée pour comparer l'instance courante
      avec celle reçue en paramètre
      La méthode retourne un entier :
        - 1 si l'instance courante est supérieur à celle qui est reçue en paramètre
        - 0 si les deux instances sont égales
        - -1 si l'instance est inférieur à celle reçue en paramètre
        - -99 si la comparaison est impossible 
    */
}