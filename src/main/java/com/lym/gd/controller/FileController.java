package com.lym.gd.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.PutObjectResult;
import com.lym.gd.utils.IdUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.util.HashMap;
import java.util.Map;

@Controller
public class FileController {
  @Value("${ali.AccessKeyID}")
  private String accessKeyID;

  @Value("${ali.AccessKeySecret}")
  private String accessKeySecret;

  @Value("${ali.EndPoint}")
  private String endPoint;

  @Value("${ali.BucketName}")
  private String bucketName;

  @PostMapping("/upload")
  @ResponseBody
  public Map upload(@RequestParam("file") MultipartFile file) {
    OSS oss = new OSSClient(endPoint, accessKeyID, accessKeySecret);
    Map result = new HashMap();

    try {
      // OSS 中文件名
      String fileName = IdUtils.getFileID() + "###" + file.getOriginalFilename();
      // 上传文件
      oss.putObject(bucketName, fileName, file.getInputStream());

      // 文件上传后生成的URL
      String URL = "https://" + bucketName + "." + endPoint + "/" + fileName;
      result.put("code","0");
      result.put("msg","success");
      result.put("url",URL);

    } catch (Exception e) {
      result.put("code","1");
      result.put("code","上传失败，请重新登录或稍后操作");
      e.printStackTrace();
    } finally {
      oss.shutdown();
    }

    return result;
  }

  @PostMapping("/uploadImg")
  @ResponseBody
  public Map uploadImg(@RequestParam("file") MultipartFile file){
    Map map = new HashMap(16);
    OSS oss = new OSSClient(endPoint, accessKeyID, accessKeySecret);

    try {
      // OSS 中文件名
      String fileName = IdUtils.getFileID() + "###" + file.getOriginalFilename();
      // 上传文件
      oss.putObject(bucketName, fileName, file.getInputStream());

      // 文件上传后生成的URL
      String URL = "https://" + bucketName + "." + endPoint + "/" + fileName;
      URL = URL.replace("#","%23");
      map.put("code","0");
      map.put("msg","success");

      Map data = new HashMap();
      data.put("src",URL);

      map.put("data",data);

    } catch (Exception e) {
      map.put("code","1");
      map.put("code","上传失败，请重新登录或稍后操作");
      e.printStackTrace();
    } finally {
      oss.shutdown();
    }

    return map;
  }
}
