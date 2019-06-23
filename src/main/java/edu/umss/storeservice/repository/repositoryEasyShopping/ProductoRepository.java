package edu.umss.storeservice.repository.repositoryEasyShopping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.umss.storeservice.model.modelEasyShopping.Producto;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Montaño
 */
public class ProductoRepository implements StoredProcedureRepositoryImpl<Producto> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");

    private EntityManager em = factory.createEntityManager();

    private Gson gson = new Gson();

    @Override
    public List<Producto> findAll() {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_ALL_PRODUCTO", Producto.class);

        storedProcedure.execute();

        List<Producto> list = storedProcedure.getResultList();
        String res = gson.toJson(list);
        if (list.size() > 0)
            System.out.println("The result is: " + res);

        em.getTransaction().commit();
        em.close();

        return gson.fromJson(res, new TypeToken<ArrayList<Producto>>() {
        }.getType());
    }

    @Override
    public Producto findById(Long id) {

        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_PRODUCTO_BY_ID", Producto.class);
        storedProcedure.registerStoredProcedureParameter("idProducto", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idProducto", id);
        storedProcedure.execute();
        List<Producto> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("The description is: " + res);
            em.getTransaction().commit();
            em.close();

            return gson.fromJson(res, Producto.class);

        } else {
            em.getTransaction().commit();
            em.close();

            return null;
        }
    }

    @Override
    public void deleteById(Long id) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("DELETE_PRODUCTO", Producto.class);
        storedProcedure.registerStoredProcedureParameter("idProducto", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("idProducto", id);

        boolean result = storedProcedure.execute();
        if (result = true) {
            System.out.print("el producto ha sido elimnado con exito");
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Producto save(Producto model) {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_PRODUCTO");
        storedProcedure.registerStoredProcedureParameter("descripcion", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("marca", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("nombre", String.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("porcentaje_oferta", Integer.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("precio", Double.class, ParameterMode.IN);
        storedProcedure.registerStoredProcedureParameter("fk_categoria", Integer.class, ParameterMode.IN);
        storedProcedure.setParameter("nombre", "Ron Zacapa");
        storedProcedure.setParameter("marca", "Zacapa");
        storedProcedure.setParameter("descripcion", "Zacapa 23 es un ron super-premium elaborado a partir de una mezcla de rones anejados entre 6 y 23 anos, Zacapa fue distinguido durante cinco anos consecutivos como el mejor ron del mundo en el International Rum Tasting Contest y es el anico ron premium incluido en el Salon de la Fama del Ron");
        storedProcedure.setParameter("precio", 2100.0);
        storedProcedure.setParameter("porcentaje_oferta", 0);
        storedProcedure.setParameter("fk_categoria", 1);

        List<Producto> list = storedProcedure.getResultList();

        if (list.size() > 0) {
            String res = gson.toJson(list.get(0));
            System.out.print("Insert date is: " + res);
            em.getTransaction().commit();
            em.close();
            return gson.fromJson(res, Producto.class);

        } else {
            em.getTransaction().commit();
            em.close();
            return null;
        }
    }
}
