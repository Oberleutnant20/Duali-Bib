/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Tim Lorse
 */
public class Information {
    
    // TODO - Name, Mail, Version, Copyright
    private final String name = "";
    private final String mail = "";
    private final String version = "";
    private final String copyright = "";
    private final String info = "Diese Funktion ist noch in der Entwicklung";

    /**
     * Bei der Entwicklerinformation ist<br>
     * Der Author, die Mailadresse, die Version der Datei und das Copyright hinterlegt
     *
     * @return EntwicklerInformationen
     */
    public String printEntwickler() {
        return "Name: " + name + " \n"
                + "Mail: " + mail + " \n"
                + "Version: " + version + " \n"
                + "©" + copyright;
    }
    
    /**
     * Bei der Entwicklungsinformation ist <br>
     * nur der Status der Entwicklung hinterlegt
     * 
     * @param info Information zum Entwicklungsstatus
     * @return Status der Entwickung
     */
    public String printEntwicklung(String info){
        if(info.equals("")|| info.isEmpty()){
            return this.info;
        } else {
            return info;
        }
    }
}
