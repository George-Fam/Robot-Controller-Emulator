package labyrinthe.model;

/**
 * Classe contenant les constantes du programme
 */
public class Constantes {
    public static final String MSG_NOM_FIC_LAB = "Entrez le nom du fichier contenant la description du Labyrinthe : ";
    public static final String MSG_FIC_PROG = "Entrez le nom du fichier contenant le code RT-104 : ";
    public static final String MSG_DEPART_COL = "Entrez le numero de colonne de depart pour la tortue : ";
    public static final String MSG_DEPART_LIGNE = "Entrez le numero de ligne de depart pour la tortue : ";

    public static final String MSG_ETAT_NBR_INSTR = "Nombre instructions interpretees : ";
    public static final String MSG_ETAT_NBR_MOUV = "Nombre mouvements : ";
    public static final String MSG_ETAT_NBR_COLL = "Nombre collisions : ";

    public static final String MSG_ERR_IMM_PAS = "La valeur immédiate doit être entre 0 et 15";
    public static final String MSG_ERR_INSTR_INV = "labyrinthe.instructions.Instruction Invalide: ";
    public static final String MSG_ERR_CHAR_DIR_INV = "labyrinthe.model.Direction invalide (seulement n, e, s, o)";

    public static final int MIN_VAL_IMM = 0;
    public static final int MAX_VAL_IMM = 15;

    public static final char DIR_NORD = 'n';
    public static final char DIR_EST = 'e';
    public static final char DIR_SUD = 's';
    public static final char DIR_OUEST = 'o';

    public static final char PREM_CAR_AVANCER = 'a';
    public static final char PREM_CAR_TOURNER = 't';
    public static final char PREM_CAR_MEMOIRE = 'm';
    public static final char PREM_CAR_SAUT = 's';
    public static final char PREM_CAR_FIN = 'f';

    public static final String INSTR_FIN = "fin";
    public static final String INSTR_SEZ = "sez";
    public static final String INSTR_SOU = "sou";
    public static final String INSTR_SDI = "sdi";
    public static final String INSTR_SMA = "sma";
    public static final String INSTR_S = "s";
    public static final String INSTR_MET = "met";
    public static final String INSTR_MOU = "mou";
    public static final String INSTR_TAD = "tad";
    public static final String INSTR_TAG = "tag";
    public static final String INSTR_AVA = "ava";
}
