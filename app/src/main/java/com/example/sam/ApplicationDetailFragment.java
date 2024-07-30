package com.example.sam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ApplicationDetailFragment extends Fragment {

    private TextView tvTitle, tvAuthor, tvDate, tvApplicationDetail, tvApplicationContent;
    private Button btnViewProfile, btnReject, btnAccept;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_application_detail, container, false);

        tvTitle = view.findViewById(R.id.tv_title);
        tvAuthor = view.findViewById(R.id.tv_author);
        tvDate = view.findViewById(R.id.tv_date);
        tvApplicationDetail = view.findViewById(R.id.tv_application_detail);
        tvApplicationContent = view.findViewById(R.id.tv_application_content);
        btnViewProfile = view.findViewById(R.id.btn_view_profile);
        btnReject = view.findViewById(R.id.btn_reject);
        btnAccept = view.findViewById(R.id.btn_accept);

        // Set the text views with data from arguments or other source
        // Example:
        // tvTitle.setText(getArguments().getString("title"));

        btnViewProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle view profile button click
            }
        });

        btnReject.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle reject button click
            }
        });

        btnAccept.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Handle accept button click
            }
        });

        return view;
    }
}
