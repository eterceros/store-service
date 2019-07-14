/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.SubCategory;

public class SubCategoryDto extends DtoBase<SubCategory> {
    private String name;
    private String code;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
