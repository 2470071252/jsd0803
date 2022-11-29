package cn.tedu.weibo02.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public  String upload(MultipartFile pic) throws IOException {
        String fileName = pic.getOriginalFilename();
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        fileName = UUID.randomUUID()+suffix;
        //得到文件夹路径
        String dirPath = "d:/files";
        File dirFile = new File(dirPath);
        if (!dirFile.exists()){
            dirFile.mkdirs();
        }
        //准备图片路径
        String filePath = dirPath+"/"+fileName;
        //把文件保存 到指定路径  异常抛出
        pic.transferTo(new File(filePath));
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url){
        // 图片路径： /xxx.jpg --->需要转化成d:/files/xxx.jpg
        new File("d:/files"+url).delete();
    }
}
