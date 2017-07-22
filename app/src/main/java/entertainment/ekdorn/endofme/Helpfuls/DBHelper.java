package entertainment.ekdorn.endofme.Helpfuls;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.HashMap;

public class DBHelper extends SQLiteOpenHelper {
    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "GameProgress";
    public static final String MY_TABLE = "CurrentGame";
    public static final String KEY_ID = "_id";
    public static final String KEY_TITLE = "keyTitle";
    public static final String KEY_VALUE = "keyValue";

    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_NOTES_TABLE = "CREATE TABLE " + MY_TABLE + "("
                + KEY_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + KEY_TITLE + " VALCHAR, "
                + KEY_VALUE + " VALCHAR" + ")";
        db.execSQL(CREATE_NOTES_TABLE);
    }

    public DBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + MY_TABLE);
        onCreate(db);
    }

    public void addRec(String title, Object value) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(KEY_TITLE, title);
        values.put(KEY_VALUE, value.toString());
        //System.out.println(values);
        db.insert(MY_TABLE, null, values);
        db.close();
    }

    public HashMap<String, String> getValueList() {
        HashMap<String, String> value = new HashMap<>();
        String selectQuery = "SELECT * FROM " + MY_TABLE;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                value.put(cursor.getString(1), cursor.getString(2));
            } while (cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return value;
    }

    public void deleteAll() {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(MY_TABLE, null, null);
        db.close();
    }
}