package test;

import HarryPotter.Game.Level;
import HarryPotter.Game.level1;
import HarryPotter.Wizard.Wizard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class level1Test {

    @Test
    public void testLevel1() {

        int expectedHP = 100;
        Level.HP1 = 100;
        Level.HP1();
        assertEquals(expectedHP, Level.HP1);

        expectedHP = 70;
        Level.HP1 = 70;
        Level.HP1();
        assertEquals(expectedHP, Level.HP1);
    }
}
