/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.preparcial2.controller;

import edu.eci.arsw.preparcial2.service.StringsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Jonathan Prieto
 */
@RestController
@RequestMapping("/strings")
public class StringsApiController {

    @Autowired
    private StringsService ss;

    @RequestMapping(method = RequestMethod.GET)
    public ResponseEntity<?> getStrings() {
        try {
            return new ResponseEntity<>(ss.getStrings(), HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>("Error al obtener las cadenas." + e, HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> setStrings(@RequestBody String contenido) {
        try {
            //registrar contenido
            //curl -i -X POST -HContent-Type:application/json -HAccept:application/json http://localhost:8080/strings -d 'anything'
            ss.addString(contenido);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (Exception ex) {
            return new ResponseEntity<>("Error al agregar la cadena: " + contenido, HttpStatus.FORBIDDEN);
        }
    }

}
