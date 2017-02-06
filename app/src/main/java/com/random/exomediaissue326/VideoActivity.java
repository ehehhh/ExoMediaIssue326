package com.random.exomediaissue326;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.devbrackets.android.exomedia.listener.OnCompletionListener;
import com.devbrackets.android.exomedia.listener.OnErrorListener;
import com.devbrackets.android.exomedia.listener.OnPreparedListener;
import com.devbrackets.android.exomedia.ui.widget.EMVideoView;

public class VideoActivity extends AppCompatActivity {

	private EMVideoView videoView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_video);
		videoView = (EMVideoView) findViewById(R.id.video_view);
		videoView.postDelayed(new Runnable() {
			@Override
			public void run() {
				preparePlayer();
			}
		}, 500);
	}

	private void preparePlayer() {
		videoView.setOnCompletionListener(new OnCompletionListener() {
			@Override
			public void onCompletion() {
				finish();
			}
		});
		videoView.setOnErrorListener(new OnErrorListener() {
			@Override
			public boolean onError() {
				finish();
				return false;
			}
		});
		videoView.setOnPreparedListener(new OnPreparedListener() {
			@Override
			public void onPrepared() {
				videoView.start();
			}
		});
		videoView.setVideoURI(Uri.parse("file:///storage/emulated/0/issue326_test_video.mp4"));
	}
}
