package com.vsga.sqliteapp.model;

public class Data {
    private String id;
    private String name;
    private String addrees;

    public Data (){

    }

    public Data (String id, String name, String addrees){
        this.id=id;
        this.name=name;
        this.addrees=addrees;

    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddrees(String addrees) {
        this.addrees = addrees;
    }


    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddrees() {
        return addrees;
    }




}
