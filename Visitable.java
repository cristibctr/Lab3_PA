/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

import java.time.Duration;
import java.time.LocalTime;

/**
 *
 * @author crist
 */
public interface Visitable {
    LocalTime getOpeningTime();
    LocalTime getClosingTime();
    default LocalTime setClosingTime(){
        return LocalTime.of(20, 00);
    }
    default LocalTime setOpeningTime(){
        return LocalTime.of(9, 30);
    }
    static Duration getVisitingDuration(LocalTime start, LocalTime end){
        return Duration.between(start, end);
    }
}
