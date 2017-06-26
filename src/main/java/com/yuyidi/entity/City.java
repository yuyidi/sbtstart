package com.yuyidi.entity;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Created by yuyidi on 2017/6/22.
 * @desc
 */
@Entity
public class City implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "country",nullable = false)
    private String country;
    @Column(name = "name",nullable = false)
    private String name;
    @Column(name ="state",nullable = false)
    private String state;
    @Column(name = "map",nullable = false)
    private String map;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getMap() {
        return map;
    }

    public void setMap(String map) {
        this.map = map;
    }
}
