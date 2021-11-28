import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/** class of menu */
public class Menu extends JFrame{
    /** title of button */
    public  static final JRadioButton radio1 = new JRadioButton("Большое");
    /** title of button */
    public static final JRadioButton radio2 = new JRadioButton("Среднее");
    /** title of button */
    public static final JRadioButton radio3 = new JRadioButton("Маленькое");
    /** title of button */
    public static final JRadioButton radio1_obj = new JRadioButton("Нет");
    /** title of button */
    public static final JRadioButton radio2_obj = new JRadioButton("Мало");
    /** title of button */
    public static final JRadioButton radio3_obj = new JRadioButton("Средне");
    /** title of button */
    public static final JRadioButton radio4_obj = new JRadioButton("Много");

    /**
     * create of menu
     */
    //создание меню настроек змеи
    public Menu(){
        super("Options");
        this.setSize(Field.SCALE*20, Field.SCALE*20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(11,1,2,3));

        JLabel label = new JLabel("Выберите размер поля");
        container.add(label);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(radio3);

        JLabel label_obj = new JLabel("Выберите количество препятствий");
        container.add(label_obj);

        ButtonGroup group_obj = new ButtonGroup();
        group_obj.add(radio1_obj);
        group_obj.add(radio2_obj);
        group_obj.add(radio3_obj);
        group_obj.add(radio4_obj);

        container.add(radio1_obj);
        radio1_obj.setSelected(true);
        container.add(radio2_obj);
        container.add(radio3_obj);
        container.add(radio4_obj);

        JButton button = new JButton("START");
        button.addActionListener(new ButtonEvent());
        container.add(button);
    }

    /**
     * create the field within menu settings
     */
    public static void create_field(){
        //настройка окна вывод
        Field.jFrame = new JFrame("Snake");
        Field.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        Field.jFrame.setLocation(0,0);
        Field.jFrame.setResizable(false);
        Field.jFrame.setSize(Field.razmer+16,Field.razmer+38);
        Field.jFrame.add(new Field());
        Field.jFrame.setVisible(true);

    }

    /**
     * install settings
     */
    public static void radio_choose(){
        if(radio1.isSelected()) {
            Field.razmer = Field.SCALE*20;
            if(radio1_obj.isSelected()) Field.col=0;//0%
            if(radio2_obj.isSelected()) Field.col=12;//3%
            if(radio3_obj.isSelected()) Field.col=28;//7%
            if(radio4_obj.isSelected()) Field.col=40;//10%
        }
        if(radio2.isSelected()) {
            Field.razmer = Field.SCALE*15;
            if(radio1_obj.isSelected()) Field.col=0;
            if(radio2_obj.isSelected()) Field.col=7;
            if(radio3_obj.isSelected()) Field.col=16;
            if(radio4_obj.isSelected()) Field.col=23;
        }
        if(radio3.isSelected()) {
            Field.razmer = Field.SCALE*10;
            if(radio1_obj.isSelected()) Field.col=0;
            if(radio2_obj.isSelected()) Field.col=3;
            if(radio3_obj.isSelected()) Field.col=7;
            if(radio4_obj.isSelected()) Field.col=10;
        }

    }
    /*** create barriers*/
    public static void create_objects(){
        Field.objx= new int[Field.col];
        Field.objy= new int[Field.col];

        //генерация координат препятствий
        for (int i=0; i< Field.col;i++) {
            Field.objx[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
            Field.objy[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));

            //проверка на спаун перед головой змеи
            if(((Field.objx[i]== (Field.razmer/Field.SCALE)/2 + 1 ) && (Field.objy[i]== (Field.razmer/Field.SCALE)/2 - 1)) ||
                    ((Field.objx[i]== (Field.razmer/Field.SCALE)/2  ) && (Field.objy[i]== (Field.razmer/Field.SCALE)/2 - 1)) ||
                    ((Field.objx[i]== (Field.razmer/Field.SCALE)/2 - 1 ) && (Field.objy[i]== (Field.razmer/Field.SCALE)/2 - 1)))
            {
                Field.objx[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1)); Field.objy[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
            }
        }
    }
    /*** assigning variables according to the specified settings*/
    //задание переменных по данным настройкам
    class ButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            dispose(); radio_choose(); create_objects(); create_field();
        }
    }
}
