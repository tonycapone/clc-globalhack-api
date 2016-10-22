package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.User;
import org.springframework.data.repository.Repository;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface UserRepository extends Repository<User, String> {

    User findById(String id);
}
