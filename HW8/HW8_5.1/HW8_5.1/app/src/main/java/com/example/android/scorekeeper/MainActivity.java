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

package com.example.android.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/***
 * Main Activity for the Scorekeeper app, which keeps score for any game
 * involving two teams. The user can increment or decrement the score
 * for each team using Button views.
 */
public class MainActivity extends AppCompatActivity {
    // Member variables for the two score TextView elements
    private ImageView battery;
    //private ImageView image;
    private int imageLevel = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the TextViews by ID
        battery = findViewById(R.id.imageView);
        battery.setImageLevel(imageLevel);
        /*
        image = findViewById(R.id.battery_image);
        image.setImageLevel(imageLevel);
         */
    }

    /**
     * Creates the night mode menu option.
     *
     * @param menu The menu in the action bar
     * @return True to display the menu, false to hide it
     */
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        // Change the label of the menu based on the state of the app.
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if(nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else{
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }


    /**
     * Handles options menu item clicks.
     *
     * @param item The item that was pressed
     * @return returns true since the item click wa handled
     */
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check if the correct item was clicked.
        if (item.getItemId() == R.id.night_mode) {
            // Get the night mode state of the app.
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            // Set the theme mode for the restarted activity.
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode
                        (AppCompatDelegate.MODE_NIGHT_YES);
            }
            // Recreate the activity for the theme change to take effect.
            recreate();
        }
        return true;
    }

    public void changeBatteryLevel(View view) {
        switch (view.getId()){
            case R.id.decreaseTeam1:
                if (imageLevel > 0){
                    imageLevel --;
                    battery.setImageLevel(imageLevel);
                }
                break;
            case R.id.increaseTeam1:
                if (imageLevel < 6){
                    imageLevel ++;
                    battery.setImageLevel(imageLevel);
                }
                break;
        }
    }
}