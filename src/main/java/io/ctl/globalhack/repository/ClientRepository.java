package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.client.Client;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface ClientRepository extends CrudRepository<Client, String> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Page<Client> findByNameStartsWithIgnoreCase(@Param("name") String name, Pageable p);

    Client findByName(String name);

    Client findBySocial(String social);


}
