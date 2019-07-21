/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.service;

import edu.umss.storeservice.model.Image;

import java.util.List;

public interface ImageService extends GenericService<Image> {
    List<Image> findByItemInstanceId(Long itemInstanceId);
}

    