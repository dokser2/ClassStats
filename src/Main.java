import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        ClassFrame classFrame = new ClassFrame("СТАТИСТИКА КЛАСУ");
        classFrame.setSize(380,280);
        classFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        classFrame.setVisible(true);
        classFrame.setResizable(false);
        classFrame.setLocationRelativeTo(null);
    }
}
