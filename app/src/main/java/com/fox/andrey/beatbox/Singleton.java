package com.fox.andrey.beatbox;


public class Singleton {
    private static Singleton sSingleton;
    private float ratePlay = 1.0f;

    public static Singleton getsSingleton (){
        if (sSingleton == null){
            sSingleton = new Singleton();
        }
        return sSingleton;
    }

    public void setRatePlay(float ratePlay) {
        this.ratePlay = ratePlay;
    }

    public float getRatePlay() {
        return ratePlay;
    }
}
