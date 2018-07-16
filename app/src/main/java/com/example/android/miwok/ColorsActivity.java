package com.example.android.miwok;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ColorsActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        final ArrayList<Word> words = new ArrayList<Word>();
        words.add(new Word("colors", "boje", R.mipmap.color_colors2, R.raw.one));
        words.add(new Word("red", "Crvene", R.mipmap.color_red, R.raw.one));
        words.add(new Word("yellow", "Žute", R.mipmap.color_mustard_yellow, R.raw.one));
        words.add(new Word("green", "Zelene", R.mipmap.color_green, R.raw.one));
        words.add(new Word("brown", "Smeđe", R.mipmap.color_brown, R.raw.one));
        words.add(new Word("gray", "Sive", R.mipmap.color_gray, R.raw.one));
        words.add(new Word("black", "Crne", R.mipmap.color_black, R.raw.one));
        words.add(new Word("white", "bijel", R.mipmap.color_white, R.raw.one));
        words.add(new Word("blue", "Narandžaste", R.mipmap.color_blue111, R.raw.one));

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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast.makeText(getApplicationContext(), "sound", Toast.LENGTH_SHORT).show();
                Word word = words.get(i);
                mediaPlayer = MediaPlayer.create(ColorsActivity.this, word.getAudioResourceId());
                mediaPlayer.start();
            }
        });

    }
}
