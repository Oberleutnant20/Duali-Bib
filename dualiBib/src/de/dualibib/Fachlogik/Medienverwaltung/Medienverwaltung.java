package de.dualibib.Fachlogik.Medienverwaltung;

import de.dualibib.Datenlogik.dto.Medien;
import de.dualibib.Datenlogik.idao.IMedienDAO;
import de.dualibib.Fachlogik.ElternVerwaltung;
import de.dualibib.info.exceptions.ConnectionError;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carina
 */
public class Medienverwaltung extends ElternVerwaltung {

    private ArrayList<Medien> medienListe;
    private ArrayList<Medien> medienListeRef;
    private ArrayList<Medien> medienListeUpdate;
    private ArrayList<Medien> medienListeDelete;
    private IMedienDAO medienDAO;

    /**
     * Konstruktor für die Medienverwaltung.
     *
     * @param medienDAO Medien Datenbankobjekt
     */
    public Medienverwaltung(IMedienDAO medienDAO) {
        medienListe = new ArrayList<>();
        medienListeRef = new ArrayList<>();
        medienListeUpdate = new ArrayList<>();
        medienListeDelete = new ArrayList<>();
        this.medienDAO = medienDAO;
        laden();
    }

    /**
     * Speichert die Medien Liste ab.
     * @throws IOException
     * @throws ConnectionError 
     */
    public void speichern() throws IOException, ConnectionError {
        List<Medien> liste = new ArrayList<>();
        if (medienListe.size() > medienListeRef.size()) {
            liste = medienListe.subList(medienListeRef.size(), medienListe.size());
        }
        medienDAO.speichern(liste);
        medienDAO.update(medienListeUpdate);
    }

    /**
     * Läd die Medien.
     */
    public void laden() {
        medienListe.clear();
        medienListeRef.clear();
        de.dualibib.Logger.debug(this, "laden");
        try {
            List<Medien> liste = medienDAO.laden();
            for (Medien medium : liste) {
                medienListe.add(medium);
                medienListeRef.add(medium);
            }
        } catch (Exception e) {
            de.dualibib.Logger.error(this, "laden");
        }
    }

    /**
     * Fügt der Medienliste neue Elemente hinzu.
     * @param medium Medium, welches hinzugefügt werden soll
     */
    public void add(Medien medium) {
        if (!medienListe.add(medium)) {
            de.dualibib.Logger.error(this, "Medium gibt es bereits.");
        }
        notifyPanels();
    }

    /**
     * Löscht ein Medien Element.
     * @param medien Medium, welches gelöscht werden soll
     */
    public void delete(Medien medien) {
        if (!medienListe.remove(medien)) {
            de.dualibib.Logger.error(this, "Medium gibt es nicht.");
        }
        notifyPanels();
    }

    /**
     * Updatet ein Medien Element.
     * @param medien Medium, welches upgedatet werden soll
     */
    public void update(Medien medien) {
        if (!medienListe.add(medien)) {
            de.dualibib.Logger.error(this, "Medium gibt es bereits.");
        }
        medienListeUpdate.add(medien);
        notifyPanels();
    }

    public ArrayList<Medien> get() {
        ArrayList<Medien> liste = new ArrayList<>();
        for (Medien medien : medienListe) {
            liste.add(medien);
            de.dualibib.Logger.debug(this, medien.getName());
        }
        return liste;
    }

}
