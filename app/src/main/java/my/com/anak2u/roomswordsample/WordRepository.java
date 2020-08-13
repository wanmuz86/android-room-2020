package my.com.anak2u.roomswordsample;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class WordRepository {
    private WordDao mWordDao;
    private LiveData<List<Word>> mWords;

    WordRepository(Application context){
        WordRoomDatabase db = WordRoomDatabase.getDatabase(context);
        mWordDao = db.wordDao();
        mWords = mWordDao.getAllWords();

    }

    LiveData<List<Word>> getAllWords(){
        return mWords;
    }

//    LiveData<Word> getWordById(Int id){
//        return
//    }

    // But when you do database modification, from example, insert, update or delete.. -> It has to be done on background..
    // How do you do in background -> AsyncTask
    void insert(Word word){
    new insertAsyncTask(this.mWordDao).execute(word);
    }

    void delete(Word word){

    }
    void deleteAll(){

    }


    private class insertAsyncTask extends AsyncTask<Word, Void,Void>{
        private WordDao mWordDao;

        insertAsyncTask(WordDao wordDao){
            this.mWordDao = wordDao;
        }

        @Override
        protected Void doInBackground(Word... words) {
            mWordDao.insert(words[0]);
            return null;
        }
    }


}
