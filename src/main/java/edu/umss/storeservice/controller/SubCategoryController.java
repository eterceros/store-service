/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.SubCategoryDto;
import edu.umss.storeservice.model.SubCategory;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.SubCategoryService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/subcategories")
public class SubCategoryController extends GenericController<SubCategory, SubCategoryDto> {
    private SubCategoryService service;

    public SubCategoryController(SubCategoryService service) {
        this.service = service;
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}