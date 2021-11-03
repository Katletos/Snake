public class Apple {

    public int posX;
    public int posY;

    public Apple(int x,int y){
        posX = x;
        posY = y;
    }
    public void  setRandom()
    {
        posX = (int) Math.random()*field.razmerx;
        posY = (int) Math.random()*field.razmery;
    }
}
