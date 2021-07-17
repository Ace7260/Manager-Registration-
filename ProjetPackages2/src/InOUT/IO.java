package InOUT;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class IO {
    private static BufferedReader in = null;

    static {
        in = new BufferedReader(new InputStreamReader(System.in));
    }

    public static int setINT(String message) {
        int value_int = 0;
        String value_s = "";
        System.out.print(message);
        do {
            try {
                value_s = in.readLine();
                value_int = Integer.parseInt(value_s);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException ex) {
                System.err.print("please set an integer here");
            }
        } while (true);
        return value_int;
    }

    public static int setFLOAT(String message) {
        int value_float = 0;
        String value_s = "";
        System.out.print(message);
        do {
            try {
                value_s = in.readLine();
                value_float = Integer.parseInt(value_s);
                break;
            } catch (IOException e) {
                e.printStackTrace();
            } catch (NumberFormatException ex) {
                System.err.print("please set an float here");
            }
        } while (true);
        return value_float;
    }

    public static String setString(String message) {
        String value_s = "";
        System.out.print(message);
        try {
            value_s = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value_s;
    }
}
