import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


public class GameKeyListener implements KeyListener {
    private Panel panel;

    public GameKeyListener(Panel p){
        this.panel = p;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
         if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
                Game2048.GM.moveRight();
                panel.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_DOWN) {
                Game2048.GM.moveDown();
                panel.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_LEFT) {
                Game2048.GM.moveLeft();
                panel.repaint();
            }
            else if (e.getKeyCode() == KeyEvent.VK_UP) {
                Game2048.GM.moveUp();
                panel.repaint();
            }


            if(Game2048.GM.isGameOver()){
                panel.repaint();
            }
            if(Game2048.GM.isGameOver() && e.getKeyCode() == KeyEvent.VK_ENTER ){
                Game2048.GM.restartGame();
                panel.repaint();
            }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
