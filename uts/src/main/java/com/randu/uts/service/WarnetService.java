package com.randu.uts.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.randu.uts.model.Warnet;
import com.randu.uts.repository.WarnetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Optional;
import java.util.List;

@Service
public class WarnetService {
@Autowired
    private WarnetRepository warnetRepository;

    public Warnet createWarnet(Warnet warnet) {
        return warnetRepository.save(warnet);
    }

    public Optional<Warnet> getWarnetById(Long id) {
        return warnetRepository.findById(id);
    } 
    public List<Warnet> getAllWarnets() {
        return warnetRepository.findAll();
    }
    @Transactional
    public Warnet updateWarnet(Long id, Warnet updatedWarnet) {
        return warnetRepository.save(updatedWarnet);
    }
    public void deleteWarnet(Long id) {
        warnetRepository.deleteById(id);
    }

}
