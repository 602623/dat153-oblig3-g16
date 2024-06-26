package dat153.g16.oblig3.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import dat153.g16.oblig3.MyApp;
import dat153.g16.oblig3.R;
import dat153.g16.oblig3.model.QuestionRepo;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get the components (buttons)
        Button startQuiz = findViewById(R.id.start_quiz);
        Button addPhoto = findViewById(R.id.add_photo);

        startQuiz.setOnClickListener(v -> {
            MyApp app = (MyApp) getApplication();
            app.resetScore();

            // Mark all questions as unanswered
            QuestionRepo.getInstance(getApplication()).resetAll();

            // Redirect to the quiz-activity
            Intent intent = new Intent(this, QuizActivity.class);
            startActivity(intent);
        });

        // Redirect to the gallery-activity
        addPhoto.setOnClickListener(v -> {
            Intent intent = new Intent(this, GalleryActivity.class);
            startActivity(intent);
        });
    }
}