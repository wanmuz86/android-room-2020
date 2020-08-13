package my.com.anak2u.roomswordsample;

import android.app.Application;

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

    void insert(Word word){

    }

    void delete(Integer id){

    }
    void deleteAll(){
        
    }

}
