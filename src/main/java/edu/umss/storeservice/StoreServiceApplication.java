package edu.umss.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreServiceApplication.class, args);
//------------ Juan------Producto
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em = factory.createEntityManager();
//
//        em.getTransaction().begin();
//
//        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("GetAllProducto");
//
//        storedProcedure.execute();
        // Gson gson = new Gson();
//
//        List<Producto> list = storedProcedure.getResultList();
//        String q = gson.toJson(list);
//        list = gson.fromJson(q, new TypeToken<ArrayList<Producto>>(){}.getType());
//        System.out.println("la cantidad es esta: " + list);
//        System.out.println("la cantidad es esta: " + list.get(1).getMarca());
//        em.getTransaction().commit();
//        em.close();
        //-----------------------------------------------------------------------------------------
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em = factory.createEntityManager();
//
//        em.getTransaction().begin();
//
//        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("GetProductoById");
//        //storedProcedure.registerStoredProcedureParameter("idProducto", Integer.class,ParameterMode.IN);
//        storedProcedure.setParameter("idProducto",2);
//
//        storedProcedure.execute();
//        Gson gson = new Gson();
//
//        List<Producto> list = storedProcedure.getResultList();
//        String q = gson.toJson(list);
//        list = gson.fromJson(q, new TypeToken<ArrayList<Producto>>(){}.getType());
//        System.out.println("el producto es : " + list);
//        System.out.println("el modelo es " + list.get(0).getMarca());
//        em.getTransaction().commit();
//        em.close();

