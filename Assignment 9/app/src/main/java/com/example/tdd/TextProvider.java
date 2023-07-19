package com.example.tdd;

import android.content.Context;

public class TextProvider {
    private Context context;

    public TextProvider(Context context) {
        this.context = context;
    }

    public String getButtonText() {
        return context.getString(R.string.button_text);
    }

    public String getItemText(int position) {
        return context.getString(R.string.item_text, position);
    }
}


