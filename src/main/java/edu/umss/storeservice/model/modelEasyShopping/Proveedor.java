package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.ProveedorDto;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.Objects;

/**
 * @author Juan Montaño
 */
@Entity
public class Proveedor extends ModelBase<ProveedorDto> {

    private String nit;
    private String razonSocial;
    private String celular;


    @Basic
    @Column(name = "Nit", nullable = false, length = 20)
    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    @Basic
    @Column(name = "RazonSocial", nullable = false, length = 250)
    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    @Basic
    @Column(name = "Celular", nullable = true, length = 20)
    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Proveedor proveedor = (Proveedor) o;
        return
                Objects.equals(nit, proveedor.nit) &&
                        Objects.equals(razonSocial, proveedor.razonSocial) &&
                        Objects.equals(celular, proveedor.celular);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nit, razonSocial, celular);
    }
}
