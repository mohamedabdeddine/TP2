package com.example.jpaap.repositories;

import com.example.jpaap.entities.Patient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface PatientRepository  extends JpaRepository<Patient,Long> {

    Page<Patient> findByMalade(boolean b, PageRequest of);
    public List<Patient> findByMalade(boolean m);
    //  Page<Patient> findByMalade(boolean m, Pageable pageable);
    //  List<Patient> findByMaladeAndScoreLessThan(boolean m, int score);
    //  List<Patient> findByMaladeIsTrueAndScoreLessThan(int score);
    //  List<Patient> findByDateNaissanceBetweenAAndMaladeIsTrueOrNomLike(Date d1, Date d2, String mc);
    // @Query("select p from Patient p where p.dateNaissance between :x and :y or p.nom like :z);
    //  List<Patient> chercherPatients(@Param("x") Date d1, @Param("y") Date d2, @Param("z") String nom);

}
