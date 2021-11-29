package com.zipcodewilmington.phonebook;

import java.util.*;
import java.util.stream.Collectors;
//import java.util.HashMap;


/**
 * Created by leon on 1/23/18.
 * Made WAY better by kristofer 6/16/20
 */
public class PhoneBook {

    private final Map<String, List<String>> phonebook;

    public PhoneBook(Map<String, List<String>> map) {
        this.phonebook = map;
    }

    public PhoneBook() {
        this.phonebook = new LinkedHashMap<>();
    }

    public void add(String name, String phoneNumber) {
        this.phonebook.put(name,Collections.singletonList(phoneNumber));
    }

    public void addAll(String name, String... phoneNumbers) {
        this.phonebook.put(name,new LinkedList<>(Arrays.asList(phoneNumbers)));
    }

    public void remove(String name) {
        this.phonebook.remove(name);
    }

    public Boolean hasEntry(String name) {
        return this.phonebook.containsKey(name);
    }
    public Boolean hasEntry(String name,String phoneNumber){
        return this.phonebook.containsKey(name) &&  this.phonebook.get(name).contains(phoneNumber);
    }
    public List<String> lookup(String name) {
        return this.phonebook.get(name);
    }

    public String reverseLookup(String phoneNumber)  {
        String n;
        for(String pn :this.phonebook.keySet()){
            if(this.phonebook.get(pn).contains(phoneNumber)){
                return pn;
            }
        }
        return "";
    }

    public List<String> getAllContactNames() {
        List<String> list = new LinkedList<>();
        this.phonebook.forEach((n,a) -> {list.add(n);});
        return list;
    }

    public Map<String, List<String>> getMap() {
        return this.phonebook;
    }
}
