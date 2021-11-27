import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 *  main class
 */
public class Field extends JPanel implements ActionListener {
    /** Frame */
    public static JFrame jFrame;                 //создание окна вывода
    /** size of scale */
    public static final int SCALE =32;           //размер клетки
    /** number of object */
    public static int col;                       //количество препятствий
    /** size of field */
    public static int razmer;                    //размер поля
    /** speed of snake */
    public static int speed=6;                   //скорость игры
    /** parameter of game */
    public boolean T=false;                      //игра на паузе или нет
    /** parameter of game over */
    public  boolean score_and_game_over = false;
    /** score of game */
    public static int score=0;                   //счет за игру
    /** coordinate X of object */
    public static int[] objx;                    //кординаты препятствий по х
    /** coordinate Y of object */
    public static int[] objy;                    //координаты пряпятствий по у
    /** title */
    public static String game_over = "GAME OVER (T-T)//";

    /** create snake on field */
    //задаем Змея
    Snake s = new Snake ((razmer/SCALE)/2,(razmer/SCALE)/2-1, (razmer/SCALE)/2-1, (razmer/SCALE)/2-1);

    /** create apple on field */
    //задаем яблоко
    Apple a = new Apple  (Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1)),Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1)));

    /** create timer of work */
    //Ввод таймера для движ змеи
    Timer timer = new Timer(1000/speed, this);

    /**
     * add keyboard and timer
     */
    //подрубаем клаву и таймер
    public Field(){
    timer.start();
    addKeyListener(new KeyBoard());
    setFocusable(true);
    }

    /**
     * field rendering
     * @param g graphics variable
     */
    //отрисовка поля
    @Override
    public void paint(Graphics g){

        //черный экран
        g.setColor(Color.black);
        g.fillRect(0,0, razmer+16, razmer+38);

        //отрисовка яблок
        g.setColor(Color.red);
        g.fillOval(a.posX*SCALE+5,a.posY*SCALE+4, SCALE-8, SCALE-8);

        //отрисовка препятствий на поле
        g.setColor(Color.gray);
        for (int i=0; i< col;i++) {
            g.fillRect(objx[i]*SCALE+4,objy[i]*SCALE+3,SCALE-6,SCALE-6);
        }

        //отрисовка змея
        for (int l=1; l<s.len; l++){
            g.setColor(Color.green);
            g.fillRect(s.sX[l]*SCALE+4, s.sY[l]*SCALE+3, SCALE-6, SCALE-6);
            g.setColor(Color.white);
            g.fillRect(s.sX[0]*SCALE+4, s.sY[0]*SCALE+3, SCALE-6, SCALE-6); // отрисовка головы змея
        }

        //отрисовка надписи счета на поле
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, razmer/SCALE+5));
        g.drawString("SCORE:"+ score,0,razmer);

        //Отрисовка надписи "PAUSE"
        if (!score_and_game_over && !T ) {
            g.setColor(Color.white);
            g.setFont(new Font("TimesRoman", Font.PLAIN, 2*razmer/SCALE));
            if(razmer/SCALE!=15)
            g.drawString("PAUSE",razmer/2-(3*razmer/SCALE),razmer/3);
            else
                g.drawString("PAUSE",razmer/2-(3*razmer/SCALE)-16,razmer/3);
        }
    }

    /**
     * main procedure
     * @param args main parameter
     */
    //начало работы програмы
    public static void main(String[] args)
    {
        Menu app = new Menu();
        app.setVisible(true);
    }

    /**
     * procedure run when game over
     */
    //Если игра закончилась
    public void game_over() {
        T = false; //стопим змею

        //отрисовка финального счета при проигрыше
        Graphics g = this.getGraphics();
        g.setColor(Color.RED);
        g.setFont(new Font("TimesRoman", Font.PLAIN, 3*razmer/SCALE));
        g.drawString(game_over, razmer / 8, razmer / 2);
        g.setColor(Color.white);
        g.setFont(new Font("TimesRoman", Font.PLAIN, razmer/SCALE+5));
        g.drawString("YOUR FINAL SCORE:"+score,razmer/4,razmer/2 + game_over.length() +  razmer/SCALE - 5);

        //создание и вывод диалогового окна, в котором можно выбрать дальнейшие действия
        int n = JOptionPane.showConfirmDialog(null,"You want to continue", "Menu",JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);

        //выход с игры
        if (n==1)
            System.exit(0);

        //создание поля по новым настройкам
        if (n==0){
            score=0;
            jFrame.dispose();
            Menu app = new Menu();
            app.setVisible(true);
        }
    }

    /**
     * procedure of all event on field
     * @param e parameter of event
     */
    //основной алгоритм игры
    @Override
    public void actionPerformed(ActionEvent e){

        // если нажат enter начинаем движ змейки
        if (T) s.move();

        //едим яблоко
        if(s.sX[0]==a.posX && s.sY[0]==a.posY) {
            a.setRandomPosition();
            s.len++;
            score = score + 25 - razmer / SCALE + col+speed/2;
            if (col==0 && s.len % 5 ==0 && speed<20) speed+=2;
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
                    game_over();
                }

            }

            //змея врезалась в себя
            if(s.sX[0]==s.sX[l] && s.sY[0]==s.sY[l]) {
                game_over();
            }
        }
        repaint();
    }

    /**
     * procedure that change direction of snake
     */
    //подключение клавиш
    public class KeyBoard extends KeyAdapter {
        public void keyPressed(KeyEvent event) {
            int key = event.getKeyCode();
            if (key == KeyEvent.VK_Q)
            {
                jFrame.dispose();
                score=0;
                speed=6;
                Menu app = new Menu();
                app.setVisible(true);
            }
            if (key == KeyEvent.VK_ENTER ) {T=true;} //начало игры
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