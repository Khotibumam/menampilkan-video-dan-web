package com.example.menmpungvideo;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.ProgressBar;
import android.widget.VideoView;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class MainActivity extends AppCompatActivity {
    private PlayerView vv;
    private  ProgressBar progress;
    private SimpleExoPlayer player;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         vv = findViewById(R.id.videoView);
         progress =findViewById(R.id.progressBar);
    }

    public void play(View view) {
        initialize();
        DefaultBandwidthMeter meter= new DefaultBandwidthMeter();
        DataSource.Factory factory=new DefaultDataSourceFactory(this,"PlayVideo",meter);
        MediaSource source= new ExtractorMediaSource.Factory(factory).createMediaSource(Uri.parse("http://commondatastorage.googleapis.com/gtv-videos-bucket/sample/ElephantsDream.mp4"));

      player.prepare(source);
        player.getPlayWhenReady();
    }
    private void initialize(){
        if (player ==null){
            player = ExoPlayerFactory.newSimpleInstance(new DefaultRenderersFactory(this),
            new DefaultTrackSelector(),new DefaultLoadControl());

            vv.setPlayer(player);
        }
    }
}
