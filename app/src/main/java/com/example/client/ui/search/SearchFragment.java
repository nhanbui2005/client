package com.example.client.ui.search;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.client.data.adapter.SearchAdapter;
import com.example.client.databinding.FragmentSearchBinding;

import java.util.ArrayList;
import java.util.List;

public class SearchFragment extends Fragment {

    // Sử dụng View Binding
    private FragmentSearchBinding binding;
    private SearchAdapter searchAdapter;
    private List<String> searchResults;

    public SearchFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Sử dụng View Binding để thay cho findViewById
        binding = FragmentSearchBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        // Khởi tạo danh sách kết quả tìm kiếm
        searchResults = new ArrayList<>();

        // Thiết lập RecyclerView
        setupRecyclerView();

        // Thiết lập sự kiện cho nút tìm kiếm
        binding.searchButton.setOnClickListener(v -> performSearch());
    }

    /**
     * Hàm thiết lập RecyclerView.
     */
    private void setupRecyclerView() {
        // Thiết lập LinearLayoutManager cho RecyclerView
        binding.recyclerViewSearch.setLayoutManager(new LinearLayoutManager(getContext()));

        // Khởi tạo SearchAdapter và gán cho RecyclerView
        searchAdapter = new SearchAdapter(searchResults);
        binding.recyclerViewSearch.setAdapter(searchAdapter);
    }

    /**
     * Hàm thực hiện tìm kiếm.
     */
    private void performSearch() {
        // Lấy từ khóa từ EditText
        String query = binding.searchInput.getText().toString();

        // Kiểm tra nếu từ khóa trống
        if (TextUtils.isEmpty(query)) {
            Toast.makeText(getContext(), "Vui lòng nhập từ khóa tìm kiếm", Toast.LENGTH_SHORT).show();
            return;
        }

        // Xóa kết quả cũ và thêm kết quả mới
        searchResults.clear();
        searchResults.add("Kết quả cho: " + query);
        searchResults.add("Bài hát 1 liên quan đến " + query);
        searchResults.add("Bài hát 2 liên quan đến " + query);
        searchResults.add("Bài hát 3 liên quan đến " + query);

        // Cập nhật RecyclerView
        searchAdapter.notifyDataSetChanged();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null; // Giải phóng View Binding
    }
}
