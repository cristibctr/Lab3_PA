/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

import java.time.LocalTime;

/**
 *
 * @author crist
 */
public class Main {

    public static void main(String[] args) {
        City c1 = new City("Iasi");
        
        Museum m = new Museum("v1");
        m.setOpeningTime(LocalTime.of(9, 30));
        m.setClosingTime(LocalTime.parse("17:00"));
        m.setTicketPrice(20);
        
        Church c = new Church("v2");
        c.setOpeningTime(c.setOpeningTime());
        c.setClosingTime(c.setClosingTime());
        
        Church c2 = new Church("v3");
        c2.setOpeningTime(LocalTime.of(6, 0));
        c2.setClosingTime(LocalTime.MIDNIGHT);
        
        Hotel h = new Hotel("v4");
        h.setRank(5);
        
        Church c3 = new Church("v5");
        c3.setOpeningTime(LocalTime.of(7, 0));
        c3.setClosingTime(LocalTime.of(17,0));
        
        System.out.println(Visitable.getVisitingDuration(c.getOpeningTime(), c.getClosingTime()));
        
        c1.addLocation(m);
        c1.addLocation(h);
        c1.addLocation(c);
        c1.addLocation(c2);
        c1.addLocation(c3);
        System.out.println(c1.toString());
        c1.printVisitable();
        TravelPlan myPlan = new TravelPlan(c1);
        
        myPlan.randomPreferences();
        myPlan.shortestPathPref();
        
        c1.getCostMatrix();
    }
    
}
