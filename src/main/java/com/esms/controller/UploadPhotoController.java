package com.esms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @program: ssm
 * @Author：admin
 * @Description：
 * @Date：1:48 2019/10/8
 * @Version: 1.0
 */
@Controller
public class UploadPhotoController {
    @RequestMapping("uploadPhoto.do")
    @ResponseBody
    public Object updateHeadPhoto(@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request, HttpServletResponse response) throws Exception {
        // 文件后缀
        String prefix = "";
        // 时间前缀
        String dateStr = "";
        //保存上传
        OutputStream out = null;
        InputStream fileInput = null;
        // 随机数前缀
        double index = 1000 * (Math.random());
        DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            if (file != null) {
                String originalName = file.getOriginalFilename();
                prefix = originalName.substring(originalName.lastIndexOf(".") + 1);
                dateStr = format.format(new Date());
                String filepath = request.getServletContext().getRealPath("/img/head/") + dateStr + index + "." + prefix;
                filepath = filepath.replace("\\", "/");
                File files = new File(filepath);
                //打印查看上传路径
                System.out.println(filepath);
                if (!files.getParentFile().exists()) {
                    files.getParentFile().mkdirs();
                }
                file.transferTo(files);
            }
        } catch (Exception e) {
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
                if (fileInput != null) {
                    fileInput.close();
                }
            } catch (IOException e) {
            }
        }
        Map<String, Object> map2 = new HashMap<String, Object>();
        Map<String, Object> map = new HashMap<String, Object>();
        // 返回上传后的图片地址 img/head/……jpg
        map2.put("src", "/ssm_esms/img/head/" + dateStr + index + "." + prefix);
        map.put("code", 0);
        map.put("msg", "");
        map.put("data", map2);
        return map;
    }
}
