package io.ctl.globalhack.model;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import io.ctl.globalhack.model.service.ShelterService;
import lombok.Data;
import org.springframework.data.annotation.Id;

/**
 * Created by khomco on 10/22/16.
 */
@Data
@JsonTypeInfo(
        use = JsonTypeInfo.Id.NAME,
        include = JsonTypeInfo.As.PROPERTY,
        property = "type_name")
@JsonSubTypes({
        @JsonSubTypes.Type(value = ShelterService.class, name = "shelter")
})
public abstract class Service {
    @Id
    private String id;

    boolean isAvailable;
}
