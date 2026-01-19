package com.randu.uts.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import com.randu.uts.model.Warnet;
import com.randu.uts.dto.WarnetDTO;
import com.randu.uts.service.WarnetService;

import org.springframework.web.bind.annotation.*;



@RestController
@RequestMapping("/api/warnet")

public class WarnetController {

    @Autowired
    private WarnetService warnetService;

    private Warnet convertToEntity(WarnetDTO warnetDTO) {
        Warnet warnet = new Warnet();
        warnet.setId(warnetDTO.getId());
        warnet.setNama(warnetDTO.getNama());
        warnet.setTanggal(warnetDTO.getTanggal());
        warnet.setDurasiMasuk(warnetDTO.getDurasiMasuk());
        warnet.setDurasiKeluar(warnetDTO.getDurasiKeluar());
        warnet.setKategori(warnetDTO.getKategori());
        warnet.setTarifPerJam(warnetDTO.getTarifPerJam());
        warnet.setLama(warnetDTO.getLama());
        warnet.setDiskon(warnetDTO.getDiskon());
        warnet.setTotal(warnetDTO.getTotal());
        return warnet;
    }

    @PostMapping
    public ResponseEntity<Warnet> createWarnet(@RequestBody WarnetDTO warnetDTO) {
        if (warnetDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        Warnet warnet = convertToEntity(warnetDTO);
        Warnet savedWarnet = warnetService.createWarnet(warnet);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedWarnet);
    }
    
    @GetMapping
    public List<Warnet> getAllWarnets() {
        return warnetService.getAllWarnets();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Warnet> getWarnetById(@PathVariable Long id) {
        return warnetService.getWarnetById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    
    @PutMapping("/{id}")
    public ResponseEntity<Warnet> updateWarnet(
        @PathVariable Long id, 
        @RequestBody WarnetDTO warnetDTO) {
        if (warnetDTO == null) {
            return ResponseEntity.badRequest().build();
        }
        Warnet warnet = convertToEntity(warnetDTO);
        warnet.setId(id);
        try {
            Warnet updatedWarnet = warnetService.updateWarnet(id, warnet);
            return ResponseEntity.ok(updatedWarnet);
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWarnet(@PathVariable Long id) {
        warnetService.deleteWarnet(id);
        return ResponseEntity.noContent().build();
    }

}
