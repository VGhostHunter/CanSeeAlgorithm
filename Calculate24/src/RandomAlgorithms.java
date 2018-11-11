import java.util.Scanner;
import java.util.Stack;

/**
 * 随机算法 计算24
 */
public class RandomAlgorithms {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入四个10以内的数字：");
        String[] data = sc.nextLine().split("[ ]+");
        play(data);
    }

    public static void play(String[] data) {
        String[] buf = new String[7];
        for (int i = 0; i < 1000 * 10; i++) {
            shuffle(data);
            for (int j = 0; j < data.length; j++) {
                buf[j] = data[j];
            }
            for (int j = 4; j < 7; j++) {
                int random = (int) (Math.random() * 4);
                if (random == 0) {
                    buf[j] = "+";
                } else if (random == 1) {
                    buf[j] = "-";
                } else if (random == 2) {
                    buf[j] = "*";
                } else {
                    buf[j] = "/";
                }
            }
            if (calculate(buf)) {
                show(buf);
                break;
            }
        }
    }

    public static void shuffle(String[] data) {
        for (int i = 0; i < data.length; i++) {
            int j = (int) (Math.random() * data.length);
            String t = data[i];
            data[i] = data[j];
            data[j] = t;
        }
    }

    public static boolean calculate(String[] buf) {
        Stack stack = new Stack();
        try {
            for (int i = 0; i < buf.length; i++) {
                if (buf[i] == "+" || buf[i] == "-" || buf[i] == "*" || buf[i] == "/") {
                    int a = Integer.parseInt((String) stack.pop());
                    int b = Integer.parseInt((String) stack.pop());
                    stack.push(op(a, b, buf[i]));
                } else {
                    stack.push(buf[i]);
                }
            }
            if (stack.size() == 1 && stack.pop().equals("24"))
                return true;
            return false;
        } catch (RuntimeException e) {
            return false;
        }
    }

    public static String op(Integer a, Integer b, String oper) {
        if (oper.equals("+")) {
            return (a + b) + "";
        } else if (oper.equals("-")) {
            return (a - b) + "";
        } else if (oper.equals("*")) {
            return (a * b) + "";
        } else {
            if (a % b != 0) {
                throw new RuntimeException("不能除尽");
            } else {
                return (a / b) + "";
            }
        }
    }

    public static void show(String[] buf) {
        Stack stack = new Stack();
        for (int i = 0; i < buf.length; i++) {
            if (buf[i] == "+" || buf[i] == "-" || buf[i] == "*" || buf[i] == "/") {
                stack.push("(" + stack.pop() + buf[i] + stack.pop() + ")");
            } else {
                stack.push(buf[i]);
            }
        }
        System.out.println(stack.pop());
    }

}
