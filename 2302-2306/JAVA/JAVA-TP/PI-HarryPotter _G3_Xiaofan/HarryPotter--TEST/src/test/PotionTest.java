package test;

import HarryPotter.Potion.Potion;
import HarryPotter.Wizard.Wizard;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    @Test
    void testUsePotion() {
        Wizard wizard = new Wizard();
        wizard.setHP(60);
        Potion.NumPotion = 0;
        Potion.usepotion(wizard);
        assertEquals(60, wizard.getHP());
        assertEquals(0, Potion.NumPotion);
    }

    @Test
    void testAddPotion() {
        Potion.NumPotion = 1;
        Potion.addpotion();
        assertEquals(2, Potion.NumPotion);
    }
}
