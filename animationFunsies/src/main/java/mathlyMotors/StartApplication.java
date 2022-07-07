package mathlyMotors;

/*
Code by Ammar Minhas (aminhas@oakland.edu, ammar2003.abid@gmail.com)
and Mara Salem (marasalem@oakland.edu, marasalem333@gmail.com

Resource credit goes to:
https://opengameart.org/content/8-bit-chiptune-car-chase
https://opengameart.org/content/driving-in-the-rain
    Composer: İlker Yalçıner (ilkeryalciner.com)
https://opengameart.org/content/winning-the-race
https://wallpaperaccess.com/city-pixel-art
 */

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import javafx.scene.image.Image;
import javafx.scene.control.Button;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.media.Media;
import java.net.URISyntaxException;
import java.util.Objects;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import static java.util.concurrent.TimeUnit.SECONDS;

public class StartApplication extends Application {
    @Override
    public void start(Stage startStage) throws URISyntaxException {

        //Backgrounds, images, and music initialization

        Text title = new Text("Mathly Motors");
        TextField coders = new TextField("By Ammar Minhas and Mara Salem (AM&AM's)");
        Button htp = new Button("How to Play");
        Button hide = new Button("Hide How to Play");
        htp.setLayoutX(0);
        htp.setLayoutY(0);
        hide.setVisible(false);

        TextArea howToPlay = new TextArea("How to play: Race as a cool blue car against an AI along the city night! " +
                "\nClick on a button to select 1 of 3 game modes, Easy, Medium, or Hard." +
                "\nIn each mode, you will be answering a range of math questions to" +
                "\nadvance your car forward. To answer the question prompted, click on" +
                "\nthe button with the corresponding answer. Every correct answer" +
                "\nadvances both your car and the AI- but if you answer incorrectly," +
                "\nthe AI will move farther than you. Also, you will have a limit" +
                "\nof 10 seconds to answer. Failing to answer will result in the AI" +
                "\nmoving forward. Do your best to make it to the end first!" +
                "\nto get rid of these instructions, press the button Hide.");

        title.setFont(Font.font("Comic Sans MS", 75));
        title.setX(250);
        title.setY(150);

        coders.setFont(Font.font("Comic Sans MS", 20));
        coders.setLayoutX(275);
        coders.setLayoutY(250);
        coders.setPrefSize(460,50);
        coders.setEditable(false);

        howToPlay.setFont(Font.font("Comic Sans MS", 13));
        howToPlay.setLayoutX(0);
        howToPlay.setLayoutY(0);
        howToPlay.setPrefSize(450,195);
        howToPlay.setEditable(false);
        howToPlay.setVisible(false);

        htp.setOnAction(e -> {
            howToPlay.setVisible(true);
            hide.setVisible(true);
        });

        hide.setOnAction(e -> {
            howToPlay.setVisible(false);
            hide.setVisible(false);
        });

        hide.setLayoutX(100);
        hide.setLayoutY(250);

        Image startBackground = new Image(Objects.requireNonNull(getClass().getResource("/cityscape.png")).toURI().toString());
        Image gameBackground = new Image(Objects.requireNonNull(getClass().getResource("/gameBack1.jpg")).toURI().toString());
        Image gameBackground2 = new Image(Objects.requireNonNull(getClass().getResource("/gameBack2.png")).toURI().toString());
        Image gameBackground3 = new Image(Objects.requireNonNull(getClass().getResource("/gameBack3.jpg")).toURI().toString());
        Image car1 = new Image(Objects.requireNonNull(getClass().getResource("/car1.png")).toURI().toString());
        Image car2 = new Image(Objects.requireNonNull(getClass().getResource("/car2.png")).toURI().toString());


        ImageView backgroundImage = new ImageView(startBackground);
        ImageView gameBack1 = new ImageView(gameBackground);
        ImageView gameBack2 = new ImageView(gameBackground2);
        ImageView gameBack3 = new ImageView(gameBackground3);
        ImageView playerCar = new ImageView(car1);
        ImageView aiCar = new ImageView(car2);

        backgroundImage.setX(0);
        backgroundImage.setY(0);
        backgroundImage.setFitHeight(800);
        backgroundImage.setFitWidth(985);

        gameBack1.setX(0);
        gameBack1.setY(0);
        gameBack1.setFitHeight(800);
        gameBack1.setFitWidth(1000);

        gameBack2.setX(0);
        gameBack2.setY(0);
        gameBack2.setFitHeight(760);
        gameBack2.setFitWidth(1000);


        gameBack3.setX(0);
        gameBack3.setY(0);
        gameBack3.setFitHeight(800);
        gameBack3.setFitWidth(1000);

        /* This section builds the pane for the starting scene, which includes buttons for game modes
        which allows users to choose their difficulty and whether they would like to play music or not
        */


        startStage.setWidth(1000);
        startStage.setHeight(750);
        startStage.setMaxHeight(750);
        startStage.setMaxWidth(1000);
        startStage.setTitle("Mathly Motors");

        Group startPane = new Group();

        Button Easy = new Button("Easy");
        Button Medium = new Button("Medium");
        Button Hard = new Button("Hard");
        Button ReadyEasy = new Button ("Let's Race!");
        Button ReadyMedium = new Button ("Let's Race!");
        Button ReadyHard = new Button ("Let's Race!");
        Button btime = new Button("Timer");

        btime.setShape(new Circle(150));
        btime.setMinSize(75,75);
        btime.setMaxSize(75, 75);
        btime.setLayoutX(455);
        btime.setLayoutY(300);
        btime.setFont(Font.font("Comic Sans MS", 15));
        btime.setPrefSize(75, 50);

        Easy.setPrefSize(100, 50);
        Easy.setLayoutX(150);
        Easy.setLayoutY(550);
        Easy.setFont(Font.font("Comic Sans MS", 15));

        Medium.setPrefSize(100, 50);
        Medium.setLayoutX(450);
        Medium.setLayoutY(550);
        Medium.setFont(Font.font("Comic Sans MS", 15));

        Hard.setPrefSize(100, 50);
        Hard.setLayoutX(750);
        Hard.setLayoutY(550);
        Hard.setFont(Font.font("Comic Sans MS", 15));

        ReadyEasy.setPrefSize(100, 50);
        ReadyEasy.setLayoutX(650);
        ReadyEasy.setLayoutY(350);
        ReadyEasy.setFont(Font.font("Comic Sans MS", 15));

        ReadyMedium.setPrefSize(100,50);
        ReadyMedium.setLayoutX(650);
        ReadyMedium.setLayoutY(350);
        ReadyMedium.setFont(Font.font("Comic Sans MS", 15));


        ReadyHard.setPrefSize(100,50);
        ReadyHard.setLayoutX(650);
        ReadyHard.setLayoutY(350);
        ReadyHard.setFont(Font.font("Comic Sans MS", 15));

        startPane.getChildren().add(backgroundImage);
        startPane.getChildren().add(Easy);
        startPane.getChildren().add(Medium);
        startPane.getChildren().add(Hard);
        startPane.getChildren().add(title);
        startPane.getChildren().add(coders);
        startPane.getChildren().add(howToPlay);
        startPane.getChildren().add(htp);
        startPane.getChildren().add(hide);

        Scene startScene = new Scene(startPane, 1250, 700);

        startStage.setScene(startScene);
        startStage.show();

        /* This section contains building nodes for each game mode screen, once a mode button is pressed it adds children
        to the game mode's group. On pressing return to start, the nodes are removed from the pane so that they can be reused
        within other modes. */

        Media music1 = new Media(Objects.requireNonNull(getClass().getResource("/S31_Winning_the_Race.mp3")).toURI().toString());
        MediaPlayer musicPlayer1 = new MediaPlayer(music1);

        MediaView mediaView = new MediaView(musicPlayer1);
        ((Group)startScene.getRoot()).getChildren().add(mediaView);

        Media music2 = new Media(Objects.requireNonNull(getClass().getResource("/car_chase.mp3")).toURI().toString());
        MediaPlayer musicPlayer2 = new MediaPlayer(music2);

        MediaView mediaView2 = new MediaView(musicPlayer2);
        ((Group)startScene.getRoot()).getChildren().add(mediaView2);

        Media music3 = new Media(Objects.requireNonNull(getClass().getResource("/Driving In The Rain_0.mp3")).toURI().toString());
        MediaPlayer musicPlayer3 = new MediaPlayer(music3);

        MediaView mediaView3 = new MediaView(musicPlayer3);
        ((Group)startScene.getRoot()).getChildren().add(mediaView3);


        TextField tf = new TextField("Are you ready to race?");

        Text replayQuestion = new Text("Do you want to play this mode again?\nIf yes, click yes.\nOtherwise, click return.");
        Button replayButton = new Button("Yes.");

        tf.setFont(Font.font("Comic Sans MS", 25));
        tf.setLayoutX(300);
        tf.setLayoutY(150);
        tf.setPrefSize(350,50);
        tf.setEditable(false);

        replayQuestion.setLayoutX(675);
        replayQuestion.setLayoutY(150);
        replayQuestion.setVisible(false);
        replayQuestion.setFill(Color.WHITE);
        replayQuestion.setFont(Font.font("Comic Sans MS", 15));

        replayButton.setLayoutX(750);
        replayButton.setLayoutY(265);
        replayButton.setPrefSize(75,50);
        replayButton.setVisible(false);
        replayButton.setFont(Font.font("Comic Sans MS", 15));

        playerCar.setX(0);
        playerCar.setY(650);
        playerCar.setFitHeight(150);
        playerCar.setFitWidth(150);
        playerCar.setPreserveRatio(true);

        aiCar.setX(0);
        aiCar.setY(605);
        aiCar.setFitHeight(150);
        aiCar.setFitWidth(150);
        aiCar.setPreserveRatio(true);

        Button ans1 = new Button();
        ans1.setPrefSize(100, 50);
        ans1.setFont(Font.font("Comic Sans MS", 15));
        ans1.setLayoutX(250);
        ans1.setLayoutY(450);

        Button ans2 = new Button();
        ans2.setPrefSize(100, 50);
        ans2.setFont(Font.font("Comic Sans MS", 15));
        ans2.setLayoutX(450);
        ans2.setLayoutY(450);

        Button ans3 = new Button();
        ans3.setPrefSize(100, 50);
        ans3.setFont(Font.font("Comic Sans MS", 15));
        ans3.setLayoutX(650);
        ans3.setLayoutY(450);

        //Easy mode screen

        Group easyPane = new Group();

        Button returnBtn1 = new Button("Return to mode selection.");
        returnBtn1.setLayoutX(0);
        returnBtn1.setLayoutY(0);
        returnBtn1.setFont(Font.font("Comic Sans MS", 15));

        Scene easyScreen = new Scene(easyPane, 1000, 850);

        Easy.setOnAction(e -> {
            easyPane.getChildren().add(gameBack1);
            easyPane.getChildren().add(ReadyEasy);
            easyPane.getChildren().add(btime);
            aiCar.setY(565);
            easyPane.getChildren().add(replayButton);
            easyPane.getChildren().add(replayQuestion);
            easyPane.getChildren().add(returnBtn1);
            easyPane.getChildren().add(tf);
            easyPane.getChildren().add(playerCar);
            easyPane.getChildren().add(aiCar);
            easyPane.getChildren().add(ans3);
            easyPane.getChildren().add(ans2);
            easyPane.getChildren().add(ans1);
            startStage.setScene(easyScreen);

            ReadyEasy.setVisible(true);
        });


        returnBtn1.setOnAction(e -> {
            musicPlayer1.stop();
            startStage.setScene(startScene);

            easyPane.getChildren().remove(btime);
            easyPane.getChildren().remove(gameBack1);
            easyPane.getChildren().remove(ReadyEasy);
            easyPane.getChildren().remove(replayButton);
            easyPane.getChildren().remove(replayQuestion);
            easyPane.getChildren().remove(returnBtn1);
            easyPane.getChildren().remove(tf);
            easyPane.getChildren().remove(playerCar);
            musicPlayer1.stop();
            playerCar.setX(0);
            aiCar.setX(0);
            aiCar.setY(600);
            tf.setText("Let's get ready to race!");
            replayButton.setVisible(false);
            replayQuestion.setVisible(false);
            ans1.setDisable(false);
            ans2.setDisable(false);
            ans3.setDisable(false);
            ans1.setText("");
            ans2.setText("");
            ans3.setText("");
            easyPane.getChildren().remove(aiCar);
            easyPane.getChildren().remove(ans3);
            easyPane.getChildren().remove(ans2);
            easyPane.getChildren().remove(ans1);
            easyPane.getChildren().remove(ReadyEasy);
        });


        //Medium mode Screen

        Group mediumPane = new Group();

        Button returnBtn2 = new Button("Return to mode selection.");
        returnBtn2.setLayoutX(0);
        returnBtn2.setLayoutY(0);
        returnBtn2.setFont(Font.font("Comic Sans MS", 15));

        Scene mediumScreen = new Scene(mediumPane, 1000, 850);

        Medium.setOnAction(e -> {
            mediumPane.getChildren().add(gameBack2);
            mediumPane.getChildren().add(ReadyMedium);
            mediumPane.getChildren().add(btime);
            mediumPane.getChildren().add(replayButton);
            mediumPane.getChildren().add(replayQuestion);
            mediumPane.getChildren().add(returnBtn2);
            mediumPane.getChildren().add(tf);
            mediumPane.getChildren().add(playerCar);
            aiCar.setY(555);
            mediumPane.getChildren().add(aiCar);
            ReadyMedium.setVisible(true);
            mediumPane.getChildren().add(ans3);
            mediumPane.getChildren().add(ans2);
            mediumPane.getChildren().add(ans1);
            startStage.setScene(mediumScreen);

        });

        returnBtn2.setOnAction(e -> {
            musicPlayer2.stop();
            aiCar.setY(605);
            startStage.setScene(startScene);

            mediumPane.getChildren().remove(btime);
            mediumPane.getChildren().remove(gameBack2);
            mediumPane.getChildren().remove(ReadyMedium);
            mediumPane.getChildren().remove(replayButton);
            mediumPane.getChildren().remove(replayQuestion);
            replayButton.setVisible(false);
            replayQuestion.setVisible(false);
            mediumPane.getChildren().remove(returnBtn2);
            mediumPane.getChildren().remove(tf);
            mediumPane.getChildren().remove(playerCar);
            playerCar.setX(0);
            aiCar.setX(0);
            tf.setText("Let's get ready to race!");
            ans1.setDisable(false);
            ans2.setDisable(false);
            ans3.setDisable(false);
            ans1.setText("");
            ans2.setText("");
            ans3.setText("");
            mediumPane.getChildren().remove(aiCar);
            mediumPane.getChildren().remove(ans3);
            mediumPane.getChildren().remove(ans2);
            mediumPane.getChildren().remove(ans1);
            mediumPane.getChildren().remove(ReadyMedium);
        });


        //Hard mode Screen

        Group hardPane = new Group();

        Button returnBtn3 = new Button("Return to mode selection.");
        returnBtn3.setLayoutX(0);
        returnBtn3.setLayoutY(0);
        returnBtn3.setFont(Font.font("Comic Sans MS", 15));

        returnBtn3.setOnAction(e -> {
            startStage.setScene(startScene);

            hardPane.getChildren().remove(btime);
            hardPane.getChildren().remove(gameBack3);
            hardPane.getChildren().remove(ReadyHard);
            hardPane.getChildren().remove(replayButton);
            hardPane.getChildren().remove(replayQuestion);
            hardPane.getChildren().remove(returnBtn3);
            hardPane.getChildren().remove(tf);
            hardPane.getChildren().remove(playerCar);
            musicPlayer3.stop();
            playerCar.setX(0);
            aiCar.setX(0);
            aiCar.setY(600);
            tf.setText("Let's get ready to race!");
            ans1.setDisable(false);
            ans2.setDisable(false);
            ans3.setDisable(false);
            ans1.setText("");
            ans2.setText("");
            ans3.setText("");
            hardPane.getChildren().remove(aiCar);
            hardPane.getChildren().remove(ans3);
            hardPane.getChildren().remove(ans2);
            hardPane.getChildren().remove(ans1);
            replayButton.setVisible(false);
            replayQuestion.setVisible(false);
            hardPane.getChildren().remove(ReadyHard);
        });

        Scene hardScreen = new Scene(hardPane, 1000, 850);

        Hard.setOnAction(e -> {
            hardPane.getChildren().add(gameBack3);
            hardPane.getChildren().add(ReadyHard);
            hardPane.getChildren().add(btime);
            hardPane.getChildren().add(replayButton);
            hardPane.getChildren().add(replayQuestion);
            hardPane.getChildren().add(returnBtn3);
            hardPane.getChildren().add(tf);
            aiCar.setY(545);
            hardPane.getChildren().add(playerCar);
            hardPane.getChildren().add(aiCar);
            hardPane.getChildren().add(ans3);
            hardPane.getChildren().add(ans2);
            hardPane.getChildren().add(ans1);
            startStage.setScene(hardScreen);
            ReadyHard.setVisible(true);
        });


        easy easy = new easy();
        medium medium = new medium();
        hard hard = new hard();

        ReadyEasy.setOnAction(e -> {
            ReadyEasy.setVisible(false);
            returnBtn1.setVisible(false);
            ans1.setDisable(false);
            ans2.setDisable(false);
            ans3.setDisable(false);
            musicPlayer1.play();
            try {
                var ref = new Object() {
                    int ans;
                };
                easy.refresh(tf, ans1, ans2, ans3);
                ref.ans = easy.answer();
                final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                final Runnable runnable = new Runnable() {
                    int countdownStarter = 10;
                    public void run() {
                        Platform.runLater(() -> {
                            ans1.setOnAction(e -> {
                                easy.movement(ans1, ref.ans, playerCar, aiCar);
                                if (easy.userDistanceTravelled >= 20 || easy.aiDistanceTravelled >= 20) {
                                    easy.result(btime, ans1, ans2, ans3, ReadyEasy, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn1);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    easy.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = easy.answer();
                                }
                            });
                            ans2.setOnAction(e -> {
                                easy.movement(ans2, ref.ans, playerCar, aiCar);
                                if (easy.userDistanceTravelled >= 20 || easy.aiDistanceTravelled >= 20) {
                                    easy.result(btime, ans1, ans2, ans3, ReadyEasy, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn1);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    easy.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = easy.answer();
                                }
                            });
                            ans3.setOnAction(e -> {
                                easy.movement(ans3, ref.ans, playerCar, aiCar);
                                if (easy.userDistanceTravelled >= 20 || easy.aiDistanceTravelled >= 20) {
                                    easy.result(btime, ans1, ans2, ans3, ReadyEasy, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn1);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    easy.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = easy.answer();
                                }
                            });

                            btime.setText(Integer.toString(countdownStarter--));

                            if (countdownStarter == -2) {
                                easy.aiDistanceTravelled += 2;
                                aiCar.setX(easy.aiDistanceTravelled * 50);

                                if (easy.aiDistanceTravelled >= 20) {
                                    tf.setText("YOU LOST!");
                                    btime.setText("-3");
                                    easy.result(btime, ans1, ans2, ans3, ReadyEasy, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn1);
                                    ans1.setDisable(true);
                                    ans2.setDisable(true);
                                    ans3.setDisable(true);
                                    easy.userDistanceTravelled = 0;
                                    easy.aiDistanceTravelled = 0;
                                    playerCar.setX(0);
                                    aiCar.setX(0);
                                    ans1.setText("");
                                    ans2.setText("");
                                    ans3.setText("");
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    easy.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = easy.answer();
                                    btime.setText(Integer.toString(countdownStarter--));
                                }
                            }
                        });
                    }
                };
                scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
            }
            catch (Exception error) {};
        });

        ReadyMedium.setOnAction(e -> {
            ReadyMedium.setVisible(false);
            returnBtn2.setVisible(false);
            ans1.setDisable(false);
            ans2.setDisable(false);
            ans3.setDisable(false);
            musicPlayer2.play();
            try {
                var ref = new Object() {
                    int ans;
                };
                medium.refresh(tf, ans1, ans2, ans3);
                ref.ans = medium.answer();
                final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                final Runnable runnable = new Runnable() {
                    int countdownStarter = 10;
                    public void run() {
                        Platform.runLater(() -> {
                            ans1.setOnAction(e -> {
                                medium.movement(ans1, ref.ans, playerCar, aiCar);
                                if (medium.userDistanceTravelled >= 20 || medium.aiDistanceTravelled >= 20) {
                                    medium.result(btime, ans1, ans2, ans3, ReadyMedium, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn2);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    medium.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = medium.answer();
                                }
                            });
                            ans2.setOnAction(e -> {
                                medium.movement(ans2, ref.ans, playerCar, aiCar);
                                if (medium.userDistanceTravelled >= 20 || medium.aiDistanceTravelled >= 20) {
                                    medium.result(btime, ans1, ans2, ans3, ReadyMedium, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn2);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    medium.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = medium.answer();
                                }
                            });
                            ans3.setOnAction(e -> {
                                medium.movement(ans3, ref.ans, playerCar, aiCar);
                                if (medium.userDistanceTravelled >= 20 || medium.aiDistanceTravelled >= 20) {
                                    medium.result(btime, ans1, ans2, ans3, ReadyMedium, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn2);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    medium.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = medium.answer();
                                }
                            });

                            btime.setText(Integer.toString(countdownStarter--));

                            if (countdownStarter == -2) {
                                medium.aiDistanceTravelled += 2;
                                aiCar.setX(medium.aiDistanceTravelled * 50);

                                if (medium.aiDistanceTravelled >= 20) {
                                    tf.setText("YOU LOST!");
                                    btime.setText("-3");
                                    medium.result(btime, ans1, ans2, ans3, ReadyMedium, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn2);
                                    ans1.setDisable(true);
                                    ans2.setDisable(true);
                                    ans3.setDisable(true);
                                    medium.userDistanceTravelled = 0;
                                    medium.aiDistanceTravelled = 0;
                                    playerCar.setX(0);
                                    aiCar.setX(0);
                                    ans1.setText("");
                                    ans2.setText("");
                                    ans3.setText("");
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    medium.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = medium.answer();
                                    btime.setText(Integer.toString(countdownStarter--));
                                }
                            }

                        });

                    }
                };
                scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
            }

            catch (Exception error) {};

        });

        ReadyHard.setOnAction(e -> {
            ReadyHard.setVisible(false);
            returnBtn3.setVisible(false);
            ans1.setDisable(false);
            ans2.setDisable(false);
            ans3.setDisable(false);
            musicPlayer3.play();
            try {
                var ref = new Object() {
                    int ans;
                };
                hard.refresh(tf, ans1, ans2, ans3);
                ref.ans = hard.answer();
                final ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(1);
                final Runnable runnable = new Runnable() {
                    int countdownStarter = 10;
                    public void run() {
                        Platform.runLater(() -> {
                            ans1.setOnAction(e -> {
                                hard.movement(ans1, ref.ans, playerCar, aiCar);
                                if (hard.userDistanceTravelled >= 20 || hard.aiDistanceTravelled >= 20) {
                                    hard.result(btime, ans1, ans2, ans3, ReadyHard, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn3);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    hard.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = hard.answer();
                                }
                            });
                            ans2.setOnAction(e -> {
                                hard.movement(ans2, ref.ans, playerCar, aiCar);
                                if (hard.userDistanceTravelled >= 20 || hard.aiDistanceTravelled >= 20) {
                                    hard.result(btime, ans1, ans2, ans3, ReadyHard, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn3);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    hard.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = hard.answer();
                                }
                            });
                            ans3.setOnAction(e -> {
                                hard.movement(ans3, ref.ans, playerCar, aiCar);
                                if (hard.userDistanceTravelled >= 20 || hard.aiDistanceTravelled >= 20) {
                                    hard.result(btime, ans1, ans2, ans3, ReadyHard, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn3);
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    hard.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = hard.answer();
                                }
                            });

                            btime.setText(Integer.toString(countdownStarter--));

                            if (countdownStarter == -2) {
                                hard.aiDistanceTravelled += 2;
                                aiCar.setX(hard.aiDistanceTravelled * 50);

                                if (hard.aiDistanceTravelled >= 20) {
                                    tf.setText("YOU LOST!");
                                    btime.setText("-3");
                                    hard.result(btime, ans1, ans2, ans3, ReadyHard, replayButton, tf, replayQuestion, playerCar, aiCar, returnBtn3);
                                    ans1.setDisable(true);
                                    ans2.setDisable(true);
                                    ans3.setDisable(true);
                                    hard.userDistanceTravelled = 0;
                                    hard.aiDistanceTravelled = 0;
                                    playerCar.setX(0);
                                    aiCar.setX(0);
                                    ans1.setText("");
                                    ans2.setText("");
                                    ans3.setText("");
                                    scheduler.shutdown();
                                } else {
                                    countdownStarter = 10;
                                    hard.refresh(tf, ans1, ans2, ans3);
                                    ref.ans = hard.answer();
                                    btime.setText(Integer.toString(countdownStarter--));
                                }
                            }

                        });

                    }
                };
                scheduler.scheduleAtFixedRate(runnable, 0, 1, SECONDS);
            }

            catch (Exception error) {};

        });



    }

    public static void main(String[] args) {
        launch();
    }

}

