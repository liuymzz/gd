package com.lym.gd.service;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsRequest;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.lym.gd.DTO.AliSMSDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author liuyaming
 * @date 2018/5/4 上午11:19
 */
@Service
public class SMSService {

    @Value("${ali.AccessKeyID}")
    private String aliAccessKeyID;

    @Value("${ali.AccessKeySecret}")
    private String aliAccessKeySecret;

    public SendSmsResponse sendSMS(AliSMSDTO aliSMSDTO) throws Exception{
        //设置超时时间-可自行调整
        System.setProperty("sun.net.client.defaultConnectTimeout", "10000");
        System.setProperty("sun.net.client.defaultReadTimeout", "10000");

        final String product = "Dysmsapi";
        final String domain = "dysmsapi.aliyuncs.com";

        final String accessKeyId = aliAccessKeyID;
        final String accessKeySecret = aliAccessKeySecret;

        IClientProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId,
                accessKeySecret);
        DefaultProfile.addEndpoint("cn-hangzhou", "cn-hangzhou", product, domain);

        IAcsClient acsClient = new DefaultAcsClient(profile);
        //组装请求对象
        SendSmsRequest request = new SendSmsRequest();
        //使用post提交
        request.setMethod(MethodType.POST);
        request.setPhoneNumbers(aliSMSDTO.getPhoneNum());
        request.setSignName(aliSMSDTO.getSignName());
        request.setTemplateCode(aliSMSDTO.getTemplateCode());
        request.setTemplateParam(aliSMSDTO.getTemplateParam());
        //请求失败这里会抛ClientException异常
        SendSmsResponse sendSmsResponse = acsClient.getAcsResponse(request);

        return sendSmsResponse;
    }

}
