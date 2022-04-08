package sn.spring.patientsmvc;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sn.spring.patientsmvc.entities.Patient;
import sn.spring.patientsmvc.repositories.PatientRepository;

import java.util.Date;

@SpringBootApplication
public class PatientsMvcApplication {

    public static void main(String[] args) {
        SpringApplication.run(PatientsMvcApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(PatientRepository patientRepository){
        return  args -> {
            patientRepository.save(new Patient(null,"Mamadou Diouf",new Date(),false,5));
            patientRepository.save(new Patient(null,"Astou Diop",new Date(),true,12));
            patientRepository.save(new Patient(null,"Demba Ndiaye",new Date(),false,7));

            patientRepository.findAll().forEach(patient ->{
                System.out.println(patient.getNom());
                    });
        };
    }
}
