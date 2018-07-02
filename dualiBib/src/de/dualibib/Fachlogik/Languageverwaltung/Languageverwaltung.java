package de.dualibib.Fachlogik.Languageverwaltung;

import de.dualibib.Fachlogik.ElternVerwaltung;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

/**
 *
 * @author Carina
 */
public class Languageverwaltung extends ElternVerwaltung {

    private Properties props;

    public Languageverwaltung() {
        props = new Properties();
    }

    public void getDeutsch() throws FileNotFoundException, IOException {
        de.dualibib.Logger.debug(this, "getDeutsch");
        FileReader fileReader = new FileReader("deutsch.props");
        props.load(fileReader);
        notifyLanguagePanels(props);
    }
    
    public void getEnglisch() throws FileNotFoundException, IOException {
        de.dualibib.Logger.debug(this, "getEnglisch");
        FileReader fileReader = new FileReader("englisch.props");
        props.load(fileReader);
        notifyLanguagePanels(props);
    }
    
    public void getJapanisch() throws FileNotFoundException, IOException {
        de.dualibib.Logger.debug(this, "getJapanisch");
        FileReader fileReader = new FileReader("/Languages/japanisch.props");
        props.load(fileReader);
        notifyLanguagePanels(props);
    }
}
