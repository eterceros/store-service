package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.ExpenseType;

/**
 * @author Willy Kelvis Sanchez Rojas
 */
public class ExpenseTypeDto extends DtoBase<ExpenseType> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
