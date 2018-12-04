package edu.eci.arsw.preparcial2;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import edu.eci.arsw.preparcial2.controller.StringsApiController;
import edu.eci.arsw.preparcial2.service.StringsService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Jonathan Prieto
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AppServiceTests {

    @Autowired
    private StringsApiController sac;

    private String mensaje;

    public AppServiceTests() {
    }

    @Before
    public void setUp() {
        mensaje = "SpringBootTest: ";
    }

    @Test
    public void registros() throws Exception{
        ExecutorService es = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            RequestService registro = new RequestService(mensaje + i);
            es.execute(registro);
        }
        try {
            es.awaitTermination(30, TimeUnit.SECONDS);
        } catch (InterruptedException ex) {
            Logger.getLogger(AppServiceTests.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    public class RequestService implements Runnable {

        private String contenido;

        public RequestService(String contenido) {
            this.contenido = contenido;
        }

        @Override
        public void run() {
            sac.setStrings(contenido);
        }

    }
}
