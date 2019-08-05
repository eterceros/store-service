/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ExpenseDto;
import edu.umss.storeservice.model.Expense;
import edu.umss.storeservice.service.ExpenseService;
import edu.umss.storeservice.service.GenericService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpenseController extends GenericController<Expense, ExpenseDto> {
    private ExpenseService service;

    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping(value = "/iteminstances/{itemInstanceId}")
    public List<Expense> findByItemInstanceId(@PathVariable("itemInstanceId") @NotNull Long itemInstanceId) {
        return service.findByItemInstanceId(itemInstanceId);
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}