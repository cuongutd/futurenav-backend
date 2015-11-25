package com.cuong.futurenav.model.wiki;

import java.util.ArrayList;

/**
 * Created by Cuong on 11/23/2015.
 */
public class DBResults {
    boolean distinct;
    boolean ordered;
    ArrayList<DBItem> bindings;

    public boolean isDistinct() {
        return distinct;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isOrdered() {
        return ordered;
    }

    public void setOrdered(boolean ordered) {
        this.ordered = ordered;
    }

    public ArrayList<DBItem> getBindings() {
        return bindings;
    }

    public void setBindings(ArrayList<DBItem> bindings) {
        this.bindings = bindings;
    }
}
