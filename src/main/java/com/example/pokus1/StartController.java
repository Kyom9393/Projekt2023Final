package com.example.pokus1;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.*;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class StartController implements Initializable{

    private int wordCounter = 0;
    private int first = 1;

    private File saveData;


    //?
    ScheduledExecutorService executor = Executors.newScheduledThreadPool(1);


    @FXML
    public Text seconds;
    @FXML
    private Text wordsPerMin;
    @FXML
    private Text accuracy;
    @FXML
    private Text programWord;
    @FXML
    private Text secondProgramWord;

    @FXML
    private TextField userWord;

    @FXML
    private ImageView correct;
    @FXML
    private ImageView wrong;

    @FXML
    private Button playAgain;

    @FXML
    private Label outputLabel;

    ArrayList<String> words = new ArrayList<>();

    public void addToList() {
        BufferedReader reader;
        try {
            reader = new BufferedReader(new
                    FileReader("words.txt"));
            String line = reader.readLine();
            while (line != null) {
                words.add(line);
                line = reader.readLine();
            }
            reader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void toMainMenu(ActionEvent ae) throws IOException {
        HelloApplication ha = new HelloApplication();
        ha.changeScene("hello-view.fxml");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        playAgain.setVisible(false);
        playAgain.setDisable(true);
        seconds.setText("60");
        addToList();
        Collections.shuffle(words);
        programWord.setText(words.get(wordCounter));
        secondProgramWord.setText(words.get(wordCounter+1));
        wordCounter++;

        Date date = new Date();
        //Ukládání dat
        //Soubor se uloží ve formátu:
        //datum, čas + ... + .txt
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH-mm-ss");
        saveData = new File("src/data/"+formatter.format(date).strip()+".txt");

        try {
            if (saveData.createNewFile()) {
                System.out.println("File created: " + saveData.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    //Nastavit na 59
    private int timer = 59;


    //Runnable object r
    Runnable r = new Runnable() {
        @Override
        public void run() {
            if (timer > -1) {
                seconds.setText(String.valueOf(timer));
                timer -= 1;
            }

            else {
                if (timer == -1) {

                    //Uživatel nemůže psát do textového pole
                    userWord.setDisable(true);

                    //Nastaví text, když vyprší časovač
                    userWord.setText("Time's up");

                    try {
                        FileWriter myWriter = new FileWriter(saveData);
                        myWriter.write(countAll +";");
                        myWriter.write(counter +";");
                        myWriter.write(String.valueOf(countAll-counter));
                        myWriter.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                if (timer == -2) {
                    playAgain.setVisible(true);
                    playAgain.setDisable(false);

                    PrintWriter writer = null;
                    try {
                        writer = new PrintWriter("keystrokes.txt");
                    } catch (FileNotFoundException e) {
                        throw new RuntimeException(e);
                    }
                    writer.print("");
                    writer.close();

                    executor.shutdown();
                }

                timer -= 1;
            }
        }
    };



    private int countAll = 0;
    private int counter = 0;


    //Popis promennych:
    //Variable 'first' = je to poprvé co uživatel spustil hru?

    public void startGame(KeyEvent ke) {
        //Key event = pokaždé, když uživatel stiskne tlačítko event se zavolá
        //Timer and file writing
        if (first == 1) {
            first = 0;
            executor.scheduleAtFixedRate(r, 0, 1, TimeUnit.SECONDS);
        }

        if (ke.getCode().equals(KeyCode.ENTER)) {

            String s = userWord.getText();
            String real = programWord.getText();
            countAll++;

            //Pokud je slovo správně...
            //Přište se slovo do WMP
            if (s.equals(real)) {
                counter++;
                wordsPerMin.setText(String.valueOf(counter));

                try {
                    FileWriter myWriter = new FileWriter("keystrokes.txt", true);
                    myWriter.write(String.valueOf(userWord.getText().length() + "\n"));
                    myWriter.close();

                } catch (IOException e) {
                    e.printStackTrace();
                }

                double sum = 0.0;
                try {
                    BufferedReader reader = new BufferedReader(new FileReader("keystrokes.txt"));
                    String line;
                    while ((line = reader.readLine()) != null) {
                        sum += Double.parseDouble(line);
                    }
                    reader.close();
                } catch (IOException e) {
                    System.err.println("Error reading file: " + e.getMessage());
                } catch (NumberFormatException e) {
                    System.err.println("Invalid number format: " + e.getMessage());
                }

                outputLabel.setText(String.valueOf(Math.round(sum)));

                //Nastaví se obrázek

            }

            //Pokud slovo není zadané správně...
            //Nastaví se obrázek "wrong"
            else {
                //Nastavení obrázku
                //Nastavení obrázku
            }

            //"vymazat" textové pole
            userWord.setText("");
            //Přesnost: slova napsané správně děleno všemi slovy * 100 = procenta
            accuracy.setText(String.valueOf(Math.round((counter*1.0/countAll)*100)));
            programWord.setText(words.get(wordCounter));

            //V druhém poli se zobrazí druhé slovo (další) ze souboru "words.txt"
            secondProgramWord.setText(words.get(wordCounter+1));
            wordCounter++;
        }

    }
}
