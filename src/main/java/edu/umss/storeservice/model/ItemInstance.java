/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.ItemInstanceDto;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import java.util.Set;

@Entity
public class ItemInstance extends ModelBase<ItemInstanceDto> {
    @OneToOne
    private Item item;
    private String identifier;

    private Boolean featured = Boolean.FALSE;

    // todo generalmente se usa BigDecimal
    private Double price;
    @Enumerated(EnumType.STRING)
    private ItemInstanceState itemInstanceState;
    // todo agregar totalCost

    @OneToMany
    private Set<Expense> expenses;

    @OneToMany
    private Set<Image> images;

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Set<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(Set<Expense> expenses) {
        this.expenses = expenses;
    }

    public ItemInstanceState getItemInstanceState() {
        return itemInstanceState;
    }

    public void setItemInstanceState(ItemInstanceState itemInstanceState) {
        this.itemInstanceState = itemInstanceState;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    @Override
    public ModelBase toDomain(ItemInstanceDto element, ModelMapper mapper) {
        super.toDomain(element, mapper);
        setItem((Item) new Item().toDomain(element.getItemDto(), mapper));
        return this;
    }
}
