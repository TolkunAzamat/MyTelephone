package com.example.mytelephone;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytelephone.db.App;
import com.example.mytelephone.db.Contacts;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class ContactsFragment extends Fragment {
    RecyclerView recyclerView;
ContactsAdapter contactsAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_contacts, container, false);
        return view;

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
       recyclerView = view.findViewById(R.id.recycler);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(requireContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        contactsAdapter = new ContactsAdapter(requireContext(),new ArrayList<>());
        recyclerView.setAdapter(contactsAdapter);
        loadContacts();

    }

    private void loadContacts(){
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        executorService.execute(()->{
            List<Contacts> contactsList = App.getDatabase().contactsDao().getAll();
            requireActivity().runOnUiThread(()->{
                contactsAdapter.setContactsList(contactsList);
            });

        });
    }
}

