/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

/**
 *
 * @author crist
 */
public class Hotel extends Location implements Classifiable{
    private int rank;

    public Hotel(String name) {
        super(name);
    }

    @Override
    public int getRank() {
        return rank;
    }
    
    public void setRank(int classification) {
        this.rank = rank;
    }
    
}
