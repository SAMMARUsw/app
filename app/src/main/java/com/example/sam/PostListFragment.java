package com.example.sam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class PostListFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_post_list, container, false);

        // ListView 설정
        ListView listView = view.findViewById(R.id.listView);
        String[] items = {"Item 1", "Item 2", "Item 3"};

        // 어댑터 설정
        ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), R.layout.post_more, R.id.textView, items);
        listView.setAdapter(adapter);

        return view;
    }
}
