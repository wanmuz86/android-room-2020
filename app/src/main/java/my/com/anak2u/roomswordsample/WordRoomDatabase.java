package my.com.anak2u.roomswordsample;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

/// This class is implementing singleton pattern ensure that there is only a single connection to the database...


// If you add other Entities, Define it here
//Change the version here
@Database(entities = {Word.class}, version = 1, exportSchema = false)
public abstract class WordRoomDatabase extends RoomDatabase {

    // If you add other Dao, define it here..
    public abstract WordDao wordDao();
    private static WordRoomDatabase INSTANCE;

    static WordRoomDatabase getDatabase(final Context context){
        if (INSTANCE == null){
            synchronized (WordRoomDatabase.class){

                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            WordRoomDatabase.class, "word_database")
                            .fallbackToDestructiveMigration()
                            .build();

                    // Add or modify the migration code here (fallbackToDesctructiveMigration)
                }

        }
        return  INSTANCE;
    }

}
