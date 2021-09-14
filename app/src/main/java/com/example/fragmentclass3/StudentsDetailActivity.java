package com.example.fragmentclass3;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class StudentsDetailActivity extends AppCompatActivity implements CommunicationListener{

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager=getSupportFragmentManager();
        launchStudentsPersonalDetailsFragment();
    }

    private void launchStudentsPersonalDetailsFragment() {
        FragmentTransaction fragmentTransaction =fragmentManager.beginTransaction();
        StudentPersonalDetailsFragments fragments=new StudentPersonalDetailsFragments();
        fragmentTransaction.add(R.id.container,fragments,"personal").commit();
    }

    @Override
    public void launchPerformanceFragment(Bundle bundle) {
        FragmentTransaction fragmentTransaction=fragmentManager.beginTransaction();
        StudentPerformanceDetails personalDetailsFragments=new StudentPerformanceDetails();
        personalDetailsFragments.setArguments(bundle);
        fragmentTransaction.replace(R.id.container,personalDetailsFragments,"personalDetailsFragment").addToBackStack("").commit();
    }
}