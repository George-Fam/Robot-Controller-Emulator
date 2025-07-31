package labyrinthe;

import labyrinthe.instructions.*;
import labyrinthe.instructions.autres.InstructionFin;
import labyrinthe.instructions.autres.InstructionTad;
import labyrinthe.instructions.autres.InstructionTag;
import labyrinthe.instructions.deplacement.InstructionAva;
import labyrinthe.instructions.ecriture.InstructionMet;
import labyrinthe.instructions.ecriture.InstructionMou;
import labyrinthe.instructions.saut.*;
import labyrinthe.model.Constantes;
import labyrinthe.model.Labyrinthe;
import labyrinthe.model.Tortue;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Cette classe représente l'interpréteur du programme.
 */
public class Interpreteur {
    private Tortue tortue;
    private Labyrinthe labyrinthe;
    private ArrayList<Instruction> instructions;

    /**
     * Constructeur de la classe labyrinthe.Interpreteur
     *
     * @param tortue l'instance de la tortue
     * @param labyrinthe l'instance du labyrinthe
     * @param instructions la liste des instructions du programme
     */
    public Interpreteur(Tortue tortue, Labyrinthe labyrinthe, ArrayList<Instruction> instructions){
        this.tortue = tortue;
        this.labyrinthe = labyrinthe;
        this.instructions = instructions;
    }

    /**
     * Cette méthode exécute le programme (exécute les instructions et imprime l'état de la tortue).
     *
     * @throws IllegalArgumentException si la valeur immédiate ou l'étiquette d'une instruction est invalide
     */
    public void executer(){
        while(!estInstructionFin(instructions.get(tortue.getPc()))){
            int ancientPc = tortue.getPc();
            instructions.get(tortue.getPc()).executer(tortue, labyrinthe);
            tortue.incrementerNbrInstructions();
            imprimerEtat(ancientPc);
        }
        tortue.incrementerNbrInstructions();
        imprimerEtat(tortue.getPc());
        imprimerEtatFinal();
    }

    /**
     * Cette méthode charge les instructions du programme dans la liste des instructions.
     *
     * @param entreesProgramme le scanner du fichier du programme
     * @throws IllegalArgumentException si l'instruction ne correspond à aucune instruction valide
     */
    public void loadInstructions(Scanner entreesProgramme) {
    while (entreesProgramme.hasNextLine()) {
        String ligne = entreesProgramme.nextLine();
        String[] parties = ligne.split(" ");
        Instruction instruction = identifierInstruction(parties);
        instructions.add(instruction);
    }
}

    /**
     * Cette méthode identifie l'instruction affin de la charger dans la liste des instructions.
     *
     * @param parties les parties de la ligne du programme
     * @return l'instruction correspondante
     * @throws IllegalArgumentException si l'instruction ne correspond à aucune instruction valide
     */
    private static Instruction identifierInstruction(String[] parties) {
        char premierCaractere = parties[0].charAt(0);
        return switch (premierCaractere) {
            case Constantes.PREM_CAR_AVANCER -> identifierInsAvancer(parties);
            case Constantes.PREM_CAR_TOURNER -> identfierInsTourner(parties);
            case Constantes.PREM_CAR_MEMOIRE -> identifierInsMemoire(parties);
            case Constantes.PREM_CAR_SAUT -> identfierInsSaut(parties);
            case Constantes.PREM_CAR_FIN -> identfierInsFin(parties);
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_INSTR_INV + parties[0]);
        };
    }

    /**
     * Cette méthode identifie l'instruction de fin.
     *
     * @param parties les parties de la ligne du programme
     * @return Une instance d'instruction de fin
     */
    private static Instruction identfierInsFin(String[] parties) {
        return switch (parties[0]) {
            case Constantes.INSTR_FIN -> new InstructionFin();
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_INSTR_INV + parties[0]);
        };
    }

    /**
     * Cette méthode identifie les instructions de saut (sez, sou, sdi, sma, s).
     *
     * @param parties les parties de la ligne du programme
     * @return Une instance d'instruction de saut correspondante
     */
    private static Instruction identfierInsSaut(String[] parties) {
        return switch (parties[0]) {
            case Constantes.INSTR_SEZ -> new InstructionSez(Integer.parseInt(parties[1]), Integer.parseInt(parties[2]));
            case Constantes.INSTR_SOU -> new InstructionSou(Integer.parseInt(parties[1]), Integer.parseInt(parties[2]));
            case Constantes.INSTR_SDI -> new InstructionSdi(parties[1].charAt(0),Integer.parseInt(parties[2]));
            case Constantes.INSTR_SMA -> new InstructionSma(Integer.parseInt(parties[1]));
            case Constantes.INSTR_S -> new InstructionS(Integer.parseInt(parties[1]));
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_INSTR_INV + parties[0]);
        };
    }

    /**
     * Cette méthode identifie les instructions d'écriture mémoire (met, mou).
     *
     * @param parties les parties de la ligne du programme
     * @return Une instance d'instruction d'écriture mémoire correspondante
     */
    private static Instruction identifierInsMemoire(String[] parties) {
        return switch (parties[0]) {
            case Constantes.INSTR_MET -> new InstructionMet(Integer.parseInt(parties[1]));
            case Constantes.INSTR_MOU -> new InstructionMou(Integer.parseInt(parties[1]));
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_INSTR_INV + parties[0]);
        };
    }

    /**
     * Cette méthode identifie les instructions de tourner (tad, tag).
     *
     * @param parties les parties de la ligne du programme
     * @return Une instance d'instruction de tourner correspondante
     */
    private static Instruction identfierInsTourner(String[] parties) {
        return switch (parties[0]) {
            case Constantes.INSTR_TAD -> new InstructionTad();
            case Constantes.INSTR_TAG -> new InstructionTag();
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_INSTR_INV + parties[0]);
        };
    }

    /**
     * Cette méthode identifie l'instruction avancer (ava).
     *
     * @param parties les parties de la ligne du programme
     * @return Une instance d'instruction avancer
     */
    private static Instruction identifierInsAvancer(String[] parties) {
        return switch (parties[0]) {
            case Constantes.INSTR_AVA -> new InstructionAva(Integer.parseInt(parties[1]));
            default -> throw new IllegalArgumentException(Constantes.MSG_ERR_INSTR_INV + parties[0]);
        };
    }

    /**
     * Cette méthode vérifie si l'instruction est une instruction de fin (une instance de labyrinthe.instructions.autres.InstructionFin).
     *
     * @param instruction l'instruction à vérifier
     * @return true si l'instruction est une instruction de fin, false sinon
     */
    private boolean estInstructionFin(Instruction instruction) {
        return instruction instanceof InstructionFin;
    }

    /**
     * Cette méthode imprime l'état final de la tortue.
     */
    private void imprimerEtatFinal() {
        System.out.println(Constantes.MSG_ETAT_NBR_INSTR + tortue.getNbrInstructions());
        System.out.println(Constantes.MSG_ETAT_NBR_MOUV + tortue.getNbrMouvements());
        System.out.println(Constantes.MSG_ETAT_NBR_COLL + tortue.getNbrCollisions());
    }

    /**
     * Cette méthode imprime l'état de la tortue.
     *
     * @param pc le compteur ordinal du programme
     */
    private void imprimerEtat(int pc) {
        System.out.println( pc + " : " + tortue.getPosition() + " " + tortue.getDirection());
    }

}
