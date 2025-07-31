package labyrinthe.instructions.autres;

import labyrinthe.instructions.Instruction;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;

/**
 * Cette classe représente une instruction tad (tourne à droite).
 */
public class InstructionTad implements Instruction {

    /**
     * Cette méthode exécute l'instruction tad (tourne à droite).
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     */
    @Override
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        tortue.setDirection(tortue.getDirection().tourneHoraire());
        tortue.incrementerNbrMouvements();
        tortue.incrementerPc();
    }
}
