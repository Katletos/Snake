public class Snake {

    public int len = 2;
    public int dierection = 2 ;

    public  int[] sX= new int[field.razmer*field.scale];
    public  int[] sY = new int[field.razmer*field.scale];

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


    }
}
