package labyrinthe.instructions.saut;

import labyrinthe.instructions.Instruction;
import labyrinthe.instructions.InstructionValImm;
import labyrinthe.model.Tortue;

/**
 * Cette classe abstraite représente les instructions de saut.
 */
public abstract class InstructionSaut implements Instruction, InstructionValImm {
    private int etiquette;
    private int valeurImm;

    //region Constructeurs
    /**
     * Constructeur de la classe labyrinthe.instructions.saut.InstructionSaut pour les instructions
     * avec une étiquette.
     *
     * @param etiquette l'étiquette de l'instruction
     */
    public InstructionSaut(int etiquette){
        setEtiquette(etiquette);
    }

    /**
     * Constructeur de la classe labyrinthe.instructions.saut.InstructionSaut pour les instructions
     * avec une étiquette et une valeur immédiate.
     *
     * @param etiquette l'étiquette de l'instruction
     * @param valeurImm la valeur immédiate de l'instruction
     */
    public InstructionSaut(int etiquette, int valeurImm){
        setEtiquette(etiquette);
        setValeurImm(valeurImm);
    }
    //endregion

    //region Getters et Setters
    /**
     * Cette méthode retourne la valeur immédiate de l'instruction.
     *
     * @return la valeur immédiate
     */
    public int getValeurImm(){
        return valeurImm;
    }

    /**
     * Cette méthode modifie la valeur immédiate de l'instruction.
     *
     * @param valeurImm la nouvelle valeur immédiate
     */
    public void setValeurImm(int valeurImm){
        this.valeurImm = valeurImm;
    }

    /**
     * Cette méthode modifie la valeur de l'étiquette de l'instruction.
     *
     * @param etiquette la nouvelle valeur de l'étiquette
     */
    public void setEtiquette(int etiquette){
        this.etiquette = etiquette;
    }
    //endregion

    /**
     * Cette méthode fait sauter la tortue à l'étiquette donnée (change le compteur ordinal).
     *
     * @param tortue l'instance de la tortue
     * @throws IllegalArgumentException si l'étiquette est invalide
     */
    public void faireSaut(Tortue tortue){
        verifierEtiquette(etiquette);
        tortue.setPc(etiquette);
    }

    /**
     * Cette méthode vérifie que l'étiquette est valide.
     *
     * @param etiquette l'étiquette à vérifier
     */
    private void verifierEtiquette(int etiquette) {
        if(etiquette < 0){
            throw new IllegalArgumentException("L'étiquette doit être un numéro de ligne dans le programme (positif)");
        }
    }

}
