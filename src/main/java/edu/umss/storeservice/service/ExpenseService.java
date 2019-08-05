/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Expense;

import java.util.List;

public interface ExpenseService extends GenericService<Expense> {
    List<Expense> findByItemInstanceId(Long itemInstanceId);
}

    