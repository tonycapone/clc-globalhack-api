package io.ctl.globalhack.repository;

import io.ctl.globalhack.model.Location;
import io.ctl.globalhack.model.client.Client;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface ClientRepository extends CrudRepository<Client, String> {
}
