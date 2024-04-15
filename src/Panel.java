import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Panel extends JPanel implements ActionListener {
        static int SIDE = Game2048.SIDE;
        public void paint(Graphics g1) {
            Graphics2D g = (Graphics2D) g1;
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g.setColor(Color.WHITE);
            g.fillRect(0,0,500,600);
            g.setColor(Color.lightGray);
            g.fillRoundRect(5,45,5 + (SIDE * 120),5 + (SIDE * 120),50,50);

            for(int i = 0; i < SIDE; i++){
                g.setFont(new Font("Calibri",Font.BOLD, 25));
                for(int j = 0; j < SIDE; j++) {
                        g.setColor(Game2048.GM.getColor(Game2048.gameField[j][i]));
                        g.fillRoundRect(10+ 120 * i,50 + 120 * j,115, 115,40,40 );
                        g.setColor(Color.BLACK);
                        if(Game2048.gameField[j][i] != 0) {
                            int offset;
                            if(Game2048.gameField[j][i] < 10){
                                offset = 0;
                            }
                            else if(Game2048.gameField[j][i] < 100){
                                offset = 5;
                            }
                            else if(Game2048.gameField[j][i] < 1000){
                                offset = 10;
                            }
                            else{
                                offset = 15;
                            }

                            g.drawString(String.valueOf(Game2048.gameField[j][i]), 60 + 120 * i - offset, 110 + 120 * j);
                        }
                }
            }
            g.setColor(Color.lightGray);
            g.fillRoundRect(130,8,200,35,25,25);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Calibri", Font.BOLD,28));
            g.drawString(" SCORE: " + Game2048.score, 150, 36);

            if(Game2048.GM.isGameOver()){
                this.gameOver(g);
            }
        }

        public void gameOver(Graphics g) {
            g.setColor(new Color(255, 255, 254, 150));
            g.fillRect(5, 5, 480, 520);
            this.repaint();
            g.setColor(Color.BLACK);
            g.setFont(new Font("asd", Font.BOLD, 34));
            g.drawString("GAME OVER", 145, 275);
            g.drawString("Score : " + Game2048.score, 145, 315);
            g.setFont(new Font("Calibri", Font.BOLD, 24));
            g.drawString("To restart press enter", 136,350);
            this.repaint();
        }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
