package com.example.mstu5031finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mstu5031finalproject.activities.DepartmentActivity;
import com.example.mstu5031finalproject.entity.Semester;

import java.util.List;

public class SemesterAdapter extends RecyclerView.Adapter<SemesterViewHolder> {

    private List<Semester> semesters;
    private Context context;

    public SemesterAdapter(List<Semester> semesters, Context context) {
        this.semesters = semesters;
        this.context = context;
    }

    @NonNull
    @Override
    public SemesterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_semester, parent, false);
        return new SemesterViewHolder(view, context);
    }

    @Override
    public void onBindViewHolder(@NonNull SemesterViewHolder holder, final int position) {
        final Semester semester = semesters.get(position);
        holder.semesterName.setText(semester.semesterName);
        holder.semesterTime.setText(semester.semesterTime);
        holder.semesterPhoto.setImageResource(semester.semesterPhoto);
        holder.selectSemester.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (semester.semesterName.equals(context.getString(R.string.fall_2020_term))) {
                    Intent intent = new Intent(context, DepartmentActivity.class);
                    context.startActivity(intent);
                } else {
                    Toast.makeText(context, semesters.get(position).semesterName + " Is Not Available", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return semesters.size();
    }
}
