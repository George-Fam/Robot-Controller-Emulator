package labyrinthe.instructions.ecriture;

import labyrinthe.instructions.Instruction;
import labyrinthe.instructions.InstructionValImm;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Memoire;
import labyrinthe.model.Tortue;

/**
 * Cette classe abstraite contient les méthodes et attributs communs aux instructions d'écriture
 */
public abstract class InstructionEcriture implements Instruction, InstructionValImm {
    private int valeurImm;

    // region Constructeur
    /**
     * Constructeur de la classe labyrinthe.instructions.ecriture.InstructionEcriture.
     *
     * @param valeurImm la valeur immédiate à utiliser dans l'écriture
     */
    public InstructionEcriture(int valeurImm){
        this.valeurImm = valeurImm;
    }
    // endregion

    //region Getter
    /**
     * Cette méthode retourne la valeur immédiate à utiliser dans l'écriture.
     * @return la valeur immédiate à utiliser dans l'écriture
     */
    public int getValeurImm() {
        return valeurImm;
    }
    //endregion

    //region Autres Methodes
    /**
     * Cette méthode exécute l'instruction d'écriture.
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     * @throws IllegalArgumentException si la valeur immédiate ne respecte pas les bornes(0-15).
     */
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        verifierImm(valeurImm);
        calculerMemoire(tortue.getMemoire());
        tortue.incrementerPc();
    }

    /**
     * Cette méthode abstraite calcule la mémoire de la tortue.
     *
     * @param memoire la case mémoire de la tortue
     */
    public abstract void calculerMemoire(Memoire memoire);
    //endregion
}
