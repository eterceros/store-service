package edu.umss.storeservice.repository.repositoryEasyShopping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.umss.storeservice.model.modelEasyShopping.Categoria;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Montaño
 */
public class CategoriaRepository implements StoredProcedureRepositoryImpl<Categoria> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");

    private EntityManager em = factory.createEntityManager();

    private Gson gson = new Gson();

    @Override
    public List<Categoria> findAll() {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_ALL_CATEGORIA", Categoria.class);
        storedProcedure.execute();
        List<Categoria> list = storedProcedure.getResultList();

        String res = gson.toJson(list);

        if (list.size() > 0)
            System.out.println("The result is: " + res);

        em.getTransaction().commit();
        em.close();

        return gson.fromJson(res, new TypeToken<ArrayList<Categoria>>() {
        }.getType());
    }

    @Override
    public Categoria findById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_CATEGORIA_BY_ID", Categoria.class);
        storedProcedure.registerStoredProcedureParameter("idCategoria", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idCategoria", id);
        storedProcedure.execute();
        List<Categoria> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("The description is: " + res);
            em.getTransaction().commit();
            em.close();

            return gson.fromJson(res, Categoria.class);

        } else {
            em.getTransaction().commit();
            em.close();

            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("DELETE_CATEGORIA", Categoria.class);
        storedProcedure.registerStoredProcedureParameter("idCategoria", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idCategoria", id);
        storedProcedure.execute();
        List<Categoria> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("Drop date is: " + res);
            em.getTransaction().commit();
            em.close();

        } else {
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Categoria save(Categoria categoria) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_CATEGORIA", Categoria.class);
        storedProcedure.registerStoredProcedureParameter("descripcion", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("descripcion", categoria.getDescripcion());
        storedProcedure.execute();
        List<Categoria> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("Insert date is: " + res);
            em.getTransaction().commit();
            em.close();
            return gson.fromJson(res, Categoria.class);

        } else {
            em.getTransaction().commit();
            em.close();
            return null;
        }
    }
}
