package us.chenyang.personal.stock.m1.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import javax.validation.Valid;

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
@JsonPropertyOrder({ "id", "security", "quantity", "cost", "value", "unrealizedGain" })
public class Position implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("security")
    @Valid
    private Security security;

    @JsonProperty("quantity")
    private double quantity;

    @JsonProperty("cost")
    @Valid
    private Cost cost;

    @JsonProperty("value")
    @Valid
    private Value value;

    @JsonProperty("unrealizedGain")
    @Valid
    private UnrealizedGain unrealizedGain;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("id")
    public String getId() {
        return id;
    }

    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    public Position withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("security")
    public Security getSecurity() {
        return security;
    }

    @JsonProperty("security")
    public void setSecurity(Security security) {
        this.security = security;
    }

    public Position withSecurity(Security security) {
        this.security = security;
        return this;
    }

    @JsonProperty("quantity")
    public double getQuantity() {
        return quantity;
    }

    @JsonProperty("quantity")
    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public Position withQuantity(double quantity) {
        this.quantity = quantity;
        return this;
    }

    @JsonProperty("cost")
    public Cost getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(Cost cost) {
        this.cost = cost;
    }

    public Position withCost(Cost cost) {
        this.cost = cost;
        return this;
    }

    @JsonProperty("value")
    public Value getValue() {
        return value;
    }

    @JsonProperty("value")
    public void setValue(Value value) {
        this.value = value;
    }

    public Position withValue(Value value) {
        this.value = value;
        return this;
    }

    @JsonProperty("unrealizedGain")
    public UnrealizedGain getUnrealizedGain() {
        return unrealizedGain;
    }

    @JsonProperty("unrealizedGain")
    public void setUnrealizedGain(UnrealizedGain unrealizedGain) {
        this.unrealizedGain = unrealizedGain;
    }

    public Position withUnrealizedGain(UnrealizedGain unrealizedGain) {
        this.unrealizedGain = unrealizedGain;
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

    public Position withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("security", security).append("quantity", quantity).append("cost", cost)
                .append("value", value).append("unrealizedGain", unrealizedGain).append("additionalProperties", additionalProperties)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(security).append(quantity).append(cost).append(unrealizedGain).append(id)
                .append(additionalProperties).append(value).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Position) == false) {
            return false;
        }
        Position rhs = ((Position) other);
        return new EqualsBuilder().append(security, rhs.security).append(quantity, rhs.quantity).append(cost, rhs.cost)
                .append(unrealizedGain, rhs.unrealizedGain).append(id, rhs.id).append(additionalProperties, rhs.additionalProperties)
                .append(value, rhs.value).isEquals();
    }

}
