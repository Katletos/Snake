public class Snake {

    public int len = 2;                        //начальная длинна
    public int direction = 1 ;                 //начальное направление
    public  int[] sX= new int[Field.razmer];   //координаты тела змеи по х
    public  int[] sY = new int[Field.razmer];  //координаты тела змеи по у

    //координаты головыя змеи
    public Snake(int x1, int y1, int x2, int y2){
        sX[0]=x1;
        sX[1]=x2;
        sY[0]=y1;
        sY[1]=y2;
    }

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
