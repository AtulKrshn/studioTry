package com.example.studiotry;

import android.os.Build;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.net.Uri;
import android.os.Bundle;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;


import android.Manifest;
import android.content.pm.PackageManager;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;



//
//public class MainActivity extends AppCompatActivity {
//
//    private ExoPlayer exoPlayer;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Initialize ExoPlayer
//        exoPlayer = new ExoPlayer.Builder(this).build();
//
//        // Bind the player to the view
//        PlayerView playerView = findViewById(R.id.player_view);
//        playerView.setPlayer(exoPlayer);
//
//        // Create a media item (e.g., from a URL or local file)
//        Uri mediaUri = Uri.parse("https://www.example.com/media.mp4"); // Replace with your media URL
//        MediaItem mediaItem = MediaItem.fromUri(mediaUri);
//
//        // Set the media item to the player
//        exoPlayer.setMediaItem(mediaItem);
//        exoPlayer.prepare();
//        exoPlayer.play();
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        // Release the player when the activity is destroyed
//        if (exoPlayer != null) {
//            exoPlayer.release();
//            exoPlayer = null;
//        }
//    }
//}




import android.Manifest;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.Log;
import android.view.WindowManager;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.ui.PlayerView;


//2nd iteration
//public class MainActivity extends AppCompatActivity {
//
//    private ExoPlayer exoPlayer;
//    private PlayerView playerView;
//    private static final int REQUEST_CODE_STORAGE_PERMISSION = 100;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Check and request storage permission
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE_PERMISSION);
//        } else {
//            initializePlayer();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_CODE_STORAGE_PERMISSION) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                initializePlayer();
//            } else {
//                Toast.makeText(this, "Storage permission denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void initializePlayer() {
//        // Initialize PlayerView
//        playerView = findViewById(R.id.player_view);
//
//        // Initialize ExoPlayer
//        exoPlayer = new ExoPlayer.Builder(this).build();
//
//        // Bind the player to the view
//        playerView.setPlayer(exoPlayer);
//
//        // Specify the exact path to your local file
//        String filePath = "/storage/emulated/0/Movies/Screenrecord/screen-20250224-115118.mp4"; // Replace with your file path
//        Uri mediaUri = Uri.parse(filePath);
//
//        // Create a media item
//        MediaItem mediaItem = MediaItem.fromUri(mediaUri);
//
//        // Set the media item to the player
//        exoPlayer.setMediaItem(mediaItem);
//        exoPlayer.prepare();
//        exoPlayer.play();
//
//        // Add listener for debugging
//        exoPlayer.addListener(new Player.Listener() {
//            @Override
//            public void onPlayerError(PlaybackException error) {
//                Log.e("ExoPlayer", "Playback error: " + error.getMessage());
//            }
//
//            @Override
//            public void onPlaybackStateChanged(int playbackState) {
//                switch (playbackState) {
//                    case Player.STATE_IDLE:
//                        Log.d("ExoPlayer", "Player is idle");
//                        break;
//                    case Player.STATE_BUFFERING:
//                        Log.d("ExoPlayer", "Player is buffering");
//                        break;
//                    case Player.STATE_READY:
//                        Log.d("ExoPlayer", "Player is ready");
//                        break;
//                    case Player.STATE_ENDED:
//                        Log.d("ExoPlayer", "Player has ended playback");
//                        break;
//                }
//            }
//        });
//    }
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (exoPlayer != null) {
//            exoPlayer.release();
//            exoPlayer = null;
//        }
//    }
//}
// 2nd iteration ends here





import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;

//public class MainActivity extends AppCompatActivity {
//
//    private static final int REQUEST_CODE_STORAGE_PERMISSION = 100;
//    private static final int REQUEST_CODE_MEDIA_VIDEO_PERMISSION = 101;
//    private static final int REQUEST_CODE_SELECTED_PHOTOS_ACCESS = 102;
//
//    private ExoPlayer exoPlayer;
//    private PlayerView playerView;
//    private static final int REQUEST_CODE_MEDIA_PERMISSION = 100;
//    private static final int PICK_VIDEO_REQUEST = 101;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        // Check and request media permission
//        if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VIDEO) != PackageManager.PERMISSION_GRANTED) {
//            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_VIDEO}, REQUEST_CODE_MEDIA_PERMISSION);
//        } else {
//            initializePlayer();
//        }
//    }
//
//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//        if (requestCode == REQUEST_CODE_MEDIA_PERMISSION) {
//            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
//                initializePlayer();
//            } else {
//                Toast.makeText(this, "Media permission denied", Toast.LENGTH_SHORT).show();
//            }
//        }
//    }
//
//    private void initializePlayer() {
//        // Initialize PlayerView
//        playerView = findViewById(R.id.player_view);
//
//        // Initialize ExoPlayer
//        exoPlayer = new ExoPlayer.Builder(this).build();
//
//        // Bind the player to the view
//        playerView.setPlayer(exoPlayer);
//
//        // Get the media URI using MediaStore
//        Uri mediaUri = getMediaUri();
//        if (mediaUri != null) {
//            MediaItem mediaItem = MediaItem.fromUri(mediaUri);
//            exoPlayer.setMediaItem(mediaItem);
//            exoPlayer.prepare();
//            exoPlayer.play();
//        } else {
//            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
//        }
//    }
//
//    private Uri getMediaUri() {
//        ContentResolver contentResolver = getContentResolver();
//        Uri mediaUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
//        String[] projection = {MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME};
//        String selection = MediaStore.Video.Media.DISPLAY_NAME + "=?";
//        String[] selectionArgs = new String[]{"video.mp4"}; // Replace with your file name
//
//        Cursor cursor = contentResolver.query(mediaUri, projection, selection, selectionArgs, null);
//        if (cursor != null && cursor.moveToFirst()) {
//            int idColumn = cursor.getColumnIndex(MediaStore.Video.Media._ID);
//            long id = cursor.getLong(idColumn);
//            cursor.close();
//            return ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
//        }
//        return null;
//    }
//
//
//    private void requestMediaPermissions() {
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
//            // Android 14+: Request Selected Photos Access
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED}, REQUEST_CODE_SELECTED_PHOTOS_ACCESS);
//            } else {
//                initializePlayer();
//            }
//        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
//            // Android 13: Request READ_MEDIA_VIDEO
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VIDEO) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_VIDEO}, REQUEST_CODE_MEDIA_VIDEO_PERMISSION);
//            } else {
//                initializePlayer();
//            }
//        } else {
//            // Android 10 to 12: Request READ_EXTERNAL_STORAGE
//            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
//                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE_PERMISSION);
//            } else {
//                initializePlayer();
//            }
//        }
//    }
//
//
//
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        if (exoPlayer != null) {
//            exoPlayer.release();
//            exoPlayer = null;
//        }
//    }
//}



//3rd iteration


import android.Manifest;
import android.content.ContentResolver;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.PlayerView;
import android.content.ContentUris;

public class MainActivity extends AppCompatActivity {

    private ExoPlayer exoPlayer;
    private PlayerView playerView;
    private static final int REQUEST_CODE_STORAGE_PERMISSION = 100;
    private static final int REQUEST_CODE_MEDIA_VIDEO_PERMISSION = 101;
    private static final int REQUEST_CODE_SELECTED_PHOTOS_ACCESS = 102;
    private static final int PICK_VIDEO_REQUEST = 103;

    private PowerManager.WakeLock wakeLock;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize PlayerView
        playerView = findViewById(R.id.player_view);

        // Initialize ExoPlayer
        exoPlayer = new ExoPlayer.Builder(this).build();

        // Bind the player to the view
        playerView.setPlayer(exoPlayer);

        // Handle the intent
        Intent intent = getIntent();
        if (intent != null && intent.getAction() != null && intent.getAction().equals(Intent.ACTION_VIEW)) {
            // Get the video URI from the intent
            Uri videoUri = intent.getData();
            if (videoUri != null) {
                // Play the video
                MediaItem mediaItem = MediaItem.fromUri(videoUri);
                exoPlayer.setMediaItem(mediaItem);
                exoPlayer.prepare();
                exoPlayer.play();
            } else {
                Toast.makeText(this, "No video file found", Toast.LENGTH_SHORT).show();
            }
        } else {
            // If no intent is provided, request media permissions
            requestMediaPermissions();
        }


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        PowerManager powerManager = (PowerManager) getSystemService(POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "ExoPlayerApp::WakeLock");




    }




    @Override
    protected void onResume () {
        super.onResume();
        // Acquire WakeLock when the activity is resumed
        if (wakeLock != null && !wakeLock.isHeld()) {
            wakeLock.acquire();
        }
    }


    @Override
    protected void onPause() {
        super.onPause();
        // Release WakeLock when the activity is paused
        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
    }








    private void requestMediaPermissions() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.UPSIDE_DOWN_CAKE) {
            // Android 14+: Request Selected Photos Access
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_VISUAL_USER_SELECTED}, REQUEST_CODE_SELECTED_PHOTOS_ACCESS);
            } else {
                initializePlayer();
            }
        } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            // Android 13: Request READ_MEDIA_VIDEO
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_MEDIA_VIDEO) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_MEDIA_VIDEO}, REQUEST_CODE_MEDIA_VIDEO_PERMISSION);
            } else {
                initializePlayer();
            }
        } else {
            // Android 10 to 12: Request READ_EXTERNAL_STORAGE
            if (ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE}, REQUEST_CODE_STORAGE_PERMISSION);
            } else {
                initializePlayer();
            }
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            switch (requestCode) {
                case REQUEST_CODE_STORAGE_PERMISSION:
                case REQUEST_CODE_MEDIA_VIDEO_PERMISSION:
                case REQUEST_CODE_SELECTED_PHOTOS_ACCESS:
                    initializePlayer();
                    break;
            }
        } else {
            Toast.makeText(this, "Permission denied", Toast.LENGTH_SHORT).show();
        }
    }

    private void initializePlayer() {
        // Initialize PlayerView
        playerView = findViewById(R.id.player_view);

        // Initialize ExoPlayer
        exoPlayer = new ExoPlayer.Builder(this).build();

        // Bind the player to the view
        playerView.setPlayer(exoPlayer);

        // Get the media URI using MediaStore
        Uri mediaUri = getMediaUri();
        if (mediaUri != null) {
            MediaItem mediaItem = MediaItem.fromUri(mediaUri);
            exoPlayer.setMediaItem(mediaItem);
            exoPlayer.prepare();
            exoPlayer.play();
        } else {
            Toast.makeText(this, "File not found", Toast.LENGTH_SHORT).show();
        }
    }

    private Uri getMediaUri() {
        ContentResolver contentResolver = getContentResolver();
        Uri mediaUri = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
        String[] projection = {MediaStore.Video.Media._ID, MediaStore.Video.Media.DISPLAY_NAME};
        String selection = MediaStore.Video.Media.DISPLAY_NAME + "=?";
        String[] selectionArgs = new String[]{"275178656_301156092115755_164512639396298451_n.mp4"}; // Replace with your file name

        Cursor cursor = contentResolver.query(mediaUri, projection, selection, selectionArgs, null);
        if (cursor != null) {
            if (cursor.moveToFirst()) {
                int idColumn = cursor.getColumnIndex(MediaStore.Video.Media._ID);
                long id = cursor.getLong(idColumn);
                cursor.close();
                return ContentUris.withAppendedId(MediaStore.Video.Media.EXTERNAL_CONTENT_URI, id);
            }
            cursor.close();
        }
        return null;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (exoPlayer != null) {
            exoPlayer.release();
            exoPlayer = null;
        }

        // Release WakeLock when the activity is destroyed

        if (wakeLock != null && wakeLock.isHeld()) {
            wakeLock.release();
        }
    }




//    275178656_301156092115755_164512639396298451_n.mp4
}