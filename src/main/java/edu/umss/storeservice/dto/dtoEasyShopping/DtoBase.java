package edu.umss.storeservice.dto.dtoEasyShopping;

import edu.umss.storeservice.model.modelEasyShopping.ModelBase;
import org.modelmapper.ModelMapper;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

;

/**
 * @author Juan Montaño
 */
@SuppressWarnings("rawtypes")
public class DtoBase<E extends ModelBase> {

    private Long id;

    protected void beforeConversion(E element, ModelMapper mapper) {
        // Do nothing
    }

    protected void afterConversion(E element, ModelMapper mapper) {
        // Do nothing
    }

    public edu.umss.storeservice.dto.dtoEasyShopping.DtoBase toDto(E element, ModelMapper mapper) {
        beforeConversion(element, mapper);
        if (element != null) {
            mapper.map(element, this);
        }
        afterConversion(element, mapper);
        return this;
    }

    public <D extends edu.umss.storeservice.dto.dtoEasyShopping.DtoBase> List<D> toListDto(Collection<E> elements, ModelMapper mapper) {
        if (elements == null || elements.isEmpty()) {
            return Collections.emptyList();
        }
        return convert(elements, mapper);
    }

    @SuppressWarnings("unchecked")
    private <D extends DtoBase> List<D> convert(Collection<E> elements, ModelMapper mapper) {
        return (List<D>) elements.stream().map(element -> {
            try {
                return this.getClass().newInstance().toDto(element, mapper);
            } catch (InstantiationException | IllegalAccessException e) {
                return new DtoBase<>();
            }
        }).sorted(Comparator.comparing(DtoBase::getId)).collect(Collectors.toList());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

}
