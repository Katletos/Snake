import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class Menu extends JFrame{
    private JButton button = new JButton("START");
    private JLabel label = new JLabel("Выберите размер поля");
    private JLabel label_obj = new JLabel("Выберите количество препятствий");
    private JRadioButton radio1 = new JRadioButton("Большое");
    private JRadioButton radio2 = new JRadioButton("Среднее");
    private JRadioButton radio3 = new JRadioButton("Маленькое");
    private JRadioButton radio1_obj = new JRadioButton("Нет");
    private JRadioButton radio2_obj = new JRadioButton("Мало");
    private JRadioButton radio3_obj = new JRadioButton("Средне");
    private JRadioButton radio4_obj = new JRadioButton("Много");


    public Menu(){
        super("Snake");
        this.setBounds(0,0, Field.SCALE*20, Field.SCALE*20);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container container = this.getContentPane();
        container.setLayout(new GridLayout(11,1,2,3));
        container.add(label);

        ButtonGroup group = new ButtonGroup();
        group.add(radio1);
        group.add(radio2);
        group.add(radio3);

        container.add(radio1);
        radio1.setSelected(true);
        container.add(radio2);
        container.add(radio3);

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

        button.addActionListener(new ButtonEvent());
        container.add(button);




    }
    class ButtonEvent implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(radio1.isSelected()) {
                Field.razmer = Field.SCALE*20;
                if(radio1_obj.isSelected()) Field.col=0;
                if(radio2_obj.isSelected()) Field.col=12;
                if(radio3_obj.isSelected()) Field.col=28;
                if(radio4_obj.isSelected()) Field.col=40;
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

            Field.objx= new int[Field.col];
            Field.objy= new int[Field.col];
            for (int i=0; i< Field.col;i++) {
                Field.objx[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
                Field.objy[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));

                if(((Field.objx[i]== (Field.razmer/Field.SCALE)/2 + 1 ) && (Field.objy[i]== (Field.razmer/Field.SCALE)/2 - 1)) ||
                        ((Field.objx[i]== (Field.razmer/Field.SCALE)/2  ) && (Field.objy[i]== (Field.razmer/Field.SCALE)/2 - 1)) ||
                        ((Field.objx[i]== (Field.razmer/Field.SCALE)/2 - 1 ) && (Field.objy[i]== (Field.razmer/Field.SCALE)/2 - 1)))
                {
                    Field.objx[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
                    Field.objy[i] = Math.abs( (int) (Math.random()*(Field.razmer/Field.SCALE)-1));
                }

            }

            //настройка окна вывод
            Field.jFrame = new JFrame("Snake");
            Field.jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            Field.jFrame.setLocation(0,0);
            Field.jFrame.setResizable(false);
            Field.jFrame.setSize(Field.razmer+16,Field.razmer+38);
            Field.jFrame.add(new Field());
            Field.jFrame.setAlwaysOnTop(true);

            Field.jFrame.setVisible(true);
            Field.jFrame.setAlwaysOnTop(false);
        }


    }

}
