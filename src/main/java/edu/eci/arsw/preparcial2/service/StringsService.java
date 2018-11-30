/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.preparcial2.service;

import edu.eci.arsw.preparcial2.model.Cadena;
import java.util.List;

/**
 *
 * @author Jonathan Prieto
 */
public interface StringsService {

    public void addString(String contenido);

    public Cadena getString();

    public List<Cadena> getStrings();
}
