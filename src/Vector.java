public class Vector {
    int x1, y1, x2, y2;

    public Vector(){

    }

    public int get_dx(){
        return x2-x1;
    }
    public int get_dy(){
        return y2-y1;
    }
    public void setStart(int x, int y){
        this.x1 = x;
        this.y1 = y;
    }
    public void setEnd(int x, int y){
        this.x2 = x;
        this.y2 = y;
    }

    public float getGradient(){
        float gradient;
        try {
            gradient = ((float)this.get_dy() )/ this.get_dx();
        }
        catch(ArithmeticException e){
            return 999;
        }
        return gradient;
    }

    public void makeMove(){
        if(getGradient() >=-1  && getGradient() < 1 ){
            if(get_dx() >= 0){
                Game2048.GM.moveRight();
            }
            else{
                Game2048.GM.moveLeft();
            }
        }
        else{
            if(get_dy() >= 0){
                Game2048.GM.moveDown();
            }
            else{
                Game2048.GM.moveUp();
            }
        }
    }
}
