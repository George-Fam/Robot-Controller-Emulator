package labyrinthe.instructions.ecriture;

import labyrinthe.model.Memoire;

/**
 * Cette classe représente une instruction d'écriture de la mémoire avec un ET bitwise.
 */
public class InstructionMet extends InstructionEcriture{

    /**
     * Constructeur de la classe labyrinthe.instructions.ecriture.InstructionMet.
     *
     * @param imm la valeur immédiate
     */
    public InstructionMet(int imm){
        super(imm);
    }

    /**
     * Cette méthode effectue un ET bitwise entre la valeur de la mémoire et la valeur immédiate
     * et met le résultat dans la mémoire.
     *
     * @param memoire la case mémoire de la tortue
     */
    @Override
    public void calculerMemoire(Memoire memoire) {
        memoire.setValeur(memoire.getValeur() & getValeurImm());
    }
}
