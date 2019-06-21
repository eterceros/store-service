package edu.umss.storeservice.repository.repositoryEasyShopping;

import edu.umss.storeservice.model.modelEasyShopping.ModelBase;

import java.util.List;

/**
 * @author Juan Montaño
 */
public abstract class StoredProcedureRepositoryImpl<T extends ModelBase> {

    public List<T> findAll(){
        return null;
    }
    public T findById(Long id){
        return null;
    }
    public void deleteById(Long id){

    }
    public T save(T model){
        return null;
    }
}
