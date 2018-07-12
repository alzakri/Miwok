package com.example.android.miwok;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.ArrayList;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        // Create a list of words
        ArrayList<Word> words = new ArrayList<Word>();

        words.add(new Word("one","jedan", R.mipmap.number_one));
        words.add(new Word("two","dva", R.mipmap.number_two));
        words.add(new Word("three","tri", R.mipmap.number_three));
        words.add(new Word("four","četiri", R.mipmap.number_four));
        words.add(new Word("five","pet", R.mipmap.number_five));
        words.add(new Word("six","šest", R.mipmap.number_six));
        words.add(new Word("seven","sedam", R.mipmap.number_seven));
        words.add(new Word("eight","osam", R.mipmap.number_eight));
        words.add(new Word("nine","devet", R.mipmap.number_nine));
        words.add(new Word("ten","Deset", R.mipmap.number_ten));

        // Create an {@link ArrayAdapter}, whose data source is a list of Strings. The
        // adapter knows how to create layouts for each item in the list, using the
        // simple_list_item_1.xml layout resource defined in the Android framework.
        // This list item layout contains a single {@link TextView}, which the adapter will set to
        // display a single word.
        WordAdapter adapter =
                new WordAdapter(this, words , R.color.category_numbers);

        // Find the {@link ListView} object in the view hierarchy of the {@link Activity}.
        // There should be a {@link ListView} with the view ID called list, which is declared in the
        // word_list.xml file.
        ListView listView = (ListView) findViewById(R.id.list);

        // Make the {@link ListView} use the {@link ArrayAdapter} we created above, so that the
        // {@link ListView} will display list items for each word in the list of words.
        // Do this by calling the setAdapter method on the {@link ListView} object and pass in
        // 1 argument, which is the {@link ArrayAdapter} with the variable name itemsAdapter.
        listView.setAdapter(adapter);

    }
}
