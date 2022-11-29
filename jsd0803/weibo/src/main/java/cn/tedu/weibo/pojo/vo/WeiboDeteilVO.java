package cn.tedu.weibo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class WeiboDeteilVO {
    private Integer id;
    private String content;
    private String urls;
    private String nickname;
    // 2022年11月17日 17时20分30秒
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone="GMT+8")
    private Date created;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getUrls() {
        return urls;
    }

    public void setUrls(String urls) {
        this.urls = urls;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    @Override
    public String toString() {
        return "WeiboDeteilVO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                ", nickname='" + nickname + '\'' +
                ", created=" + created +
                '}';
    }
}
