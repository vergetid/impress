package eu.impress.repository.model.weather.current;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "cod",
    "calctime",
    "cnt",
    "list"
})
public class WeatherCurrent {

    @JsonProperty("cod")
    private String cod;
    @JsonProperty("calctime")
    private Double calctime;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private java.util.List< eu.impress.repository.model.weather.current.List> list = new ArrayList< eu.impress.repository.model.weather.current.List>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The cod
     */
    @JsonProperty("cod")
    public String getCod() {
        return cod;
    }

    /**
     * 
     * @param cod
     *     The cod
     */
    @JsonProperty("cod")
    public void setCod(String cod) {
        this.cod = cod;
    }

    /**
     * 
     * @return
     *     The calctime
     */
    @JsonProperty("calctime")
    public Double getCalctime() {
        return calctime;
    }

    /**
     * 
     * @param calctime
     *     The calctime
     */
    @JsonProperty("calctime")
    public void setCalctime(Double calctime) {
        this.calctime = calctime;
    }

    /**
     * 
     * @return
     *     The cnt
     */
    @JsonProperty("cnt")
    public Integer getCnt() {
        return cnt;
    }

    /**
     * 
     * @param cnt
     *     The cnt
     */
    @JsonProperty("cnt")
    public void setCnt(Integer cnt) {
        this.cnt = cnt;
    }

    /**
     * 
     * @return
     *     The list
     */
    @JsonProperty("list")
    public java.util.List< eu.impress.repository.model.weather.current.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    @JsonProperty("list")
    public void setList(java.util.List<eu.impress.repository.model.weather.current.List> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(cod).append(calctime).append(cnt).append(list).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherCurrent) == false) {
            return false;
        }
        WeatherCurrent rhs = ((WeatherCurrent) other);
        return new EqualsBuilder().append(cod, rhs.cod).append(calctime, rhs.calctime).append(cnt, rhs.cnt).append(list, rhs.list).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}