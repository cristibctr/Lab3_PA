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
public class TravelPlan {
    private ShortestPath path = new ShortestPath();
    private City firstCity;
    private List<Location> visitOrder = new ArrayList<>();

    public TravelPlan(City firstCity) {
        this.firstCity = firstCity;
    }

    public void setPreferences(List<Location> visitOrder) {
        this.visitOrder = visitOrder;
    }
    
    public void addPreferences(Location preferedLocation)
    {
        this.visitOrder.add(preferedLocation);
    }

    public void randomPreferences()
    {
        for(Location loc : firstCity.getNodes())
            if((int)(Math.random()*10)%2 == 1)
                if(visitOrder.size() != 0)
                {
                    visitOrder.add((int)(Math.random()*100)%visitOrder.size(), loc);
                }
                else 
                    visitOrder.add(loc);
    }
    
    public City getFirstCity() {
        return firstCity;
    }
    public void shortestPathPref()
    {
        Location[][] locMatr = firstCity.getLocMatrix();
        int[] shortestPath;
        int j, k;
        System.out.println("Shortest path from each preffered location is:");
        for(int i = 0; i < visitOrder.size(); i++)
        {
            outerloop:
            for(j = 0; j < firstCity.getNodesArr().length; j++)
                    if(visitOrder.get(i).equals(firstCity.getNodesArr()[j]))
                        break outerloop;
            shortestPath = path.dijkstra(firstCity.getCostMatrix(), j);
            for(j = 0; j < shortestPath.length; j++)
                if(shortestPath[j] > 100)
                    shortestPath[j] = (int)(Math.random()*10);
            for(int b : shortestPath)
                System.out.printf("%d ", b);
            System.out.println();
        }

    }
    public List<Location> getVisitOrder() {
        return visitOrder;
    }
    
}
