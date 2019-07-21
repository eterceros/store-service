/**
 * @author: Edson A. Terceros T.
 * 18
 */

package edu.umss.storeservice.dto;

import edu.umss.storeservice.model.ItemInstance;
import edu.umss.storeservice.model.ItemInstanceState;
import org.modelmapper.ModelMapper;

import java.util.List;

public class ItemInstanceDto extends DtoBase<ItemInstance> {

    private String name;
    private String code;
    private String label;
    private List<ImageDto> images;
    private String category;
    private Long subCategoryId;
    private String price;
    private Object[] comments = new Object[0];
    private Long id;
    private String description;
    private Boolean featured;
    private String identifier;
    private ItemDto item;
    private ItemInstanceState itemInstanceState;

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

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<ImageDto> getImages() {
        return images;
    }

    public void setImages(List<ImageDto> images) {
        this.images = images;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getSubCategoryId() {
        return subCategoryId;
    }

    public void setSubCategoryId(Long subCategoryId) {
        this.subCategoryId = subCategoryId;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public Object[] getComments() {
        return comments;
    }

    public void setComments(Object[] comments) {
        this.comments = comments;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public ItemDto getItem() {
        return item;
    }

    public void setItem(ItemDto item) {
        this.item = item;
    }

    public ItemInstanceState getItemInstanceState() {
        return itemInstanceState;
    }

    public void setItemInstanceState(ItemInstanceState itemInstanceState) {
        this.itemInstanceState = itemInstanceState;
    }

    @Override
    public DtoBase toDto(ItemInstance itemInstance, ModelMapper mapper) {
        super.toDto(itemInstance, mapper);
        mapper.map(itemInstance.getItem(), this);
        // copy item to itemdto
        setItem(new ItemDto().toDto(itemInstance.getItem(), mapper));
        setCategory(itemInstance.getItem().getSubCategory().getName());
        return this;
    }
}
