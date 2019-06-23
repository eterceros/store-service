package edu.umss.storeservice.repository.repositoryEasyShopping;


import edu.umss.storeservice.model.modelEasyShopping.ModelBase;

import java.util.List;

/**
 * @author Juan Montaño
 */
public interface StoredProcedureRepositoryImpl<T extends ModelBase> {

    List<T> findAll();

    T findById(Long id);

    void deleteById(Long id);

    T save(T model);
}
