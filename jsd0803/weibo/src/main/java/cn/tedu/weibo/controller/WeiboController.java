package cn.tedu.weibo.controller;

import cn.tedu.weibo.mapper.WeboMapper;
import cn.tedu.weibo.pojo.dto.WeiboDTO;
import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.UserVO;
import cn.tedu.weibo.pojo.vo.WeiboDeteilVO;
import cn.tedu.weibo.pojo.vo.WeiboIndexVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.io.File;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/weibo")
public class WeiboController {
    @Autowired(required = false)
    WeboMapper mapper;


    @RequestMapping("/insert")
    public int insert(HttpSession session, @RequestBody WeiboDTO weibo){
        // 获取登录成功时保存的用户对象
        UserVO u = (UserVO) session.getAttribute("user");
        if (u==null) {
            // 没有登陆需要删除上传成功的图片, "/a.jpg,/b.jpg,/c.jpg"
            for (String url : weibo.getUrls().split(",")){
                // 删除遍历的每一张图片
                new File("d:/files"+url).delete();
            }
            return 2; // 没有登陆
        }

        // id content urls created(发布时间) user_id(用户id)
        Weibo w = new Weibo();
        // 把dto里面的数据装进实体类中
        BeanUtils.copyProperties(weibo,w);
        // 设置微博的作者
        w.setUserId(u.getId());
        // 设置微博的时间 new Date() 得到的是当前系统的时间
        w.setCreated(new Date());
        // 保存到数据库
         mapper.insert(w);
        return 1;  // 发布成功
    }

    @RequestMapping("/select")
    public List<WeiboIndexVO> select(){
        return mapper.selectIndex();
    }

    @RequestMapping("/selectById")
    public WeiboDeteilVO selectById(int id){
        return mapper.selectById(id);
    }
}
