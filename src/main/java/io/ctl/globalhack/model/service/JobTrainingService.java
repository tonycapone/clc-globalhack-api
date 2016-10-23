package io.ctl.globalhack.model.service;

import io.ctl.globalhack.model.Service;
import lombok.Data;

/**
 * Created by khomco on 10/22/16.
 */
@Data
public class JobTrainingService extends Service {
    private String type = "job_training";

    public boolean isAvailable() {
        return true;
    }
}
