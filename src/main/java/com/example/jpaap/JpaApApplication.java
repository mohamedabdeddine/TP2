package com.example.jpaap;

import com.example.jpaap.entities.Patient;
import com.example.jpaap.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaApApplication implements CommandLineRunner {
    @Autowired
    private PatientRepository patientRepository;

    public static void main(String[] args) {
        SpringApplication.run(JpaApApplication.class, args);
    }


    @Override
    public void run(String... args) throws Exception {
        for(int i =0 ; i<100; i++){
            patientRepository.save(
                    new Patient(null,"mohamed", new Date(),Math.random()>0.5?true:false, (int)(Math.random()*100)));
        }

        //la pagination pour eviter select *
        Page <Patient> patients = patientRepository.findAll(PageRequest.of(0,5));
        System.out.println("Total pages: "+patients.getTotalPages());
        System.out.println("Total elements: "+ patients.getTotalElements());
        System.out.println("Num page: "+ patients.getNumber());
        List<Patient> content = patients.getContent();
        content.forEach( p->{
                System.out.println("---patient---");
                System.out.println(p.getId());
                System.out.println(p.getNom());
                System.out.println(p.getScore());
                System.out.println(p.getDateNaissance());
                System.out.println(p.isMalade());});

        System.out.println("---chercherPatient---");
      //  List<Patient> patientList = patientRepository.chercherPatients("%m%", 40);
        //  patientList.forEach( p->{
        // System.out.println("---patient---");
        //  System.out.println(p.getId());
        //  System.out.println(p.getNom());
        //  System.out.println(p.getScore());
        //  System.out.println(p.getDateNaissance());
        //   System.out.println(p.isMalade());});



        System.out.println("---find BY id---");
        Patient patient=patientRepository.findById(1L).orElse(null);
        if(patient != null){
            System.out.println(patient.getId());
            System.out.println(patient.getNom());
            System.out.println(patient.isMalade()); }
        patient.setScore(22);
        //patientRepository.save(patient);
       // patientRepository.deleteById(1L);





        System.out.println("---find by maladie ---");
        Page<Patient> byMalade = patientRepository.findByMalade(true,PageRequest.of(0,5));
        byMalade.forEach( p->{
            System.out.println("---patient---");
            System.out.println(p.getId());
            System.out.println(p.getNom());
            System.out.println(p.getScore());
            System.out.println(p.getDateNaissance());
            System.out.println(p.isMalade());});

    }
}
