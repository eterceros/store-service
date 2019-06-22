package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.CategoriaDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * @author Juan Montaño
 */

@Entity
public class Categoria extends ModelBase<CategoriaDto> {

    private String descripcion;

    @Basic
    @Column(name = "descripcion", nullable = false, length = 50)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return
                Objects.equals(descripcion, categoria.descripcion);
    }

    @Override
    public int hashCode() {

        return Objects.hash(descripcion);
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Categoria [description=").append(descripcion).append("]");
        return builder.toString();
    }
}
