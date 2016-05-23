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
    "dt",
    "main",
    "weather",
    "clouds",
    "wind",
    "rain",
    "snow",
    "sys",
    "dt_txt"
})
public class List {

    @JsonProperty("dt")
    private Integer dt;
    @JsonProperty("main")
    private Main main;
    @JsonProperty("weather")
    private java.util.List<Weather> weather = new ArrayList<Weather>();
    @JsonProperty("clouds")
    private Clouds clouds;
    @JsonProperty("wind")
    private Wind wind;
    @JsonProperty("rain")
    private Rain rain;
    @JsonProperty("snow")
    private Snow snow;
    @JsonProperty("sys")
    private Sys_ sys;
    @JsonProperty("dt_txt")
    private String dtTxt;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The dt
     */
    @JsonProperty("dt")
    public Integer getDt() {
        return dt;
    }

    /**
     * 
     * @param dt
     *     The dt
     */
    @JsonProperty("dt")
    public void setDt(Integer dt) {
        this.dt = dt;
    }

    /**
     * 
     * @return
     *     The main
     */
    @JsonProperty("main")
    public Main getMain() {
        return main;
    }

    /**
     * 
     * @param main
     *     The main
     */
    @JsonProperty("main")
    public void setMain(Main main) {
        this.main = main;
    }

    /**
     * 
     * @return
     *     The weather
     */
    @JsonProperty("weather")
    public java.util.List<Weather> getWeather() {
        return weather;
    }

    /**
     * 
     * @param weather
     *     The weather
     */
    @JsonProperty("weather")
    public void setWeather(java.util.List<Weather> weather) {
        this.weather = weather;
    }

    /**
     * 
     * @return
     *     The clouds
     */
    @JsonProperty("clouds")
    public Clouds getClouds() {
        return clouds;
    }

    /**
     * 
     * @param clouds
     *     The clouds
     */
    @JsonProperty("clouds")
    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    /**
     * 
     * @return
     *     The wind
     */
    @JsonProperty("wind")
    public Wind getWind() {
        return wind;
    }

    /**
     * 
     * @param wind
     *     The wind
     */
    @JsonProperty("wind")
    public void setWind(Wind wind) {
        this.wind = wind;
    }

    /**
     * 
     * @return
     *     The rain
     */
    @JsonProperty("rain")
    public Rain getRain() {
        return rain;
    }

    /**
     * 
     * @param rain
     *     The rain
     */
    @JsonProperty("rain")
    public void setRain(Rain rain) {
        this.rain = rain;
    }

    /**
     * 
     * @return
     *     The snow
     */
    @JsonProperty("snow")
    public Snow getSnow() {
        return snow;
    }

    /**
     * 
     * @param snow
     *     The snow
     */
    @JsonProperty("snow")
    public void setSnow(Snow snow) {
        this.snow = snow;
    }

    /**
     * 
     * @return
     *     The sys
     */
    @JsonProperty("sys")
    public Sys_ getSys() {
        return sys;
    }

    /**
     * 
     * @param sys
     *     The sys
     */
    @JsonProperty("sys")
    public void setSys(Sys_ sys) {
        this.sys = sys;
    }

    /**
     * 
     * @return
     *     The dtTxt
     */
    @JsonProperty("dt_txt")
    public String getDtTxt() {
        return dtTxt;
    }

    /**
     * 
     * @param dtTxt
     *     The dt_txt
     */
    @JsonProperty("dt_txt")
    public void setDtTxt(String dtTxt) {
        this.dtTxt = dtTxt;
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
        return new HashCodeBuilder().append(dt).append(main).append(weather).append(clouds).append(wind).append(rain).append(snow).append(sys).append(dtTxt).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof List) == false) {
            return false;
        }
        List rhs = ((List) other);
        return new EqualsBuilder().append(dt, rhs.dt).append(main, rhs.main).append(weather, rhs.weather).append(clouds, rhs.clouds).append(wind, rhs.wind).append(rain, rhs.rain).append(snow, rhs.snow).append(sys, rhs.sys).append(dtTxt, rhs.dtTxt).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}