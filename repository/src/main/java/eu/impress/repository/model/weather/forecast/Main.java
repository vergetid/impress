package eu.impress.repository.model.weather.forecast;

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
    "temp",
    "temp_min",
    "temp_max",
    "pressure",
    "sea_level",
    "grnd_level",
    "humidity",
    "temp_kf"
})
public class Main {

    @JsonProperty("temp")
    private Double temp;
    @JsonProperty("temp_min")
    private Double tempMin;
    @JsonProperty("temp_max")
    private Double tempMax;
    @JsonProperty("pressure")
    private Double pressure;
    @JsonProperty("sea_level")
    private Double seaLevel;
    @JsonProperty("grnd_level")
    private Double grndLevel;
    @JsonProperty("humidity")
    private Integer humidity;
    @JsonProperty("temp_kf")
    private Integer tempKf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The temp
     */
    @JsonProperty("temp")
    public Double getTemp() {
        return temp;
    }

    /**
     * 
     * @param temp
     *     The temp
     */
    @JsonProperty("temp")
    public void setTemp(Double temp) {
        this.temp = temp;
    }

    /**
     * 
     * @return
     *     The tempMin
     */
    @JsonProperty("temp_min")
    public Double getTempMin() {
        return tempMin;
    }

    /**
     * 
     * @param tempMin
     *     The temp_min
     */
    @JsonProperty("temp_min")
    public void setTempMin(Double tempMin) {
        this.tempMin = tempMin;
    }

    /**
     * 
     * @return
     *     The tempMax
     */
    @JsonProperty("temp_max")
    public Double getTempMax() {
        return tempMax;
    }

    /**
     * 
     * @param tempMax
     *     The temp_max
     */
    @JsonProperty("temp_max")
    public void setTempMax(Double tempMax) {
        this.tempMax = tempMax;
    }

    /**
     * 
     * @return
     *     The pressure
     */
    @JsonProperty("pressure")
    public Double getPressure() {
        return pressure;
    }

    /**
     * 
     * @param pressure
     *     The pressure
     */
    @JsonProperty("pressure")
    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    /**
     * 
     * @return
     *     The seaLevel
     */
    @JsonProperty("sea_level")
    public Double getSeaLevel() {
        return seaLevel;
    }

    /**
     * 
     * @param seaLevel
     *     The sea_level
     */
    @JsonProperty("sea_level")
    public void setSeaLevel(Double seaLevel) {
        this.seaLevel = seaLevel;
    }

    /**
     * 
     * @return
     *     The grndLevel
     */
    @JsonProperty("grnd_level")
    public Double getGrndLevel() {
        return grndLevel;
    }

    /**
     * 
     * @param grndLevel
     *     The grnd_level
     */
    @JsonProperty("grnd_level")
    public void setGrndLevel(Double grndLevel) {
        this.grndLevel = grndLevel;
    }

    /**
     * 
     * @return
     *     The humidity
     */
    @JsonProperty("humidity")
    public Integer getHumidity() {
        return humidity;
    }

    /**
     * 
     * @param humidity
     *     The humidity
     */
    @JsonProperty("humidity")
    public void setHumidity(Integer humidity) {
        this.humidity = humidity;
    }

    /**
     * 
     * @return
     *     The tempKf
     */
    @JsonProperty("temp_kf")
    public Integer getTempKf() {
        return tempKf;
    }

    /**
     * 
     * @param tempKf
     *     The temp_kf
     */
    @JsonProperty("temp_kf")
    public void setTempKf(Integer tempKf) {
        this.tempKf = tempKf;
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
        return new HashCodeBuilder().append(temp).append(tempMin).append(tempMax).append(pressure).append(seaLevel).append(grndLevel).append(humidity).append(tempKf).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Main) == false) {
            return false;
        }
        Main rhs = ((Main) other);
        return new EqualsBuilder().append(temp, rhs.temp).append(tempMin, rhs.tempMin).append(tempMax, rhs.tempMax).append(pressure, rhs.pressure).append(seaLevel, rhs.seaLevel).append(grndLevel, rhs.grndLevel).append(humidity, rhs.humidity).append(tempKf, rhs.tempKf).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}