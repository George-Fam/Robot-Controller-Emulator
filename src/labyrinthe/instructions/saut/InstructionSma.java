package labyrinthe.instructions.saut;

import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;

/**
 * Cette classe représente une instruction sma (saut si mur en avant de la tortue).
 */
public class InstructionSma extends InstructionSaut{

    /**
     * Constructeur de la classe labyrinthe.instructions.saut.InstructionSma.
     *
     * @param etiquette l'étiquette de l'instruction
     */
    public InstructionSma(int etiquette){
        super(etiquette);
    }

    /**
     * Cette méthode exécute l'instruction sma (saut si mur en avant de la tortue).
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     */
    @Override
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        if (labyrinthe.aMur(tortue.getPosition(), tortue.getDirection())) {
            faireSaut(tortue);
        } else {
            tortue.incrementerPc();
        }
    }
}
