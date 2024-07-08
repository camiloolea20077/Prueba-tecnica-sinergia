package com.prueba.inicio.controller;

import com.prueba.inicio.model.Puerto;
import com.prueba.inicio.service.PuertoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/puertos")
@CrossOrigin(origins = {"http://localhost:4200"})
public class PuertoController {
    
    @Autowired
    private PuertoService puertoService;

    @PostMapping
    public ResponseEntity<Puerto> createPuerto(@RequestBody Puerto puerto) {
        Puerto createdPuerto = puertoService.savePuerto(puerto);
        return new ResponseEntity<>(createdPuerto, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Puerto>> getAllPuertos() {
        List<Puerto> puertos = puertoService.getAllPuertos();
        return new ResponseEntity<>(puertos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Puerto> getPuertoById(@PathVariable Long id) {
        Puerto puerto = puertoService.getPuertoById(id);
        return puerto != null ? new ResponseEntity<>(puerto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Puerto> updatePuerto(@PathVariable Long id, @RequestBody Puerto puertoDetails) {
        Puerto updatedPuerto = puertoService.updatePuerto(id, puertoDetails);
        return updatedPuerto != null ? new ResponseEntity<>(updatedPuerto, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePuerto(@PathVariable Long id) {
        puertoService.deletePuerto(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
