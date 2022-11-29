package cn.tedu.weibo02.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
@Data
public class WeiboDeteilVO {
    private Integer id;
    private String content;
    private String urls;
    private String nickname;
    // 2022年11月17日 17时20分30秒
    @JsonFormat(pattern = "yyyy年MM月dd日 HH时mm分ss秒",timezone="GMT+8")
    private Date created;
}
