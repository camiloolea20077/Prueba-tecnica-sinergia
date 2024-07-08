package com.prueba.inicio.controller;

import com.prueba.inicio.model.EnvioTerrestre;
import com.prueba.inicio.service.EnvioTerrestreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/envios-terrestres")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EnvioTerrestreController {
    
    @Autowired
    private EnvioTerrestreService envioTerrestreService;

    @PostMapping
    public ResponseEntity<EnvioTerrestre> createEnvioTerrestre(@RequestBody EnvioTerrestre envioTerrestre) {
        EnvioTerrestre createdEnvioTerrestre = envioTerrestreService.saveEnvioTerrestre(envioTerrestre);
        return new ResponseEntity<>(createdEnvioTerrestre, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<EnvioTerrestre>> getAllEnviosTerrestres() {
        List<EnvioTerrestre> enviosTerrestres = envioTerrestreService.getAllEnviosTerrestres();
        return new ResponseEntity<>(enviosTerrestres, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnvioTerrestre> getEnvioTerrestreById(@PathVariable Long id) {
        EnvioTerrestre envioTerrestre = envioTerrestreService.getEnvioTerrestreById(id);
        return envioTerrestre != null ? new ResponseEntity<>(envioTerrestre, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnvioTerrestre> updateEnvioTerrestre(@PathVariable Long id, @RequestBody EnvioTerrestre envioTerrestreDetails) {
        EnvioTerrestre updatedEnvioTerrestre = envioTerrestreService.updateEnvioTerrestre(id, envioTerrestreDetails);
        return updatedEnvioTerrestre != null ? new ResponseEntity<>(updatedEnvioTerrestre, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEnvioTerrestre(@PathVariable Long id) {
        envioTerrestreService.deleteEnvioTerrestre(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
