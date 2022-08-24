package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.service.WpCommentmetaService;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import com.zhang.blogadmin.pojo.WpCommentmeta;
import com.github.pagehelper.PageInfo;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:xiaotao
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "WpCommentmetaController")
@RestController
@RequestMapping("/wpCommentmeta")
@CrossOrigin
public class WpCommentmetaController {

    @Autowired
    private WpCommentmetaService wpCommentmetaService;

    /***
     * WpCommentmeta分页条件搜索实现
     * @param wpCommentmeta
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpCommentmeta条件分页查询",notes = "分页条件查询WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpCommentmeta对象",value = "传入JSON数据",required = false) WpCommentmeta wpCommentmeta, @PathVariable  int page, @PathVariable  int size){
        //调用WpCommentmetaService实现分页条件查询WpCommentmeta
        PageInfo<WpCommentmeta> pageInfo = wpCommentmetaService.findPage(wpCommentmeta, page, size);
        return new Result(true, StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpCommentmeta分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpCommentmeta分页查询",notes = "分页查询WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpCommentmetaService实现分页查询WpCommentmeta
        PageInfo<WpCommentmeta> pageInfo = wpCommentmetaService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpCommentmeta
     * @return
     */
    @ApiOperation(value = "WpCommentmeta条件查询",notes = "条件查询WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @PostMapping(value = "/search" )
    public Result<List<WpCommentmeta>> findList(@RequestBody(required = false) @ApiParam(name = "WpCommentmeta对象",value = "传入JSON数据",required = false) WpCommentmeta wpCommentmeta){
        //调用WpCommentmetaService实现条件查询WpCommentmeta
        List<WpCommentmeta> list = wpCommentmetaService.findList(wpCommentmeta);
        return new Result<List<WpCommentmeta>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpCommentmeta根据ID删除",notes = "根据ID删除WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpCommentmetaService实现根据主键删除
        wpCommentmetaService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpCommentmeta数据
     * @param wpCommentmeta
     * @param id
     * @return
     */
    @ApiOperation(value = "WpCommentmeta根据ID修改",notes = "根据ID修改WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpCommentmeta对象",value = "传入JSON数据",required = false) WpCommentmeta wpCommentmeta,@PathVariable Long id){
        //设置主键值
        wpCommentmeta.setMetaId(id);
        //调用WpCommentmetaService实现修改WpCommentmeta
        wpCommentmetaService.update(wpCommentmeta);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpCommentmeta数据
     * @param wpCommentmeta
     * @return
     */
    @ApiOperation(value = "WpCommentmeta添加",notes = "添加WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpCommentmeta对象",value = "传入JSON数据",required = true) WpCommentmeta wpCommentmeta){
        //调用WpCommentmetaService实现添加WpCommentmeta
        wpCommentmetaService.add(wpCommentmeta);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpCommentmeta数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpCommentmeta根据ID查询",notes = "根据ID查询WpCommentmeta方法详情",tags = {"WpCommentmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpCommentmeta> findById(@PathVariable Long id){
        //调用WpCommentmetaService实现根据主键查询WpCommentmeta
        WpCommentmeta wpCommentmeta = wpCommentmetaService.findById(id);
        return new Result<WpCommentmeta>(true,StatusCode.OK,"查询成功",wpCommentmeta);
    }

    /***
     * 查询WpCommentmeta全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpCommentmeta",notes = "查询所WpCommentmeta有方法详情",tags = {"WpCommentmetaController"})
    @GetMapping
    public Result<List<WpCommentmeta>> findAll(){
        //调用WpCommentmetaService实现查询所有WpCommentmeta
        List<WpCommentmeta> list = wpCommentmetaService.findAll();
        return new Result<List<WpCommentmeta>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
