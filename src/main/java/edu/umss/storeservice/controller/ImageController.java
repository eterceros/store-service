/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.controller;

import edu.umss.storeservice.dto.ImageDto;
import edu.umss.storeservice.model.Image;
import edu.umss.storeservice.service.GenericService;
import edu.umss.storeservice.service.ImageService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
@RequestMapping("/images")
public class ImageController extends GenericController<Image, ImageDto> {
    private ImageService service;

    public ImageController(ImageService service) {
        this.service = service;
    }

    @GetMapping(value = "/iteminstances/{itemInstanceId}")
    public List<Image> findByItemInstanceId(@PathVariable("itemInstanceId") @NotNull Long itemInstanceId) {
        return service.findByItemInstanceId(itemInstanceId);
    }

    @Override
    protected GenericService getService() {
        return service;
    }
}