import java.awt.*;
import java.util.LinkedList;

public class AlgoVisualizer {

    private static int DELAY = 60;
    private MonteCarloPiData data;
    private LinkedList<Point> points;
    private int N;
    private AlgoFrame frame;    // 视图

    public AlgoVisualizer(int sceneWidth, int sceneHeight, int N){
        if(sceneWidth != sceneHeight) {
            throw new IllegalArgumentException("the demo must be run in a sqare window!");
        }
        // 初始化数据
        this.N = N;
        Circle circle = new Circle(sceneWidth / 2, sceneHeight / 2, sceneHeight / 2);
        data = new MonteCarloPiData(circle);

        // 初始化视图
        EventQueue.invokeLater(() -> {
            frame = new AlgoFrame("Get PI With Carlo", sceneWidth, sceneHeight);
            new Thread(() -> {
                run();
            }).start();
        });
    }

    // 动画逻辑
    private void run(){
        for(int i = 0; i < N; i++) {
            if(i % 100 == 0) {
                frame.render(data);
                AlgoVisHelper.pause(DELAY);
                System.out.println(data.estimatePI());
            }

            int x = (int)(Math.random() * frame.getCanvasWidth());
            int y = (int)(Math.random() * frame.getCanvasHeight());
            data.addPoint(new Point(x, y));
        }
    }

    public static void main(String[] args) {

        int sceneWidth = 500;
        int sceneHeight = 500;
        int N = 20000;

        AlgoVisualizer visualizer = new AlgoVisualizer(sceneWidth, sceneHeight, N);
    }
}
