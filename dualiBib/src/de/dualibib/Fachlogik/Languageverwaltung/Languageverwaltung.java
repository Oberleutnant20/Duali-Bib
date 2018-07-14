package de.dualibib.Fachlogik.Languageverwaltung;

import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.Logger;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Properties;
import java.util.logging.Level;

/**
 *
 * @author Carina
 */
public class Languageverwaltung extends ElternVerwaltung {

    private Properties props;

    /**
     * Konstruktor für die Sprachenverwaltung.
     */
    public Languageverwaltung() {
        props = new Properties();
    }

    /**
     * Läd die deutschen Properties.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void getDeutsch() throws FileNotFoundException, IOException {
        de.dualibib.Logger.debug(this, "getDeutsch");
        FileReader fileReader = new FileReader("deutsch.props");
        props.load(fileReader);
        notifyLanguagePanels(props);
    }

    /**
     * Läd die Englischen Properties.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void getEnglisch() throws FileNotFoundException, IOException {
        de.dualibib.Logger.debug(this, "getEnglisch");
        FileReader fileReader = new FileReader("englisch.props");
        props.load(fileReader);
        notifyLanguagePanels(props);
    }

    /**
     * Läd die Japanischen Properties.
     *
     * @throws FileNotFoundException
     * @throws IOException
     */
    public void getJapanisch() throws FileNotFoundException, IOException {
        de.dualibib.Logger.debug(this, "getJapanisch");
        FileReader fileReader = new FileReader("japanisch.props");
        props.load(fileReader);
        notifyLanguagePanels(props);
    }
}
