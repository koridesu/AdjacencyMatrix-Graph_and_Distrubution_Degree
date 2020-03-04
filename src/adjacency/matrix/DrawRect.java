/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adjacency.matrix;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.Random;
import javax.swing.JPanel;

/**
 *
 * @author admin
 */
public class DrawRect extends javax.swing.JPanel{
    
   private static int RECT_X = 10;
   private static int RECT_Y = RECT_X;
   private static boolean matrix[][];
   public static int size;
   public static ArrayList<Node> nodes = new ArrayList<Node>();
 

   @Override
   public void paint(Graphics g) {
      super.paintComponent(g);
     
      boolean has_i = false;
      boolean has_j = false;
      int index_i=0;
      int index_j=0;
      int x = 50, y =50;
      int parameter = 1;
      int coefficent = 0;
      
      for(int i =0;i<size; i++)
      {
          for(int j=0; j<size ;j++)
          {
              if(i!=j)
              {
                  if(matrix[i][j]){
                      
                       
                      for(int t = 0; t< nodes.size();t++)
                    {
                        if(nodes.get(t).name.equals(Integer.toString(i)))
                        {   has_i=true;   index_i = t;   }
                        if(nodes.get(t).name.equals(Integer.toString(j)))
                        {  has_j=true;     index_j = t;  }
                        if(has_i && has_j) {break;}
                    }
                      
                      if(!(has_i) && !(has_j))
                      { 
                        Node node = new Node(Integer.toString(i),x,y );
                        Node node2 = new Node(Integer.toString(j),x+50,y+50 );
                        nodes.add(node);
                        nodes.add(node2);
                        g.setColor(Color.black);
                        g.setFont(new Font(null,Font.BOLD,15));
                        g.drawRect(node.x, node.y, node.width, node.height);
                        g.drawString(node.name,node.x+10, node.y+10);
                        g.drawRect(node2.x,node2.y, node2.width, node2.height);
                        g.drawString(node2.name, node2.x+10, node2.y+10);
                        g.setColor(Color.red);
                        g.drawLine(node.x+10, node.y+10, node2.x+10, node2.y+10);
                  
                       
                      }
                      
                      else if(has_i && !has_j) // i var j yok
                      {
                       Node node = new Node(Integer.toString(j),x,y );
                       nodes.add(node);
                       g.setColor(Color.black);
                       g.drawRect(node.x, node.y, node.width, node.height);
                       g.drawLine(node.x+10, node.y+10, nodes.get(index_i).x+10, nodes.get(index_i).y+10);
                       g.setFont(new Font(null,Font.BOLD,15));
                       g.setColor(Color.red);
                       g.drawString(node.name, node.x+10, node.y+10);
                      
                      }
                      else if(!(has_i) && has_j) // j var i yok
                      {
                       Node node = new Node(Integer.toString(i),x,y );
                       nodes.add(node);
                       g.setFont(new Font(null,Font.BOLD,15));
                       g.setColor(Color.black);
                       g.drawRect(node.x, node.y, node.width, node.height);
                       g.setFont(new Font(null,Font.BOLD,15));
                       g.drawString(node.name, node.x, node.y);
                       g.setColor(Color.red);
                       g.drawLine(node.x+10, node.y+10, nodes.get(index_j).x+10, nodes.get(index_j).y+10);
                        
                      }
                      
                      has_i = false;
                      has_j = false;
                      index_i=0;
                      index_j=0;
                   
                      x+=100;
                      y+=50;
                      if(parameter % 2 == 0) y-=100;
                   
                      if(x>1600 ){ x=50; y=300+coefficent; coefficent+=300;}
                      if(y>1000) {coefficent=0; x = 85; y =250+coefficent; }
                      parameter++;
                  } 
              }
          }
      }
     return;
      }
   

   
   @Override
   public Dimension getPreferredSize() {
      // so that our GUI is big enough
      return new Dimension(2000,1000);
   }

    /**
     * @return the matrix
     */
    public static boolean[][] getMatrix() {
        return matrix;
    }

    /**
     * @param aMatrix the matrix to set
     */
    public static void setMatrix(boolean[][] aMatrix,int s) {
        matrix = aMatrix;
        size = s;
    } 
}

           
                    
                    