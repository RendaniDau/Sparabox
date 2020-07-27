package com.sparabox.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;

/**
 * Created by rendani.dau on 2020/04/24.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class MerchantDto implements Serializable {

    private String name;
    private String city;
    @JsonProperty("category")
    private CategoryDto categoryDto;
    @JsonProperty("country")
    private CountryDto countryDto;

    public CategoryDto getCategoryDto() {
        return categoryDto;
    }

    public void setCategoryDto(CategoryDto categoryDto) {
        this.categoryDto = categoryDto;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public CountryDto getCountryDto() {
        return countryDto;
    }

    public void setCountryDto(CountryDto countryDto) {
        this.countryDto = countryDto;
    }

}
