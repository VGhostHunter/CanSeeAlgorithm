public class ThreeGatesExperiment {

    private int N;

    public ThreeGatesExperiment(int N) {
        if(N < 0)
            throw new IllegalArgumentException("N must be larger than 0");
        this.N = N;
    }

    public void run(boolean changeDoor) {
        int wins = 0;
        for(int i = 0; i < N; i++) {
            if(play(changeDoor)) {
                wins ++;
            }
        }
        System.out.println((changeDoor == true ? "Change" : "NotChange") + " winning rate: " + (double)wins / N);
    }

    private boolean play(boolean changeDoor) {
        //生成获奖门
        int win = (int)(Math.random() * 3 + 1);
        int choose = (int)(Math.random() * 3 + 1);
        if(changeDoor) {
            return choose != win;
        } else {
            return  choose == win;
        }
    }

    public static void main(String[] args) {
        int N = 10000000;
        new ThreeGatesExperiment(N).run(true);
        new ThreeGatesExperiment(N).run(false);
    }
}
