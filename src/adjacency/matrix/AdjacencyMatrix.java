package adjacency.matrix;

import java.util.Hashtable;
import java.util.Random;
import javax.print.attribute.HashAttributeSet;
import javax.swing.JFrame;

public class AdjacencyMatrix {
    
      private boolean adjMatrix[][];
      private int numVertices;
 
      public AdjacencyMatrix(int numVertices) {
          this.numVertices = numVertices;
          adjMatrix = new boolean[numVertices][numVertices];
    }
 
      public void addEdge(int i, int j) {
                adjMatrix[i][j] = true;
                adjMatrix[j][i] = true;
    }
 
      public void removeEdge(int i, int j) {
                adjMatrix[i][j] = false;
                adjMatrix[j][i] = false;
    }
 
      public boolean isEdge(int i, int j) {
                  return getAdjMatrix()[i][j];
    }

    public String toString() {
        StringBuilder s = new StringBuilder();
        for (int i = 0; i < numVertices; i++) {
            s.append(i + ": ");
            for (boolean j : getAdjMatrix()[i]) {
                s.append((j?1:0) + " ");
            }
            s.append("\n");
        }
        return s.toString();
    }
    
     public boolean[][] getAdjMatrix() {
        return adjMatrix;
    }
    
    public static void main(String[] args) {
        int size = 100;
        AdjacencyMatrix a = new AdjacencyMatrix(size);
        Random rand = new Random();
        
        Hashtable<Integer, Integer> hash = new Hashtable<Integer, Integer>();
        //Hashtable<Integer, Integer> banned_List = new Hashtable<>();
        
      DrawRect mainPanel = new DrawRect();
      mainPanel.setMatrix(a.getAdjMatrix(),size);
      JFrame frame = new JFrame("DrawRect");
      frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      frame.add(mainPanel);
      frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
      frame.pack();
      frame.setResizable(true);
      frame.setFocusable(true);
      frame.requestFocus();
      frame.setLocationByPlatform(true);
      frame.setVisible(true);
      frame.getPreferredSize();
     
        
        for(int i = 0; i< size; i++)
        {   
            a.addEdge(rand.nextInt(size), rand.nextInt(size));
            hash.put(i, 0);
        }
        for(int i = 0; i<size; i++)
        {
            for(int j=0; j<size; j++)
            {   
                if(i!=j){
                    if(a.isEdge(i, j)){
                    hash.put(i,hash.get(i)+1);
                    }  
                }
            }
        }
        
            
        System.out.println(a.toString());
        System.out.println("");
        System.out.println("Degree Distrubution of nodes:");
        for(int i=0;i<size;i++){
            System.out.print(i+"'s degree: ");
            System.out.println(hash.get(i));
        } 
        return;
    }

   

}
