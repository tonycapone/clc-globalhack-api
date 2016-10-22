package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.ProviderUser;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface ProviderUserRepository extends CrudRepository<ProviderUser, String> {

    ProviderUser findByUsername(String username);
}
