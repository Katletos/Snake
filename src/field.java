import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.Scanner;

public class field extends JPanel implements ActionListener {


    public static JFrame jFrame;            //создание окна вывода
    public static final int scale =32;                 //размер клетки
    public static int col;

    public static int speed = 10;

    //public static int f=0;

   // public static int[] coordx;
    //public static int[] coordy;

    public static int razmerx;
    public static int razmery;

    Snake sn = new Snake(razmerx/(2*scale),razmery/(2*scale)+1,razmerx/(2*scale),razmery/(2*scale));
    Apple apple = new Apple((int) Math.random()*razmerx,(int) Math.random()*razmery);
    Timer timer = new Timer(1000/speed,this);

    public  field(){
        timer.start();
        addKeyListener(new KeyBoard());
        setFocusable(true);
    }

    public void paint(Graphics t) {
        t.setColor(Color.black);
        t.fillRect(0,0,640,640);
        for (int x= 1; x<640; x+=scale){
            t.setColor(Color.white);
            t.drawLine(x,0,x,640);
        }
        for (int y=0; y<640; y+=scale){
            t.setColor(Color.white);
            t.drawLine(0,y,640,y);
        }

        t.setColor(Color.red);
        t.fillOval(apple.posX*scale, apple.posY*scale,scale,scale);

        for (int l = 0; l < sn.len; l++) {
            t.setColor(Color.GREEN);
            t.fillRect(sn.sX[l] * scale, sn.sY[l] * scale, scale, scale);
        }

        /*if (f==0){
            for (int c = 0; c < col; c++) {
                t.setColor(Color.white);
                int rx = getRandom() * scale;
                int ry = getRandom() * scale;
                coordx[c] = rx;
                coordy[c] = ry;
                t.fillRect(rx , ry, scale, scale);
            }
            f = 1;
        }
        else{
            for (int c = 0; c< col; c++){
                t.setColor(Color.white);
                t.fillRect(coordx[c],coordy[c],scale,scale);
            }
        }*/

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



        //в соотвестсвии с выбором задается размер и количество препятствий
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
        razmerx=raz+17;
        razmery=raz+39;

        //настройка окна вывода
        jFrame = new JFrame("Snake");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(100,100);
        jFrame.setVisible(true);
        jFrame.setResizable(false);
        jFrame.add(new field());
        jFrame.setSize(razmerx,razmery);
        jFrame.setAlwaysOnTop(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        sn.move();
        repaint();
    }

    public class KeyBoard extends KeyAdapter{
        public void keyPressed(KeyEvent event){

            if ((event.getKeyCode() == KeyEvent.VK_UP) && (sn.dierection != 2)) sn.dierection=0;
            if (event.getKeyCode() == KeyEvent.VK_DOWN  && (sn.dierection != 0)) sn.dierection=2;
            if (event.getKeyCode() == KeyEvent.VK_LEFT && (sn.dierection != 1)) sn.dierection=3;
            if (event.getKeyCode() == KeyEvent.VK_RIGHT && (sn.dierection != 3)) sn.dierection=1;

        }
    }
}