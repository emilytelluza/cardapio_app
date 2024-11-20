package br.edu.uniritter.cardapio.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class UserDAO {
    private final SQLiteDatabase db;

    public UserDAO(Context context) {
        DatabaseHelper dbHelper = new DatabaseHelper(context);
        this.db = dbHelper.getWritableDatabase();
    }

    public boolean registerUser(String name, String email, String password) {
        ContentValues values = new ContentValues();
        values.put("name", name);
        values.put("email", email);
        values.put("password", password);

        long result = db.insert("users", null, values);
        return result != -1;
    }

    public boolean authenticateUser(String email, String password) {
        Cursor cursor = db.query(
                "users",
                null,
                "email = ? AND password = ?",
                new String[]{email, password},
                null,
                null,
                null
        );
        boolean isAuthenticated = cursor.getCount() > 0;
        cursor.close();
        return isAuthenticated;
    }
}
