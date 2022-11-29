package cn.tedu.boot09.controller;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.xml.ws.RequestWrapper;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
public class UploadController {
    @RequestMapping("/upload")
    public String upload(MultipartFile pic) throws IOException {
        System.out.println("pic="+pic);
        // 得到原始文件名 微信截图_20221111204850.png
        String fileName = pic.getOriginalFilename();
        System.out.println(fileName);
        // 得到文件后缀 .png
        String suffix = fileName.substring(fileName.lastIndexOf("."));
        // 得到唯一文件名UUID.randomUUID()得到一个16进制组成的一个唯一标识符
        fileName = UUID.randomUUID()+suffix;
        System.out.println(fileName);
        //准备保存图片的文件夹路径
        String dirPath = "d:/files";
        File dirFile = new File(dirPath);
        //判断如果文件夹不存在 则创建
        if (!dirFile.exists()){
            dirFile.mkdirs();//创建文件夹
        }
        //准备文件的完整路径  d:/files/xxxxx.jpg
        String filePath = dirPath+"/"+fileName;
        //把图片保存到指定路径  异常抛出
        pic.transferTo(new File(filePath));
        // 将上传成功的图片路径响应给客户端
        // 响应的是网络路径并非是磁盘路径
        return "/"+fileName;
    }

    @RequestMapping("/remove")
    public void remove(String url){
        // url=/xxxx.png
        // 删除指定路径的文件  d:/files/xxx.png
        new File("d:/files"+url).delete();
    }

}
