package com.sparabox.domain.business;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Created by rendani.dau on 2020/04/24.
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class CardDto implements Serializable {

    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

}