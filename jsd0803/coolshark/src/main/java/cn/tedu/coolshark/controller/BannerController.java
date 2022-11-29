package cn.tedu.coolshark.controller;

import cn.tedu.coolshark.mapper.BannerMapper;
import cn.tedu.coolshark.pojo.entity.Banner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.util.List;

@RestController
@RequestMapping("/banner")
public class BannerController {
    @Autowired(required = false)
    BannerMapper mapper;
    @Value("${dirPath}")
    private String dirPath;

    @RequestMapping("/select")
    public List<Banner> select() {
        return mapper.select();
    }

    @RequestMapping("delete")
    public void delete(int id) {
        // 通过id查询到图片路径，然后删除
        String url = mapper.selectById(id);
        // d:/files/xxx.jpg
        new File(dirPath + url).delete();
        mapper.deleteById(id);
    }

    @RequestMapping("/insert")
    public void insert(String url) {
        mapper.insert(url);
    }

    @RequestMapping("/selectById")
    public String selectById(int id) {
        return mapper.selectById(id);
    }

    @RequestMapping("/update")
    public void update(@RequestBody Banner banner) {
        mapper.update(banner);
    }


}
