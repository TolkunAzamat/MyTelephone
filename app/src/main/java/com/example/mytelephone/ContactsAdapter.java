package com.example.mytelephone;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mytelephone.db.Contacts;

import java.util.List;

public class ContactsAdapter extends RecyclerView.Adapter<ContactsAdapter.ViewHolder> {
private Context context;
private List<Contacts> list;
public void setContactsList (List<Contacts> contactsList){
    this.list = contactsList;
    notifyDataSetChanged();

}
public ContactsAdapter(Context context, List <Contacts> contactsList){
    this.context = context;
    this.list = contactsList;
}
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.item_contacts, parent, false);
        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
    holder.name.setText(list.get(position).name);
    holder.number.setText(list.get(position).number);
 }

    @Override
    public int getItemCount() {return list.size();}


    class ViewHolder extends RecyclerView.ViewHolder {
        TextView number, name;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            number = (TextView) itemView.findViewById(R.id.numbers);
            name = (TextView) itemView.findViewById(R.id.names);

        }


    }

}
