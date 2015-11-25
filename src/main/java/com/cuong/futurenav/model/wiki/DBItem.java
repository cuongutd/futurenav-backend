package com.cuong.futurenav.model.wiki;

/**
 * Created by Cuong on 11/23/2015.
 */
public class DBItem {
    DBProperty property;
    DBValue value;

    public DBProperty getProperty() {
        return property;
    }

    public void setProperty(DBProperty property) {
        this.property = property;
    }

    public DBValue getValue() {
        return value;
    }

    public void setValue(DBValue value) {
        this.value = value;
    }
}
