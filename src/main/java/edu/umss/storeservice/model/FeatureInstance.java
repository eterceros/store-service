/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.model;

import edu.umss.storeservice.dto.FeatureInstanceDto;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class FeatureInstance extends ModelBase<FeatureInstanceDto> {
    private String value;
    @ManyToOne
    private Feature feature;

    @OneToOne
    private Item item;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Feature getFeature() {
        return feature;
    }

    public void setFeature(Feature feature) {
        this.feature = feature;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }
}
