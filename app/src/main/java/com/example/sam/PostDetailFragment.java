package com.example.sam;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

public class PostDetailFragment extends Fragment {

    private String[] memberNames = {"김철수", "이영희", "박민수"};
    private String[] memberEmails = {"chulsoo@example.com", "younghee@example.com", "minsoo@example.com"};

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_detail, container, false);

        // "목록으로" 버튼 설정
        Button buttonGoList = view.findViewById(R.id.go_list);
        buttonGoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_postDetailFragment_to_postListFragment);
            }
        });

        // "지원서 작성" 버튼 설정
        Button buttonApply = view.findViewById(R.id.apply);
        buttonApply.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(v);
                navController.navigate(R.id.action_postDetailFragment_to_applyFragment);
            }
        });

        // "멤버 보기" 버튼 설정
        Button viewMemberButton = view.findViewById(R.id.view_member);
        viewMemberButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showMemberDialog();
            }
        });

        return view;
    }

    private void showMemberDialog() {
        // 다이얼로그 레이아웃 인플레이트
        LayoutInflater inflater = getLayoutInflater();
        View dialogView = inflater.inflate(R.layout.dialog_member_list, null);

        ListView listView = dialogView.findViewById(R.id.member_list);

        // 커스텀 어댑터를 사용하여 리스트뷰에 데이터 설정
        CustomAdapter adapter = new CustomAdapter();
        listView.setAdapter(adapter);

        // 다이얼로그 생성 및 표시
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setTitle("멤버 목록");
        builder.setView(dialogView);
        builder.setPositiveButton("닫기", null);
        AlertDialog dialog = builder.create();
        dialog.show();

        // 아이템 클릭 리스너 설정
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 클릭된 아이템에 대한 작업 수행
                String name = memberNames[position];
                String email = memberEmails[position];
                // 다이얼로그 닫기
                dialog.dismiss();

                // 프로필 보기 화면으로 이동
                NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                Bundle bundle = new Bundle();
                bundle.putString("memberEmail", email);
                navController.navigate(R.id.action_postDetailFragment_to_profileFragment, bundle);
            }
        });
    }

    private class CustomAdapter extends ArrayAdapter<String> {
        CustomAdapter() {
            super(requireContext(), R.layout.member_item, memberNames);
        }

        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.member_item, parent, false);
            }

            TextView memberName = convertView.findViewById(R.id.member_name);
            TextView memberEmail = convertView.findViewById(R.id.member_email);
            Button profileButton = convertView.findViewById(R.id.profile_button);

            memberName.setText(memberNames[position]);
            memberEmail.setText(memberEmails[position]);

            profileButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {

                    // 프로필 보기 화면으로 이동
                    NavController navController = Navigation.findNavController(requireActivity(), R.id.nav_host_fragment);
                    Bundle bundle = new Bundle();
                    bundle.putString("memberEmail", memberEmails[position]);
                    navController.navigate(R.id.action_postDetailFragment_to_profileFragment, bundle);

                }
            });

            return convertView;
        }
    }
}
