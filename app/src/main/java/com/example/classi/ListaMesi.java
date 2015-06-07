package com.example.classi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Enrico on 05/06/2015.
 */
public class ListaMesi {
    private LinkedHashMap<String,ArrayList<String>> list;
    public ListaMesi()
    {
        list=new LinkedHashMap<String, ArrayList<String>>();
        ArrayList<String> cities=new ArrayList<String>();

        list.put("Gennaio", cities);
        list.put("Febbraio", cities);
        list.put("Marzo", cities);
        list.put("Aprile", cities);
        list.put("Maggio", cities);
        list.put("Giugno", cities);
        list.put("Luglio", cities);
        list.put("Agosto", cities);
        list.put("Settembre", cities);
        list.put("Ottobre", cities);
        list.put("Novembre", cities);
        list.put("Dicembre", cities);

    }
    public Collection<String> getCountries()
    {
        return list.keySet();
    }
    public Collection<String> getCitiesByCountry(String c)
    {
        return list.get(c);
    }
}
