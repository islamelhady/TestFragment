package com.example.testfragment;


import android.content.Context;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class NameFragment extends Fragment {

    String name;
    public static final String KEY_ARG = "NAME";
    private OnFragmentClickListener listener;

    public NameFragment() {
        // Required empty public constructor
    }

    public static NameFragment newInstance(String name) {
        Bundle bundle = new Bundle();
        bundle.putString("NAME", name);
         NameFragment nameFragment = new NameFragment();
         nameFragment.setArguments(bundle);
        return nameFragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentClickListener)
        listener = (OnFragmentClickListener) context;
        else
            throw new ClassCastException("ur activity does not implements OnFragmentClickListener");

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
    public void onDetach() {
        super.onDetach();
        listener = null;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_name, container, false);
        RecyclerView rv = v.findViewById(R.id.main_rv);

        ArrayList<Name> names = new ArrayList<>();
        names.add(new Name("islam"));
        names.add(new Name("Mohamed"));
        names.add(new Name("Jannat"));
        names.add(new Name("Ali"));
        names.add(new Name("ahmed"));
        names.add(new Name("sarah"));
        names.add(new Name("Mohamed"));
        names.add(new Name("Jannat"));
        names.add(new Name("Ali"));
        names.add(new Name("ahmed"));
        names.add(new Name("sarah"));

        NameAdapter nameAdapter = new NameAdapter(names, new ItemOnClickListener() {
            @Override
            public void onClick(Name name) {
                listener.onClickFragment(name);

            }
        });

        rv.setAdapter(nameAdapter);
        rv.setLayoutManager(new LinearLayoutManager(getActivity()));
        return v;
    }

    public interface OnFragmentClickListener{
        void onClickFragment(Name name);
    }

}
