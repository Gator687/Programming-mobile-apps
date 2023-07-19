package com.example.shoppinglist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {
    private NoteViewModel noteViewModel;
    private TextView notesCountTextView;
    private EditText noteEditText;
    private Button addNoteButton;
    private RecyclerView notesRecyclerView;
    private NoteAdapter noteAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        notesCountTextView = findViewById(R.id.notesCountTextView);
        noteEditText = findViewById(R.id.noteEditText);
        addNoteButton = findViewById(R.id.addNoteButton);
        notesRecyclerView = findViewById(R.id.notesRecyclerView);

        noteAdapter = new NoteAdapter();
        notesRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        notesRecyclerView.setAdapter(noteAdapter);

        noteViewModel = new ViewModelProvider(this).get(NoteViewModel.class);
        noteViewModel.getAllNotes().observe(this, notes -> {
            // Update the UI when the notes list changes
            noteAdapter.submitList(notes);
            int count = notes != null ? notes.size() : 0;
            notesCountTextView.setText("Number of Notes: " + count);
        });

        addNoteButton.setOnClickListener(view -> addNote());
    }

    private void addNote() {
        String noteText = noteEditText.getText().toString().trim();
        if (!noteText.isEmpty()) {
            Note note = new Note();
            note.setText(noteText);
            noteViewModel.insert(note);
            noteEditText.setText("");
        }
    }
}
