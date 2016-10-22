package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.Provider;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import java.util.List;

public interface ProviderRepository extends CrudRepository<Provider, String> {

    @RestResource(path = "nameStartsWith", rel = "nameStartsWith")
    Page findByNameStartsWithIgnoreCase(@Param("name") String name, Pageable p);
}
