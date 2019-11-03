package us.chenyang.personal.stock.m1.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
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
@JsonPropertyOrder({ "id", "name", "_portfolioLinksSvHx2", "__typename", "isActive", "symbol", "profile" })
public class Security implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("id")
    private String id;

    @JsonProperty("name")
    private String name;

    @JsonProperty("_portfolioLinksSvHx2")
    @Valid
    private List<PortfolioLinksSvHx2> portfolioLinksSvHx2 = null;

    @JsonProperty("__typename")
    private String typename;

    @JsonProperty("isActive")
    private boolean isActive;

    @JsonProperty("symbol")
    private String symbol;

    @JsonProperty("profile")
    @Valid
    private Profile profile;

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

    public Security withId(String id) {
        this.id = id;
        return this;
    }

    @JsonProperty("name")
    public String getName() {
        return name;
    }

    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    public Security withName(String name) {
        this.name = name;
        return this;
    }

    @JsonProperty("_portfolioLinksSvHx2")
    public List<PortfolioLinksSvHx2> getPortfolioLinksSvHx2() {
        return portfolioLinksSvHx2;
    }

    @JsonProperty("_portfolioLinksSvHx2")
    public void setPortfolioLinksSvHx2(List<PortfolioLinksSvHx2> portfolioLinksSvHx2) {
        this.portfolioLinksSvHx2 = portfolioLinksSvHx2;
    }

    public Security withPortfolioLinksSvHx2(List<PortfolioLinksSvHx2> portfolioLinksSvHx2) {
        this.portfolioLinksSvHx2 = portfolioLinksSvHx2;
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

    public Security withTypename(String typename) {
        this.typename = typename;
        return this;
    }

    @JsonProperty("isActive")
    public boolean isIsActive() {
        return isActive;
    }

    @JsonProperty("isActive")
    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public Security withIsActive(boolean isActive) {
        this.isActive = isActive;
        return this;
    }

    @JsonProperty("symbol")
    public String getSymbol() {
        return symbol;
    }

    @JsonProperty("symbol")
    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public Security withSymbol(String symbol) {
        this.symbol = symbol;
        return this;
    }

    @JsonProperty("profile")
    public Profile getProfile() {
        return profile;
    }

    @JsonProperty("profile")
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Security withProfile(Profile profile) {
        this.profile = profile;
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

    public Security withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("id", id).append("name", name).append("portfolioLinksSvHx2", portfolioLinksSvHx2)
                .append("typename", typename).append("isActive", isActive).append("symbol", symbol).append("profile", profile)
                .append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(symbol).append(portfolioLinksSvHx2).append(profile).append(name).append(id)
                .append(additionalProperties).append(isActive).append(typename).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Security) == false) {
            return false;
        }
        Security rhs = ((Security) other);
        return new EqualsBuilder().append(symbol, rhs.symbol).append(portfolioLinksSvHx2, rhs.portfolioLinksSvHx2)
                .append(profile, rhs.profile).append(name, rhs.name).append(id, rhs.id)
                .append(additionalProperties, rhs.additionalProperties).append(isActive, rhs.isActive).append(typename, rhs.typename)
                .isEquals();
    }

}
