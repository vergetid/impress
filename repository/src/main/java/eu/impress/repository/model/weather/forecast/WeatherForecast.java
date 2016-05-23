package eu.impress.repository.model.weather.forecast;

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
    "city",
    "cod",
    "message",
    "cnt",
    "list"
})
public class WeatherForecast {

    @JsonProperty("city")
    private City city;
    @JsonProperty("cod")
    private String cod;
    @JsonProperty("message")
    private Double message;
    @JsonProperty("cnt")
    private Integer cnt;
    @JsonProperty("list")
    private java.util.List<eu.impress.repository.model.weather.forecast.List> list = new ArrayList<eu.impress.repository.model.weather.forecast.List>();
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("city")
    public City getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(City city) {
        this.city = city;
    }

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
     *     The message
     */
    @JsonProperty("message")
    public Double getMessage() {
        return message;
    }

    /**
     * 
     * @param message
     *     The message
     */
    @JsonProperty("message")
    public void setMessage(Double message) {
        this.message = message;
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
    public java.util.List<eu.impress.repository.model.weather.forecast.List> getList() {
        return list;
    }

    /**
     * 
     * @param list
     *     The list
     */
    @JsonProperty("list")
    public void setList(java.util.List<eu.impress.repository.model.weather.forecast.List> list) {
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
        return new HashCodeBuilder().append(city).append(cod).append(message).append(cnt).append(list).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof WeatherForecast) == false) {
            return false;
        }
        WeatherForecast rhs = ((WeatherForecast) other);
        return new EqualsBuilder().append(city, rhs.city).append(cod, rhs.cod).append(message, rhs.message).append(cnt, rhs.cnt).append(list, rhs.list).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}