//--------------------------------------------------------------------------
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em = factory.createEntityManager();
//
//        em.getTransaction().begin();
//
//        StoredProcedureQuery storedProcedure = em.createNamedStoredProcedureQuery("DeleteProducto");
//        storedProcedure.setParameter("idProducto",2);
//
//        boolean result = storedProcedure.execute();
//        if(result = true){
//            System.out.print("el producto ha sido elimnado con exito");
//        }
//----------------------------------------------------------------
//
//        EntityManagerFactory factory1 = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em1 = factory1.createEntityManager();
//        em1.getTransaction().begin();
//        StoredProcedureQuery storedProcedure = em1.createNamedStoredProcedureQuery("InsertProducto");
//
//        Producto pro = new Producto();
//        pro.getClass().getName();
//
//        storedProcedure.setParameter("nombre", "Ron Zacapa");
//        storedProcedure.setParameter("marca", "Zacapa");
//        storedProcedure.setParameter("descripcion", "Zacapa 23 es un ron super-premium elaborado a partir de una mezcla de rones anejados entre 6 y 23 anos, Zacapa fue distinguido durante cinco anos consecutivos como el mejor ron del mundo en el International Rum Tasting Contest y es el anico ron premium incluido en el Salon de la Fama del Ron");
//        storedProcedure.setParameter("precio", 2100.0);
//        storedProcedure.setParameter("porcentaje_oferta", 0);
//        storedProcedure.setParameter("fk_categoria", 1);
//
//        List<Categoria> list = storedProcedure.getResultList();
//
//        if (list.size() > 0) {
//
//            String res1 = gson.toJson(list.get(0));
//            System.out.print("Insert date is: " + res1);
//            em1.getTransaction().commit();
//            em1.close();
//
//        } else {
//            em1.getTransaction().commit();
//            em1.close();
//        }
//--------------Producto end--------------------------

        //----------------------------------------------------------------------------------------------------
        /*
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_CATEGORIA_BY_ID", new Categoria().getClass());
        storedProcedure.registerStoredProcedureParameter("idCategoria", Integer.class,ParameterMode.IN);
        storedProcedure.setParameter("idCategoria",2);
        storedProcedure.execute();
        List<Categoria> res = storedProcedure.getResultList();
        Gson gson = new Gson();
        String out = gson.toJson(res.get(0));

        if(res.size()>0) {
            System.out.print("The description is: " + out);
            em.getTransaction().commit();
            em.close();
        }else {
            em.getTransaction().commit();
            em.close();
        }*/
        //--------------------------------------------------------
        /*
        em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("DELETE_CATEGORIA", Categoria.class);
        storedProcedure.registerStoredProcedureParameter("idCategoria", Integer.class,ParameterMode.IN);
        storedProcedure.setParameter("idCategoria",1);
        storedProcedure.execute();
        List<Categoria> list = storedProcedure.getResultList();
        Gson gson = new Gson();

        if(list.size()>0) {
            String res = gson.toJson(list.get(0));
            System.out.print("Drop date is: " + res);
            em.getTransaction().commit();
            em.close();

        }else {
            em.getTransaction().commit();
            em.close();
        }*/
        //-------------------------------------------------------------------
        /*
        em.getTransaction().begin();
        Categoria categoria = new Categoria();
        categoria.setDescripcion("desde java");

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_CATEGORIA", Categoria.class);
        storedProcedure.registerStoredProcedureParameter("descripcion", String.class,ParameterMode.IN);
        storedProcedure.setParameter("descripcion",categoria.getDescripcion());
        storedProcedure.execute();
        List<Categoria> list = storedProcedure.getResultList();

        if(list.size()>0) {
            Gson gson = new Gson();
            String res = gson.toJson(list.get(0));
            System.out.print("Insert date is: " + res);
            em.getTransaction().commit();
            em.close();

        }else {
            em.getTransaction().commit();
            em.close();
        }*/

        //------------ Yerko------Caracteristica
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//
//        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_CARACTERISTICA_BY_ID", Caracteristica.class);
//        storedProcedure.registerStoredProcedureParameter("idCaracteristica", Integer.class, ParameterMode.IN);
//        storedProcedure.setParameter("idCaracteristica", 1);
//        storedProcedure.execute();
//        List<Caracteristica> res = storedProcedure.getResultList();
//        Gson gson = new Gson();
//        String out = gson.toJson(res.get(0));
//
//        if (res.size() > 0) {
//            System.out.print("La caracteristica es: " + out);
//            em.getTransaction().commit();
//            em.close();
//        } else {
//            em.getTransaction().commit();
//            em.close();
//        }
//
          //--------------------------------------------------------
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//
//        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("DELETE_CARACTERISTICA", Caracteristica.class);
//        storedProcedure.registerStoredProcedureParameter("idCaracteristica", Integer.class, ParameterMode.IN);
//        storedProcedure.setParameter("idCaracteristica", 1);
//        storedProcedure.execute();
//        List<Caracteristica> list = storedProcedure.getResultList();
//        Gson gson = new Gson();
//
//        if (list.size() > 0) {
//            String res = gson.toJson(list.get(0));
//            System.out.print("La caracteristica fue eliminada correctamente");
//            em.getTransaction().commit();
//            em.close();
//
//        } else {
//            em.getTransaction().commit();
//            em.close();
//        }
//
          //--------------------------------------------------------
//        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
//        EntityManager em = factory.createEntityManager();
//        em.getTransaction().begin();
//
//        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("INSERT_CARACTERISTICA");
//        storedProcedure.registerStoredProcedureParameter("campo", Integer.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("valor", Integer.class, ParameterMode.IN);
//        storedProcedure.registerStoredProcedureParameter("fk_producto", Integer.class, ParameterMode.IN);
//        storedProcedure.setParameter("campo", "Probando");
//        storedProcedure.setParameter("valor", "test");
//        storedProcedure.setParameter("fk_producto", 1);
//        storedProcedure.execute();
//        List<Caracteristica> list = storedProcedure.getResultList();
//
//        if (list.size() > 0) {
//            Gson gson = new Gson();
//            String res = gson.toJson(list.get(0));
//            System.out.print("El dato insertado es: " + res);
//            em.getTransaction().commit();
//            em.close();
//
//        } else {
//            em.getTransaction().commit();
//            em.close();
//        }
//--------------Final Caracteristica-------------------------
    }

}
