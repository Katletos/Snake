import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

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




}