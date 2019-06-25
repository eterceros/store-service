package edu.umss.storeservice.repository.repositoryEasyShopping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.umss.storeservice.model.modelEasyShopping.Caracteristica;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Yerko Manzel
 */
@Component
public class CaracteristicaRepository implements StoredProcedureRepositoryImpl<Caracteristica> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");

    private EntityManager em = factory.createEntityManager();

    private Gson gson = new Gson();

    @Override
    public List<Caracteristica> findAll() {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_ALL_CARACTERISTICA", Caracteristica.class);
        storedProcedure.execute();
        List<Caracteristica> list = storedProcedure.getResultList();

        String res = gson.toJson(list);

        if (list.size() > 0)
            System.out.println("El resultado es: " + res);

        em.getTransaction().commit();
        em.close();

        return gson.fromJson(res, new TypeToken<ArrayList<Caracteristica>>() {
        }.getType());
    }

    @Override
    public Caracteristica findById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_CARACTERISTICA_BY_ID", Caracteristica.class);
        storedProcedure.registerStoredProcedureParameter("idCaracteristica", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idCaracteristica", id);
        storedProcedure.execute();
        List<Caracteristica> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("La caracteristica es: " + res);
            em.getTransaction().commit();
            em.close();

            return gson.fromJson(res, Caracteristica.class);

        } else {
            em.getTransaction().commit();
            em.close();

            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("DELETE_CARACTERISTICA", Caracteristica.class);
        storedProcedure.registerStoredProcedureParameter("idCaracteristica", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idCaracteristica", id);
        storedProcedure.execute();
        List<Caracteristica> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("La caracteristica fue eliminada correctamente");
            em.getTransaction().commit();
            em.close();

        } else {
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Caracteristica save(Caracteristica caracteristica) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_CARACTERISTICA", Caracteristica.class);
        storedProcedure.registerStoredProcedureParameter("campo", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("valor", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("fk_producto", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("campo", caracteristica.getCampo());
        storedProcedure.setParameter("valor", caracteristica.getValor());
        storedProcedure.setParameter("fk_producto", caracteristica.getProducto().getId());
        storedProcedure.execute();
        List<Caracteristica> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("El dato insertado es: " + res);
            em.getTransaction().commit();
            em.close();
            return gson.fromJson(res, Caracteristica.class);

        } else {
            em.getTransaction().commit();
            em.close();
            return null;
        }
    }
}
