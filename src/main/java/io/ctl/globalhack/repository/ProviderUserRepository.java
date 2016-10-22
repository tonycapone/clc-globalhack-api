package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.ProviderUser;
import org.springframework.data.repository.Repository;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface ProviderUserRepository extends Repository<ProviderUser, String> {

    ProviderUser findByUsername(String username);
}
