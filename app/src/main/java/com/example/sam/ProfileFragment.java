package com.example.sam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ProfileFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_profile, container, false);

        Button button_modify = view.findViewById(R.id.modify_profile_btn);
        button_modify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 네비게이션을 통해 ProfileFragment로 전환
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_fragmentProfile_to_fragmentModifyProfile);
            }
        });

        return view;
    }
}
