package mathlyMotors;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Random;

public class medium extends MainCode {

    public static int var1, var2, var3;
    public static String operation1, operation2;


    Random randVar = new Random();
    Random randOper = new Random();

    @Override
    public void questionGenerator () {
        this.operation1 = operationReturn(randOper);
        this.operation2 = operationReturn(randOper);
        this.var1 = randVar.nextInt(20) + 1;
        this.var2 = randVar.nextInt(20) + 1;
        this.var3 = randVar.nextInt(20) + 1;
    }

    public static int answer() {
        int ans;

        if (operation2.equals("x")) {
            ans = var2 * var3;
            if (operation1.equals("+"))
                ans = var1 + ans;
            else if (operation1.equals("-"))
                ans = var1 - ans;
            else
                ans = var1 * ans;
        }
        else {
            if (operation1.equals("+"))
                ans = var1 + var2;
            else if (operation1.equals("-"))
                ans = var1 - var2;
            else
                ans = var1 * var2;

            if (operation2.equals("+"))
                ans = ans + var3;
            else if (operation2.equals("-"))
                ans = ans - var3;
            else
                ans = ans * var3;
        }
        return ans;
    }

    public void refresh (TextField text, Button b1, Button b2, Button b3) {
        questionGenerator();
        text.setText((medium.var1) + medium.operation1 + (medium.var2) + medium.operation2 + (medium.var3));
        int[] options = medium.Options(medium.answer());
        b1.setText(Integer.toString(options[0]));
        b2.setText(Integer.toString(options[1]));
        b3.setText(Integer.toString(options[2]));
    }
}