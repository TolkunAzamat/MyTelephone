package com.example.mytelephone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.room.Transaction;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.example.mytelephone.db.App;
import com.example.mytelephone.db.AppDatabase;
import com.example.mytelephone.db.Contacts;
import com.example.mytelephone.db.App;
import com.example.mytelephone.db.Contacts;

import java.util.List;
public class SaveFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_save, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        EditText name = view.findViewById(R.id.name);
        EditText number = view.findViewById(R.id.number);
        Button save = view.findViewById(R.id.save);

        // Получение данных из Bundle
        Bundle bundle = getArguments();
        if (bundle != null) {
            String names = bundle.getString("number");

            // Устанавливаем значение в EditText для номера
            number.setText(names);
        }

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String contactName = name.getText().toString().trim();
                String contactNumber = number.getText().toString().trim();

                // Создание объекта контакта
                Contacts contact = new Contacts(contactName, contactNumber);

                // Вставка контакта в базу данных
                AppDatabase database = App.getDatabase(); // Получаем экземпляр базы данных
                database.contactsDao().insert(contact);

                // Получение всех контактов и вывод их количества в лог
                List<Contacts> contactList = database.contactsDao().getAll();
                int size = contactList.size();
                Log.d("SaveFragment", "Number of contacts in database: " + size);
            }
        });
    }
}
