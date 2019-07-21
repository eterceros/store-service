/**
 * @author: Edson A. Terceros T.
 * 09
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.Image;
import org.modelmapper.ModelMapper;

public class ImageDto extends DtoBase<Image> {

    private String image;
    private boolean featured;
    private String name;
    private ItemInstanceDto itemInstance;

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isFeatured() {
        return featured;
    }

    public void setFeatured(boolean featured) {
        this.featured = featured;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ItemInstanceDto getItemInstance() {
        return itemInstance;
    }

    public void setItemInstance(ItemInstanceDto itemInstance) {
        this.itemInstance = itemInstance;
    }

    @Override
    public DtoBase toDto(Image element, ModelMapper mapper) {
        super.toDto(element, mapper);
        setItemInstance((ItemInstanceDto) new ItemInstanceDto().toDto(element.getItemInstance(), mapper));
        return this;
    }
}
