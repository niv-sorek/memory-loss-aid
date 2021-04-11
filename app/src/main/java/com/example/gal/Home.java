package com.example.gal;

import java.util.Map;

public class Home {
    private String name;
    private int number;
    private String description;
    private Map<String, Object> attributes;

    public Home() {

    }

    public int getNumber() {
        return number;
    }

    public Home setNumber(int number) {
        this.number = number;
        return this;
    }

    public String getName() {
        return name;
    }

    public Home setName(String name) {
        this.name = name;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Home setDescription(String description) {
        this.description = description;
        return this;
    }

    public Map<String, Object> getAttributes() {
        return attributes;
    }

    public Home setAttributes(Map<String, Object> attributes) {
        this.attributes = attributes;
        return this;
    }
}
