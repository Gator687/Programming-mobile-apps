package com.example.finalproject;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MenuAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] menuItems;

    public MenuAdapter(Context context, String[] menuItems) {
        super(context, 0, menuItems);
        this.context = context;
        this.menuItems = menuItems;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(context).inflate(R.layout.list_item, parent, false);
        }

        TextView menuItemText = listItemView.findViewById(R.id.menu_item_text);
        ImageView menuItemIcon = listItemView.findViewById(R.id.menu_item_icon);

        menuItemText.setText(menuItems[position]);

        // Set custom icons based on the menu item
        int iconResId;
        switch (position) {
            case 0:
                iconResId = R.drawable.breakfast_icon;
                break;
            case 1:
                iconResId = R.drawable.lunch_icon;
                break;
            case 2:
                iconResId = R.drawable.dinner_icon;
                break;
            case 3:
                iconResId = R.drawable.desserts_icon;
                break;
            case 4:
                iconResId = R.drawable.my_order_icon;
                break;
            default:
                iconResId = R.drawable.default_icon;
                break;
        }
        menuItemIcon.setImageResource(iconResId);

        return listItemView;
    }
}