import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class GameMouseListener implements MouseListener {
    Vector vector = Game2048.vector;
    private Panel panel;

    public GameMouseListener(Panel p){
        this.panel = p;
    }
    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        vector.setStart(e.getX(), e.getY());
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        vector.setEnd(e.getX(), e.getY());
        vector.makeMove();
        panel.repaint();
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
