package com.zlw.mymodel.main.bean;

import java.io.Serializable;

/**
 * Created by zlw
 */
public class ContentEntity implements Serializable {
    //创建时间
    private String create_time;
    //不喜欢的数量
    private String hate;
    //图片高度
    private String height;
    //id
    private String id;
    //0号图，数字越大，尺寸越大
    private String image0;
    private String image1;
    private String image2;
    private String image3;
    //是否是gif 0表示不是，1表示是
    private String is_gif;
    // 	点赞的数量
    private String love;
    // 	段子正文
    private String text;
    // 	type=10 图片 type=29 段子 type=31 声音 type=41 视频
    private int type;
    // 	视频时长
    private String videotime;
    //视频url
    private String video_uri;
    //声音文件大小
    private String voicelength;
    //声音时长
    private String voicetime;
    // 	声音url
    private String voiceuri;
    // 	微信链接地址
    private String weixin_url;
    //图片宽度
    private String width;


    public ContentEntity() {
    }

    public ContentEntity(String create_time, String hate, String height, String id,
                         String image0, String image1, String image2, String image3,
                         String is_gif, String love, String text, int type, String videotime,
                         String video_uri, String voicelength, String voicetime, String voiceuri,
                         String weixin_url, String width) {
        this.create_time = create_time;
        this.hate = hate;
        this.height = height;
        this.id = id;
        this.image0 = image0;
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.is_gif = is_gif;
        this.love = love;
        this.text = text;
        this.type = type;
        this.videotime = videotime;
        this.video_uri = video_uri;
        this.voicelength = voicelength;
        this.voicetime = voicetime;
        this.voiceuri = voiceuri;
        this.weixin_url = weixin_url;
        this.width = width;
    }

    public String getCreate_time() {
        return create_time;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public String getHate() {
        return hate;
    }

    public void setHate(String hate) {
        this.hate = hate;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getImage0() {
        return image0;
    }

    public void setImage0(String image0) {
        this.image0 = image0;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getIs_gif() {
        return is_gif;
    }

    public void setIs_gif(String is_gif) {
        this.is_gif = is_gif;
    }

    public String getLove() {
        return love;
    }

    public void setLove(String love) {
        this.love = love;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getVideotime() {
        return videotime;
    }

    public void setVideotime(String videotime) {
        this.videotime = videotime;
    }

    public String getVideo_uri() {
        return video_uri;
    }

    public void setVideo_uri(String video_uri) {
        this.video_uri = video_uri;
    }

    public String getVoicelength() {
        return voicelength;
    }

    public void setVoicelength(String voicelength) {
        this.voicelength = voicelength;
    }

    public String getVoicetime() {
        return voicetime;
    }

    public void setVoicetime(String voicetime) {
        this.voicetime = voicetime;
    }

    public String getVoiceuri() {
        return voiceuri;
    }

    public void setVoiceuri(String voiceuri) {
        this.voiceuri = voiceuri;
    }

    public String getWeixin_url() {
        return weixin_url;
    }

    public void setWeixin_url(String weixin_url) {
        this.weixin_url = weixin_url;
    }

    public String getWidth() {
        return width;
    }

    public void setWidth(String width) {
        this.width = width;
    }
}