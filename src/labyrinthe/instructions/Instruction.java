package labyrinthe.instructions;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;


/**
 * Cette interface contient les méthodes à implémenter pour exécuter une instruction
 */
public interface Instruction {
    /**
     * Cette méthode exécute l'instruction.
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     */
    void executer(Tortue tortue, Labyrinthe labyrinthe);
}
