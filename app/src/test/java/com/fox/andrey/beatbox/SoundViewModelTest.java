package com.fox.andrey.beatbox;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

public class SoundViewModelTest {
    private BeatBox mBeatBox;
    private Sound mSound;
    private  SoundViewModel mSubject;

    @Before
    public void setUp() throws Exception {
        mBeatBox = mock(BeatBox.class);
        mSound = new Sound("assetPath");
        mSubject = new SoundViewModel(mBeatBox);
        mSubject.setmSound(mSound);
    }

    @Test
    public void exposesSoundNameAsTitle(){
        //проверяю соответсвтует ли значения методов, должны быть одинаковы
        assertThat(mSubject.getTitle(),is(mSound.getmName()));
    }

    @Test
    public void callsBeatBoxPlayOnButtonClicked(){
        mSubject.onButtonClicked();
        //проверить что метод play біл візван для mBeatBox с передачей mSound в параметре
        verify(mBeatBox).play(mSound);
    }

}