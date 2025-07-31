package labyrinthe.instructions.deplacement;

import labyrinthe.instructions.Instruction;
import labyrinthe.instructions.InstructionValImm;

/**
 * Cette interface contient les méthodes à implémenter pour exécuter une instruction de déplacement.
 */
public abstract class InstructionDeplacement implements Instruction, InstructionValImm {
    private int pas;

    // region Constructeur
    /**
     * Constructeur de la classe labyrinthe.instructions.deplacement.InstructionDeplacement.
     *
     * @param pas le nombre de pas à effectuer
     */
    public InstructionDeplacement(int pas){
        this.pas = pas;
    }
    // endregion

    /**
     * Cette méthode retourne le nombre de pas à effectuer.
     * @return le nombre de pas à effectuer
     */
    public int getPas() {
        return pas;
    }
}
