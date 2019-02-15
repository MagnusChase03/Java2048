import javax.swing.*;

class Game extends JFrame {

  Game() {
  
    setTitle("2048");
    setSize(500, 530);
    setResizable(false);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    
    add(new Panel());
    
    setVisible(true);
  
  }

}
