import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;


public class DatabaseConnection extends SQLiteOpenHelper {

    public DatabaseConnection(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name: "Login.db", factory: null, version: 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("Create table user(Name text , Usernmae text , Email text primary key,Password text,Phoneno text,Address text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        db.execSQL("drop table if exists user");
    }
    //inserting in database
}
