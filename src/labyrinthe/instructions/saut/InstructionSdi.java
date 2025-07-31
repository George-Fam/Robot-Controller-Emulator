package labyrinthe.instructions.saut;

import labyrinthe.model.Constantes;
import labyrinthe.model.Direction;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;

/**
 * Cette classe représente une instruction de type Sdi. (saut si direction)
 */
public class InstructionSdi extends InstructionSaut{
    private Direction direction;
    private char directionChar;

    /**
     * Constructeur de la classe labyrinthe.instructions.saut.InstructionSdi.
     *
     * @param directionChar la direction de la tortue à vérifier (en char)
     * @param etiquette l'étiquette de l'instruction
     */
    public InstructionSdi (char directionChar, int etiquette){
        super(etiquette);
        this.directionChar = directionChar;
    }

    /**
     * Cette méthode modifie l'attribut direction selon la direction en char donnée.
     *
     * @param directionChar la direction de la tortue à vérifier (en char)
     * @throws IllegalArgumentException si la direction en char est invalide
     */
    public void setDirection(char directionChar) {
        switch (directionChar) {
            case Constantes.DIR_NORD -> direction = Direction.Nord;
            case Constantes.DIR_EST -> direction = Direction.Est;
            case Constantes.DIR_SUD -> direction = Direction.Sud;
            case Constantes.DIR_OUEST -> direction = Direction.Ouest;
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_CHAR_DIR_INV);
        }
    }

    /**
     * Cette méthode exécute l'instruction de saut si la direction de la tortue est la même que celle donnée.
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     */
    @Override
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        setDirection(directionChar);
        if (tortue.getDirection() == direction){
            faireSaut(tortue);
        } else {
            tortue.incrementerPc();
        }
    }
}
