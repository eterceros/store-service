package edu.umss.storeservice;

import edu.umss.storeservice.model.modelEasyShopping.Categoria;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;

;

@SpringBootTest
class StoreServiceApplicationTests {

    private static EntityManagerFactory factory = null;
    private static EntityManager entityManager = null;

    @BeforeClass
    public static void init() {
        factory = Persistence.createEntityManagerFactory("jpa-db");
        entityManager = factory.createEntityManager();
    }

    @Test
    public void findCarsStored() {
        StoredProcedureQuery findByYearProcedure;// =
        //entityManager.createNamedStoredProcedureQuery("allCar");

        //StoredProcedureQuery storedProcedure =
               // findByYearProcedure.setParameter("p_year", 2000);
        findByYearProcedure = entityManager.createStoredProcedureQuery("EXECUTE GET_ALL_CATEGORIA");
        findByYearProcedure.execute();

        //CategoriaRepository repository = new CategoriaRepository();

        findByYearProcedure.getResultList()
                .forEach(c -> Assert.assertEquals(new String("mi descripcion"), ((Categoria) c).getDescripcion()));

        //findByYearProcedure.getResultList()
        //.forEach(c -> Assert.assertEquals(new String("Fiat Panda"), ((Car) c).getYear()));
    }
    //@Test
    //void contextLoads() {
    //}

}
