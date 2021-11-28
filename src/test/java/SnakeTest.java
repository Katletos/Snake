import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;



//import static org.junit.jupiter.api.Assertions.*;

class SnakeTest {

    @ParameterizedTest
    @DisplayName("moving")
    @ValueSource( ints = {0, 1, 2, 3})
    public void moving( int direct){
        Field.razmer = Field.SCALE*10;
        Snake s = new Snake(1,1,1,2);
        s.direction = direct;
        Assertions.assertTrue(s.direction>=0 && s.direction <=3);
    }
    @ParameterizedTest
    @DisplayName("dismoving")
    @ValueSource( ints = {-3,4,12})
    public void dismoving( int direct){
        Field.razmer = Field.SCALE*10;
        Snake s = new Snake(1,1,1,2);
        s.direction = direct;
        Assertions.assertFalse(s.direction>=0 && s.direction <=3);
    }
    @Test
    @DisplayName("snake in wall")
    public void move_in_wall(){
        Field.razmer = Field.SCALE*15;
        Snake s = new Snake(-1,1,1,2);
        Snake.move_in_wall(s.sY,s.sX);
        Assertions.assertEquals(s.sX[0],Field.razmer/Field.SCALE-1);
    }
    @Test
    @DisplayName("snake in wall2")
    public void move_in_wall2(){
        Field.razmer = Field.SCALE*15;
        Snake s = new Snake(1,-1,1,2);
        Snake.move_in_wall(s.sY,s.sX);
        Assertions.assertEquals(s.sY[0],Field.razmer/Field.SCALE-1);
    }
    @Test
    @DisplayName("move")
    public void move(){
        Field.razmer = Field.SCALE*10;
        Snake s = new Snake(5,5,6,5);
        s.move();
        Assertions.assertEquals(6, s.sX[0]);

    }




}