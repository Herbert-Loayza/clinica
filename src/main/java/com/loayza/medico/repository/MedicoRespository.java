package com.loayza.medico.repository;


import com.loayza.medico.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRespository extends JpaRepository<Medico, Integer> {
}
