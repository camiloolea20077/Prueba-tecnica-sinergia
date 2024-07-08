package com.prueba.inicio.controller;

import com.prueba.inicio.model.Bodega;
import com.prueba.inicio.service.BodegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bodegas")
@CrossOrigin(origins = {"http://localhost:4200"})
public class BodegaController {
    
    @Autowired
    private BodegaService bodegaService;

    @PostMapping
    public ResponseEntity<Bodega> createBodega(@RequestBody Bodega bodega) {
        Bodega createdBodega = bodegaService.saveBodega(bodega);
        return new ResponseEntity<>(createdBodega, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Bodega>> getAllBodegas() {
        List<Bodega> bodegas = bodegaService.getAllBodegas();
        return new ResponseEntity<>(bodegas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Bodega> getBodegaById(@PathVariable Long id) {
        Bodega bodega = bodegaService.getBodegaById(id);
        return bodega != null ? new ResponseEntity<>(bodega, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Bodega> updateBodega(@PathVariable Long id, @RequestBody Bodega bodegaDetails) {
        Bodega updatedBodega = bodegaService.updateBodega(id, bodegaDetails);
        return updatedBodega != null ? new ResponseEntity<>(updatedBodega, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBodega(@PathVariable Long id) {
        bodegaService.deleteBodega(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
