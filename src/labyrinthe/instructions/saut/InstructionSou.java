package labyrinthe.instructions.saut;

import labyrinthe.model.Constantes;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;

/**
 * Cette classe représente une instruction sou (saut si ou bitwise
 * entre la mémoire et la valeur immédiate est égale à 15).
 */
public class InstructionSou extends InstructionSaut{

    /**
     * Constructeur de la classe labyrinthe.instructions.saut.InstructionSou.
     *
     * @param imm la valeur immédiate
     * @param etiquette l'étiquette de l'instruction
     */
    public InstructionSou(int imm, int etiquette){
        super(etiquette, imm);
    }

    /**
     * Cette méthode exécute l'instruction sou (saut si ou bitwise
     * entre la mémoire et la valeur immédiate est égale à 15).
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     * @throws IllegalArgumentException si la valeur immédiate est invalide
     */
    @Override
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        verifierImm(getValeurImm());
        if ((tortue.getMemoire().getValeur() | getValeurImm()) == Constantes.MAX_VAL_IMM){
            faireSaut(tortue);
        } else {
            tortue.incrementerPc();
        }
    }
}