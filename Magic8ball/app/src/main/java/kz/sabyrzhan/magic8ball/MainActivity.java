package kz.sabyrzhan.magic8ball;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private static final Random RANDOM = new Random(System.currentTimeMillis());

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.askButton);
        ImageView image = findViewById(R.id.image);
        int[] imageIds = {
                R.drawable.ball1,
                R.drawable.ball2,
                R.drawable.ball3,
                R.drawable.ball4,
                R.drawable.ball5
        };

        button.setOnClickListener(event -> {
            Log.i("Magic8", "Ask button pressed");
            int randomId = RANDOM.nextInt(5);
            image.setImageResource(imageIds[randomId]);
        });
    }
}