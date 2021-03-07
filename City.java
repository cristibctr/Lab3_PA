/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

import java.util.ArrayList;
import java.util.Collections;
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
        Collections.sort(nodes, Location::compareTo);
        for(Location i : nodes)
        {
            if(i.compareTo(node) == 0)
                continue;
            i.setCost(node, (int) (Math.random() * 10)+1);
        }
    }
    public void printVisitable(){
        System.out.println("The locations that are visitable but not payable are:");
        List<Location> visitableLocations = new ArrayList<>();
        Boolean OK = true;
        //Loop through each node and add it in visitableLocations array. The position depends on getOpeningTime()
        //I downcast every object in nodes to Visitable in order to access getOpeningTime() method
        for(Location loc:nodes)
        {
            //Check if location is visitable and not payable
            if(loc instanceof Visitable && !(loc instanceof Payable))
                if(visitableLocations.isEmpty())
                    //If it's the first object add it to the array no matter the order
                    visitableLocations.add(loc);
                else
                {
                    //Loop through the already added locations
                    for(int sortIndex = 0; sortIndex < visitableLocations.size(); sortIndex++)
                        if(((Visitable)loc).getOpeningTime().isBefore(((Visitable)visitableLocations.get(sortIndex)).getOpeningTime()))
                        {
                            //Compare opening times and add it to the array before the next "bigger" time
                            visitableLocations.add(sortIndex, loc);
                            OK = false;
                            break;
                        }
                    //If it wasn't added until the end of the loop, add it now
                    if(OK)
                        visitableLocations.add(loc);
                }
        }
        for(Location i : visitableLocations)
        {
            System.out.printf("%s", i.getName() + " opening hours: ");
            System.out.println(((Visitable)i).getOpeningTime());
        }
    }
    public int[][] getCostMatrix(){
        int[][] costMatr = new int[nodes.size()][nodes.get(0).getCost().size()+1];
        int[] arr;
        int i = 0;
        for(Location loc : nodes)
        {
            arr = loc.getCostArr();
            for(int j = 0; j < arr.length; j++)
                costMatr[i][j] = arr[j];
            for(int j = i; j < arr.length; j++)
                costMatr[i][j+1] = costMatr[i][j];
            costMatr[i][i] = 0;
            i++;
        }
//        for (i = 0; i < costMatr.length; i++) {
//            for (int j = 0; j < costMatr[i].length; j++) {
//                System.out.print(costMatr[i][j] + " ");
//            }
//            System.out.println();
//        }
        return costMatr;
    }
    public Location[][] getLocMatrix()
    {
        Location[][] locMatr = new Location[nodes.size()][nodes.get(0).getCost().size()];
        int i = 0;
        for(Location loc : nodes)
        {
            locMatr[i] = loc.getLocationArr();
            i++;
        }
//        for (i = 0; i < locMatr.length; i++) {
//            for (int j = 0; j < locMatr[i].length; j++) {
//                System.out.print(locMatr[i][j] + " ");
//            }
//            System.out.println();
//        }
        return locMatr;
    }
    public List<Location> getNodes() {
        return nodes;
    }
    public Location[] getNodesArr() {
        return nodes.toArray(new Location[0]);
    }
    @Override
    public String toString() {
        String returnStr = cityName + ":\n";
        for(int i = 0; i < nodes.size(); i++)
            returnStr += nodes.get(i).toString() + "\n";
        return returnStr;
    }
    
}
