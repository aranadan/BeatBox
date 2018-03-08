package com.fox.andrey.beatbox;


import android.content.Context;
import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.widget.SeekBar;

public class SeekBarValueModel extends BaseObservable{

    public ObservableField<String> mSeekBarValue;
    public ObservableInt mSeekBarRate;

    private BeatBox mBeatBox;
    private Context mContext;

    public SeekBarValueModel(BeatBox beatBox, Context context){
        mBeatBox = beatBox;
        mSeekBarValue = new ObservableField<>(context.getResources().getString(R.string.seek_bar_value,getRatePlayInt()) + "%");
        mSeekBarRate = new ObservableInt(getRatePlayInt());
        mContext = context;
    }

    public void onSeekBarChanged(SeekBar seekBar, int progress, boolean fromUser){
        mSeekBarValue.set(mContext.getResources().getString(R.string.seek_bar_value,progress) + "%");
        float rate = progress/100.0f;
        //mBeatBox.setRatePlay(rate);
        Singleton.getsSingleton().setRatePlay(rate);
        Log.e("TAG",rate + "");
    }
    @Bindable
    public int getRatePlayInt(){
        int rate = (int) (Singleton.getsSingleton().getRatePlay() * 100);
        return rate;
    }

}
