import javax.swing.*;
import java.awt.*;
import java.util.Scanner;
public class field extends JPanel {

   /* public class block {
        public int posy;
        public int posx;


        public block(int x, int y) {
            posx = x;
            posy = y;
        }

        public void SetRandomPosition() {
            posx = (int) (Math.random() * 20 - 1);
            posy = (int) (Math.random() * 20 - 1);
        }
    }*/




    public static JFrame jFrame;
    public static final int scale =32;                 //размер клетки

    //отрисовка клеток на поле
    public void paint(Graphics g){
        g.setColor(Color.black);
        g.fillRect(0,0,1000,1000);
        for (int x= 0; x<1000; x+=scale){
            g.setColor(Color.white);
            g.drawLine(x,0,x,1000);
        }
        for (int y=0; y<1000; y+=scale){
            g.setColor(Color.white);
            g.drawLine(0,y,1000,y);
        }
        //for (int i=0; i<20; i++){
       //     g.setColor(Color.white);
        //    g.fillRect(block.posx*scale+1, blok.posy*scale+1,scale-1,scale-1);
        //}
    }


    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
        System.out.println("Выберите размер поля");
        System.out.println("1:Большое; 2:Среднее; 3:Маленькое");
        int raz = in.nextInt();

        System.out.println("Выберите количество препятствий");
        System.out.println("1:Нет; 2:Мало; 3:Средне; 4:Много");
        int colich = in.nextInt();


        if (raz==1)
        {
             raz=scale*20;
            switch (colich) {
                case 1:
                    colich = 0;
                    break;
                case 2:
                    colich =50;
                    break;
                case 3:
                    colich =100;
                    break;
                case 4:
                    colich =250;
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
                    colich =25;
                    break;
                case 3:
                    colich =50;
                    break;
                case 4:
                    colich =100;
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
                    colich =10;
                    break;
                case 3:
                    colich =30;
                    break;
                case 4:
                    colich =50;
                    break;
            }

        }

        int col=colich;
        int razmerx=raz+17;
        int razmery=raz+40;

        //создание окна для змейки
        jFrame = new JFrame("Snake");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.add(new field());
        jFrame.setSize(razmerx,razmery);


       // block= new block ((int) (Math.random() * 20 - 1),(int) (Math.random() * 20 - 1));

        int x;
        int y;
       // for (int i=0; i<colich; i++){

       // }
    }
    }
