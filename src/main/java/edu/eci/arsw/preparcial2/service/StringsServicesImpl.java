/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.preparcial2.service;

import java.util.List;
import edu.eci.arsw.preparcial2.model.Cadena;
import edu.eci.arsw.preparcial2.persistance.StringsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;

/**
 *
 * @author Jonathan Prieto
 */
@Service
public class StringsServicesImpl implements StringsService {

    @Autowired
    StringsRepository repositorio;

    @Override
    public void addString(String contenido) {
        repositorio.save(new Cadena(contenido));
    }

    @Override
    public List<Cadena> getStrings() {
        return repositorio.findAll(new Sort(Direction.DESC, "fecha"));
    }
}
