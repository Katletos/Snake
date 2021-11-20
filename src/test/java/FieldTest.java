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
}