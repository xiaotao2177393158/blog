package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpTermmeta;
import com.zhang.blogadmin.service.WpTermmetaService;
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
@Api(value = "WpTermmetaController")
@RestController
@RequestMapping("/wpTermmeta")
@CrossOrigin
public class WpTermmetaController {

    @Autowired
    private WpTermmetaService wpTermmetaService;

    /***
     * WpTermmeta分页条件搜索实现
     * @param wpTermmeta
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpTermmeta条件分页查询",notes = "分页条件查询WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpTermmeta对象",value = "传入JSON数据",required = false) WpTermmeta wpTermmeta, @PathVariable  int page, @PathVariable  int size){
        //调用WpTermmetaService实现分页条件查询WpTermmeta
        PageInfo<WpTermmeta> pageInfo = wpTermmetaService.findPage(wpTermmeta, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpTermmeta分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpTermmeta分页查询",notes = "分页查询WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpTermmetaService实现分页查询WpTermmeta
        PageInfo<WpTermmeta> pageInfo = wpTermmetaService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpTermmeta
     * @return
     */
    @ApiOperation(value = "WpTermmeta条件查询",notes = "条件查询WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @PostMapping(value = "/search" )
    public Result<List<WpTermmeta>> findList(@RequestBody(required = false) @ApiParam(name = "WpTermmeta对象",value = "传入JSON数据",required = false) WpTermmeta wpTermmeta){
        //调用WpTermmetaService实现条件查询WpTermmeta
        List<WpTermmeta> list = wpTermmetaService.findList(wpTermmeta);
        return new Result<List<WpTermmeta>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermmeta根据ID删除",notes = "根据ID删除WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpTermmetaService实现根据主键删除
        wpTermmetaService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpTermmeta数据
     * @param wpTermmeta
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermmeta根据ID修改",notes = "根据ID修改WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpTermmeta对象",value = "传入JSON数据",required = false) WpTermmeta wpTermmeta,@PathVariable Long id){
        //设置主键值
        wpTermmeta.setMetaId(id);
        //调用WpTermmetaService实现修改WpTermmeta
        wpTermmetaService.update(wpTermmeta);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpTermmeta数据
     * @param wpTermmeta
     * @return
     */
    @ApiOperation(value = "WpTermmeta添加",notes = "添加WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpTermmeta对象",value = "传入JSON数据",required = true) WpTermmeta wpTermmeta){
        //调用WpTermmetaService实现添加WpTermmeta
        wpTermmetaService.add(wpTermmeta);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpTermmeta数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpTermmeta根据ID查询",notes = "根据ID查询WpTermmeta方法详情",tags = {"WpTermmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpTermmeta> findById(@PathVariable Long id){
        //调用WpTermmetaService实现根据主键查询WpTermmeta
        WpTermmeta wpTermmeta = wpTermmetaService.findById(id);
        return new Result<WpTermmeta>(true,StatusCode.OK,"查询成功",wpTermmeta);
    }

    /***
     * 查询WpTermmeta全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpTermmeta",notes = "查询所WpTermmeta有方法详情",tags = {"WpTermmetaController"})
    @GetMapping
    public Result<List<WpTermmeta>> findAll(){
        //调用WpTermmetaService实现查询所有WpTermmeta
        List<WpTermmeta> list = wpTermmetaService.findAll();
        return new Result<List<WpTermmeta>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
