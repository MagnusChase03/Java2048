import java.awt.event.*;

class Keyboard extends KeyAdapter {

  Panel panel;
  
  Keyboard(Panel panel) {
  
    this.panel = panel;
  
  }

  public void keyPressed(KeyEvent e) {
  
    int keycode = e.getKeyCode();
    switch (keycode) {

      case 'W':
        panel.update(keycode);
        break;
        
      case 'A':
       panel.update(keycode);
       break;   
        
      case 'S':
        panel.update(keycode);
        break;   
         
      case 'D':
        panel.update(keycode);
        break;    
    
    }
  
  }

}
