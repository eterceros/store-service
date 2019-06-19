package edu.umss.storeservice.dto.dtoEasyShopping;

import edu.umss.storeservice.model.modelEasyShopping.RegistroIngreso;

import java.sql.Timestamp;

/**
 * @author Juan Montaño
 */
public class RegistroIngresoDto extends DtoBase<RegistroIngreso> {
    private Timestamp fecha;
    private Integer cantidad;

    public Timestamp getFecha() {
        return fecha;
    }

    public void setFecha(Timestamp fecha) {
        this.fecha = fecha;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}