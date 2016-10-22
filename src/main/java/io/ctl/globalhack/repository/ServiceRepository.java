package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.Service;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by khomco on 10/22/16.
 */
public interface ServiceRepository extends CrudRepository<Service, String> {

}
