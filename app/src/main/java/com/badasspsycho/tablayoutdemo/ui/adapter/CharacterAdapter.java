package com.badasspsycho.tablayoutdemo.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.badasspsycho.tablayoutdemo.R;
import com.badasspsycho.tablayoutdemo.model.Character;
import java.util.ArrayList;

public class CharacterAdapter extends RecyclerView.Adapter<CharacterAdapter.ItemHolder> {

    private ArrayList<Character> mCharacterList;
    private LayoutInflater mInflater;

    public CharacterAdapter(ArrayList<Character> characterList) {
        mCharacterList = characterList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        if (mInflater == null) {
            mInflater = LayoutInflater.from(parent.getContext());
        }
        View view = mInflater.inflate(R.layout.item_character, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Character character = mCharacterList.get(position);
        holder.bindData(character);
    }

    @Override
    public int getItemCount() {
        return (mCharacterList != null) ? mCharacterList.size() : 0;
    }

    class ItemHolder extends RecyclerView.ViewHolder {

        private ImageView mCharacterImage;
        private TextView mCharacterName;

        public ItemHolder(View itemView) {
            super(itemView);
            mCharacterImage = itemView.findViewById(R.id.iv_character_image);
            mCharacterName = itemView.findViewById(R.id.tv_character_name);
        }

        public void bindData(Character character) {
            if (character != null) {
                mCharacterImage.setImageResource(character.getImageId());
                mCharacterName.setText(character.getName());
            }
        }
    }
}
