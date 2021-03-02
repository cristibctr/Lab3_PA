/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author crist
 */
public abstract class Location implements Comparable<Location>{
    private String name;
    private Map<Location, Integer> cost = new HashMap<>();

    public Location(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<Location, Integer> getCost() {
        return cost;
    }

    public void setCost(Location node, int value) {
        cost.put(node, value);
    }

    @Override
    public String toString() {
        String returnStr = "";
        for(Location i : cost.keySet())
            returnStr += name + "->" + i.getName() + " " + cost.get(i);
        return returnStr;
    }
    @Override
    public int compareTo(Location other)
    {
        if(other.name == null || this.name == null)
            throw new NullPointerException();
        return this.name.compareTo(other.name);
    }
}
