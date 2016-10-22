package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.User;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface UserRepository extends CrudRepository<User, String> {

    User findByUsername(String username);
}
