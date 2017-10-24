package com.collect.model;

/**
 * Created by zhangyuncai on 2017/10/7.
 */

public class Test8Model {

    /**
     * cmpName : string
     * cnt : 0
     * friends : true
     * headUrl : string
     * memberId : 0
     * memberTitle : string
     * nickName : string
     */

    private String cmpName;
    private int cnt;
    private boolean friends;
    private String headUrl;
    private int memberId;
    private String memberTitle;
    private String nickName;

    public String getCmpName() {
        return cmpName;
    }

    public void setCmpName(String cmpName) {
        this.cmpName = cmpName;
    }

    public int getCnt() {
        return cnt;
    }

    public void setCnt(int cnt) {
        this.cnt = cnt;
    }

    public boolean isFriends() {
        return friends;
    }

    public void setFriends(boolean friends) {
        this.friends = friends;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getMemberTitle() {
        return memberTitle;
    }

    public void setMemberTitle(String memberTitle) {
        this.memberTitle = memberTitle;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
