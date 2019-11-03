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
@JsonPropertyOrder({ "gain", "gainPercent" })
public class UnrealizedGain implements Serializable {
    private static final long serialVersionUID = 1L;

    @JsonProperty("gain")
    private double gain;
    @JsonProperty("gainPercent")
    private double gainPercent;

    @JsonIgnore
    @Valid
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonProperty("gain")
    public double getGain() {
        return gain;
    }

    @JsonProperty("gain")
    public void setGain(double gain) {
        this.gain = gain;
    }

    public UnrealizedGain withGain(double gain) {
        this.gain = gain;
        return this;
    }

    @JsonProperty("gainPercent")
    public double getGainPercent() {
        return gainPercent;
    }

    @JsonProperty("gainPercent")
    public void setGainPercent(double gainPercent) {
        this.gainPercent = gainPercent;
    }

    public UnrealizedGain withGainPercent(double gainPercent) {
        this.gainPercent = gainPercent;
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

    public UnrealizedGain withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this).append("gain", gain).append("gainPercent", gainPercent)
                .append("additionalProperties", additionalProperties).toString();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(additionalProperties).append(gainPercent).append(gain).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof UnrealizedGain) == false) {
            return false;
        }
        UnrealizedGain rhs = ((UnrealizedGain) other);
        return new EqualsBuilder().append(additionalProperties, rhs.additionalProperties).append(gainPercent, rhs.gainPercent)
                .append(gain, rhs.gain).isEquals();
    }

}
