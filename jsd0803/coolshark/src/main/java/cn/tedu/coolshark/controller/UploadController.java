package cn.tedu.coolshark.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    // @Value 注解作用是给下面变量赋值，
    // ${xx} 读取application.properties配置文件中的xx数据
    @Value("${dirPath}")
    private String dirPath;

    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        //得到原始文件名
        String fileName = pic.getOriginalFilename();
        //得到后缀
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        //得到唯一文件名
        fileName = UUID.randomUUID()+suffix;
        //得到保存图片的文件夹路径
        //String dirPath = "d:/files";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        String filePath = dirPath+"/"+fileName;
        //保存图片到指定的路径  异常抛出
        pic.transferTo(new File(filePath));
        return "/"+fileName;//把文件路径响应给客户端


    }

    @RequestMapping("/remove")
    public void remove(String url){
        System.out.println("url = " + url);
        //删除文件
        new File(dirPath+url).delete();

    }
}
