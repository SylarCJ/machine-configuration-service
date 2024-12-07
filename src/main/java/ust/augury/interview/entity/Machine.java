package ust.augury.interview.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Machine {

    private String id;  // Use String instead of ObjectId

    private String name;

    @JsonProperty("createdAt")
    private Date createdAt;

    @JsonProperty("technicalSpecs")
    private Map<String, Object> technicalSpecs;

    private List<Component> components;

    @JsonProperty("updatedAt")
    private Date updatedAt;

    private String updatedBy;
}
