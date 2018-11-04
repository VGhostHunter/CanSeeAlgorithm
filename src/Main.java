import com.dhy.frame.AlgoFrame;

import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {

        EventQueue.invokeLater(() -> {
            AlgoFrame algoFrame = new AlgoFrame("Welcome", 500, 500);
//            AlgoFrame algoFrame = new AlgoFrame("Welcome");
        });
    }
}
