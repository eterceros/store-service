
package edu.umss.storeservice.repository.repositoryEasyShopping;

import com.google.gson.Gson;
import edu.umss.storeservice.model.modelEasyShopping.Proveedor;
import org.modelmapper.TypeToken;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel A. Quispe
 */

public class ProveedorRepository implements StoredProcedureRepositoryImpl<Proveedor> {
    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");

    private EntityManager em = factory.createEntityManager();

    private Gson gson = new Gson();

    @Override
    public List<Proveedor> findAll() {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_ALL_PROVEEDOR", Proveedor.class);
        storedProcedure.execute();
        List<Proveedor> list = storedProcedure.getResultList();

        String res = gson.toJson(list);

        if (list.size() > 0)
            System.out.println("The result is: " + res);

        em.getTransaction().commit();
        em.close();

        return gson.fromJson(res, new TypeToken<ArrayList<Proveedor>>() {
        }.getType());
    }

    @Override
    public Proveedor findById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_PROVEEDOR_BY_ID", Proveedor.class);
        storedProcedure.registerStoredProcedureParameter("idProveedor", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idProveedor", Integer.valueOf(id.intValue()));
        storedProcedure.execute();
        List<Proveedor> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("The description is: " + res);
            em.getTransaction().commit();
            em.close();

            return gson.fromJson(res, Proveedor.class);

        } else {
            em.getTransaction().commit();
            em.close();

            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("DELETE_PROVEEDOR", Proveedor.class);
        storedProcedure.registerStoredProcedureParameter("idProveedor", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idProveedor", id);
        storedProcedure.execute();
        List<Proveedor> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            em.getTransaction().commit();
            em.close();

        } else {
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Proveedor save(Proveedor proveedor) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_PROVEEDOR", Proveedor.class);
        storedProcedure.setParameter("nit", proveedor.getNit());
        storedProcedure.setParameter("name", proveedor.getName());
        storedProcedure.setParameter("celular", proveedor.getCelular());
        storedProcedure.execute();
        List<Proveedor> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("Insert is: " + res);
            em.getTransaction().commit();
            em.close();
            return gson.fromJson(res, Proveedor.class);

        } else {
            em.getTransaction().commit();
            em.close();
            return null;
        }
    }
}
