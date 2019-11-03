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
@JsonPropertyOrder({ "cost", "averageSharePrice" })
public class Cost implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("cost")
    private double cost;

    @JsonProperty("averageSharePrice")
    private double averageSharePrice;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("cost")
    public double getCost() {
        return cost;
    }

    @JsonProperty("cost")
    public void setCost(double cost) {
        this.cost = cost;
    }

    public Cost withCost(double cost) {
        this.cost = cost;
        return this;
    }

    @JsonProperty("averageSharePrice")
    public double getAverageSharePrice() {
        return averageSharePrice;
    }

    @JsonProperty("averageSharePrice")
    public void setAverageSharePrice(double averageSharePrice) {
        this.averageSharePrice = averageSharePrice;
    }

    public Cost withAverageSharePrice(double averageSharePrice) {
        this.averageSharePrice = averageSharePrice;
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

    public Cost withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("cost", cost).append("averageSharePrice", averageSharePrice)
                .append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cost).append(additionalProperties).append(averageSharePrice).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Cost) == false) {
            return false;
        }
        Cost rhs = ((Cost) other);
        return new EqualsBuilder().append(cost, rhs.cost).append(additionalProperties, rhs.additionalProperties)
                .append(averageSharePrice, rhs.averageSharePrice).isEquals();
    }

}
