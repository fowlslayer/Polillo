package com.example.classi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * Created by Enrico on 05/06/2015.
 */
public class ListaAttivita {
    private LinkedHashMap<String,ArrayList<String>> list;
    public ListaAttivita()
    {
        list=new LinkedHashMap<String, ArrayList<String>>();
        ArrayList<String> cities=new ArrayList<String>();

        list.put("Scegli tipologia:", cities);
        list.put("Bar", cities);
        list.put("Disco e Pub", cities);
        list.put("Gelateria", cities);
        list.put("Minimarket", cities);
        list.put("Abbigliamento", cities);
        list.put("Pizzeria", cities);
        list.put("Ristorante", cities);
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
