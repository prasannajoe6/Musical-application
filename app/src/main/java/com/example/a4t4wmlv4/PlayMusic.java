package com.example.a4t4wmlv4;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;

public class PlayMusic extends Service {
    public PlayMusic() {
        MediaPlayer music = MediaPlayer.create(this,R.raw.background);
        music.start();
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}
