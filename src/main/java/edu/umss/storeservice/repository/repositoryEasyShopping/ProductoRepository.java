package edu.umss.storeservice.repository.repositoryEasyShopping;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import edu.umss.storeservice.model.modelEasyShopping.Producto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.StoredProcedureQuery;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Juan Montaño
 */
@Service
public class ProductoRepository implements StoredProcedureRepositoryImpl<Producto> {

    private EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");

    private EntityManager em = factory.createEntityManager();

    private Gson gson = new Gson();

    @Override
    public List<Producto> findAll() {
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("GetAllProducto");

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

        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("GetProductoById");

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

        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("DeleteProducto");

        storedProcedure.setParameter("idProducto", id);

        boolean result = storedProcedure.execute();
        if (result = true) {
            System.out.print("el producto ha sido elimnado con exito");
            em.getTransaction().commit();
            em.close();
        }
    }

    @Override
    public Producto save(Producto producto) {

        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("InsertProducto");

        storedProcedure.setParameter("nombre", producto.getNombre());
        storedProcedure.setParameter("marca", producto.getMarca());
        storedProcedure.setParameter("descripcion", producto.getDescripcion());
        storedProcedure.setParameter("precio", producto.getPrecio());
        storedProcedure.setParameter("porcentaje_oferta", producto.getPorcentajeOferta());
        storedProcedure.setParameter("fk_categoria", Integer.valueOf(producto.getCategoriaId().getId().intValue()));

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
