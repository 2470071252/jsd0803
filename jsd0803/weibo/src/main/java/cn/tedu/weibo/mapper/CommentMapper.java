package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;

import java.util.List;

public interface CommentMapper {
    void insert(Comment comment);

    List<CommentVO> selectById(int id);
}
