import javax.swing.*;
import java.awt.*;
import java.util.Scanner;

public class field extends JPanel {


    public static JFrame jFrame;            //создание окна вывода
    public static final int scale =32;                 //размер клетки
    public static int col;
    public static int razmer;
    //отрисовка клеток на поле
    public void paint(Graphics g){
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
        }


    }


    public static int getRandom()
    {
        return (int) (Math.random() * scale);
    }

    public static void Size(int raz, int colich)
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
        razmer=raz;
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
         Size(r,k);
        int razmerx=razmer+17;
        int razmery=razmer+39;

        //настройка окна вывода
        jFrame = new JFrame("Snake");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(0,0);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.add(new field());
        jFrame.setSize(razmerx,razmery);
        jFrame.setBackground(Color.black);

    }
}