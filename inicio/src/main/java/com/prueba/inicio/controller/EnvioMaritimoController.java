package com.prueba.inicio.controller;

import com.prueba.inicio.model.EnvioMaritimo;
import com.prueba.inicio.service.EnvioMaritimoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios-maritimos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EnvioMaritimoController {
    
    @Autowired
    private EnvioMaritimoService envioMaritimoService;

    @PostMapping
    public ResponseEntity<EnvioMaritimo> createEnvioMaritimo(@RequestBody EnvioMaritimo envioMaritimo) {
        EnvioMaritimo createdEnvioMaritimo = envioMaritimoService.saveEnvioMaritimo(envioMaritimo);
        return new ResponseEntity<>(createdEnvioMaritimo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnvioMaritimo>> getAllEnviosMaritimos() {
        List<EnvioMaritimo> enviosMaritimos = envioMaritimoService.getAllEnviosMaritimos();
        return new ResponseEntity<>(enviosMaritimos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioMaritimo> getEnvioMaritimoById(@PathVariable Long id) {
        EnvioMaritimo envioMaritimo = envioMaritimoService.getEnvioMaritimoById(id);
        return envioMaritimo != null ? new ResponseEntity<>(envioMaritimo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioMaritimo> updateEnvioMaritimo(@PathVariable Long id, @RequestBody EnvioMaritimo envioMaritimoDetails) {
        EnvioMaritimo updatedEnvioMaritimo = envioMaritimoService.updateEnvioMaritimo(id, envioMaritimoDetails);
        return updatedEnvioMaritimo != null ? new ResponseEntity<>(updatedEnvioMaritimo, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvioMaritimo(@PathVariable Long id) {
        envioMaritimoService.deleteEnvioMaritimo(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}