/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Expense;

public class ExpenseDto extends DtoBase<Expense> {
    private ExpenseTypeDto expenseType;
    private Long value;
    private String description;
    private ItemInstanceDto itemInstanceDto;

    public ExpenseTypeDto getExpenseType() {
        return expenseType;
    }

    public void setExpenseType(ExpenseTypeDto expenseType) {
        this.expenseType = expenseType;
    }

    public Long getValue() {
        return value;
    }

    public void setValue(Long value) {
        this.value = value;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ItemInstanceDto getItemInstanceDto() {
        return itemInstanceDto;
    }

    public void setItemInstanceDto(ItemInstanceDto itemInstanceDto) {
        this.itemInstanceDto = itemInstanceDto;
    }
}
