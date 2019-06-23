package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.CaracteristicaDto;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Yerko Manzel
 */
@Entity
public class Caracteristica extends ModelBase<CaracteristicaDto> {

    private String campo;
    private String valor;

    @ManyToOne
    @JoinColumn(name = "fk_producto ", nullable = false)
    private Producto productoId;


    @Basic
    @Column(name = "Campo", nullable = false, length = 150)
    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    @Basic
    @Column(name = "Valor", nullable = false, length = 150)
    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Caracteristica that = (Caracteristica) o;
        return
                Objects.equals(campo, that.campo) &&
                        Objects.equals(valor, that.valor);
    }

    @Override
    public int hashCode() {

        return Objects.hash(campo, valor);
    }

    public Producto getProducto() {
        return productoId;
    }

    public void setProducto(Producto producto) {
        this.productoId = producto;
    }

    @Override
    public String toString() {
        final StringBuilder builder = new StringBuilder();
        builder.append("Caracteristica [model=").append(getId()).append("]");
        return builder.toString();
    }
}
