package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpUsermeta;
import com.zhang.blogadmin.service.WpUsermetaService;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.utils.Result;
import com.zhang.blogadmin.utils.StatusCode;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/****
 * @Author:xiaotao
 * @Description:
 * @Date 2019/6/14 0:18
 *****/
@Api(value = "WpUsermetaController")
@RestController
@RequestMapping("/wpUsermeta")
@CrossOrigin
public class WpUsermetaController {

    @Autowired
    private WpUsermetaService wpUsermetaService;

    /***
     * WpUsermeta分页条件搜索实现
     * @param wpUsermeta
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpUsermeta条件分页查询",notes = "分页条件查询WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpUsermeta对象",value = "传入JSON数据",required = false) WpUsermeta wpUsermeta, @PathVariable  int page, @PathVariable  int size){
        //调用WpUsermetaService实现分页条件查询WpUsermeta
        PageInfo<WpUsermeta> pageInfo = wpUsermetaService.findPage(wpUsermeta, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpUsermeta分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpUsermeta分页查询",notes = "分页查询WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpUsermetaService实现分页查询WpUsermeta
        PageInfo<WpUsermeta> pageInfo = wpUsermetaService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpUsermeta
     * @return
     */
    @ApiOperation(value = "WpUsermeta条件查询",notes = "条件查询WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @PostMapping(value = "/search" )
    public Result<List<WpUsermeta>> findList(@RequestBody(required = false) @ApiParam(name = "WpUsermeta对象",value = "传入JSON数据",required = false) WpUsermeta wpUsermeta){
        //调用WpUsermetaService实现条件查询WpUsermeta
        List<WpUsermeta> list = wpUsermetaService.findList(wpUsermeta);
        return new Result<List<WpUsermeta>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsermeta根据ID删除",notes = "根据ID删除WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpUsermetaService实现根据主键删除
        wpUsermetaService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpUsermeta数据
     * @param wpUsermeta
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsermeta根据ID修改",notes = "根据ID修改WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpUsermeta对象",value = "传入JSON数据",required = false) WpUsermeta wpUsermeta,@PathVariable Long id){
        //设置主键值
        wpUsermeta.setUmetaId(id);
        //调用WpUsermetaService实现修改WpUsermeta
        wpUsermetaService.update(wpUsermeta);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpUsermeta数据
     * @param wpUsermeta
     * @return
     */
    @ApiOperation(value = "WpUsermeta添加",notes = "添加WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpUsermeta对象",value = "传入JSON数据",required = true) WpUsermeta wpUsermeta){
        //调用WpUsermetaService实现添加WpUsermeta
        wpUsermetaService.add(wpUsermeta);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpUsermeta数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsermeta根据ID查询",notes = "根据ID查询WpUsermeta方法详情",tags = {"WpUsermetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpUsermeta> findById(@PathVariable Long id){
        //调用WpUsermetaService实现根据主键查询WpUsermeta
        WpUsermeta wpUsermeta = wpUsermetaService.findById(id);
        return new Result<WpUsermeta>(true,StatusCode.OK,"查询成功",wpUsermeta);
    }

    /***
     * 查询WpUsermeta全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpUsermeta",notes = "查询所WpUsermeta有方法详情",tags = {"WpUsermetaController"})
    @GetMapping
    public Result<List<WpUsermeta>> findAll(){
        //调用WpUsermetaService实现查询所有WpUsermeta
        List<WpUsermeta> list = wpUsermetaService.findAll();
        return new Result<List<WpUsermeta>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
