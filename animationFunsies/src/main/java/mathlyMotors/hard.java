package mathlyMotors;

import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Random;

public class hard extends MainCode {

    public static int var1, var2, var3, var4;
    public static String operation1, operation2, operation3;


    Random randVar = new Random();
    Random randOper = new Random();

    @Override
    public void questionGenerator () {
        this.operation1 = operationReturn(randOper);
        this.operation2 = operationReturn(randOper);
        this.operation3 = operationReturn(randOper);
        this.var1 = randVar.nextInt(20) + 1;
        this.var2 = randVar.nextInt(20) + 1;
        this.var3 = randVar.nextInt(20) + 1;
        this.var4 = randVar.nextInt(20) + 1;
    }

    public static int answer() {
        int ans, temp;
        if (operation2.equals("x") && !operation3.equals("x")) {
            ans = var2 * var3;

            if (operation1.equals("+"))
                ans = var1 + ans;
            else if (operation1.equals("-"))
                ans = var1 - ans;
            else
                ans = var1 * ans;

            if (operation3.equals("+"))
                ans = ans + var4;
            else if (operation3.equals("-"))
                ans = ans - var4;
            else
                ans = ans * var4;
        }

        else if (!operation2.equals("x") && operation3.equals("x")) {
            ans = var3 * var4;

            if (operation1.equals("+"))
                temp = var1 + var2;
            else if (operation1.equals("-"))
                temp = var1 - var2;
            else
                temp = var1 * var2;

            if (operation2.equals("+"))
                ans = temp + ans;
            else if (operation2.equals("-"))
                ans = temp - ans;
            else
                ans = temp * ans;
        }

        else if (operation2.equals("x") && operation3.equals("x")) {
            ans = var2 * var3;
            ans = ans * var4;

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

            if (operation3.equals("+"))
                ans = ans + var4;
            else if (operation3.equals("-"))
                ans = ans - var4;
            else
                ans = ans * var4;
        }

        return ans;
    }

    public void refresh (TextField text, Button b1, Button b2, Button b3) {
        questionGenerator();
        text.setText((hard.var1) + hard.operation1 + (hard.var2) + hard.operation2 + (hard.var3) + hard.operation3 + (hard.var4));
        int[] options = hard.Options(hard.answer());
        b1.setText(Integer.toString(options[0]));
        b2.setText(Integer.toString(options[1]));
        b3.setText(Integer.toString(options[2]));
    }

}