import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;



class AppleTest {

    @Test
    @DisplayName("stay positions")
    void stay_position() {
        Field.razmer = Field.SCALE*10;
        Snake s = new Snake(1,1,1,2);
        Apple a = new Apple(1,1);
        if(s.sX[0]==a.posX && s.sY[0]==a.posY) {
            a.setRandomPosition();
        }
        Assertions.assertNotEquals(s.sX[0],a.posX);
    }
}