package com.example.fragmentclass3;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


public class StudentPerformanceDetails extends Fragment {


    private EditText mEtGrade;
    private EditText mEtPercentage;
    private Button mBtnPreview;
    private String name;
    private int age;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            name=getArguments().getString("name");
            age=getArguments().getInt("age");
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_student_performance_details_fragments, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initViews(view);
    }

    private void initViews(View view) {
        mEtGrade=view.findViewById(R.id.etStudentGrade);
        mEtPercentage=view.findViewById(R.id.etStudentPercentage);
        mBtnPreview=view.findViewById(R.id.btnPreview);
        mBtnPreview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String grade=mEtGrade.getText().toString();
                String percentage=mEtPercentage.getText().toString();
                Model model=new Model(name,grade,age,percentage);
                Intent intent=new Intent(getContext(),PreviewActivity.class);
                intent.putExtra("model",model);
                startActivity(intent);

            }
        });
    }
}