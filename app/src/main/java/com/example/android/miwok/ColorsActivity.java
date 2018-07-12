package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("colors", "boje", R.mipmap.color_colors2));
        words.add(new Word("red", "Crvene", R.mipmap.color_red));
        words.add(new Word("yellow", "Žute", R.mipmap.color_mustard_yellow));
        words.add(new Word("green", "Zelene", R.mipmap.color_green));
        words.add(new Word("brown", "Smeđe", R.mipmap.color_brown));
        words.add(new Word("gray", "Sive", R.mipmap.color_gray));
        words.add(new Word("black", "Crne", R.mipmap.color_black));
        words.add(new Word("white", "bijel", R.mipmap.color_white));
        words.add(new Word("blue", "Narandžaste", R.mipmap.color_blue111));

        // Create an {@link WordAdapter}, whose data source is a list of {@link Word}s. The
        // adapter knows how to create list items for each item in the list.
        WordAdapter adapter = new WordAdapter(this, words, R.color.category_colors);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml layout file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link WordAdapter} we created above, so that the
        // {@link ListView} will display list items for each {@link Word} in the list.
        listView.setAdapter(adapter);

    }
}
