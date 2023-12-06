package test;

import HarryPotter.Game.level2;
import org.junit.Assert;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static javax.swing.text.StyleConstants.Background;

public class Level2Test {

    @Test
    public void Level2Test() {
        // Set up the input stream with test input
        String testInput = "1\n";
        ByteArrayInputStream in = new ByteArrayInputStream(testInput.getBytes());
        System.setIn(in);

        // Call the method under test
        level2.level2();

        // Check that the output is as expected
        Assert.assertEquals(testInput, Background);;
    }

}
