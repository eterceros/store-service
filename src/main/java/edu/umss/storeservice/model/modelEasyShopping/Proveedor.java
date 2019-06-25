package edu.umss.storeservice.model.modelEasyShopping;

import edu.umss.storeservice.dto.dtoEasyShopping.ProveedorDto;

import javax.persistence.*;
import java.util.Objects;

/**
 * @author Juan Montaño
 */
@Entity
@NamedStoredProcedureQueries({
        @NamedStoredProcedureQuery(
                name = "getAllProveedor",
                procedureName = "GET_ALL_PROVEEDOR",
                resultClasses = Proveedor.class
        ),
        @NamedStoredProcedureQuery(
                name = "GetProveedorById",
                procedureName = "GET_PROVEEDOR_BY_ID",
                resultClasses = {Proveedor.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "idProveedor",
                                type = Integer.class,
                                mode = ParameterMode.IN)
                }
        ),
        @NamedStoredProcedureQuery(
                name = "DeleteProveedor",
                procedureName = "DELETE_PROVEEDOR",
                resultClasses = {Proveedor.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "idProveedor",
                                type = Integer.class,
                                mode = ParameterMode.IN
                        )
                }
        ),
        @NamedStoredProcedureQuery(
                name = "InsertProveedor",
                procedureName = "INSERT_PROVEEDOR",
                resultClasses = {Proveedor.class},
                parameters = {
                        @StoredProcedureParameter(
                                name = "nit",
                                type = String.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "name",
                                type = String.class,
                                mode = ParameterMode.IN
                        ),
                        @StoredProcedureParameter(
                                name = "celular",
                                type = String.class,
                                mode = ParameterMode.IN
                        )
                }
        )

})
public class Proveedor extends ModelBase<ProveedorDto> {

    private String nit;
    private String name;
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
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                        Objects.equals(name, proveedor.name) &&
                        Objects.equals(celular, proveedor.celular);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nit, name, celular);
    }

}
