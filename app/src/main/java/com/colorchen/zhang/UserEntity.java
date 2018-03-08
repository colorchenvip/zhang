package com.colorchen.zhang;

import com.chad.library.adapter.base.entity.MultiItemEntity;

import java.io.Serializable;

/**
 * name：人员信息
 * @author: ChenQ
 * @date: 2018-2-26
 */
public class UserEntity implements MultiItemEntity, Serializable {
    public String title;
    public String fansCount;
    public String goldNumber;
    public String playUrl;
    public String faceUrl;

    public UserEntity(String title,String fansCount, String goldNumber,String playUrl,String faceUrl){
        this.title = title;
        this.fansCount = fansCount;
        this.goldNumber = goldNumber;
        this.playUrl = playUrl;
        this.faceUrl = faceUrl;
    }

    @Override
    public int getItemType() {
        return 0;
    }
}
