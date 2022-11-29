package cn.tedu.weibo02.mapper;

import cn.tedu.weibo02.pojo.entity.Weibo;
import cn.tedu.weibo02.pojo.vo.WeiboDeteilVO;
import cn.tedu.weibo02.pojo.vo.WeiboIndexVO;

import java.util.List;

public interface WeboMapper {
    void insert(Weibo weibo);

    List<WeiboIndexVO> selectIndex();

    WeiboIndexVO selectIndexById(int id);

    WeiboDeteilVO selectById(int id);
}
