package com.fox.andrey.beatbox;

/**
 * Created by Andrey on 05.02.2018.
 */

public class Sound {
    private String mAssetsPath;
    private String mName;

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
