package labyrinthe.instructions.deplacement;

import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;
import labyrinthe.model.Vecteur;

/**
 * Cette classe représente une instruction d'avancement.
 *
 */
public class InstructionAva extends InstructionDeplacement{

    // region Constructeur
    /**
     * Constructeur de la classe labyrinthe.instructions.deplacement.InstructionAva.
     *
     * @param pas le nombre de pas à avancer
     */
    public InstructionAva(int pas){
        super(pas);
    }
    // endregion



    /**
     *  Cette méthode exécute l'instruction d'avancement.
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     * @throws IllegalArgumentException si le pas ne respecte pas les bornes(0-15).
     *
     */
    @Override
    public void executer(Tortue tortue, Labyrinthe labyrinthe) {
        verifierImm(getPas());
        avancer(tortue, labyrinthe);
        tortue.incrementerPc();
    }

    /**
     * Cette méthode vérifie si la tortue peut avancer. (s'il y a un mur ou non)
     *
     * @param position Position à vérifier
     * @param tortue Instance de la tortue (pour obtenir la direction de la tortue)
     * @param labyrinthe Instance du labyrinthe
     * @return true s'il y a un mur(collision) , false sinon
     */
    private boolean verifierCollision(Vecteur position, Tortue tortue, Labyrinthe labyrinthe) {
        return labyrinthe.aMur(position, tortue.getDirection());
    }

    /**
     * Cette méthode fait avancer la tortue et calcule le nombre de collisions et de mouvements.
     *
     * @param tortue Instance de la tortue
     * @param labyrinthe Instance du labyrinthe
     */
    private void avancer(Tortue tortue, Labyrinthe labyrinthe) {
        boolean collision = false;
        for (int i = 0; i < getPas() && !collision; i++) {
            Vecteur positionInitiale = tortue.getPosition();
            Vecteur positionFinale = positionInitiale.add(tortue.getDirection().getVecteurDeplacement());

            if (verifierCollision(positionInitiale, tortue, labyrinthe)) {
                collision = true;
                tortue.incrementerNbrCollisions();
            } else {
                tortue.setPosition(positionFinale);
                tortue.incrementerNbrMouvements();
            }
        }
    }
}
