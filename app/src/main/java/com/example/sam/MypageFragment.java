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
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class MypageFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mypage, container, false);

        // 프로필 보기 버튼 설정
        Button button_view_profile = view.findViewById(R.id.view_profile);
        button_view_profile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 네비게이션을 통해 ProfileFragment로 전환
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_mypageFragment_to_profileFragment);
            }
        });

        // 로그아웃 텍스트 뷰 설정
        TextView logoutTextView = view.findViewById(R.id.logout);
        logoutTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 네비게이션을 통해 LoginFragment로 전환
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_mypageFragment_to_loginFragment);
            }
        });

        return view;
    }
}
