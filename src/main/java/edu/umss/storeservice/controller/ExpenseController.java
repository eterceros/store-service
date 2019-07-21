/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ExpenseDto;
import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.service.ExpenseService;
import edu.umss.storeservice.service.GenericService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/expenses")
public class ExpenseController extends GenericController<Expense, ExpenseDto> {
    private ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}