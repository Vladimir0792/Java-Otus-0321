package ru.otus.model;

import java.util.List;

public class ObjectForMessage implements Cloneable {
    private List<String> data;

    public List<String> getData() {
        return data;
    }

    public void setData(List<String> data) {
        this.data = data;
    }

    public ObjectForMessage clone() throws CloneNotSupportedException {
        ObjectForMessage ofm = (ObjectForMessage) super.clone();
        ofm.setData(List.copyOf(ofm.getData()));
        return ofm;
    }

}


