import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

//import static org.junit.jupiter.api.Assertions.*;

class FieldTest {

    @Test
    void paint() {

    }

    @Test
    void main() {
        Menu app = new Menu();
        app.setVisible(true);
    }

    @Test
    @DisplayName("snake eat apple")
    public void snake_eat_apple() {
        Field.razmer = Field.SCALE*20;

        Snake s = new Snake(1,1,1,2);
        Apple a = new Apple(1,1);
        Snake so = new Snake(1,1,1,2);
        Apple ao = new Apple(1,4);
        Assertions.assertTrue(s.sX[0]==a.posX && s.sY[0]==a.posY);
        Assertions.assertFalse(so.sX[0]==ao.posX && so.sY[0]==ao.posY);

    }
    @Test
    @DisplayName("score_up")
    public void score_up() {
        Field.razmer = Field.SCALE*20;
        Field.score = 0;
        Field.col = 12;
        Snake s = new Snake(1,1,1,2);
        Apple a = new Apple(1,1);
        if (s.sX[0]==a.posX && s.sY[0]==a.posY) Field.score = 25 - Field.razmer/Field.SCALE + Field.col;
        Assertions.assertEquals(17, Field.score);

    }
    @Test
    @DisplayName("speed")
    public void speed() {
        int s = Field.speed;
        Assertions.assertEquals(6,s);

    }
    @Test
    @DisplayName("snake_eat_snake")
    public void snake_eat_snake() {
        Field.razmer = Field.SCALE*20;

        Snake s = new Snake(1,1,1,2);
        s.len = 5;
        for(int i=1; i< s.len; i++) {
            Assertions.assertFalse(s.sX[0] == s.sX[i] && s.sY[0] == s.sY[i]);
        }


    }
}