package com.example.mynote;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class NotesAdapter extends RecyclerView.Adapter<NotesAdapter.NoteViewHolder> {

    private List<Note> notesList;

    // Constructor untuk menerima data
    public NotesAdapter(List<Note> notesList) {
        this.notesList = notesList;
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflate layout untuk setiap item di RecyclerView
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_main, parent, false);
        return new NoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        // Ambil data dari list berdasarkan posisi
        Note note = notesList.get(position);

        // Set data ke dalam ViewHolder
        holder.titleTextView.setText("Title: " + note.getTitle());
        holder.descTextView.setText("Desc: " + note.getDescription());
        holder.dateTextView.setText("Date: " + note.getDate());
    }

    @Override
    public int getItemCount() {
        return notesList.size(); // Mengembalikan jumlah data
    }

    // ViewHolder untuk memegang referensi view item
    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        TextView titleTextView, descTextView, dateTextView;

        public NoteViewHolder(@NonNull View itemView) {
            super(itemView);
            titleTextView = itemView.findViewById(R.id.titleTextView);
            descTextView = itemView.findViewById(R.id.descTextView);
            dateTextView = itemView.findViewById(R.id.dateTextView);
        }
    }
}
