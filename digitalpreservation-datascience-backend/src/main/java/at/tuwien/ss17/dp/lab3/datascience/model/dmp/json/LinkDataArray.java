
package at.tuwien.ss17.dp.lab3.datascience.model.dmp.json;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "from",
    "to",
    "text",
    "curviness"
})
public class LinkDataArray {

    @JsonProperty("from")
    private Integer from;
    @JsonProperty("to")
    private Integer to;
    @JsonProperty("text")
    private String text;
    @JsonProperty("curviness")
    private Integer curviness;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public LinkDataArray(){

    }

    public LinkDataArray(Integer from, Integer to, String text, Integer curviness){
        this.from = from;
        this.to = to;
        this.text = text;
        this.curviness = curviness;
    }

    @JsonProperty("from")
    public Integer getFrom() {
        return from;
    }

    @JsonProperty("from")
    public void setFrom(Integer from) {
        this.from = from;
    }

    @JsonProperty("to")
    public Integer getTo() {
        return to;
    }

    @JsonProperty("to")
    public void setTo(Integer to) {
        this.to = to;
    }

    @JsonProperty("text")
    public String getText() {
        return text;
    }

    @JsonProperty("text")
    public void setText(String text) {
        this.text = text;
    }

    @JsonProperty("curviness")
    public Integer getCurviness() {
        return curviness;
    }

    @JsonProperty("curviness")
    public void setCurviness(Integer curviness) {
        this.curviness = curviness;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
