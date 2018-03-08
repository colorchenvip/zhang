package com.colorchen.zhang;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.squareup.picasso.Picasso;

import java.util.List;

import cn.jzvd.JZVideoPlayer;
import cn.jzvd.JZVideoPlayerStandard;


/**
 * @author ChenQ
 * @name： markyou
 * @date 2018-2-26
 * des：
 */
public class UserListAdapter extends BaseMultiItemQuickAdapter<UserEntity, BaseViewHolder> {
    /**
     * Same as QuickAdapter#QuickAdapter(Context,int) but with
     * some initialization data.
     *
     * @param data A new list is created out of this one to avoid mutable list
     */
    public UserListAdapter(@Nullable List<UserEntity> data) {
        super(data);
        addItemType(0, R.layout.layout_item_user);
    }


    @Override
    protected void convert(BaseViewHolder helper, UserEntity item) {
        JZVideoPlayerStandard videoPlayerStandard = helper.getView(R.id.videoplayer);
        videoPlayerStandard.setUp(item.playUrl, JZVideoPlayer.SCREEN_WINDOW_LIST,item.title);
        Picasso.with(videoPlayerStandard.getContext()).load(item.faceUrl).fit().into(videoPlayerStandard.thumbImageView);
        helper.setText(R.id.item_fan_count, item.fansCount);
        helper.setText(R.id.item_gold_count, item.goldNumber);

    }

    @Nullable
    @Override
    public UserEntity getItem(int position) {
        return super.getItem(position);
    }
}
