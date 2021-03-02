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
public class Restaurant extends Location implements Classifiable{
    private int rank;

    public Restaurant(String name) {
        super(name);
    }

    public void setRank(int rank) {
        this.rank = rank;
    }

    public int getRank() {
        return rank;
    }
    
}
