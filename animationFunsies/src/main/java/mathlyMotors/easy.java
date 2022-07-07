package mathlyMotors;

import java.util.Random;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class easy extends MainCode {


    public static int var1, var2;
    public static String operation1;


    Random randVar = new Random();
    Random randOper = new Random();

    @Override
    public void questionGenerator() {
        operation1 = operationReturn(randOper);
        var1 = randVar.nextInt(20) + 1;
        var2 = randVar.nextInt(20) + 1;
    }

    public static int answer() {
        int ans;
        if (operation1.equals("+"))
            ans = var1 + var2;
        else if (operation1.equals("-"))
            ans = var1 - var2;
        else
            ans = var1 * var2;
        return ans;
    }


    public void refresh (TextField text, Button b1, Button b2, Button b3) {
        questionGenerator();
        text.setText((easy.var1) + easy.operation1 + (easy.var2));
        int[] options = Options(easy.answer());
        b1.setText(Integer.toString(options[0]));
        b2.setText(Integer.toString(options[1]));
        b3.setText(Integer.toString(options[2]));
    }



}