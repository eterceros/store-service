package edu.umss.storeservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@SpringBootApplication
public class StoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(StoreServiceApplication.class, args);

        EntityManagerFactory factory = Persistence.createEntityManagerFactory("jpa-db");
        EntityManager em = factory.createEntityManager();

        /*em.getTransaction().begin();

        StoredProcedureQuery storedProcedure = em.createStoredProcedureQuery("GET_ALL_CATEGORIA", Categoria.class);

        storedProcedure.execute();
        Gson gson = new Gson();

        List<Categoria> list = storedProcedure.getResultList();
        String q = gson.toJson(list);
        list = gson.fromJson(q, new TypeToken<ArrayList<Categoria>>(){}.getType());
        System.out.println("la cantidad es esta: " + list.get(0).getDescripcion());
        em.getTransaction().commit();
        em.close();*/
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
    }

}
