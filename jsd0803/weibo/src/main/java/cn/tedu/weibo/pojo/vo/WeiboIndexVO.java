package cn.tedu.weibo.pojo.vo;

public class WeiboIndexVO {
    private Integer id;
    private String content;
    private String urls;
    private String nickname;

    @Override
    public String toString() {
        return "WeiboIndexVO{" +
                "id=" + id +
                ", content='" + content + '\'' +
                ", urls='" + urls + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }

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
}
