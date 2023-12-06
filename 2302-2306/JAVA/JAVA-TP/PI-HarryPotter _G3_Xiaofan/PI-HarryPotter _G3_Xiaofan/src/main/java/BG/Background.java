package main.java.BG;

public class Background {

    public static void BG(){
        String sentence = "\nA hat falls on your head ...... is the Sorting Hat!" +
                "\nWelcome to the world of magic! Now you are a wizard." +
                "\nEvery next step is crucial for you ......" +
                "\nFollow the hints and enjoy your journey!\n";

        print(sentence);
    }
    public static void print(String sentence){
        for (int i = 0; i < sentence.length(); i++) {
            System.out.print(sentence.charAt(i));
            try {
                Thread.sleep(10); // 控制打印速度，可根据需要调整
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
