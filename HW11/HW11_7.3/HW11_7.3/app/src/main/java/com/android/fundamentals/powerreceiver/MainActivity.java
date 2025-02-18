/*
 * Copyright (C) 2018 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.android.fundamentals.powerreceiver;

import android.arch.core.BuildConfig;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.Random;

/**
 * The Power Receiver app responds to system broadcasts about the power
 * connected state as well as a custom broadcast that is sent when the user
 * taps the button.
 */
public class MainActivity extends AppCompatActivity {

    private CustomReceiver mReceiver = new CustomReceiver();

    private static final String EXTRA_RANDOM_NUMBER = "com.android.fundamentals.powerreceiver.RANDOM_NUMBER";
    // String constant that defines the custom broadcast Action.
    private static final String ACTION_CUSTOM_BROADCAST =
            BuildConfig.APPLICATION_ID + ".ACTION_CUSTOM_BROADCAST";
    private TextView View_Number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        View_Number = findViewById(R.id.textView);

        // Define the IntentFilter.
        IntentFilter filter = new IntentFilter();
        // Add system broadcast actions sent by the system when the power is
        // connected and disconnected.
        filter.addAction(Intent.ACTION_POWER_CONNECTED);
        filter.addAction(Intent.ACTION_POWER_DISCONNECTED);

        // Register the receiver using the activity context, passing in the
        // IntentFilter.
        this.registerReceiver(mReceiver, filter);

        // Register the receiver to receive custom broadcast.
        LocalBroadcastManager.getInstance(this).registerReceiver
                (mReceiver, new IntentFilter(ACTION_CUSTOM_BROADCAST));
    }

    /**
     * Click event handler for the button, that sends custom broadcast using the
     * LocalBroadcastManager.
     */
    public void sendCustomBroadcast(View view) {
        Intent customBroadcastIntent = new Intent(ACTION_CUSTOM_BROADCAST);
        int num = RandomNumber();
        View_Number.setText(String.valueOf(num));
        customBroadcastIntent.putExtra(EXTRA_RANDOM_NUMBER, String.valueOf(num));
        LocalBroadcastManager.getInstance(this)
                .sendBroadcast(customBroadcastIntent);
    }

    /**
     * Unregisters the broadcast receivers when the app is destroyed.
     */
    @Override
    protected void onDestroy() {
        // Unregister the receivers.
        this.unregisterReceiver(mReceiver);
        LocalBroadcastManager.getInstance(this).unregisterReceiver(mReceiver);
        super.onDestroy();
    }

    public int RandomNumber() {
        Random random_num = new Random();
        return random_num.nextInt(20) + 1;
    }
}
