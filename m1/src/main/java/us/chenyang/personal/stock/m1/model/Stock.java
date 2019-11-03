package us.chenyang.personal.stock.m1.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "node", "cursor" })
public class Stock implements Serializable {
    private final static long serialVersionUID = 1;

    @JsonProperty("node")
    @Valid
    private Node node;

    @JsonProperty("cursor")
    private String cursor;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonIgnore
    public String getTick() {
        return StringUtils.replaceChars(node.getPosition().getSecurity().getSymbol(), '.', '-');
    }

    @JsonProperty("node")
    public Node getNode() {
        return node;
    }

    @JsonProperty("node")
    public void setNode(Node node) {
        this.node = node;
    }

    public Stock withNode(Node node) {
        this.node = node;
        return this;
    }

    @JsonProperty("cursor")
    public String getCursor() {
        return cursor;
    }

    @JsonProperty("cursor")
    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public Stock withCursor(String cursor) {
        this.cursor = cursor;
        return this;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Stock withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("node", node).append("cursor", cursor).append("additionalProperties", additionalProperties)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cursor).append(node).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Stock) == false) {
            return false;
        }
        Stock rhs = ((Stock) other);
        return new EqualsBuilder().append(cursor, rhs.cursor).append(node, rhs.node).append(additionalProperties, rhs.additionalProperties)
                .isEquals();
    }
}
