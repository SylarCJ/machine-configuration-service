package ust.augury.interview.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Component {

    private String id;  // Use String instead of ObjectId

    private String type;

    @JsonProperty("technicalSpecs")
    private Map<String, Object> technicalSpecs;

    @JsonProperty("numBearings")
    private int numBearings;

    private List<Bearing> bearings;

    private PowerDrive powerDrives;

}

