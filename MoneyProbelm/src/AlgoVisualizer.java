import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.MouseAdapter;
import java.util.Arrays;

public class AlgoVisualizer {

    private static int DELAY = 40;
    private static int CONUT = 50;
    private int[] money;        // 数据
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight){

        // 初始化数据
        money = new int[100];
        for (int i = 0; i < money.length; i++) {
            money[i] = 100;
        }
        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Welcome", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        while (true) {
            Arrays.sort(money);
            frame.render(money);
            AlgoVisHelper.pause(DELAY);
            //每COUNT轮模拟一次 加快速度
            for(int k = 0; k < CONUT; k++) {
                for(int i = 0; i< money.length; i++) {
//                    if(money[i] > 0) {
                    int j = (int)(Math.random() * money.length);
                    money[i] -= 1;
                    money[j] += 1;
//                        while (true) {
//                            int j = (int)(Math.random() * money.length);
//                            if(money[j] > 0) {
//                                money[i] -= 1;
//                                money[j] += 1;
//                                break;
//                            }
//                        }
//                    }
                }
            }
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 1200;
        int sceneHeight = 800;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight);
    }
}
