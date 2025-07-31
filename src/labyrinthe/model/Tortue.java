package labyrinthe.model;

/**
 * Cette classe représente la tortue.
 */
public class Tortue {
    private Vecteur position;
    private Direction direction = Direction.Nord;
    private Memoire[][] tableauMemoire;

    private int pc = 0;
    private int nbrInstructions = 0;
    private int nbrMouvements = 0;
    private int nbrCollisions = 0;

    /**
     * Construit une instance de tortue avec une position donnée.
     *
     * @param position la position de la tortue
     */
    public Tortue (Vecteur position){
        this.position = position;
    }

    //region Getters et Setters
    /**
     * Retourne le nombre de mouvements de la tortue.
     *
     * @return le nombre de mouvements de la tortue
     */
    public int getNbrMouvements() {
        return nbrMouvements;
    }

    /**
     * Retourne le nombre d'instructions exécutées par la tortue.
     *
     * @return le nombre d'instructions exécutées par la tortue.
     */
    public int getNbrInstructions() {
        return nbrInstructions;
    }

    /**
     * Retourne le nombre de collisions de la tortue.
     *
     * @return le nombre de collisions de la tortue
     */
    public int getNbrCollisions() {
        return nbrCollisions;
    }

    /**
     * Retourne le compteur de programme de la tortue.
     *
     * @return le compteur de programme de la tortue
     */
    public int getPc() {
        return pc;
    }

    /**
     * Retourne la direction de la tortue.
     *
     * @return la direction de la tortue
     */
    public Direction getDirection() {
        return direction;
    }

    /**
     * Retourne la mémoire de la case où se trouve la tortue.
     *
     * @return la mémoire de la case où se trouve la tortue.
     */
    public Memoire getMemoire(){
        int x = position.x();
        int y = position.y();
        return tableauMemoire[x][y];
    }

    /**
     * Retourne la position de la tortue.
     *
     * @return la position de la tortue
     */
    public Vecteur getPosition() {
        return position;
    }

    /**
     * Modifie la direction de la tortue.
     *
     * @param direction la nouvelle direction de la tortue
     */
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * Modifie la position de la tortue.
     *
     * @param position la nouvelle position de la tortue
     */
    public void setPosition(Vecteur position) {
        this.position = position;
    }

    /**
     * Modifie le compteur de programme de la tortue.
     *
     * @param pc le nouveau compteur de programme de la tortue
     */
    public void setPc(int pc) {
        this.pc = pc;
    }
    //endregion

    //region Methodes
    /**
     * Cette méthode permet d'initialiser la mémoire de la tortue de taille x et y (meme taille que le labyrinthe).
     *
     * @param x la taille de la mémoire en x
     * @param y la taille de la mémoire en y
     */
    public void initialiserMemoire(int x, int y){
        tableauMemoire = new Memoire[x][y];
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                tableauMemoire[i][j] = new Memoire();
            }
        }
    }

    /**
     * Cette méthode permet d'incrémenter le nombre de collisions de la tortue.
     */
    public void incrementerNbrCollisions() {
        nbrCollisions++;
    }

    /**
     * Cette méthode permet d'incrémenter le nombre d'instructions de la tortue.
     */
    public void incrementerNbrInstructions(){
        nbrInstructions++;
    }

    /**
     * Cette méthode permet d'incrémenter le nombre de mouvements de la tortue.
     */
    public void incrementerNbrMouvements(){
        nbrMouvements++;
    }

    /**
     * Cette méthode permet d'incrémenter le compteur de programme de la tortue.
     */
    public void incrementerPc(){
        pc++;
    }
    //endregion
}
