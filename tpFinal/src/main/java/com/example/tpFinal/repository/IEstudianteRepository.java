package com.example.tpFinal.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.tpFinal.model.Estudiante;
@Repository
public interface IEstudianteRepository extends JpaRepository<Estudiante,Long> {

}
