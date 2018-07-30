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
public class MarvelFragment extends Fragment {

    private final int COLUMN_COUNT = 2;

    private ArrayList<Character> mMarvelCharacters;

    public MarvelFragment() {
        // Required empty public constructor
        mMarvelCharacters = new ArrayList<>();

        mMarvelCharacters.add(new Character("Ant Man", R.drawable.antman));
        mMarvelCharacters.add(new Character("Avengers", R.drawable.avengers));
        mMarvelCharacters.add(new Character("Black Panther", R.drawable.black_panther));
        mMarvelCharacters.add(new Character("Captain America", R.drawable.captain));
        mMarvelCharacters.add(new Character("Captain Marvel", R.drawable.captain_marvel));
        mMarvelCharacters.add(new Character("Dead Pool", R.drawable.dead_pool));
        mMarvelCharacters.add(new Character("Iron Man", R.drawable.ironman));
        mMarvelCharacters.add(new Character("Spider Man", R.drawable.spiderman));
        mMarvelCharacters.add(new Character("Wolverine", R.drawable.wolverine));
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_character_list, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recycle_characters);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(new CharacterAdapter(mMarvelCharacters));

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
