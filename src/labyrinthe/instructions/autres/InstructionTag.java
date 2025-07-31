package labyrinthe.instructions.autres;

import labyrinthe.instructions.Instruction;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;

/**
 * Cette classe représente une instruction tag (tourne à gauche).
 */
public class InstructionTag implements Instruction {

    /**
     * Cette méthode exécute l'instruction tag (tourne à gauche).
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     */
    @Override
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        tortue.setDirection(tortue.getDirection().tourneAntiHoraire());
        tortue.incrementerNbrMouvements();
        tortue.incrementerPc();
    }
}
