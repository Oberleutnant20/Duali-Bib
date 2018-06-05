/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package de.dualibib.Datenlogik.dto;

import java.util.ArrayList;

/**
 *
 * @author Carina
 */
interface DataTransferObject {
    public ArrayList getList();
    public void setList(ArrayList list);
    public ArrayList addToList(); //boolean?
    public void removeFromList();
    public int getSizeFromList();
}
