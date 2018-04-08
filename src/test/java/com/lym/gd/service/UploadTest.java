package com.lym.gd.service;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UploadTest {

    @Value("${ali.AccessKeyID}")
    private String accessKeyID;

    @Value("${ali.AccessKeySecret}")
    private String accessKeySecret;

    @Value("${ali.EndPoint}")
    private String endPoint;

    @Value("${ali.BucketName}")
    private String bucketName;

    @Test
    public void upload() throws IOException {
        OSS oss = new OSSClient(endPoint,accessKeyID,accessKeySecret);

        File file = File.createTempFile("abc",".txt");
        Writer writer = new OutputStreamWriter(new FileOutputStream(file));
        writer.write("abcdefghijklmnopqrstuvwxyz\n");
        writer.write("0123456789011234567890\n");
        writer.close();


        if (oss.doesBucketExist(bucketName)){
            System.out.println("bucket "+bucketName+"存在");

            oss.putObject(bucketName,"zifuchuan.txt",file);
        }

        oss.shutdown();

    }

}
