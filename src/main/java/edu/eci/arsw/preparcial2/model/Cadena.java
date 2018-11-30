/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.preparcial2.model;

import java.util.Date;
import org.springframework.data.annotation.Id;

/**
 *
 * @author Jonathan Prieto
 */
public class Cadena {

    @Id
    public String id;

    private String contenido;
    private String fecha;

    public Cadena() {
    }

    
    
    public Cadena(String contenido) {
        this.contenido = contenido;
        this.fecha = new Date().toString();
    }

    public Cadena(String contenido, String fecha) {
        this.contenido = contenido;
        this.fecha = fecha;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    @Override
    public String toString() {
        return String.format(
                "String[id=%s, date='%s', content='%s']",
                id, fecha, contenido);
    }

}
