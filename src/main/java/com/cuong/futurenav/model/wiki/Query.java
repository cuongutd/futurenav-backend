package com.cuong.futurenav.model.wiki;

import java.util.ArrayList;

/**
 * Created by Cuong on 11/23/2015.
 */
public class Query {
    public ArrayList<CategoryMember> getCategorymembers() {
        return categorymembers;
    }

    public void setCategorymembers(ArrayList<CategoryMember> categorymembers) {
        this.categorymembers = categorymembers;
    }

    ArrayList<CategoryMember> categorymembers;
}
