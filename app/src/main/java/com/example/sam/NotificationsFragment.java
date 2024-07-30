package com.example.sam;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NotificationsFragment extends Fragment {

    private RecyclerView recyclerView;
    private NotificationsAdapter adapter;
    private List<NotificationItem> notificationList;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);
        recyclerView = view.findViewById(R.id.recycler_view_notifications);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        notificationList = new ArrayList<>();
        // Populate the notification list with dummy data
        for (int i = 0; i < 10; i++) {
            notificationList.add(new NotificationItem("000님이 내 글 'AI 융합 공모전'에 지원서를 제출하였습니다.", "지원서 보기"));
        }

        adapter = new NotificationsAdapter(notificationList, new NotificationsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(NotificationItem item) {
                // Navigate to ApplicationDetailFragment
                NavController navController = Navigation.findNavController(getActivity(), R.id.nav_host_fragment);
                navController.navigate(R.id.action_notificationsFragment_to_applicationDetailFragment);
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}
