import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class MenuTest {

    @Test
    @DisplayName("middle field")
    public void middle_field(){
        Menu.radio2.setSelected(true);
        if (Menu.radio2.isSelected()) {Field.razmer = Field.SCALE*15;}
        Assertions.assertFalse(Field.razmer == 640 || Field.razmer == 320);
}
    @Test
    @DisplayName("Big field")
    public void big_field(){
        Menu.radio1.setSelected(true);
        if (Menu.radio1.isSelected()) {Field.razmer = Field.SCALE*20;}
        Assertions.assertEquals(640, Field.razmer);
    }
    @Test
    @DisplayName("small field")
    public void small_field(){
        Menu.radio3.setSelected(true);
        if (Menu.radio3.isSelected()) {Field.razmer = Field.SCALE*10;}
        Assertions.assertEquals( Field.razmer , 320);
    }
    @Test
    @DisplayName("number of barriers on big field")
    public void obj_on_big_field() {
        Menu.radio1.setSelected(true);
        Menu.radio3_obj.setSelected(true);
        Menu.radio_choose();
        Assertions.assertEquals(Field.col,28);
        Assertions.assertEquals(Field.razmer,640);
    }
    @Test
    @DisplayName("number of barriers on middle field")
    public void obj_on_middle_field() {
        Menu.radio2.setSelected(true);
        Menu.radio1.setSelected(false);
        Menu.radio3.setSelected(false);
        Menu.radio2_obj.setSelected(false);
        Menu.radio3_obj.setSelected(false);
        Menu.radio4_obj.setSelected(false);
        Menu.radio1_obj.setSelected(true);
        Menu.radio_choose();
        Assertions.assertEquals(Field.col,0);
        Assertions.assertEquals(Field.razmer,480);
    }
    @Test
    @DisplayName("number of barriers on small field")
    public void obj_on_small_field() {
        Menu.radio3.setSelected(true);
        Menu.radio4_obj.setSelected(true);
        Menu.radio_choose();
        Assertions.assertEquals(Field.col,10);
        Assertions.assertEquals(Field.razmer,320);
    }
    @Test
    @DisplayName("clear the menu")
    public void clear() {
    }
    @Test
    @DisplayName("create field")
    public void creation(){
        Field.razmer = Field.SCALE*20;
        Menu.create_field();
    }
    @Test
    @DisplayName("create objects")
    public void objects(){
        Field.razmer = Field.SCALE*20;
        Menu.create_objects();
    }



}