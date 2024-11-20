package com.example.mynote;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddNoteActivity extends AppCompatActivity {

    private EditText noteTitle, noteDescription, noteDate;
    private Button addButton, updateButton;
    private NoteRoomDatabase noteDatabase;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        noteTitle = findViewById(R.id.noteTitle);
        noteDescription = findViewById(R.id.noteDescription);
        noteDate = findViewById(R.id.noteDate);
        addButton = findViewById(R.id.addButton);
        updateButton = findViewById(R.id.updateButton);

        noteDatabase = NoteRoomDatabase.getDatabase(this);

        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = noteTitle.getText().toString().trim();
                String desc = noteDescription.getText().toString().trim();
                String date = noteDate.getText().toString().trim();

                if (title.isEmpty() || desc.isEmpty() || date.isEmpty()) {
                    Toast.makeText(AddNoteActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else {
                    Note note = new Note(title, desc, date);

                    new Thread(() -> {
                        noteDatabase.noteDao().insert(note);
                        runOnUiThread(() -> {
                            Toast.makeText(AddNoteActivity.this, "Note added", Toast.LENGTH_SHORT).show();
                            finish();
                        });
                    }).start();
                }
            }
        });

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(AddNoteActivity.this, "Update feature not implemented yet", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
