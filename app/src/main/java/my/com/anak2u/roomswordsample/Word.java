package my.com.anak2u.roomswordsample;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName="word_table")
public class Word {
    @PrimaryKey(autoGenerate = true)
    public int mId;
    @NonNull
    public String mWord;
    public String mSentence;

    public Word(@NonNull String mWord, String mSentence) {
        this.mWord = mWord;
        this.mSentence = mSentence;
    }

    public int getId() {
        return mId;
    }

    public String getWord() {
        return mWord;
    }

    public String getSentence() {
        return mSentence;
    }
}
