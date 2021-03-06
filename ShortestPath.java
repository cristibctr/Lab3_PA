/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3_pa;

import java.util.*; 
import java.lang.*; 
import java.io.*; 

/**
 *
 * @author crist
 */
public class ShortestPath { 
    private int V; 
    public int minDistance(int dist[], Boolean sptSet[]) 
    { 
        // Initialize min value 
        int min = Integer.MAX_VALUE, min_index = -1; 
  
        for (int v = 0; v < V; v++) 
            if (sptSet[v] == false && dist[v] <= min) { 
                min = dist[v]; 
                min_index = v; 
            } 
  
        return min_index; 
    } 
  
    public int[] dijkstra(int graph[][], int src) 
    { 
        V = graph.length;
        int dist[] = new int[V];
        Boolean sptSet[] = new Boolean[V];
        for (int i = 0; i < V; i++) { 
            dist[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        }
        dist[src] = 0;
        for (int count = 0; count < graph.length - 1; count++) { 
            int u = minDistance(dist, sptSet); 
            sptSet[u] = true; 
            for (int v = 0; v < graph[u].length; v++) 
                if (!sptSet[v] && graph[u][v] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][v] < dist[v]) 
                    dist[v] = dist[u] + graph[u][v]; 
        } 
  
        return dist;
    } 
}
