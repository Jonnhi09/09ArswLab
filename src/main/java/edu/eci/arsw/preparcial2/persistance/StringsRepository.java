/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.eci.arsw.preparcial2.persistance;

import java.util.List;
import edu.eci.arsw.preparcial2.model.Cadena;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author Jonathan Prieto
 */
public interface StringsRepository extends MongoRepository<Cadena, String> {

    public List<Cadena> findByFecha(String fecha);
}
