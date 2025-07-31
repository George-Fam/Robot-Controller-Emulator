package labyrinthe;

import labyrinthe.instructions.Instruction;
import labyrinthe.io.Lecteurs;
import labyrinthe.model.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe est le point d'entrée du programme.
 */
public class Principal {
    /**
     * Méthode principale du programme.
     */
    public static void main(String[] args) {
        String nomFichierLabyrinthe;
        Labyrinthe labyrinthe;
        String nomFichierProgramme;
        Tortue tortue;
        Interpreteur interpreteur;
        Scanner clavier = new Scanner( System.in );

        nomFichierLabyrinthe = lireNomFichier(Constantes.MSG_NOM_FIC_LAB, clavier);
        labyrinthe = initialiserLabyrinthe(nomFichierLabyrinthe);
        nomFichierProgramme = lireNomFichier(Constantes.MSG_FIC_PROG, clavier);
        tortue = initialiserTortue(nomFichierLabyrinthe,clavier);
        clavier.close();

        interpreteur = initialiserInterpreteur(nomFichierProgramme, tortue, labyrinthe);

        interpreteur.executer();
    }
    /**
     * Lire le nom d'un fichier à partir de l'entrée standard
     *
     * @param messageSolicitation le message de solicitation
     * @param clavier             Le stream d'entrée (clavier)
     * @return le nom du fichier
     */
    private static String lireNomFichier(String messageSolicitation, Scanner clavier) {
        System.out.print(messageSolicitation);
        return clavier.next();
    }

    /**
     * Initialise une instance de labyrinthe avec les informations du fichier labyrinthe
     *
     * @param nomFichierLabyrinthe le nom du fichier labyrinthe
     * @return Instance de labyrinthe
     */
    private static Labyrinthe initialiserLabyrinthe(String nomFichierLabyrinthe) {
        Scanner entreesLabyrinthe = Lecteurs.ouvrirScanner(nomFichierLabyrinthe);
        Labyrinthe labyrinthe = Labyrinthe.lire(entreesLabyrinthe);
        entreesLabyrinthe.close();
        return labyrinthe;
    }

    /**
     * Initialise une instance tortue avec les informations du fichier labyrinthe et programme
     *
     * @param nomFichierLabyrinthe le nom du fichier labyrinthe
     * @param clavier              Le stream d'entree (clavier)
     * @return Instance de tortue
     */
    public static Tortue initialiserTortue(String nomFichierLabyrinthe, Scanner clavier){
        Vecteur positionDepart;

        System.out.print(Constantes.MSG_DEPART_COL);
        int colonneDepart = clavier.nextInt();
        System.out.print(Constantes.MSG_DEPART_LIGNE);
        int ligneDepart = clavier.nextInt();
        positionDepart = new Vecteur(colonneDepart, ligneDepart);

        Scanner entreesLabyrinthe = Lecteurs.ouvrirScanner(nomFichierLabyrinthe);
        int nbColonne = entreesLabyrinthe.nextInt();
        int nbLigne = entreesLabyrinthe.nextInt();
        Tortue tortue = new Tortue(positionDepart);
        tortue.initialiserMemoire(nbColonne, nbLigne);
        entreesLabyrinthe.close();
        return tortue;
    }
    /**
     * Initialise une instance de l'interpreteur.
     *
     * @param nomFichierProgramme   le nom du fichier programme
     * @param tortue                L'instance de la tortue
     * @param labyrinthe            the labyrinthe
     * @return Une instance de l'interpreteur
     */
    private static Interpreteur initialiserInterpreteur(String nomFichierProgramme, Tortue tortue,
                                                        Labyrinthe labyrinthe) {
        Scanner entreesProgramme = Lecteurs.ouvrirScanner(nomFichierProgramme);
        ArrayList<Instruction> instructions = new ArrayList<>();
        Interpreteur interpreteur = new Interpreteur(tortue, labyrinthe, instructions);
        interpreteur.loadInstructions(entreesProgramme);
        entreesProgramme.close();
        return interpreteur;
    }
}
