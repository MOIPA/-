package com.PrototypePattern.Interface;

public abstract class Shape implements Cloneable{

    private String id;
    protected String type;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public abstract void draw();

    public Object clone() {
        Object objClone = null;
        try {
            objClone = super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return objClone;
    }
}
