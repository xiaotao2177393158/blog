package com.zhang.blogadmin.controller;

import com.github.pagehelper.PageInfo;
import com.qiniu.storage.model.DefaultPutRet;
import com.zhang.blogadmin.utils.IdWorker;
import com.zhang.blogadmin.utils.QiniuUtils;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: xiaotao
 * @Date: 2022/09/08/11:02
 * @Description: todo
 */
@Api(value = "UploadFileController")
@RestController
@RequestMapping("/upload")
@CrossOrigin
public class UploadFileController {
    /**
     * @Description: 图片上传
     * @Param:
     * @return:
     * @Author: xiaotao
     * @Date: 2022/9/8
     */
    @ApiOperation(value = "图片上传",notes = "图片上传",tags = {"UploadFileController"})
    @PostMapping(value = "/img" )
    public Result<PageInfo> findPage(@RequestParam MultipartFile file) {
        try {
            //获取原始文件名
            String originalFilename = file.getOriginalFilename();
            int lastIndexOf = originalFilename.lastIndexOf(".");
            //获取文件后缀
            String suffix = originalFilename.substring(lastIndexOf - 1);
            //使用UUID随机产生文件名称，防止同名文件覆盖
            IdWorker idWorker = new IdWorker(0,0);
            String fileName = idWorker.nextId() + suffix;
            DefaultPutRet defaultPutRet = QiniuUtils.upload2Qiniu(file.getBytes(), fileName);
            //图片上传成功
            return new Result(true, StatusCode.OK,"上传成功",defaultPutRet);
        } catch (Exception e) {
            e.printStackTrace();
            //图片上传失败
            return new Result(false,StatusCode.ERROR, "上传失败");
        }
    }
}
