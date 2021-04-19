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

package com.example.android.recyclerview;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class MainActivity extends AppCompatActivity {

    private LinkedList<String> RecTitles = new LinkedList<>();
    private LinkedList<String> RecDess = new LinkedList<>();

    private void fileReader(InputStream input, LinkedList<String> output) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(input));

        try {
            String line;
            while ((line = reader.readLine()) != null)
                output.addLast(line);
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        
        fileReader(getResources().openRawResource(R.raw.recipe_titles), RecTitles);
        fileReader(getResources().openRawResource(R.raw.recipe_descriptions), RecDess);

        Recyclerview Adapter = new Recyclerview(this, RecTitles, RecDess);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        recyclerView.setAdapter(Adapter);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
