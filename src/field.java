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
    public  int speed=6;
    public boolean T=false;
    public int score=0;
    public static int[] objx;
    public static int[] objy;
//задаем Змея и яблоко
    snake s = new snake ((razmer/scale)/2,(razmer/scale)/2-1, (razmer/scale)/2-1, (razmer/scale)/2-1);
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

        //яблоко,конфета...хз как ее там
        g.setColor(Color.red);
        g.fillOval(a.posX*scale+5,a.posY*scale+4, scale-8, scale-8);

        //отрисовка препятствий на поле
        g.setColor(Color.gray);
        for (int i=0; i< col;i++) {
            g.fillRect(objx[i]*scale+4,objy[i]*scale+3,scale-6,scale-6);
        }


        //змей
        for (int l=1; l<s.len; l++){
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*scale+4, s.sY[l]*scale+3, scale-6, scale-6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0]*scale+4, s.sY[0]*scale+3, scale-6, scale-6);
        }

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, razmer/scale+5));
        g.drawString("SCORE:",0,razmer);
        g.drawString(Integer.toString(score), razmer/scale * 5 + 10, razmer);

    }


   //выбираем размер поля и кол-во препятствий(доработать)
    public static void Size(int raz, int colich)
    {
        if (raz==1)
        {
            raz=scale*20;
            switch (colich) {
                case 1:
                    colich = 0;//0%
                    break;
                case 2:
                    colich =12;//3%
                    break;
                case 3:
                    colich =28;//7%
                    break;
                case 4:
                    colich =40;//10%
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
                    colich =7;
                    break;
                case 3:
                    colich =16;
                    break;
                case 4:
                    colich =23;
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
                    colich =3;
                    break;
                case 3:
                    colich =7;
                    break;
                case 4:
                    colich =10;
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

        //создание координат препятствий
        objx= new int[col];
        objy= new int[col];
        for (int i=0; i< field.col;i++) {
            objx[i] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));
            objy[i] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));

            if(((objx[i]== (razmer/scale)/2 + 1 ) && (objy[i]== (razmer/scale)/2 - 1)) ||
            ((objx[i]== (razmer/scale)/2  ) && (objy[i]== (razmer/scale)/2 - 1)) ||
            ((objx[i]== (razmer/scale)/2 - 1 ) && (objy[i]== (razmer/scale)/2 - 1)))
            {
                objx[i] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));
                objy[i] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));
            }

        }

        //настройка окна вывод
        jFrame = new JFrame("Snake");
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLocation(0,0);
        jFrame.setResizable(false);
        jFrame.setSize(razmerx,razmery);
        jFrame.add(new field());
        jFrame.setAlwaysOnTop(true);

        jFrame.setVisible(true);
        jFrame.setAlwaysOnTop(false);


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
            //если яблоко в препятствии
            for (int i = 0; i< col;i++){
                if(objx[i]==a.posX && objy[i]==a.posY){
                    a.setRandomPosition();
                }
            }
            //змей и препятствия
            for (int i=0; i< field.col;i++) {
                if( (s.sX[0]==objx[i] && s.sY[0]==objy[i]) ){
                    T = false; //стопим змею
                    JOptionPane.showMessageDialog(null, "GAME OVER!!! \nYour score:","THE END", JOptionPane.INFORMATION_MESSAGE);
                    JOptionPane.showMessageDialog(null, score);
                   jFrame.setVisible(false);
                    // turn off the field
                    s.len=2;// start length
                    a.setRandomPosition();//new candy
                    s.sX[0] = (razmer/scale)/2; s.sY[0]=(razmer/scale)/2-1; s.sY[1]=(razmer/scale)/2-1; s.sX[1]=(razmer/scale)/2-1;//start position
                    s.wall=false;//start walls
                    score=0;//start score
                    s.direction=1;
                    for (int j=0; i< field.col;i++) {
                        objx[j] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));
                        objy[j] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));

                    }

                    jFrame.setVisible(true);// turn on the field
                }

            }
            // если змея в змее или стене
            if( (s.sX[0]==s.sX[l] && s.sY[0]==s.sY[l]) || s.wall)
            {
                T = false; //стопим змею
                JOptionPane.showMessageDialog(null, "GAME OVER!!! \nYour score:","THE END", JOptionPane.INFORMATION_MESSAGE);
                JOptionPane.showMessageDialog(null, score);
                jFrame.setVisible(false);// turn off the field
                s.len=2;// start length
                a.setRandomPosition();//new candy
                s.sX[0] = (razmer/scale)/2; s.sY[0]=(razmer/scale)/2-1; s.sY[1]=(razmer/scale)/2-1; s.sX[1]=(razmer/scale)/2-1;//start position
                s.wall=false;//start walls
                score=0;//start score

                s.direction=1;
                for (int i=0; i< field.col;i++) {
                    objx[i] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));
                    objy[i] = Math.abs( (int) (Math.random()*(field.razmer/field.scale)-1));

                }
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