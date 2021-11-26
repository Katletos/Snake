public class Apple {

    public int posX;  //координата яблока по х
    public int posY;  //координата яблока по у

    //расположение яблока
    public Apple(int x,int y){
        posX = x;
        posY = y;
    }

    //задание коодинат яблоку
    public void setRandomPosition(){
        posX = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
        posY = Math.abs((int) (Math.random()*(Field.razmer/Field.SCALE)-1));
    }

}
