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
    public static int razmer;
    public  int speed=8;
    public boolean T=false;
    public int score=0;
//задаем Змея и яблоко
    Snake s = new Snake ((razmer/scale)/2,(razmer/scale)/2-1, (razmer/scale)/2-1, (razmer/scale)/2-1);
    Apple a = new Apple  (Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1)),Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1)));
    //Ввод таймера для движ змеи
    Timer timer = new Timer(1000/speed, this);
//подрубаем клаву и таймер
    public field(){
    timer.start();
    addKeyListener(new KeyBoard());
    setFocusable(true);

    }

    //отрисовка клеток на поле
    public void paint(Graphics g){
        //черный экран
        g.setColor(Color.black);
        g.fillRect(0,0, razmer, razmer);
         //клетки
        for (int x= 1; x<1000; x+=scale){
            g.setColor(Color.black);
            g.drawLine(x,0,x,1000);
        }
        for (int y=0; y<1000; y+=scale){
            g.setColor(Color.black);
            g.drawLine(0,y,1000,y);
        }

        //отрисовка препятствий на поле
         g.setColor(Color.gray);
        //СКОРО

        //яблоко,конфета...хз как ее там
        g.setColor(Color.red);
        g.fillOval(a.posX*scale+5,a.posY*scale+4, scale-8, scale-8);

        //змей
        for (int l=1; l<s.len; l++){
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*scale+4, s.sY[l]*scale+3, scale-6, scale-6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0]*scale+4, s.sY[0]*scale+3, scale-6, scale-6);
        }


    }


   //выбираем размер поля и кол-во препятствий(доработать)
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
// закидываю их в общую массу
        col=colich;
        razmer=raz;
    }

    public static void main(String[] args)
    {

        Scanner in = new Scanner(System.in);
          System.out.println("Выберите размер поля");
          System.out.println("1:Большое; 2:Среднее; 3:Маленькое");
        int r =  in.nextInt();

          System.out.println("Выберите количество препятствий");
          System.out.println("1:Нет; 2:Мало; 3:Средне; 4:Много");
        int k = in.nextInt();



        //в соотвестсвии с выбором задается размер и количество препятствий
         Size(r,k);
        //System.out.println(field.razmer);
        int razmerx=razmer+16;
        int razmery=razmer+38;

        //настройка окна вывода
        jFrame = new JFrame("Snake");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(0,0);
        jFrame.setResizable(false);
        jFrame.setSize(razmerx,razmery);
        jFrame.add(new field());
        jFrame.setVisible(true);

    }
    @Override
    public void actionPerformed(ActionEvent e){
        // если нажат enter начинаем движ змейки
        if (T) s.move();
//едим яблоко
        if(s.sX[0]==a.posX && s.sY[0]==a.posY){
            a.setRandomPosition();
            s.len++;
            score += 5;
        }
//проверка на проигрыш
        for (int l=1; l<s.len; l++){
            // если яблоко в змейке перерисуем
            if(s.sX[l]==a.posX && s.sY[l]==a.posY){
                a.setRandomPosition();
            }
            // если змея в змее или стене
            if( (s.sX[0]==s.sX[l] && s.sY[0]==s.sY[l]) || s.wall)
            {
                T = false; //стопим змею
                JOptionPane.showMessageDialog(null,"GAME OVER");//you lose
                jFrame.setVisible(false);// turn off the field
                s.len=2;// start length
                a.setRandomPosition();//new candy
                s.sX[0] = (razmer/scale)/2; s.sY[0]=(razmer/scale)/2-1; s.sY[1]=(razmer/scale)/2-1; s.sX[1]=(razmer/scale)/2-1;//start position
                s.wall=false;//start walls
                score=0;//start score
                jFrame.setVisible(true);// turn on the field

            }
        }

        repaint();
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_ENTER ) T=true;//начало игры
            if (key == KeyEvent.VK_ESCAPE) T=false;//пауза
            if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && s.direction != 2) s.direction = 0;//UP
            if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && s.direction != 3) s.direction = 1;//RIGHT
            if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && s.direction != 0) s.direction = 2;//DOWN
            if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && s.direction != 1) s.direction = 3;//LEFT


        }
    }
}