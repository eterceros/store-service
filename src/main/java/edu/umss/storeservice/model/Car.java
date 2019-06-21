package edu.umss.storeservice.model;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Juan Montaño
 */

@NamedStoredProcedureQuery(
                name = "allCar",
                procedureName = "ALL_CAR",
                resultClasses = Car.class
                )
@Entity
public class Car implements Serializable {

    private long id;
    private String model;
    private Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    public Car() {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true, nullable = false, scale = 0)
    public long getId() {
        return id;
    }

    @Column(name = "MODEL")
    public String getModel() {
        return model;
    }

    @Column(name = "YEAR")
    public Integer getYear() {
        return year;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        return result;
    }

    @Override
    public boolean equals(final Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        final Car other = (Car) obj;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        return true;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Car [model=").append(model).append("]");
        return builder.toString();
    }
    // standard setter methods


    public void setId(long id) {
        this.id = id;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(Integer year) {
        this.year = year;
    }
}