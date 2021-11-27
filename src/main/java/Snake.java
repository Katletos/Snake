/**
 * class of snake
 */
public class Snake {

    /** initial length */
    public int len = 2;                        //начальная длинна
    /** initial direction */
    public int direction = 1 ;                 //начальное направление
    /** coordinate X of snake body */
    public  int[] sX= new int[Field.razmer];   //координаты тела змеи по х
    /** coordinate Y of snake body */
    public  int[] sY = new int[Field.razmer];  //координаты тела змеи по у

    /**
     * @param x1 coordinate X of snake head
     * @param y1 coordinate Y of snake head
     * @param x2 coordinate X of the second scale of snake
     * @param y2 coordinate Y of the second scale of snake
     */
    //координаты головыя змеи
    public Snake(int x1, int y1, int x2, int y2){
        sX[0]=x1;
        sX[1]=x2;
        sY[0]=y1;
        sY[1]=y2;
    }


    /**
     * move of snake
     */
    //движение змеи
    public void move(){
        for(int l = len; l > 0; l--){
            sX[l] = sX[l-1];
            sY[l] = sY[l-1];
        }
        //up
        if(direction == 0) sY[0]--;
        //down
        if(direction == 2) sY[0]++;
        //right
        if(direction == 1) sX[0]++;
        //left
        if(direction == 3) sX[0]--;

        //змея переползает с одной части экрана в другую
        if(sY[0]>Field.razmer/Field.SCALE-1) sY[0]=0;
        if(sY[0]<0) sY[0]=Field.razmer/Field.SCALE-1;
        if(sX[0]>Field.razmer/Field.SCALE-1)  sX[0]=0;
        if(sX[0]<0) sX[0]=Field.razmer/Field.SCALE-1;
    }
}
