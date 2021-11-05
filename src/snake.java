

public class snake {

    public int length = 2;
    public int direction = 1;

    public int snake_X[] = new int[field.scale*field.razmer];
    public int snake_Y[] = new int[field.scale*field.razmer];

    public snake(int x1, int y1, int x2, int y2)
    {
        snake_X[0]=x1;
        snake_Y[0]=y1;
        snake_X[1]=x2;
        snake_Y[1]=y2;
    }

    public void Move()
    {
        for(int i = length; i>0;i--){
            snake_X[i]=snake_X[i-1];
            snake_Y[i]=snake_Y[i-1];
        }
        //up
        if (direction == 0) snake_Y[0]--;
        //right
        if (direction == 1) snake_X[0]++;
        //left
        if (direction == 2) snake_X[0]--;
        //down
        if (direction == 3) snake_Y[0]++;




            }

}
