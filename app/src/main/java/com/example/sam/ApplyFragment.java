package com.example.sam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class ApplyFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_apply, container, false);

        // "목록으로" 버튼 설정
        Button button_go_list = view.findViewById(R.id.go_list);
        button_go_list.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 네비게이션을 통해 PostListFragment로 전환
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_applyFragment_to_postListFragment);
            }
        });

        Button button_apply =view.findViewById(R.id.apply);
        button_apply.setOnClickListener(new View.OnClickListener(){
            public void onClick(View view){
                Toast.makeText(getContext(),"제출되었습니다.",Toast.LENGTH_LONG).show();
            }
        });


        return view;
    }


}
