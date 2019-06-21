package edu.umss.storeservice;

import edu.umss.storeservice.model.Car;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@SpringBootApplication
public class StoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreServiceApplication.class, args);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
        EntityManager em = factory.createEntityManager();

        em.getTransaction().begin();
        StoredProcedureQuery storedProcedure=em.createNamedStoredProcedureQuery("allCar");

        storedProcedure.execute();
        List<Car> list = storedProcedure.getResultList();
        System.out.println("The cars model are:" + list);
        em.getTransaction().commit();
        em.close();
    }

}
