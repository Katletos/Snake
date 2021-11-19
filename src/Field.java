import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Field extends JPanel implements ActionListener {


    public static JFrame jFrame;            //создание окна вывода
    public static final int SCALE =32;                 //размер клетки
    public static int col;
    public static int razmer;
    public int speed=6;
    public boolean T=false;
    public int score=0;
    public static int[] objx;
    public static int[] objy;

    //задаем Змея и яблоко
    Snake s = new Snake ((razmer/SCALE)/2,(razmer/SCALE)/2-1, (razmer/SCALE)/2-1, (razmer/SCALE)/2-1);
    Apple a = new Apple  (Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1)),Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1)));
    //Ввод таймера для движ змеи
    Timer timer = new Timer(1000/speed, this);

    //подрубаем клаву и таймер
    public Field(){
    timer.start();
    addKeyListener(new KeyBoard());
    setFocusable(true);

    }

    //отрисовка клеток на поле
    @Override
    public void paint(Graphics g){

        //черный экран
        g.setColor(Color.black);
        g.fillRect(0,0, razmer, razmer);
         //клетки
        for (int x= 1; x<1000; x+=SCALE){
            g.setColor(Color.black);
            g.drawLine(x,0,x,1000);
        }
        for (int y=0; y<1000; y+=SCALE){
            g.setColor(Color.black);
            g.drawLine(0,y,1000,y);
        }

        //яблоко,конфета...хз как ее там
        g.setColor(Color.red);
        g.fillOval(a.posX*SCALE+5,a.posY*SCALE+4, SCALE-8, SCALE-8);

        //отрисовка препятствий на поле
        g.setColor(Color.gray);
        for (int i=0; i< col;i++) {
            g.fillRect(objx[i]*SCALE+4,objy[i]*SCALE+3,SCALE-6,SCALE-6);
        }


        //змей
        for (int l=1; l<s.len; l++){
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*SCALE+4, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0]*SCALE+4, s.sY[0]*SCALE+3, SCALE-6, SCALE-6);
        }

        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, razmer/SCALE+5));
        g.drawString("SCORE:",0,razmer);
        g.drawString(Integer.toString(score), razmer/SCALE * 5 + 10, razmer);

    }

    public static void main(String[] args)
    {
        Menu app = new Menu();
        app.setVisible(true);
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

        //проверка спауна яблока
        for (int l=1; l<s.len; l++){
            // если яблоко в змейке
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
            for (int i=0; i< Field.col;i++) {
                if( (s.sX[0]==objx[i] && s.sY[0]==objy[i]) ){
                    T = false; //стопим змею
                    JOptionPane.showMessageDialog(null, score,"GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                    s.len=2;// start length
                    a.setRandomPosition();//new candy
                    s.sX[0] = (razmer/SCALE)/2; s.sY[0]=(razmer/SCALE)/2-1; s.sY[1]=(razmer/SCALE)/2-1; s.sX[1]=(razmer/SCALE)/2-1;//start position
                    score=0;//start score
                    s.direction=1;
                    for (int j=0; j< Field.col;j++) {
                        objx[j] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
                        objy[j] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));

                    }
                }

            }
            // если змея в змее
            if( (s.sX[0]==s.sX[l] && s.sY[0]==s.sY[l]))
            {
                T = false; //стопим змею
                JOptionPane.showMessageDialog(null, score,"GAME OVER", JOptionPane.INFORMATION_MESSAGE);
                s.len=2;// start length
                a.setRandomPosition();//new candy
                s.sX[0] = (razmer/SCALE)/2; s.sY[0]=(razmer/SCALE)/2-1; s.sY[1]=(razmer/SCALE)/2-1; s.sX[1]=(razmer/SCALE)/2-1;//start position
                score=0;//start score
                s.direction=1;
                for (int i=0; i< Field.col;i++) {
                    objx[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
                    objy[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));

                }
            }
        }

        repaint();
    }

    public class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();

            if (key == KeyEvent.VK_ENTER ) T=true;//начало игры
            if (key == KeyEvent.VK_ESCAPE) T=false;//пауза
            if (T){
                if ((key == KeyEvent.VK_UP || key == KeyEvent.VK_W) && s.direction != 2) s.direction = 0;//UP
                if ((key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_D) && s.direction != 3) s.direction = 1;//RIGHT
                if ((key == KeyEvent.VK_DOWN || key == KeyEvent.VK_S) && s.direction != 0) s.direction = 2;//DOWN
                if ((key == KeyEvent.VK_LEFT || key == KeyEvent.VK_A) && s.direction != 1) s.direction = 3;//LEFT
            }
        }
    }
}