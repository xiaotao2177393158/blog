package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpPostmeta;
import com.zhang.blogadmin.service.WpPostmetaService;
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
@Api(value = "WpPostmetaController")
@RestController
@RequestMapping("/wpPostmeta")
@CrossOrigin
public class WpPostmetaController {

    @Autowired
    private WpPostmetaService wpPostmetaService;

    /***
     * WpPostmeta分页条件搜索实现
     * @param wpPostmeta
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpPostmeta条件分页查询",notes = "分页条件查询WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpPostmeta对象",value = "传入JSON数据",required = false) WpPostmeta wpPostmeta, @PathVariable  int page, @PathVariable  int size){
        //调用WpPostmetaService实现分页条件查询WpPostmeta
        PageInfo<WpPostmeta> pageInfo = wpPostmetaService.findPage(wpPostmeta, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpPostmeta分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpPostmeta分页查询",notes = "分页查询WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpPostmetaService实现分页查询WpPostmeta
        PageInfo<WpPostmeta> pageInfo = wpPostmetaService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpPostmeta
     * @return
     */
    @ApiOperation(value = "WpPostmeta条件查询",notes = "条件查询WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @PostMapping(value = "/search" )
    public Result<List<WpPostmeta>> findList(@RequestBody(required = false) @ApiParam(name = "WpPostmeta对象",value = "传入JSON数据",required = false) WpPostmeta wpPostmeta){
        //调用WpPostmetaService实现条件查询WpPostmeta
        List<WpPostmeta> list = wpPostmetaService.findList(wpPostmeta);
        return new Result<List<WpPostmeta>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPostmeta根据ID删除",notes = "根据ID删除WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpPostmetaService实现根据主键删除
        wpPostmetaService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpPostmeta数据
     * @param wpPostmeta
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPostmeta根据ID修改",notes = "根据ID修改WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpPostmeta对象",value = "传入JSON数据",required = false) WpPostmeta wpPostmeta,@PathVariable Long id){
        //设置主键值
        wpPostmeta.setMetaId(id);
        //调用WpPostmetaService实现修改WpPostmeta
        wpPostmetaService.update(wpPostmeta);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpPostmeta数据
     * @param wpPostmeta
     * @return
     */
    @ApiOperation(value = "WpPostmeta添加",notes = "添加WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpPostmeta对象",value = "传入JSON数据",required = true) WpPostmeta wpPostmeta){
        //调用WpPostmetaService实现添加WpPostmeta
        wpPostmetaService.add(wpPostmeta);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpPostmeta数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpPostmeta根据ID查询",notes = "根据ID查询WpPostmeta方法详情",tags = {"WpPostmetaController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpPostmeta> findById(@PathVariable Long id){
        //调用WpPostmetaService实现根据主键查询WpPostmeta
        WpPostmeta wpPostmeta = wpPostmetaService.findById(id);
        return new Result<WpPostmeta>(true,StatusCode.OK,"查询成功",wpPostmeta);
    }

    /***
     * 查询WpPostmeta全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpPostmeta",notes = "查询所WpPostmeta有方法详情",tags = {"WpPostmetaController"})
    @GetMapping
    public Result<List<WpPostmeta>> findAll(){
        //调用WpPostmetaService实现查询所有WpPostmeta
        List<WpPostmeta> list = wpPostmetaService.findAll();
        return new Result<List<WpPostmeta>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
