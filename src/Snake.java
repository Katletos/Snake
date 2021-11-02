public class Snake {

    public int len = 2;
    public int dierection = 3;

    public  int sX[] = new int[300];
    public  int sY[] = new int[300];

    public Snake(int x1, int y1, int x2, int y2){
        sX[0]=x1;
        sX[1]=x2;
        sY[0]=y1;
        sY[1]=y2;
    }

    public void move(){
        for(int l = len; l > 0; l--){
            sX[l] = sX[l-1];
            sY[l] = sY[l-1];
        }
        //up
        if(dierection == 0) sY[0]--;
        //down
        if(dierection == 2) sY[0]++;
        //right
        if(dierection == 1) sX[0]++;
        //left
        if(dierection == 3) sX[0]--;

        if (sY[0]>field.razmery/field.scale-1) sY[0]=0;
        if (sY[0]<0) sY[0]=field.razmery/field.scale-1;

        if (sX[0]>field.razmerx/field.scale-1) sX[0]=0;
        if (sX[0]<0) sX[0]=field.razmerx/field.scale-1;
    }
}
