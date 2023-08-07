package com.loayza.clinica.repository;


import com.loayza.clinica.model.Medico;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicoRespository extends JpaRepository<Medico, Integer> {
}
