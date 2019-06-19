package edu.umss.storeservice.dto.dtoEasyShopping;

import edu.umss.storeservice.model.modelEasyShopping.Categoria;

/**
 * @author Juan Montaño
 */
public class CategoriaDto extends DtoBase<Categoria> {
    private String descripcion;

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}