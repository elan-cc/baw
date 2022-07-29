package com.ruoyi.web.utils;


import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * @author ruoyi
 * @date 2022年04月02日14:58
 */
public class FileTypeUtil {
    private final static Map<String, String> FILE_TYPE_MAP = new HashMap<String, String>();
    public FileTypeUtil(){}

    static{
        getAllFileType();  //初始化文件类型信息
    }

    private static void getAllFileType() {
        FILE_TYPE_MAP.put("ffd8ffe000104a464946", "jpg"); //JPEG (jpg)
        FILE_TYPE_MAP.put("89504e470d0a1a0a0000", "png"); //PNG (png)
        FILE_TYPE_MAP.put("47494638396126026f01", "gif"); //GIF (gif)
        FILE_TYPE_MAP.put("49492a00227105008037", "tif"); //TIFF (tif)
        FILE_TYPE_MAP.put("424d228c010000000000", "bmp"); //16色位图(bmp)
        FILE_TYPE_MAP.put("424d8240090000000000", "bmp"); //24位位图(bmp)
        FILE_TYPE_MAP.put("424d8e1b030000000000", "bmp"); //256色位图(bmp)

    }

    /**
     * 得到上传文件的文件头
     * @param src
     * @return
     */
    public static String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder();
        if(null==src || src.length <= 0){
            return null;
        }
        for(int i = 0; i < src.length; i++){
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if(hv.length() < 2){
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    /**
     * 获取文件类型
     * @param file
     * @return
     */
    public static String getFileType(File file){
        String res = null;
        FileInputStream fis = null;
        try{
            fis = new FileInputStream( file);
            //获取文件头的前六位
            byte[] b = new byte[3];
            fis.read(b, 0, b.length);
            String fileCode = bytesToHexString(b);
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while(keyIter.hasNext()){
                String key = keyIter.next();
                //比较前几位是否相同就可以判断文件格式（相同格式文件文件头后面几位会有所变化）
                if(key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())){
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
            fis.close();
        }catch(FileNotFoundException e){
            e.printStackTrace();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                fis.close();
            }catch (IOException e) {
                e.printStackTrace();
            }
        }
        return res;
    }

    /**
     * 获取文件类型
     * @param src
     * @return
     */
    public static String getFileType(byte[] src){
        String res = null;
        try {
            String fileCode = bytesToHexString(src);
            Iterator<String> keyIter = FILE_TYPE_MAP.keySet().iterator();
            while(keyIter.hasNext()){
                String key = keyIter.next();
                //比较前几位是否相同就可以判断文件格式（相同格式文件文件头后面几位会有所变化）
                if(key.toLowerCase().startsWith(fileCode.toLowerCase()) || fileCode.toLowerCase().startsWith(key.toLowerCase())){
                    res = FILE_TYPE_MAP.get(key);
                    break;
                }
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return res;
    }

}
