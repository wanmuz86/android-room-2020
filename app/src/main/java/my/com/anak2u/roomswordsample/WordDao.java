package my.com.anak2u.roomswordsample;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface WordDao {

    @Insert
    public void insert(Word word);

    @Query("DELETE FROM word_table")
    public void deleteAll();

    @Query("SELECT * FROM word_table")
    public LiveData<List<Word>> getAllWords();

    @Query("SELECT * FROM word_table WHERE mId=:id")
    public LiveData<Word> getWordById(Integer id);

    @Delete
    public void deleteById(Integer id);
}
