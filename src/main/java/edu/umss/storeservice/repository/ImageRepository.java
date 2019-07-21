/**
 * @author: Edson A. Terceros T.
 */

package edu.umss.storeservice.repository;

import edu.umss.storeservice.model.Image;

import java.util.List;

public interface ImageRepository extends GenericRepository<Image> {
    List<Image> findByItemInstanceId(Long itemInstanceId);
}
  