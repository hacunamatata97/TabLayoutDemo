package com.badasspsycho.tablayoutdemo.ui.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ToggleButton;
import com.badasspsycho.tablayoutdemo.R;
import com.badasspsycho.tablayoutdemo.model.Character;
import com.badasspsycho.tablayoutdemo.ui.adapter.CharacterAdapter;
import java.util.ArrayList;

/**
 * A simple {@link Fragment} subclass.
 */
public class DCFragment extends Fragment {

    private final int COLUMN_COUNT = 2;

    private ArrayList<Character> mDCCharacters;

    public DCFragment() {
        // Required empty public constructor
        mDCCharacters = new ArrayList<>();

        mDCCharacters.add(new Character("Superman", R.drawable.superman));
        mDCCharacters.add(new Character("Batman", R.drawable.batman));
        mDCCharacters.add(new Character("Wonder Woman", R.drawable.wonder_woman));
        mDCCharacters.add(new Character("Green Lantern", R.drawable.green_lantern));
        mDCCharacters.add(new Character("The Flash", R.drawable.the_flash));
        mDCCharacters.add(new Character("Aquaman", R.drawable.aquaman));
        mDCCharacters.add(new Character("Cyborg", R.drawable.cyborg));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_characters);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CharacterAdapter(mDCCharacters));

        ToggleButton tbChangeLayout = view.findViewById(R.id.tb_change_layout_manager);
        tbChangeLayout.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked) {
                recyclerView.setLayoutManager(new GridLayoutManager(getContext(), COLUMN_COUNT));
            } else {
                recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
            }
        });

        return view;
    }
}
