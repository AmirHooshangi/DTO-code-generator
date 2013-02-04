package com.velorin.codegenerator;

/**
 * User: Pooya
 * Date: 2/4/13
 * Time: 2:50 PM
 */
public class Field {
    private String type;
    private String name;

    public Field() {
    }

    public Field(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
