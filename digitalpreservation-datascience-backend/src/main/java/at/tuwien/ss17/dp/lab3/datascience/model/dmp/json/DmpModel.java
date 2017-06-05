
package at.tuwien.ss17.dp.lab3.datascience.model.dmp.json;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "nodeKeyProperty",
    "nodeDataArray",
    "linkDataArray"
})
public class DmpModel {

    @JsonProperty("nodeKeyProperty")
    private String nodeKeyProperty;
    @JsonProperty("nodeDataArray")
    private List<NodeDataArray> nodeDataArray = null;
    @JsonProperty("linkDataArray")
    private List<LinkDataArray> linkDataArray = null;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("nodeKeyProperty")
    public String getNodeKeyProperty() {
        return nodeKeyProperty;
    }

    @JsonProperty("nodeKeyProperty")
    public void setNodeKeyProperty(String nodeKeyProperty) {
        this.nodeKeyProperty = nodeKeyProperty;
    }

    @JsonProperty("nodeDataArray")
    public List<NodeDataArray> getNodeDataArray() {
        return nodeDataArray;
    }

    @JsonProperty("nodeDataArray")
    public void setNodeDataArray(List<NodeDataArray> nodeDataArray) {
        this.nodeDataArray = nodeDataArray;
    }

    @JsonProperty("linkDataArray")
    public List<LinkDataArray> getLinkDataArray() {
        return linkDataArray;
    }

    @JsonProperty("linkDataArray")
    public void setLinkDataArray(List<LinkDataArray> linkDataArray) {
        this.linkDataArray = linkDataArray;
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
