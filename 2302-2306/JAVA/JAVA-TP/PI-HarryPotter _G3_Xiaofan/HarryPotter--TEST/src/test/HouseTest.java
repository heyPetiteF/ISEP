package test;

import HarryPotter.House.House;
import HarryPotter.Wizard.Wizard;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class HouseTest {

    @Test
    public void testChoice() {
        String input = "3\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        House.Choice();

        assertEquals(3, House.choice);
        assertEquals(100, Wizard.HP);
        assertEquals(140, Wizard.DEF);
        assertEquals(70, Wizard.SA);
    }
}
