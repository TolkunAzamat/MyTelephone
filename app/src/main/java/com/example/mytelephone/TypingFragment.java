package com.example.mytelephone;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.navigation.Navigation;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class TypingFragment extends Fragment {
String textNumber="";


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_typing, container, false);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        EditText txt = view.findViewById(R.id.editText);
        Button one = view.findViewById(R.id.one);
        Button two = view.findViewById(R.id.two);
        Button three = view.findViewById(R.id.three);
        Button four = view.findViewById(R.id.four);
        Button five = view.findViewById(R.id.five);
        Button six = view.findViewById(R.id.six);
        Button seven = view.findViewById(R.id.seven);
        Button eight = view.findViewById(R.id.eight);
        Button nine = view.findViewById(R.id.nine);
        Button zero = view.findViewById(R.id.zero);
        Button lattice = view.findViewById(R.id.lattice);
        Button star = view.findViewById(R.id.star);
        Button add = view.findViewById(R.id.addcontacts);
        FloatingActionButton del = view.findViewById(R.id.delete);
        Bundle bundle = new Bundle();
        SaveFragment saveFragment = new SaveFragment();
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String o = "1";
                textNumber = textNumber + o;
                txt.setText(textNumber);
                Log.d("ZZZ",o);
            }
        });

        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String t = "2";
                textNumber = textNumber + t;
                txt.setText(textNumber);
            }
        });

        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String th = "3";
                textNumber = textNumber + th;
                txt.setText(textNumber);
            }
        });

        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String f = "4";
              textNumber = textNumber + f;
              txt.setText(textNumber);
            }
        });

        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String fi ="5";
                textNumber = textNumber + fi;
                txt.setText(textNumber);

            }
        });

        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s = "6";
                textNumber = textNumber + s;
                txt.setText(textNumber);
            }
        });

        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String se = "7";
                textNumber = textNumber + se;
                txt.setText(textNumber);
            }
        });


        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String e = "8";
                textNumber = textNumber + e;
                txt.setText(textNumber);

            }
        });


        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String n = "9";
                textNumber = textNumber + n;
                txt.setText(textNumber);
            }
        });


        lattice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String l = "#";
                textNumber = textNumber + l;
                txt.setText(textNumber);
            }
        });


        star.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String st = "*";
                textNumber = textNumber + st;
                txt.setText(textNumber);
            }
        });

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String z ="0";
                textNumber = textNumber + z;
                txt.setText(textNumber);

            }
        });



        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Получение текста из EditText
                String number = txt.getText().toString();

                // Создание Bundle для передачи данных
                Bundle bundle = new Bundle();
                bundle.putString("number", number);

                // Навигационное действие для перехода в SaveFragment
                Navigation.findNavController(v).navigate(R.id.action_typingFragment_to_saveFragment, bundle);
            }
        });


        del.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        textNumber = txt.getText().toString();
        if (textNumber.length()>0){
            txt.setText(textNumber.substring(0,textNumber.length()-1));
        }
    }
});
    }

}

