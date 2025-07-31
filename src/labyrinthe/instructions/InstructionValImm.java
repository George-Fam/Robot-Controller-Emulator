package labyrinthe.instructions;

import labyrinthe.model.Constantes;

/**
 * Cette interface contient des méthodes pour les instructions avec une valeur immédiate.
 */
public interface InstructionValImm {

    /**
     * Cette méthode vérifie si la valeur immédiate est valide (entre 0 et 15 inclusivement).
     *
     * @param valeurImm la valeur immédiate
     * @throws IllegalArgumentException si la valeur immédiate est invalide
     */
    default void verifierImm(int valeurImm){
        if (valeurImm < Constantes.MIN_VAL_IMM || valeurImm > Constantes.MAX_VAL_IMM) {
            throw new IllegalArgumentException(Constantes.MSG_ERR_IMM_PAS);
        }
    }
}
