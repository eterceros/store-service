package edu.umss.storeservice.dto.dtoEasyShopping;


import edu.umss.storeservice.model.modelEasyShopping.Caracteristica;

/**
 * @author Juan Montaño
 */

public class CaracteristicaDto extends DtoBase<Caracteristica> {

    private String campo;
    private String valor;

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getValor() {
        return valor;
    }

    public void setValor(String valor) {
        this.valor = valor;
    }
}
