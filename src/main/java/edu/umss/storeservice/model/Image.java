/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ImageDto;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

@Entity
public class Image extends ModelBase<ImageDto> {
    @Lob
    private String image;

    private String name;

    @ManyToOne
    private ItemInstance itemInstance;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public ItemInstance getItemInstance() {
        return itemInstance;
    }

    public void setItemInstance(ItemInstance itemInstance) {
        this.itemInstance = itemInstance;
    }
}