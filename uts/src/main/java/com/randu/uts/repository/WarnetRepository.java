package com.randu.uts.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.randu.uts.model.Warnet;

@Repository
public interface WarnetRepository extends JpaRepository<Warnet, Long> {

}
