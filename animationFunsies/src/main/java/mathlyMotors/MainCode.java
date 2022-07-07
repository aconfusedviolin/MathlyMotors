package mathlyMotors;

import javafx.scene.control.Button;

import java.util.Random;

import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public abstract class MainCode {

    public static int aiDistanceTravelled = 0;
    public static int userDistanceTravelled = 0;

    abstract void questionGenerator();

    abstract void refresh(TextField text, Button b1, Button b2, Button b3);

    public String operationReturn(Random random) {
        int operationNo = random.nextInt(3);
        if (operationNo == 0)
            return "+";
        else if (operationNo == 1)
            return "-";
        else
            return "x";
    }

    public static int[] Options(int ans) {
        int op1, op2, op3;
        int[] temp = new int[3];
        int[] ops = new int[3];
        Random randomOption = new Random();
        op1 = ans;
        op2 = randomOption.nextInt(10) + ans - 5;
        op3 = randomOption.nextInt(10) + ans - 5;
        int i = randomOption.nextInt(3);
        int j = 0;
        temp[0] = op1;
        temp[1] = op2;
        temp[2] = op3;
        while (j <= 2) {
            ops[i] = temp[j];
            i++;
            j++;
            if (i > 2)
                i = 0;
        }
        if (ops[0] == ops[1] || ops[1] == ops[2] || ops[0] == ops[2])
            return Options(ans);
        return (ops);
    }


    public void movement(Button btn, int ans, ImageView userCar, ImageView aiCar) {
        if (btn.getText().equals(Integer.toString(ans))) {
            this.userDistanceTravelled += 3;
            userCar.setX(userDistanceTravelled*50);
        } else {
            this.userDistanceTravelled += 1;
            userCar.setX(userDistanceTravelled*50);
        }
        this.aiDistanceTravelled += 2;
        aiCar.setX(aiDistanceTravelled*50);
    }

    public void result (Button btime, Button ans1, Button ans2, Button ans3, Button Ready, Button replayButton, TextField tf, Text replayQuestion, ImageView playerCar, ImageView aiCar, Button returnBtn) {
        if (userDistanceTravelled >= 20 && aiDistanceTravelled >= 20) {
            tf.setText("TIED!");
        }
        else if (easy.userDistanceTravelled >= 20 && easy.aiDistanceTravelled < 20) {
            tf.setText("YOU WON!");
        }
        else if (easy.aiDistanceTravelled >= 20 && easy.userDistanceTravelled < 20){
            tf.setText("YOU LOST!");
        }
        btime.setText("Timer");
        ans1.setDisable(true);
        ans2.setDisable(true);
        ans3.setDisable(true);
        replayQuestion.setVisible(true);
        replayButton.setVisible(true);
        returnBtn.setVisible(true);
        replayButton.setOnAction(ee -> {
            playerCar.setX(0);
            aiCar.setX(0);
            tf.setText("Let's get ready to race!");
            ans1.setDisable(true);
            ans2.setDisable(true);
            ans3.setDisable(true);
            ans1.setText("");
            ans2.setText("");
            ans3.setText("");
            Ready.setVisible(true);
            replayButton.setVisible(false);
            replayQuestion.setVisible(false);
        });
        easy.userDistanceTravelled = 0;
        easy.aiDistanceTravelled = 0;
        playerCar.setX(0);
        aiCar.setX(0);
        ans1.setText("");
        ans2.setText("");
        ans3.setText("");
    }

}
