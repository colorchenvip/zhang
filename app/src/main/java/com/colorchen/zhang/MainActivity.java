package com.colorchen.zhang;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.blankj.utilcode.util.ToastUtils;
import com.scwang.smartrefresh.layout.api.RefreshLayout;

import java.util.ArrayList;
import java.util.List;

import cn.jzvd.JZVideoPlayer;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initListView();
    }

    private void initListView() {
        RefreshLayout refreshLayout = findViewById(R.id.refreshLayout);
        refreshLayout.setOnRefreshListener(layout -> {
            layout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
        });
        refreshLayout.setOnLoadmoreListener(layout -> {
            layout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
        });

        recyclerView = findViewById(R.id.recyclerView);

        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new UserListAdapter(getTestData());
        recyclerView.setAdapter(adapter);
        adapter.setOnItemClickListener((adapter, view, position) -> {
            UserEntity item = (UserEntity) adapter.getItem(position);
            ToastUtils.showShort("开始播放视频");
        });
    }

    private List<UserEntity> getTestData() {
        List<UserEntity> list = new ArrayList<>();
        list.add(new UserEntity("视频1","粉丝数：1001","金币数：168"
                ,"http://note.colorchen.com/video/zhang_001.mp4"
                , "http://jzvd-pic.nathen.cn/jzvd-pic/2204a578-609b-440e-8af7-a0ee17ff3aee.jpg"));
        list.add(new UserEntity("视频2","粉丝数：1001","金币数：555"
                ,"http://note.colorchen.com/video/zhang_002.mp4"
                , "http://jzvd-pic.nathen.cn/jzvd-pic/bd7ffc84-8407-4037-a078-7d922ce0fb0f.jpg"));
        list.add(new UserEntity("视频3","粉丝数：1000","金币数：99"
                ,"http://jzvd.nathen.cn/d2e969f2ec734520b46ab0965d2b68bd/f124edfef6c24be8b1a7b7f996ccc5e0-5287d2089db37e62345123a1be272f8b.mp4"
                , "http://jzvd-pic.nathen.cn/jzvd-pic/3430ec64-e6a7-4d8e-b044-9d408e075b7c.jpg"));
        list.add(new UserEntity("视频4","粉丝数：1001","金币数：888"
                ,"http://jzvd.nathen.cn/f07fa9fddd1e45a6ae1570c7fe7967c1/c6db82685b894e25b523b1cb28d79f2e-5287d2089db37e62345123a1be272f8b.mp4"
                , "http://jzvd-pic.nathen.cn/jzvd-pic/f2dbd12e-b1cb-4daf-aff1-8c6be2f64d1a.jpg"));
        list.add(new UserEntity("视频5","粉丝数：1001","金币数：666"
                ,"http://jzvd.nathen.cn/6340efd1962946ad80eeffd19b3be89c/65b499c0f16e4dd8900497e51ffa0949-5287d2089db37e62345123a1be272f8b.mp4"
                , "http://jzvd-pic.nathen.cn/jzvd-pic/aaeb5da9-ac50-4712-a28d-863fe40f1fc6.png"));
        return list;
    }

    @Override
    public void onBackPressed() {
        if (JZVideoPlayer.backPress()) {
            return;
        }
        super.onBackPressed();
    }
    @Override
    protected void onPause() {
        super.onPause();
        JZVideoPlayer.releaseAllVideos();
    }


}
