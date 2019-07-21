/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Image;
import edu.umss.storeservice.repository.GenericRepository;
import edu.umss.storeservice.repository.ImageRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class ImageServiceImpl extends GenericServiceImpl<Image> implements ImageService {
    private final ImageRepository repository;

    public ImageServiceImpl(ImageRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Image> findByItemInstanceId(Long itemInstanceId) {
        return repository.findByItemInstanceId(itemInstanceId);
    }

    @Override
    protected void validateSave(Image model) {
        if (CollectionUtils.isEmpty(findByItemInstanceId(model.getItemInstance().getId()))) {
            model.setFeatured(true);
            super.validateSave(model);
        }
    }

    @Override
    protected GenericRepository<Image> getRepository() {
        return repository;
    }
}
