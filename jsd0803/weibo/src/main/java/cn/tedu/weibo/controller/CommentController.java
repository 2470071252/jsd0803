package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.CommentMapper;
import cn.tedu.weibo.pojo.dto.CommentDTO;
import cn.tedu.weibo.pojo.entity.Comment;
import cn.tedu.weibo.pojo.vo.CommentVO;
import cn.tedu.weibo.pojo.vo.UserVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

// 有什么表，就有什么controller，就有什么pojo，就有什么mapper
@RestController
@RequestMapping("/comment")
public class CommentController<list> {
    @Autowired(required = false)
    CommentMapper mapper;

    @RequestMapping("/insert")
    public int insert(@RequestBody CommentDTO comment, HttpSession session){
        UserVO user = (UserVO) session.getAttribute("user");
        if (user==null) {
            return 2; // 代表未登陆
        }
        Comment c = new Comment();
        BeanUtils.copyProperties(comment,c);
        // 设置用户id
        c.setUserId(user.getId());
        // 设置时间
        c.setCreated(new Date());
        // 保存到数据库
        mapper.insert(c);
        return 1;
    }

    @RequestMapping("/selectByWeiboId")
    public List<CommentVO> selectByWeibo(int id){
        return mapper.selectById(id);
    }


}
