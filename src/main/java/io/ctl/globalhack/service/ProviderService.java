package io.ctl.globalhack.service;

import io.ctl.globalhack.model.Service;
import io.ctl.globalhack.model.client.Client;

/**
 * Created by aimeemudd on 10/22/16.
 */
public interface ProviderService {

    void checkIn(Client client, String id);

    void registerService(String id, Service service);
}
