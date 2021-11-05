import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
//import java.awt.event.KeyAdapter;
//import java.awt.event.KeyEvent;
import java.util.Scanner;

public class field extends JPanel implements ActionListener {


    public static JFrame jFrame;            //создание окна вывода
    public static final int scale =32;                 //размер клетки
    public static int col;
    public static int razmer;
    public  int speed = 10;

    snake s = new snake(1,1, 2, 1);
    Timer timer = new Timer(1000/speed, this);

   public field(){
       timer.start();
   }

    //отрисовка клеток на поле
    public void paint(Graphics g){
       g.setColor(Color.black);
       g.fillRect(0,0,20*scale, 20*scale);

       for (int x= 1; x<1000; x+=scale){
            g.setColor(Color.white);
            g.drawLine(x,0,x,1000);
        }
        for (int y=0; y<1000; y+=scale){
            g.setColor(Color.white);
            g.drawLine(0,y,1000,y);
        }

        //отрисовка препятствий на поле
        for (int c=0; c<col; c++){
            g.setColor(Color.white);
            int rx=getRandom()*scale;
            int ry=getRandom()*scale;
            g.fillRect(rx+1,ry, scale, scale);
            // System.out.println(rx);
        }

        for (int i=0; i<s.length; i++){
            g.setColor(Color.GREEN);
            g.fillRect(s.snake_X[i]*scale + 2,s.snake_Y[i]*scale+1, scale-1, scale-1);

        }


    }


    public static int getRandom()
    {
        return (int) (Math.random() * 20);
    }

    public static int Size( int raz, int colich)
    {
        if (raz==1)
    {
        raz=scale*20;
        switch (colich) {
            case 1:
                colich = 0;
                break;
            case 2:
                colich =20;
                break;
            case 3:
                colich =25;
                break;
            case 4:
                colich =50;
                break;
        }

    }
        if (raz==2)
        {
            raz=scale*15;
            switch (colich) {
                case 1:
                    colich = 0;
                    break;
                case 2:
                    colich =15;
                    break;
                case 3:
                    colich =20;
                    break;
                case 4:
                    colich =40;
                    break;
            }

        }
        if (raz==3)
        {
            raz=scale*10;
            switch (colich) {
                case 1:
                    colich = 0;
                    break;
                case 2:
                    colich =20;
                    break;
                case 3:
                    colich =40;
                    break;
                case 4:
                    colich =50;
                    break;
            }

        }
        col=colich;
        return raz;
    }
    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите размер поля");
        System.out.println("1:Большое; 2:Среднее; 3:Маленькое");
        int r = in.nextInt();

        System.out.println("Выберите количество препятствий");
        System.out.println("1:Нет; 2:Мало; 3:Средне; 4:Много");
        int k = in.nextInt();



        //в соотвестсвии с выбором задается размер и количество препятствий
        razmer = Size(r,k);
        int razmerx=razmer+16;
        int razmery=razmer+38;
        //настройка окна вывода
        jFrame = new JFrame("Snake");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(0,0);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.add(new field());
        jFrame.setSize(razmerx,razmery);
    }
    @Override
    public void actionPerformed(ActionEvent e){
       s.Move();
     repaint();
    }

}