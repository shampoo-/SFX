/*
 * Copyright (C) 2014 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.shampooo0o.sfx;

import android.app.Activity;
import android.media.MediaPlayer;
import android.net.Uri;
import android.nfc.Tag;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

/*
 * Google Assistant  activity class that loads LeanbackDetailsFragment class
 */
public class GoogleAssistantActivity extends Activity {
    private static final String TAG = "GoogleAssistantActivity";
    public static final String SHARED_ELEMENT_NAME = "hero";
    public static final String DEMO = "Demo";

    private VideoView mVideoView;
    /**
     * Called when the activity is first created.
     */
    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.googleassistant_demo);
        mVideoView = (VideoView) findViewById(R.id.googleassistant_fragment);
        //mVideoView.setMediaController(new MediaController(this));
        Log.d(TAG, "start VideoView");
        // Set local video file with path
        mVideoView.setVideoURI(Uri.parse("android.resource://" + this.getPackageName() +
        //        "/" + R.raw.loop_listening));
                "/" + R.raw.what_can_you_do));
        Log.d(TAG, "Duration " + mVideoView.getDuration());
        mVideoView.start();

        // 再生完了通知リスナー
        mVideoView.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mediaPlayer) {
                //TODO: ループ？
                mVideoView.seekTo(0);
                mVideoView.start();
            }
        });

        // 再生中にキー操作で別トリガー
        mVideoView.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                switch (keyEvent.getAction()){
                    case KeyEvent.KEYCODE_DPAD_DOWN:
                        onDown();
                        break;
                    case KeyEvent.KEYCODE_DPAD_UP:
                        onUp();
                        break;
                    case KeyEvent.KEYCODE_DPAD_DOWN_LEFT:
                        onLeft();
                        break;
                    case KeyEvent.KEYCODE_DPAD_RIGHT:
                        onRight();
                        break;
                    default:
                        break;
                }
                return false;
            }
        });
    }

    void onDown() {
        Log.d(TAG, "KeyEvent DOWN");
    }

    void onUp() {
        Log.d(TAG, "KeyEvent UP");
    }

    void onLeft() {
        Log.d(TAG, "KeyEvent LEFT");
    }

    void onRight() {
        Log.d(TAG, "KeyEvent RIGHT");
    }

}

