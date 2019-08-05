/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.repository.ExpenseRepository;
import edu.umss.storeservice.repository.GenericRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseServiceImpl extends GenericServiceImpl<Expense> implements ExpenseService {
    private final ExpenseRepository repository;

    public ExpenseServiceImpl(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Expense> findByItemInstanceId(Long itemInstanceId) {
        return repository.findByItemInstanceId(itemInstanceId);
    }

    @Override
    protected GenericRepository<Expense> getRepository() {
        return repository;
    }
}
