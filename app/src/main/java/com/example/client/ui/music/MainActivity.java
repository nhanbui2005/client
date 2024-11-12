package com.example.client.ui.music;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Button;
import android.widget.SeekBar;
import androidx.appcompat.app.AppCompatActivity;

import com.example.client.R;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private SeekBar seekBar;
    private Button playPauseButton, prevButton, nextButton, repeatButton, shuffleButton;
    private Handler handler = new Handler();
    private boolean isShuffle = false;
    private boolean isRepeat = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Mapping UI components
        seekBar = findViewById(R.id.seekBar);
        playPauseButton = findViewById(R.id.playPauseButton);
        prevButton = findViewById(R.id.prevButton);
        nextButton = findViewById(R.id.nextButton);
        repeatButton = findViewById(R.id.repeatButton);
        shuffleButton = findViewById(R.id.shuffleButton);

        // Set up MediaPlayer and SeekBar
        //mediaPlayer = MediaPlayer.create(this, R.raw.buong_doi_tay_nhau_ra); // Add a music file in res/raw
        seekBar.setMax(mediaPlayer.getDuration());

        // Play/Pause button functionality
        playPauseButton.setOnClickListener(v -> {
            if (mediaPlayer.isPlaying()) {
                mediaPlayer.pause();
                playPauseButton.setText("▶️");
            } else {
                mediaPlayer.start();
                playPauseButton.setText("⏸️");
                updateSeekBar();
            }
        });

        // Previous button functionality
        prevButton.setOnClickListener(v -> playPrevious());

        // Next button functionality
        nextButton.setOnClickListener(v -> playNext());

        // Repeat button functionality
        repeatButton.setOnClickListener(v -> {
            isRepeat = !isRepeat;
            mediaPlayer.setLooping(isRepeat); // Enable looping in MediaPlayer
            repeatButton.setText(isRepeat ? "🔂" : "🔁");
        });

        // Shuffle button functionality
        shuffleButton.setOnClickListener(v -> {
            isShuffle = !isShuffle;
            shuffleButton.setText(isShuffle ? "🔀 On" : "🔀 Off");
        });

        // SeekBar listener to update progress
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                if (fromUser) {
                    mediaPlayer.seekTo(progress);
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {}

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {}
        });
    }

    private void playPrevious() {
        // Logic for previous song
    }

    private void playNext() {
        // Logic for next song
    }

    private void updateSeekBar() {
        seekBar.setProgress(mediaPlayer.getCurrentPosition());
        if (mediaPlayer.isPlaying()) {
            handler.postDelayed(this::updateSeekBar, 1000);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mediaPlayer != null) {
            mediaPlayer.release();
            mediaPlayer = null;
        }
    }
}
