package com.example.donskoy_lab14;

import android.content.ContentValues;
import android.content.Context;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnAdd, btnRead, btnClear;
    EditText etName, etEmail;
    DBHelper dbHelper;

    final String LOG_TAG = "myLogs";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        btnAdd.setOnClickListener(oclBtn);

        btnRead = (Button) findViewById(R.id.btnRead);
        btnRead.setOnClickListener(oclBtn);

        btnClear = (Button) findViewById(R.id.btnClear);
        btnClear.setOnClickListener(oclBtn);

        etName = (EditText) findViewById(R.id.etName);
        etEmail = (EditText) findViewById(R.id.etEmail);

        dbHelper = new DBHelper( this);
    }

    View.OnClickListener oclBtn = new View.OnClickListener() {
        public void onClick(View v) {
            ContentValues cv = new ContentValues();

            String name = etName.getText().toString();
            String email = etEmail.getText().toString();

            SQLiteDatabase db = dbHelper.getWritableDatabase();

            switch (v.getId()) {
                case R.id.btnAdd:
                    Log.d(LOG_TAG, "--- Insert in mytable: ---");
                    // подготовим данные для вставки в виде пар: наименование столбца - значение

                    cv.put("name", name);
                    cv.put("email", email);
                    // вставляем запись и получаем ее ID
                    long rowID = db.insert("mytable", null, cv);
                    Log.d(LOG_TAG, "row inserted, ID = " + rowID);
                    break;
                case R.id.btnRead:
                    Log.d(LOG_TAG, "--- Rows in mytable: ---");
                    // делаем запрос всех данных из таблицы mytable, получаем Cursor
                    Cursor c = db.query("mytable", null, null, null, null, null, null);

                    // ставим позицию курсора на первую строку выборки
                    // если в выборке нет строк, вернется false
                    if (c.moveToFirst()) {

                        // определяем номера столбцов по имени в выборке
                        int idColIndex = c.getColumnIndex("id");
                        int nameColIndex = c.getColumnIndex("name");
                        int emailColIndex = c.getColumnIndex("email");

                        do {
                            // получаем значения по номерам столбцов и пишем все в лог
                            Log.d(LOG_TAG,
                                    "ID = " + c.getInt(idColIndex) +
                                            ", name = " + c.getString(nameColIndex) +
                                            ", email = " + c.getString(emailColIndex));
                            // переход на следующую строку
                            // а если следующей нет (текущая - последняя), то false - выходим из цикла
                        } while (c.moveToNext());
                    } else
                        Log.d(LOG_TAG, "0 rows");
                    c.close();
                    break;
                case R.id.btnClear:
                    Log.d(LOG_TAG, "--- Clear mytable: ---");
                    // удаляем все записи
                    int clearCount = db.delete("mytable", null, null);
                    Log.d(LOG_TAG, "deleted rows count = " + clearCount);
                    break;
            }
            // закрываем подключение к БД
            dbHelper.close();
        }
    };

    class DBHelper extends SQLiteOpenHelper {

        public DBHelper(Context context) {
            // конструктор суперкласса
            super(context, "myDB", null, 1);
        }

        @Override
        public void onCreate(SQLiteDatabase db) {
            Log.d(LOG_TAG, "--- onCreate database ---");
            // создаем таблицу с полями
            db.execSQL("create table mytable ("
                    + "id integer primary key autoincrement,"
                    + "name text,"
                    + "email text" + ");");
        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }

}
