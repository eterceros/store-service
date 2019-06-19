package edu.umss.storeservice.dto.dtoEasyShopping;

import edu.umss.storeservice.model.modelEasyShopping.Proveedor;

/**
 * @author Juan Montaño
 */
public class ProveedorDto extends DtoBase<Proveedor> {
    private String nit;
    private String razonSocial;
    private String celular;

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getRazonSocial() {
        return razonSocial;
    }

    public void setRazonSocial(String razonSocial) {
        this.razonSocial = razonSocial;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}