/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ExpenseTypeDto;

import javax.persistence.Entity;

@Entity
public class ExpenseType extends ModelBase<ExpenseTypeDto> {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
