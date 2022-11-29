package cn.tedu.boot09.mapper;

import cn.tedu.boot09.entity.Weibo;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface WeiboMapper {
    @Insert("insert into weibo values(null,#{content},#{url})")
    void insert(Weibo weibo);

    @Select("select id,content,url from weibo")
    List<Weibo> select();
}
