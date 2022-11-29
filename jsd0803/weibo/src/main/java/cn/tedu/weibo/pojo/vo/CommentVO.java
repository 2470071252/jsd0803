package cn.tedu.weibo.pojo.vo;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

@Data
public class CommentVO {
    private Integer id;
    private String nickname;
    private String content;
    @JsonFormat(pattern = "yyyy/mm/dd HH:mm:ss",timezone = "GMT+8")
    private Date created;

}
