package ust.augury.interview.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PowerDrive {

    @JsonProperty("driving")
    private List<Drive> driving;

    @JsonProperty("drivenBy")
    private List<Drive> drivenBy;
}


