package com.example.classi;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Enrico on 24/05/2015.
 */
public class AttivitaList {

    private HashMap<String,ArrayList<String>> list;
    public AttivitaList()
    {
        list=new HashMap<String, ArrayList<String>>();
        ArrayList<String> cities=new ArrayList<String>();

        list.put("Bar", cities);

        list.put("Disco & Pub", cities);

        list.put("Gelateria", cities);
        list.put("Minimarket", cities);
        list.put("Pizzeria", cities);
        list.put("Ristorante", cities);
        list.put("Abbigliamento", cities);
        list.put("Benessere", cities);
        list.put("Casa", cities);
        list.put("Elettronica", cities);
        list.put("Oreficeria", cities);
        list.put("Benessere", cities);
        list.put("Bottega", cities);
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
