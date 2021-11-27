/**
 * class of apple
 */
public class Apple {

    /** coordinate X of apple */
    public int posX;  //координата яблока по х
    /** coordinate Y of apple */
    public int posY;  //координата яблока по у

    /**
     *
     * @param x coordinate of the first apple
     * @param y coordinate of the first apple
     */
    //расположение яблока
    public Apple(int x,int y){
        posX = x;
        posY = y;
    }

    /**
     * make random coordinate of apple
     */
    //задание коодинат яблоку
    public void setRandomPosition(){
        posX = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
        posY = Math.abs((int) (Math.random()*(Field.razmer/Field.SCALE)-1));
    }

}
