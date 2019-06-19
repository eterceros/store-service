package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.ProductoDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * @author Juan Montaño
 */
@Entity
public class Producto extends ModelBase<ProductoDto> {
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;
    private Integer porcentajeOferta;

    @ManyToOne
    private Categoria categoriaByIdCategoria;

    @Basic
    @Column(name = "Nombre", nullable = false, length = 150)
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    @Basic
    @Column(name = "Marca", nullable = false, length = 100)
    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Basic
    @Column(name = "Descripcion", nullable = true, length = 2147483647)
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "Precio", nullable = false)
    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    @Basic
    @Column(name = "PorcentajeOferta", nullable = true)
    public Integer getPorcentajeOferta() {
        return porcentajeOferta;
    }

    public void setPorcentajeOferta(Integer porcentajeOferta) {
        this.porcentajeOferta = porcentajeOferta;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return
                Objects.equals(nombre, producto.nombre) &&
                        Objects.equals(marca, producto.marca) &&
                        Objects.equals(descripcion, producto.descripcion) &&
                        Objects.equals(precio, producto.precio) &&
                        Objects.equals(porcentajeOferta, producto.porcentajeOferta);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre, marca, descripcion, precio, porcentajeOferta);
    }

    public Categoria getCategoriaByIdCategoria() {
        return categoriaByIdCategoria;
    }

    public void setCategoriaByIdCategoria(Categoria categoriaByIdCategoria) {
        this.categoriaByIdCategoria = categoriaByIdCategoria;
    }
}
