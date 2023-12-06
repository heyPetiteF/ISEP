package test;

import HarryPotter.Pet.Pet;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PetTest {

    private static final InputStream stdin = System.in;
    private static ByteArrayInputStream testIn;

    @BeforeAll
    public static void setup() {
        // 设置输入流
        String input = "1\n"; // 选择1，模拟输入
        testIn = new ByteArrayInputStream(input.getBytes());
        System.setIn(testIn);
    }

    @Test
    @DisplayName("测试选择宠物函数")
    public void testChoicePet() {
        // 调用函数
        Pet.ChoicePet();
        // 恢复输入流
        System.setIn(stdin);
        // 检查输出是否符合预期
        String expected = "\nNow, you have an owl to keep you company\n";
        assertEquals(expected, System.out.toString());
    }
}
