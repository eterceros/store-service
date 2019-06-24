
package edu.umss.storeservice.repository.repositoryEasyShopping;

import com.google.gson.Gson;
import edu.umss.storeservice.model.modelEasyShopping.Proveedor;
import org.modelmapper.TypeToken;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: Miguel A.
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
        return null;
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Proveedor save(Proveedor model) {
        return null;
    }


}
