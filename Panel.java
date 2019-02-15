import javax.swing.*;
import java.awt.*;

class Panel extends JPanel {

  private int[][] grid;

  Panel() {
  
    setFocusable(true);
    addKeyListener(new Keyboard(this));
    
    grid = new int[4][4];
    addTile(grid);
  
  }
  
  public void paint(Graphics g) {
  
    createTiles(g, grid);
  
  }
  
  private void createTiles(Graphics g, int[][] grid) {
  
    for (int y = 0; y < grid.length; y++) {
    
      for (int x = 0; x < grid[y].length; x++) {
    
        if (grid[y][x] == 0) {
        
          g.setColor(Color.GRAY);
          g.fillRect(x * 110 + 30, y * 110 + 30, 100, 100);
          
        } else {
        
          g.setColor(Color.YELLOW);
          g.fillRect(x * 110 + 30, y * 110 + 30, 100, 100);
          g.setColor(Color.BLACK);
          g.setFont(new Font("monospace", Font.PLAIN, 26));
          g.drawString(String.valueOf(grid[y][x]), x * 110 + 50, y * 110 + 90);
        
        }
    
      }
    
    }
    
  }
  
  private void addTile(int[][] grid) {
  
    boolean done = false;
    while (!done) {
    
      int randomX = (int) (Math.random() * 4);
      int randomY = (int) (Math.random() * 4);
      
      if (grid[randomY][randomX] == 0) {
      
        grid[randomY][randomX] = 2;
        done = true;
        repaint();
      
      }
      
      if (!done)
        done = !isSpots(grid);
    
    }
  
  } 
  
  private boolean isSpots(int[][] grid) {
  
    for (int y = 0; y < grid.length; y++) {
    
      for (int x = 0; x < grid.length; x++) {
    
        if (grid[y][x] == 0)
          return true;
            
      }
    
    }
    
    return false;
  
  }
  
  public void update(int keycode) {
  
    switch (keycode) {

      case 'W':
      
        for (int x = 0; x < grid.length; x++) {
        
          if (grid[0][x] == grid[1][x]) {
             
            grid[1][x] = 0;
            grid[0][x] = grid[0][x] * 2;
            
          } else if (grid[1][x] == grid[2][x]) {
           
            grid[2][x] = 0;
            grid[1][x] = grid[1][x] * 2;
            
          } else if (grid[2][x] == grid[3][x]) {
           
            grid[3][x] = 0;
            grid[2][x] = grid[2][x] * 2;
            
          }
          
        }
        break;
        
      case 'A':  
      
       for (int y = 0; y < grid.length; y++) {
        
        if (grid[y][0] == grid[y][1]) {
           
          grid[y][1] = 0;
          grid[y][0] = grid[y][0] * 2;
          
        } else if (grid[y][1] == grid[y][2]) {
         
          grid[y][2] = 0;
          grid[y][1] = grid[y][1] * 2;
          
        } else if (grid[y][2] == grid[y][3]) {
         
          grid[y][3] = 0;
          grid[y][2] = grid[y][2] * 2;
          
        }
        
       }     
       break;   
        
      case 'S':
      
        for (int x = 0; x < grid.length; x++) {
        
          if (grid[0][x] == grid[1][x]) {
             
            grid[0][x] = 0;
            grid[1][x] = grid[1][x] * 2;
            
          } else if (grid[1][x] == grid[2][x]) {
           
            grid[1][x] = 0;
            grid[2][x] = grid[2][x] * 2;
            
          } else if (grid[2][x] == grid[3][x]) {
           
            grid[2][x] = 0;
            grid[3][x] = grid[3][x] * 2;
            
          }
          
        }       
        break;   
         
      case 'D':
        
        for (int y = 0; y < grid.length; y++) {
        
          if (grid[y][0] == grid[y][1]) {
           
            grid[y][0] = 0;
            grid[y][1] = grid[y][1] * 2;
            
          } else if (grid[y][1] == grid[y][2]) {
           
            grid[y][1] = 0;
            grid[y][2] = grid[y][2] * 2;
            
          } else if (grid[y][2] == grid[y][3]) {
           
            grid[y][2] = 0;
            grid[y][3] = grid[y][3] * 2;
            
          }
        
        }      
        break;    
    
    }
  
    addTile(grid);
  
  }

}
