package com.unitriapp.matheus.unitriapp.model.content;

/**
 * Created by Matheus on 19/11/2017.
 */

public class Matter {
    String name;
    String id;

    public Matter(String name, String id) {
        this.name = name;
        this.id = id;
    }
    public Matter() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
