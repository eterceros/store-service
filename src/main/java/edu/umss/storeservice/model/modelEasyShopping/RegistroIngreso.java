package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.RegistroIngresoDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;
import java.util.Objects;

/**
 * @author Juan Montaño
 */
@Entity
public class RegistroIngreso extends ModelBase<RegistroIngresoDto> {

    private Timestamp fecha;
    private Integer cantidad;
    @ManyToOne
    private Producto productoByCodigoProducto;

    @ManyToOne
    private Proveedor proveedor;

    @Basic
    @Column(name = "Fecha", nullable = false)
    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    @Basic
    @Column(name = "Cantidad", nullable = false)
    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegistroIngreso that = (RegistroIngreso) o;
        return
                Objects.equals(fecha, that.fecha) &&
                        Objects.equals(cantidad, that.cantidad);
    }

    @Override
    public int hashCode() {

        return Objects.hash(fecha, cantidad);
    }


    public Producto getProductoByCodigoProducto() {
        return productoByCodigoProducto;
    }

    public void setProductoByCodigoProducto(Producto productoByCodigoProducto) {
        this.productoByCodigoProducto = productoByCodigoProducto;
    }

    public Proveedor getProveedor() {
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
