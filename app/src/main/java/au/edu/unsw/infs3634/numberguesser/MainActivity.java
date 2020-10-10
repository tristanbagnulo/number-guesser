package au.edu.unsw.infs3634.numberguesser;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    //Create a random number at the beginning
    //RN - final TextView textGenerateNumber = (TextView)findViewById(R.id.idRandomNumber);
    // Declaring the input number, EditText and Button.
    int number;
    EditText numberInput;
    Button submitButton;

    //Best practice is to reference a string to send to ResultActivity as a public variable
    public static final String EXTRA_NUMBER_USER = "cau.edu.unsw.infs3634.numberguesser.EXTRA_NUMBER_USER";
    public static final String EXTRA_NUMBER_RANDOM = "cau.edu.unsw.infs3634.numberguesser.EXTRA_NUMBER_RANDOM";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Create and display the random number
        Random myRandom = new Random();
        final int randomNumber = myRandom.nextInt(100)+1;
            //TEMPORARY - Display random number in MainActivity

        TextView myText = (TextView)findViewById(R.id.idRandomNumber);
        String myString = String.valueOf(randomNumber);
        myText.setText(myString);

        /* DID NOT INCLUDE IN FINAL
        //Getting the number of guesses remaining from Result Act.
        // - create ResultActivity object
        ResultActivity obj1 = new ResultActivity();
        int numberOfGuesses = obj1.getNumberOfGuesses();
        // - pushing number of guesses left to text in MainActivity display
        TextView newText = (TextView)findViewById(R.id.idGuessesRemainingMain);
        String newString = String.valueOf("Guesses left: "+(5-numberOfGuesses));
        newText.setText(newString);
         */

        //Assign the EditText widget the user input to the variable "numberInput"
        numberInput = (EditText) findViewById(R.id.idNumberInput);
            // TO DO - Research "findViewByID" and how it works
            // TO DO Find out what this EditText class thing is
        //Assign Button widget to a the variable "submitButton".
        submitButton = (Button) findViewById(R.id.idSubmitButton);

        // Below we add an OnClickListener to allow us to react when the user clicks the
        // "Submit" button
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Create and error that shows when no number is added.
                if (numberInput.length()==0){
                    numberInput.setError("Please enter a number");
                } else {
                    //Assign submitted number to the variable "number"
                    number = Integer.valueOf(numberInput.getText().toString());
                    //Launch the ResultActivity which determines whether number is equal,
                    // higher or lower, and shows a result
                    launchResultActivity(randomNumber);
                }
            }
        });
    }

    private void launchResultActivity(int randomNumber){
        //Specifying information to sent. This links the user's input number to a variable
        // "editText1"
        EditText editText1 = (EditText) findViewById(R.id.idNumberInput);
        //Now the user's input is an integer
        int number = Integer.parseInt(editText1.getText().toString());
        //Now send this above int to the ResultActivity
        // Step 1: Create Intent object and assign it to the variable "intent"
        Intent intent = new Intent(this, ResultActivity.class);
        // Step 2: send the number that the user input and the randomNumber
        intent.putExtra(EXTRA_NUMBER_USER, number);
        intent.putExtra(EXTRA_NUMBER_RANDOM, randomNumber);
        startActivity(intent);
    }
}