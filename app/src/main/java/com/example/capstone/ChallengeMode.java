package com.example.capstone;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

public class ChallengeMode extends AppCompatActivity {

    private FragmentStatePagerAdapter mSelectionPageAdapter;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_challenge_mode);

        mSelectionPageAdapter = new FragmentStatePagerAdapter(getSupportFragmentManager());
        mViewPager = findViewById(R.id.container);
        setupViewPager(mViewPager);
    }

    private void setupViewPager(ViewPager vp){
        FragmentStatePagerAdapter adapter = new FragmentStatePagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new mathFrag(), "Math Game");
        adapter.addFragment(new ColorFragment(), "Color Game");
        adapter.addFragment(new NumberFrag(), "Number Game");
        adapter.addFragment(new FragColorFlash(), "Flash Game");
        vp.setAdapter(adapter);
    }

    public void setViewPager(int fragIndex){
        mViewPager.setCurrentItem(fragIndex);
    }
}