package com.gachon.priend.community.activity;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.os.Bundle;
import android.widget.Toast;

import com.gachon.priend.R;
import com.gachon.priend.community.BulletinAdapter;
import com.gachon.priend.community.database.BulletinData;

import java.util.Arrays;
import java.util.List;


public class BulletinListActivity extends AppCompatActivity {

    private BulletinAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bulletin_list);

        init();

        getData();
    }

    private void init() {
        RecyclerView bulletinRecyclerView = findViewById(R.id.bulletin_list_recycler_view_boards);
        bulletinRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        adapter = new BulletinAdapter();
        adapter.setItemSelectionListener(new BulletinAdapter.ItemSelectionListener() {
            @Override
            public void onItemSelected(@NonNull BulletinData bulletinData) {
                Toast.makeText(BulletinListActivity.this, bulletinData.getTitle(), Toast.LENGTH_SHORT).show();
            }
        });
        bulletinRecyclerView.setAdapter(adapter);
    }

    private void getData() {
        // 임의의 데이터입니다.
        List<String> listTitle = Arrays.asList("Free Bulletin", "Information", "Market", "Cat Bulletin", "Dog Bulletin");
        List<String> listContent = Arrays.asList(
                "Share a variety of content",
                "Share a variety of content",
                "Share a variety of content",
                "Share a variety of content",
                "Share a variety of content"
        );
        List<Integer> listResId = Arrays.asList(
                R.drawable.ic_bulletin_icon,
                R.drawable.ic_bulletin_icon,
                R.drawable.ic_bulletin_icon,
                R.drawable.ic_bulletin_icon,
                R.drawable.ic_bulletin_icon
        );
        for (int i = 0; i < listTitle.size(); i++) {
            // 각 List의 값들을 data 객체에 set 해줍니다.
            BulletinData data = new BulletinData();
            data.setId((short)i);
            data.setTitle(listTitle.get(i));
            data.setContent(listContent.get(i));
            data.setResId(listResId.get(i));

            // 각 값이 들어간 data를 adapter에 추가합니다.
            adapter.addItem(data);
        }

        // adapter의 값이 변경되었다는 것을 알려줍니다.
        adapter.notifyDataSetChanged();
    }
}



