package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.CaracteristicaDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import java.util.Objects;

/**
 * @author Juan Montaño
 */
@Entity
public class Caracteristica extends ModelBase<CaracteristicaDto> {

    private String campo;
    private String valor;

    @ManyToOne
    private Producto producto;


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
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
