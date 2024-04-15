import javax.print.attribute.standard.Sides;
import java.awt.*;
import java.util.Random;

public class GameMechanics {
    public static int SIDE = Game2048.SIDE;

    public void createSquare() {
        if(hasEmpty()) {
            Random r = new Random();
            int x, y;
            do {
                x = r.nextInt(Game2048.SIDE);
                y = r.nextInt(Game2048.SIDE);
            }
            while (Game2048.gameField[x][y] != 0);
            Game2048.gameField[x][y] = r.nextInt(10) + 1 == 9 ?4 : 2;
        }
    }

    public void mergeRow() {
        for (int i = 0; i < SIDE; i++) {
            for (int j = 0; j < SIDE - 1; j++) {
                if (Game2048.gameField[i][j] == Game2048.gameField[i][j + 1] && Game2048.gameField[i][j] != 0) {
                    Game2048.gameField[i][j] = Game2048.gameField[i][j] * 2;
                    Game2048.gameField[i][j + 1] = 0;
                    Game2048.score += Game2048.gameField[i][j];
                }
            }
        }
    }

    public void compressRow() {
        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < Game2048.gameField[i].length - 1; j++) {
                    if (Game2048.gameField[i][j] == 0 && Game2048.gameField[i][j + 1] != 0) {
                        Game2048.gameField[i][j] = Game2048.gameField[i][j + 1];
                        Game2048.gameField[i][j + 1] = 0;
                    }
                }
            }
        }
    }

    public void rotateClockwise() {
        for(int k = 0; k <3; k++){
            for (int x = 0; x < (SIDE / 2); x++) {
                for (int y = x; y < SIDE-x-1; y++) {
                    int temp = Game2048.gameField[x][y];
                    Game2048.gameField[x][y] = Game2048.gameField[y][SIDE-1-x];
                    Game2048.gameField[y][SIDE-1-x] = Game2048.gameField[SIDE-1-x][SIDE-1-y];
                    Game2048.gameField[SIDE-1-x][SIDE-1-y] = Game2048.gameField[SIDE-1-y][x];
                    Game2048.gameField[SIDE-1-y][x] = temp;
                }
            }
        }
    }

    public void moveRight() {
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
    }

    public void moveUp() {
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
        moveLeft();
        rotateClockwise();
    }

    public void moveLeft() {
        if(canMove()) {
            compressRow();
            mergeRow();
            compressRow();
            if (hasEmpty()) {
                this.createSquare();
            }
        }
    }

    public void moveDown() {
        rotateClockwise();
        moveLeft();
        rotateClockwise();
        rotateClockwise();
        rotateClockwise();
    }

    public Color getColor(int i) {
        if (i == 2) {
            return new Color(204, 255, 255);
        }
        if (i == 4) {
            return new Color(102, 255, 255);
        }
        if(i == 8){
            return new Color(58, 228,255);
        }
        if (i == 16) {
            return new Color(0, 151, 255);
        }
        if (i == 32) {
            return new Color(0, 107, 255);
        }
        if (i == 64) {
            return new Color(0, 63, 255);
        }
        if (i == 128) {
            return new Color(0, 17, 255);
        }
        if (i == 256) {
            return new Color(71, 24, 255);
        }
        if (i == 512) {
            return new Color(137, 0, 255);
        }
        if (i == 1024) {
            return new Color(180, 0, 255);
        }
        if (i == 2048) {
            return new Color(255, 0, 183);
        }
        return new Color(255,255,255);
    }

    public boolean hasEmpty(){
        for(int i = 0; i < SIDE; i++){
            for(int j = 0; j < SIDE; j++){
                if(Game2048.gameField[i][j] == 0){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isGameOver(){
        if(hasEmpty()){
            return false;
        }
        if(canMove()){
            return false;
        }
        return true;
    }

    public boolean canMove(){
        for(int k = 0; k  < 4; k++) {
            for (int i = 0; i < SIDE; i++) {
                for (int j = 0; j < SIDE - 1; j++) {
                    if (Game2048.gameField[i][j] == Game2048.gameField[i][j + 1] && Game2048.gameField[i][j] != 0) {
                        for(int g = 0; g < 4 - k; k++){
                            rotateClockwise();
                        }
                        return true;
                    }
                }
            }
            rotateClockwise();
        }

        for(int i = 0; i < SIDE; i++){
            for(int j = 0; j < SIDE - 1; j++){
                if(Game2048.gameField[i][j] == 0 && Game2048.gameField[i][j+1] != 0 ) {
                    return true;
                }
            }
        }
        return false;

    }

    public void restartGame(){
        for(int i = 0; i < SIDE; i++){
            for(int j =0 ;j< SIDE; j++){
                Game2048.gameField[i][j] = 0;
            }
        }
        Game2048.score = 0;
        Game2048.GM.createSquare();
        Game2048.GM.createSquare();
    }
}