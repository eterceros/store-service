package edu.umss.storeservice.model.modelEasyShopping;


import edu.umss.storeservice.dto.dtoEasyShopping.DtoBase;
import org.modelmapper.ModelMapper;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

/**
 * @author Juan Montaño
 */

@MappedSuperclass
@EntityListeners(AuditingEntityListener.class)
@SuppressWarnings("rawtypes")
public class ModelBase<D extends DtoBase> {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public edu.umss.storeservice.model.modelEasyShopping.ModelBase toDomain(D element, ModelMapper mapper) {
        mapper.map(element, this);
        return this;
    }
}
