package com.fox.andrey.beatbox;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.fox.andrey.beatbox.databinding.FragmentBeatBoxBinding;
import com.fox.andrey.beatbox.databinding.ListItemSoundBinding;

import java.util.List;


public class BeatBoxFragment extends Fragment {

    private BeatBox mBeatBox;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBeatBox = new BeatBox(getActivity());
    }


    public static BeatBoxFragment newInstance() {
        return new BeatBoxFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // класс FragmentBeatBoxBinding автоматически генерируется потому что макет помещен в тег layout
        FragmentBeatBoxBinding binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_beat_box, container, false);

        binding.recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 3));
        binding.recyclerView.setAdapter(new SoundAdapter(mBeatBox.getmSounds()));

        return binding.getRoot();
    }

    private class SoundHolder extends RecyclerView.ViewHolder {
        private ListItemSoundBinding mBinding;

        public SoundHolder(ListItemSoundBinding binding) {
            super(binding.getRoot());
            mBinding = binding;
            mBinding.setViewModel(new SoundViewModel(mBeatBox));
        }
         public void bind(Sound sound){
             mBinding.getViewModel().setmSound(sound);
             // метод executePendingBindings приказівает макету обновить себя немедленно
             mBinding.executePendingBindings();
         }
    }

    private class SoundAdapter extends RecyclerView.Adapter<SoundHolder> {
        private List<Sound> mSounds;

        public SoundAdapter(List<Sound> sounds){
            mSounds = sounds;
        }

        @Override
        public SoundHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            LayoutInflater inflater = LayoutInflater.from(getActivity());
            ListItemSoundBinding binding = DataBindingUtil
                    .inflate(inflater, R.layout.list_item_sound, parent, false);

            return new SoundHolder(binding);
        }

        @Override
        public void onBindViewHolder(SoundHolder holder, int position) {
            Sound sound = mSounds.get(position);
            holder.bind(sound);
        }

        @Override
        public int getItemCount() {
            return mSounds.size();
        }
    }
}
