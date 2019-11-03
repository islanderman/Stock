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
@JsonPropertyOrder({ "id", "__typename" })
public class PortfolioLinksSvHx2 implements Serializable {
    private final static long serialVersionUID = 1;

    @JsonProperty("id")
    private String id;

    @JsonProperty("__typename")
    private String typename;

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

    public PortfolioLinksSvHx2 withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("__typename")
    public String getTypename() {
        return typename;
    }

    @JsonProperty("__typename")
    public void setTypename(String typename) {
        this.typename = typename;
    }

    public PortfolioLinksSvHx2 withTypename(String typename) {
        this.typename = typename;
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

    public PortfolioLinksSvHx2 withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("typename", typename).append("additionalProperties", additionalProperties)
                .toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(additionalProperties).append(typename).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof PortfolioLinksSvHx2) == false) {
            return false;
        }
        PortfolioLinksSvHx2 rhs = ((PortfolioLinksSvHx2) other);
        return new EqualsBuilder().append(id, rhs.id).append(additionalProperties, rhs.additionalProperties).append(typename, rhs.typename)
                .isEquals();
    }

}
