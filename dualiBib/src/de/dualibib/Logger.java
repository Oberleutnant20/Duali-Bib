package de.dualibib;

/**
 *
 * @author Carina
 */
public class Logger {

    private static final Logger INSTANCE = new Logger();
    private static boolean debug = false;
    private static boolean warnung = false;

    /**
     * Konstruktor der Klasse ist privat. Damit nicht weitere Instancen erstellt
     * werden können.
     */
    private Logger() {
    }

    /**
     *
     * @return eine Instanz von der Klasse Logger.
     */
    public static Logger getInstance() {
        return INSTANCE;
    }

    /**
     * Loggt eine Debug Ausgabe.
     *
     * @param b true oder false
     */
    public static void enableDebug(boolean b) {
        debug = b;
    }

    /**
     * Loggt <strong>Warnmeldungen</strong>.
     *
     * @param b true oder false
     */
    public static void enableWarnung(boolean b) {
        warnung = b;
    }

    /**
     * Loggt <strong>Info</strong> Meldungen im Log-File.
     *
     * @param o Objekt von welchem die Information ausgeht
     * @param msg Nachricht
     */
    public static void info(Object o, String msg) {
        System.out.println("info - " + o.getClass().getName() + ": " + msg);
    }

    /**
     * Debug Informationen zu einem Objekt.
     *
     * @param o Objekt
     * @param msg Nachricht
     */
    public static void debug(Object o, String msg) {
        if (debug) {
            System.out.println("debug - " + o.getClass().getName() + ": " + msg);
        }
    }

    /**
     * Warnungen zu einem Objekt.
     *
     * @param o Objekt
     * @param msg Nachricht
     */
    public static void warnung(Object o, String msg) {
        if (warnung) {
            System.out.println("warnung - " + o.getClass().getName() + ": " + msg);
        }
    }

    /**
     * Errors zu einem Objekt.
     *
     * @param o Objekt
     * @param msg Nachricht
     */
    public static void error(Object o, String msg) {
        System.out.println("error - " + o.getClass().getName() + ": " + msg);
    }
}
