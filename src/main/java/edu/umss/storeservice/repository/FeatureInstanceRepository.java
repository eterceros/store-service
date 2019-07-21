/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.model.FeatureInstance;

import java.util.List;

public interface FeatureInstanceRepository extends GenericRepository<FeatureInstance> {
    List<Expense> findByItemId(Long itemId);
}
  