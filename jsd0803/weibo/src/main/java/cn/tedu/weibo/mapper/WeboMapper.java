package cn.tedu.weibo.mapper;

import cn.tedu.weibo.pojo.entity.Weibo;
import cn.tedu.weibo.pojo.vo.WeiboDeteilVO;
import cn.tedu.weibo.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeboMapper {
    void insert(Weibo weibo);

    List<WeiboIndexVO> selectIndex();

    WeiboIndexVO selectIndexById(int id);

    WeiboDeteilVO selectById(int id);
}
