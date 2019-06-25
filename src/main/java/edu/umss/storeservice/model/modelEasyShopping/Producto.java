package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.ProductoDto;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Juan Montaño
 */
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "GetProductoById",
                procedureName = "GET_PRODUCTO_BY_ID",
                resultClasses = {Producto.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "idProducto",
                                type = Integer.class,
                                mode = ParameterMode.IN)
                }),
        @NamedStoredProcedureQuery(
                name = "GetAllProducto",
                procedureName = "GET_ALL_PRODUCTO",
                resultClasses = {Producto.class}
        ),
        @NamedStoredProcedureQuery(
                name = "DeleteProducto",
                procedureName = "DELETE_PRODUCTO",
                resultClasses = {Producto.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "idProducto",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        )
                }
        ),
        @NamedStoredProcedureQuery(
                name = "InsertProducto",
                procedureName = "INSERT_PRODUCTO",
                resultClasses = {Producto.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "descripcion",
                                type = String.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "marca",
                                type = String.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "nombre",
                                type = String.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "porcentaje_oferta",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "precio",
                                type = Double.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "fk_categoria",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        )

                }
        )
})
@Entity
public class Producto extends ModelBase<ProductoDto> {
    private String nombre;
    private String marca;
    private String descripcion;
    private Double precio;

    @Column(name = "porcentaje_oferta", nullable = true)
    private Integer porcentajeOferta;

    @ManyToOne
    @JoinColumn(name = "fk_categoria", nullable = false)
    private Categoria categoriaId;

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

    public Categoria getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(Categoria categoriaId) {
        this.categoriaId = categoriaId;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Producto [name=").append(nombre).append("]");
        return builder.toString();
    }
}
