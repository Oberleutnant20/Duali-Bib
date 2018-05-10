/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.info.exceptions;

/**
 *
 * @author Tim Lorse
 * @version 0.1
 * @since 0.1
 */
public class ConnectionError extends Exception{
    public ConnectionError(){
        super("Connection ist nicht vorhanden. Bitte Prüfen. \n"
                + "Sollte der Fehler weiterhin bestehen, bitte die Entwickler kontaktieren.");
    }
}
