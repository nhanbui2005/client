package com.example.client.ui.music;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.client.R;

public class MusicPlayerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_player);

        // Tham chiếu các thành phần
        ImageButton playPauseButton = findViewById(R.id.playPauseButton);
        ImageButton prevButton = findViewById(R.id.prevButton);
        ImageButton nextButton = findViewById(R.id.nextButton);
        TextView lyricsTextView = findViewById(R.id.lyricsTextView);

        // Sự kiện cho nút Play/Pause
        playPauseButton.setOnClickListener(v -> {
            // Logic phát/tạm dừng nhạc
        });

        // Sự kiện cho nút Previous
        prevButton.setOnClickListener(v -> {
            // Logic bài trước
        });

        // Sự kiện cho nút Next
        nextButton.setOnClickListener(v -> {
            // Logic bài tiếp theo
        });
    }
}
