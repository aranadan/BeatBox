package com.fox.andrey.beatbox;


public class Sound {
    private String mAssetsPath;
    private String mName;
    private Integer mSoundId;

    public Integer getmSoundId() {
        return mSoundId;
    }

    public void setmSoundId(Integer mSoundId) {
        this.mSoundId = mSoundId;
    }

    public Sound(String assetPath){
        mAssetsPath = assetPath;
        String[] components = assetPath.split("/");
        String fileName = components[components.length-1];
        mName = fileName.replace(".wav","");
    }

    public String getmAssetsPath() {
        return mAssetsPath;
    }

public String getmName() {
        return mName;
    }
}
