package ru.mirea.muratov.thread;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView textViewAve;
    LessonCounter lessonCounter;
    Handler handler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textViewAve = findViewById(R.id.text_lessons_ave);
        handler = new Handler() {
            public void handleMessage(android.os.Message msg) {
                textViewAve.setText(String.valueOf(msg.obj));
            };
        };
    }


    public void onClickCalculate(View view) {
        lessonCounter = new LessonCounter(handler);
        lessonCounter.start();
    }
}