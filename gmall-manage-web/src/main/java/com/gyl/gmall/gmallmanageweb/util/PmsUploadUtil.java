package com.gyl.gmall.gmallmanageweb.util;

import com.gyl.gmall.gmallmanageweb.GmallManageWebApplication;
import org.csource.common.MyException;
import org.csource.fastdfs.ClientGlobal;
import org.csource.fastdfs.StorageClient;
import org.csource.fastdfs.TrackerClient;
import org.csource.fastdfs.TrackerServer;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public class PmsUploadUtil {

    public static String uploadImage(MultipartFile multipartFile) throws IOException, MyException {
        String imgUrl="";

        //配置fdfs的全局链接地址
        String tracker=GmallManageWebApplication.class.getResource("/tracker.conf").getPath();//获得配置文件的路径
        ClientGlobal.init(tracker);
        TrackerClient trackerClient=new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        //通过tracker获得一个Storage连接客户端
        StorageClient storageClient = new StorageClient(trackerServer,null);

        //获得上传的二进制对象
        byte[] bytes = multipartFile.getBytes();
        //xxx.jpg
        String originalFilename = multipartFile.getOriginalFilename();
        int i = originalFilename.lastIndexOf(".");
        String extName = originalFilename.substring(i+1);
        String[] uploadInfos = storageClient.upload_file(bytes, extName, null);
        String url="http://192.168.1.128:8888";
        for (String uploadinfo:uploadInfos) {
            url = url + "/" + uploadinfo;
        }

        return url;
    }
}
