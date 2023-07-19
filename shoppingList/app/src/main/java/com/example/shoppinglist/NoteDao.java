package com.example.shoppinglist;

@Dao
public interface NoteDao {
    @Insert
    void insert(Note note);

    @Query("SELECT * FROM notes")
    List<Note> getAllNotes();
}

