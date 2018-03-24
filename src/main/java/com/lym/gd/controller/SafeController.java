package com.lym.gd.controller;

import com.alibaba.fastjson.JSONObject;
import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.lym.gd.utils.NumberUtil;
import com.lym.gd.utils.ResultVOUtil;
import com.lym.gd.vo.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.lang.reflect.Type;

/**
 * @author liuyaming
 * @date 2018/3/15 下午10:52
 */
@Controller
public class SafeController {

  private final DefaultKaptcha defaultKaptcha;

  @Autowired
  public SafeController(DefaultKaptcha defaultKaptcha) {
    this.defaultKaptcha = defaultKaptcha;
  }

  @GetMapping("/pictureVerifyCode")
  public void pictureComputeVerify(
      HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,String type)
      throws IOException {

    byte[] captchaChallengeAsJpeg;
    ByteArrayOutputStream jpegOutputStream = new ByteArrayOutputStream();
    try {
      // 生成验证码字符串并保存到session中
      int v1 = NumberUtil.randomNumber(100);
      int v2 = NumberUtil.randomNumber(100);
      int result = v1 + v2;
      String string = "" + v1 +"+"+ v2 + "=?";

      httpServletRequest.getSession().setAttribute("pictureVerifyCode"+type, String.valueOf(result));

      // 使用生产的验证码字符串返回一个BufferedImage对象并转为byte写入到byte数组中
      BufferedImage challenge = defaultKaptcha.createImage(string);
      ImageIO.write(challenge, "jpg", jpegOutputStream);
    } catch (IllegalArgumentException e) {
      httpServletResponse.sendError(HttpServletResponse.SC_NOT_FOUND);
      return;
    }

    // 定义response输出类型为image/jpeg类型，使用response输出流输出图片的byte数组
    captchaChallengeAsJpeg = jpegOutputStream.toByteArray();
    httpServletResponse.setHeader("Cache-Control", "no-store");
    httpServletResponse.setHeader("Pragma", "no-cache");
    httpServletResponse.setDateHeader("Expires", 0);
    httpServletResponse.setContentType("image/jpeg");
    ServletOutputStream responseOutputStream = httpServletResponse.getOutputStream();
    responseOutputStream.write(captchaChallengeAsJpeg);
    responseOutputStream.flush();
    responseOutputStream.close();
  }

  @PostMapping("/checkPictureCode")
  @ResponseBody
  public ResultVO checkPictureCode(
          HttpServletRequest request, @RequestBody JSONObject jsonObject){
        String type = jsonObject.getString("type");
        String code = jsonObject.getString("code");

        //正确答案
        String picResult = (String) request.getSession().getAttribute("pictureVerifyCode"+type);

        boolean result = (picResult == null || !code.equals(picResult));
        if (result){
            ResultVO resultVO = ResultVOUtil.error("验证码不正确！！！");
            return resultVO;
        }

      return ResultVOUtil.success();
  }

}
