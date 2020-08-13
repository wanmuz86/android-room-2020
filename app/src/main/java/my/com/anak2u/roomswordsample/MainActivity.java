package my.com.anak2u.roomswordsample;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               Intent intent = new Intent(MainActivity.this,
                       AddActivity.class);

               // This is required because we expect AddActivity
                // to pass back the
                // info entered on second page..
                // Then we will save that info on the database...
                // We create a subActivity in thi scenario
               startActivityForResult(intent,1);

            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        CustomAdapter adapter = new CustomAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.CustomViewHolder> {

        public List<Word> words = new ArrayList<>();
        @NonNull
        @Override
        //onCreateViewHolder in the Adaptor
        public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            return new CustomViewHolder(LayoutInflater.from(viewGroup.getContext()), viewGroup);
        }


        @Override
        public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
            holder.wordTextView.setText(words.get(position).getWord());
            holder.sentenceTextView.setText(words.get(position).getSentence());
        }

        @Override
        public int getItemCount() {
            return words.size();
        }

        public class CustomViewHolder extends RecyclerView.ViewHolder {
            private TextView wordTextView, sentenceTextView;
            public CustomViewHolder(LayoutInflater inflater, ViewGroup parent) {
                super(inflater.inflate(R.layout.custom_row, parent, false));
                wordTextView = itemView.findViewById(R.id.wordTextView);
                sentenceTextView = itemView.findViewById(R.id.defTextView);
            }

        }
    }
}
