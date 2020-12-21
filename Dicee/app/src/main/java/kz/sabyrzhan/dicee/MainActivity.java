package kz.sabyrzhan.dicee;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = findViewById(R.id.button_roll);
        ImageView leftDice = findViewById(R.id.image_leftDice);
        ImageView rightDice = findViewById(R.id.image_rightDice);

        int[] diceArray = new int[] {
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6
        };

        rollButton.setOnClickListener(v -> {
            Log.d("Dicee", "Roll button pressed");

            Random random = new Random();
            int leftDiceRandomNumber = random.nextInt(6);
            int rightDiceRandomNumber = random.nextInt(6);
            leftDice.setImageResource(diceArray[leftDiceRandomNumber]);
            rightDice.setImageResource(diceArray[rightDiceRandomNumber]);
        });

    }
}