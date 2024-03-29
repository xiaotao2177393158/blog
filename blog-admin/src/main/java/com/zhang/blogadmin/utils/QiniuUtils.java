package com.zhang.blogadmin.utils;

import com.qiniu.common.QiniuException;
import com.qiniu.http.Response;
import com.google.gson.Gson;
import com.qiniu.storage.BucketManager;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.Region;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;
import com.zhang.blogadmin.config.Config;

/**
 * @author xiaotao
 * 七牛云工具类
 */
public class QiniuUtils {
    public static final String accessKey = Config.ACCESS_KEY;
    public static final String secretKey = Config.SECRET_KEY;
    public static final String bucket = Config.BUCKET;

    /**
     * @Description: 上传文件
     * @Param:
     * @return:
     * @Author: xiaotao
     * @Date: 2022/9/12
     */
    public static DefaultPutRet upload2Qiniu(String filePath,String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        UploadManager uploadManager = new UploadManager(cfg);
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(filePath, fileName, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet =
                    new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet;
        } catch (QiniuException ex) {
            Response r = ex.response;
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            return null;
        }
    }

    /**
     * @Description: 上传文件
     * @Param:
     * @return:
     * @Author: xiaotao
     * @Date: 2022/9/12
     */
    public static DefaultPutRet upload2Qiniu(byte[] bytes, String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        //...其他参数参考类注释
        UploadManager uploadManager = new UploadManager(cfg);
        //默认不指定key的情况下，以文件内容的hash值作为文件名
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        String upToken = auth.uploadToken(bucket);
        try {
            Response response = uploadManager.put(bytes, key, upToken);
            //解析上传成功的结果
            DefaultPutRet putRet =
                    new Gson().fromJson(response.bodyString(), DefaultPutRet.class);
            return putRet;
        } catch (QiniuException ex) {
            Response r = ex.response;
            System.err.println(r.toString());
            try {
                System.err.println(r.bodyString());
            } catch (QiniuException ex2) {
                //ignore
            }
            return null;
        }
    }

    /**
     * @Description: 删除文件
     * @Param:
     * @return:
     * @Author: xiaotao
     * @Date: 2022/9/12
     */
    public static void deleteFileFromQiniu(String fileName) {
        //构造一个带指定Zone对象的配置类
        Configuration cfg = new Configuration(Region.huanan());
        String key = fileName;
        Auth auth = Auth.create(accessKey, secretKey);
        BucketManager bucketManager = new BucketManager(auth, cfg);
        try {
            bucketManager.delete(bucket, key);
        } catch (QiniuException ex) {
            //如果遇到异常，说明删除失败
            System.err.println(ex.code());
            System.err.println(ex.response.toString());
        }
    }
}

