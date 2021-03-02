/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author crist
 */
public class City {
    String cityName;
    private List<Location> nodes = new ArrayList<>();

    public City(String cityName) {
        this.cityName = cityName;
    }

    public String getCityName() {
        return cityName;
    }
    
    public void addLocation(Location node)
    {
        nodes.add(node);
        for(Location i : nodes)
            i.setCost(node, (int) Math.random() *1000000 %10);
    }

    @Override
    public String toString() {
        String returnStr = cityName + ":\n";
        for(int i = 0; i < nodes.size(); i++)
            returnStr += nodes.get(i).toString() + "\n";
        return returnStr;
    }
    
}
