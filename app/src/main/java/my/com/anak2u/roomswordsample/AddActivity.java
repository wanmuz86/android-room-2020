package my.com.anak2u.roomswordsample;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AddActivity extends AppCompatActivity {
EditText wordEditText, sentenceEditText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        wordEditText = findViewById(R.id.wordEditText);
        sentenceEditText = findViewById(R.id.sentenceEditText);


    }

    // THere are 3 ways for you to create onClick
    // 1) Adding on View
    // 2) By creating class new OnClicklistener (verify MainActivity)
    // 3) Implementing OnClickListener -> Is the most recommended one

    // What is the code for no 3?
    public void savePressed(View view) {
        String word = wordEditText.getText().toString();
        String sentence = sentenceEditText.getText().toString();
        Intent replyIntent = new Intent();
        replyIntent.putExtra("word",word);
        replyIntent.putExtra("sentence",sentence);
        setResult(RESULT_OK, replyIntent);
        finish();
    }
}
