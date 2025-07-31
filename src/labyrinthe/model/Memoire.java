package labyrinthe.model;

/**
 * Cette classe représente les cases mémoires de la tortue.
 */
public class Memoire {
    private int valeur;

    /**
     * Cette méthode retourne la valeur de la case mémoire.
     *
     * @return la valeur de la case mémoire
     */
    public int getValeur() {
        return valeur;
    }

    /**
     * Cette méthode modifie la valeur de la case mémoire.
     *
     * @param valeur la nouvelle valeur de la case mémoire
     */
    public void setValeur(int valeur) {
        this.valeur = valeur;
    }
}
