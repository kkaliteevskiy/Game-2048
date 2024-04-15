import javax.swing.JFrame;

public class Game2048 {
    public static int SIDE = 4;
    public static int score = 0;
    static int[][] gameField = new int[SIDE][SIDE];
    public static GameMechanics GM = new GameMechanics();
    public static Vector vector = new Vector();

    static {
        for (int i = 0; i < SIDE; i ++){
            for(int j = 0; j < SIDE; j++){
                gameField[i][j] = 0;
            }
        }
//        gameField[0][0] = 2;
//        gameField[1][1] = 16;
//        gameField[2][2] = 128;
//        gameField[3][3] = 1024;
    }

    public static void main(String[] args){
        JFrame window = new JFrame();
        Panel panel = new Panel();
        panel.setFocusable(true);
        panel.addKeyListener(new GameKeyListener(panel));
        panel.addMouseListener(new GameMouseListener(panel));
        window.getContentPane().add(panel);

        window.setSize(510, 580);
        window.setTitle("2048");
        window.setVisible(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GM.createSquare();
        GM.createSquare();
    }
}