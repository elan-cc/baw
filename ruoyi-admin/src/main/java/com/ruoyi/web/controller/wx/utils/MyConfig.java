package com.ruoyi.web.controller.wx.utils;

import com.github.wxpay.sdk.WXPayConfig;
import com.ruoyi.common.utils.StringUtils;
import com.ruoyi.web.wechat.WxAppletProperties;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class MyConfig implements WXPayConfig {
    
    private static final Logger log = LoggerFactory.getLogger(WXPayConfig.class);

    private byte[] certData;
    /*public MyConfig() throws Exception {
        log.info("------------------------------------------------------");
        String path = this.getClass().getClassLoader().getResource("apiclient_cert.p12").getPath();
        log.info("path : " + path);
        File file = new File(path);
        log.info("file.exists() : " + file.exists());
        String testPath = getUploadResource("apiclient_cert.p12");
        log.info("testPath : " + testPath);
        File testFile = new File(path);
        log.info("testFile.exists() : " + testFile.exists());
    
        InputStream certStream = new FileInputStream(file);
        this.certData = new byte[(int) file.length()];
        certStream.read(this.certData);
        certStream.close();
    }*/
    public MyConfig() throws Exception {
        //从微信商户平台下载的安全证书存放的路径
        InputStream certStream = MyConfig.class.getClassLoader().getResourceAsStream("apiclient_cert.p12");
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int ch;
        while ((ch = certStream.read(buffer)) != -1) {
            outputStream.write(buffer,0, ch);
        }
        this.certData = outputStream.toByteArray();
        certStream.read(this.certData);
        certStream.close();
    }
    
    
    public String getAppID() {
        return WxAppletProperties.APP_ID;
    }

    public String getMchID() {
        return WxAppletProperties.MCH_ID;
    }

    public String getKey() {
        return WxAppletProperties.PAY_SIGN_KEY;
    }

    public InputStream getCertStream() {
        ByteArrayInputStream certBis = new ByteArrayInputStream(this.certData);
        return certBis;
    }

    public int getHttpConnectTimeoutMs() {
        return 8000;
    }

    public int getHttpReadTimeoutMs() {
        return 10000;
    }
    
    public static void main(String[] args) throws Exception {
        MyConfig myConfig = new MyConfig();
        String uploadResource = myConfig.getUploadResource("apiclient_cert.p12");
        System.out.println(uploadResource);
    }
    public String getUploadResource(String fileName) {
        //返回读取指定资源的输入流
        InputStream is = this.getClass().getResourceAsStream(fileName);
        
        //若文件已存在，则返回的filePath中含有"EXIST"，则不需再重写文件
        String filePath = createFile(fileName);
        
        //文件不存在，则创建流输入默认数据到新文件
        if (!filePath.contains("EXIST")) {
            File file = new File(filePath);
            inputStreamToFile(is, file);
            return filePath;
        }
        return filePath.substring(5);
    }
    
    public String createFile(String filename) {
        String path = System.getProperty("user.dir");
        //create folder
        String dirPath = path;
        File dir = new File(dirPath);
        dir.mkdirs();
        
        //create file
        String filePath = dirPath + File.separator + filename;
        File file = new File(filePath);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return filePath;
        }
        return "EXIST" + filePath;
    }
    
    public void inputStreamToFile(InputStream ins, File file) {
        OutputStream os = null;
        try {
            os = new FileOutputStream(file);
            
            int bytesRead = 0;
            byte[] buffer = new byte[8192];
            while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
                os.write(buffer, 0, bytesRead);
            }
            os.close();
            ins.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
