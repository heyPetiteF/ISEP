package test;

import HarryPotter.Wizard.Wizard;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class WizardTest {
    @Test
    public void WizardTest() {
        // 模拟输入
        String input = "Harry\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        // 调用方法

        //Wizard.wizard();

        // 检查输出
        //assertEquals(100, Wizard.getHP()); // 初始生命值为100
    }

    @Test
    public void GetHPTest() {
        Wizard wizard = new Wizard();
        wizard.setHP(80);
        assertEquals(80, wizard.getHP());
    }

    @Test
    public void SetHPTest() {
        Wizard wizard = new Wizard();
        wizard.setHP(80);
        assertEquals(80, wizard.getHP());
    }

}