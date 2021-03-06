package de.dualibib.Fachlogik.Ausleihverwaltung;

import de.dualibib.Datenlogik.dto.Ausleihe;
import de.dualibib.Datenlogik.idao.IAusleiheDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Ausleiheverwaltung extends ElternVerwaltung {

    private ArrayList<Ausleihe> ausleiheListe;
    private ArrayList<Ausleihe> ausleiheListeRef;
    private ArrayList<Ausleihe> ausleiheListeUpdate;
    private ArrayList<Ausleihe> ausleiheListeDelete;
    private IAusleiheDAO ausleiheDAO;

    /**
     * Konstruktor für die Ausleihe Verwaltung.
     *
     * @param ausleiheDAO Ausleihe Datenbankobjekt
     */
    public Ausleiheverwaltung(IAusleiheDAO ausleiheDAO) {
        ausleiheListe = new ArrayList<>();
        ausleiheListeRef = new ArrayList<>();
        ausleiheListeUpdate = new ArrayList<>();
        ausleiheListeDelete = new ArrayList<>();
        this.ausleiheDAO = ausleiheDAO;
        laden();
    }

    /**
     * Speichert die Ausleihe ab.
     *
     * @throws IOException
     * @throws ConnectionError
     */
    public void speichern() throws IOException, ConnectionError {
        List<Ausleihe> liste = new ArrayList<>();
        if (ausleiheListe.size() > ausleiheListeRef.size()) {
            liste = ausleiheListe.subList(ausleiheListeRef.size(), ausleiheListe.size());
        }
        ausleiheDAO.speichern(liste);
        ausleiheDAO.loeschen(ausleiheListeDelete);
    }

    /**
     * Läd die Ausleihe.
     */
    public void laden() {
        ausleiheListe.clear();
        ausleiheListeRef.clear();
        de.dualibib.Logger.debug(this, "laden");
        try {
            List<Ausleihe> liste = ausleiheDAO.laden();
            for (Ausleihe ausleihe : liste) {
                ausleiheListe.add(ausleihe);
                ausleiheListeRef.add(ausleihe);
            }
        } catch (Exception e) {
            de.dualibib.Logger.error(this, "laden Error");
        }
    }

    /**
     * Fügt der Ausleihe ein neues Element hinzu.
     *
     * @param ausleihe Ausleihe, was hinzugefügt werden soll.
     */
    public void add(Ausleihe ausleihe) {
        if (!ausleiheListe.add(ausleihe)) {
            de.dualibib.Logger.error(this, "Ausleihe gibt es bereits.");
        }
        notifyPanels();
    }

    /**
     * Löscht ein Ausleihe Element.
     *
     * @param ausleihe Ausleihe, welches gelöscht werden soll.
     */
    public void delete(Ausleihe ausleihe) {
        if (!ausleiheListeDelete.add(ausleihe)) {
            de.dualibib.Logger.error(this, "Ausleihe gibt es nicht.");
        } else {
            ausleiheListe.remove(ausleihe);
            notifyPanels();
        }
    }

    /**
     * Updatet ein Ausleihe Element
     *
     * @param ausleihe Ausleihe, welche upgedatet werden soll
     */
    public void update(Ausleihe ausleihe) {
        if (!ausleiheListeUpdate.add(ausleihe)) {
            de.dualibib.Logger.error(this, "Ausleihe gibt es nicht.");
        }
        notifyPanels();
    }

    public ArrayList<Ausleihe> get() {
        ArrayList<Ausleihe> liste = new ArrayList<>();
        ausleiheListe.forEach((ausleihe) -> {
            liste.add(ausleihe);
        });
        return liste;
    }
}
