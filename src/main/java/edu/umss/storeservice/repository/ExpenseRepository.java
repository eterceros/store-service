/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Expense;

import java.util.List;

public interface ExpenseRepository extends GenericRepository<Expense> {
    List<Expense> findByItemInstanceId(Long itemInstanceId);
}
  