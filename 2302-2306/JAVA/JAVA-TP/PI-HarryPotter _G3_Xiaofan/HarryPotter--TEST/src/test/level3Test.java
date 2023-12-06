package test;

import HarryPotter.Game.level1;
import org.junit.Test;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import static org.junit.Assert.*;

public class level3Test {

    @Test
    public void testLevel3() {
        // redirect standard output to a byte array for testing
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));

        // mock user input
        String userInput = "1\n1\n1\n1\n1\n";

        // call the method under test
        level1.level1();

        // assert that the expected output was printed
        String expectedOutput = "---------------------------------------------LEVEL 1---------------------------------------------\n" +
                "\nYou have arrived 【Toilettes du donjon】......\n" +
                "Here you will use and be subject to attacks of ATN.\n" +
                "You can throw things at your enemies.\n" +
                "Watch out for dodging your opponent's attacks!\n" +
                "Are you ready to fight?\n" +
                "!!!Troll is coming!!!\n" +
                "###################################################\n" +
                "Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll\n" +
                "###################################################\n" +
                "HP1: 70, Wizard HP: 85\n" +
                "###################################################\n" +
                "Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll\n" +
                "###################################################\n" +
                "HP1: 55, Wizard HP: 80\n" +
                "###################################################\n" +
                "Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll\n" +
                "###################################################\n" +
                "HP1: 40, Wizard HP: 75\n" +
                "###################################################\n" +
                "Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll\n" +
                "###################################################\n" +
                "HP1: 25, Wizard HP: 70\n" +
                "###################################################\n" +
                "Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll\n" +
                "###################################################\n" +
                "HP1: 10, Wizard HP: 65\n" +
                "###################################################\n" +
                "Please select the items you want to throw: \n1. mirror\n2. sink\n3. toilet\n4. toilet roll\n" +
                "###################################################\n" +
                "HP1: -5, Wizard HP: 60\n" +
                "Congratulations! You have defeated the troll!\n";
        assertEquals(expectedOutput, outContent.toString());
    }
}
