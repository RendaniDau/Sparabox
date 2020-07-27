package com.sparabox.domain.persistence;

import javax.persistence.*;

@Entity
@Table(name = "Merchant", schema = "SPA_BOX")
public class Merchant {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SPA_BOX_SEQ")
    @SequenceGenerator(name = "SPA_BOX_SEQ", sequenceName = "SEQUENCE_SPA_BOX")
    @Column(name = "MERCHANT_ID")
    private Long merchantId;

    @Column(name = "CAT_CODE")
    private String categoryCode;

    @Column(name = "CAT_KEY")
    private String categoryKey;

    @Column(name = "CAT_NAME")
    private String categoryName;

    @Column(name = "NAME", nullable = false)
    private String name;

    @Column(name = "CITY", nullable = false)
    private String city;

    @Column(name = "COUNTRY_CODE", nullable = false)
    private String countryCode;

    @Column(name = "COUNTRY_ALPHA", nullable = false)
    private String countryAphaThree;

    @Column(name = "COUNTRY_NAME", nullable = false)
    private String countryName;

    public Long getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Long merchantId) {
        this.merchantId = merchantId;
    }

    public String getCategoryCode() {
        return categoryCode;
    }

    public void setCategoryCode(String categoryCode) {
        this.categoryCode = categoryCode;
    }

    public String getCategoryKey() {
        return categoryKey;
    }

    public void setCategoryKey(String categoryKey) {
        this.categoryKey = categoryKey;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getCountryAphaThree() {
        return countryAphaThree;
    }

    public void setCountryAphaThree(String countryAphaThree) {
        this.countryAphaThree = countryAphaThree;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }
}
