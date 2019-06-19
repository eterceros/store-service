package edu.umss.storeservice.dto.dtoEasyShopping;

import edu.umss.storeservice.model.modelEasyShopping.Producto;

/**
 * @author Juan Montaño
 */
public class ProductoDto extends DtoBase<Producto> {
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    private Integer porcentajeOferta;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getPorcentajeOferta() {
        return porcentajeOferta;
    }

    public void setPorcentajeOferta(Integer porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }
}