package com.example.testfragment;


import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import static com.example.testfragment.NameFragment.KEY_ARG;


/**
 * A simple {@link Fragment} subclass.
 */
public class TextFragment extends Fragment {

    String name;
    public static final String KEY_ARG = "NAME";
    public TextFragment() {
        // Required empty public constructor
    }

    public static TextFragment newInstance(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
        TextFragment textFragment = new TextFragment();
        textFragment.setArguments(bundle);
        return textFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
            name = bundle.getString(KEY_ARG);
        }
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_text, container, false);
        TextView textView = v.findViewById(R.id.fragment_tv);
        textView.setText(name);
        return v;
    }

}
