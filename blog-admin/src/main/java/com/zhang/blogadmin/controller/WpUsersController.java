package com.zhang.blogadmin.controller;
import com.zhang.blogadmin.pojo.WpUsers;
import com.zhang.blogadmin.service.WpUsersService;
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
@Api(value = "WpUsersController")
@RestController
@RequestMapping("/wpUsers")
@CrossOrigin
public class WpUsersController {

    @Autowired
    private WpUsersService wpUsersService;

    /***
     * WpUsers分页条件搜索实现
     * @param wpUsers
     * @param page
     * @param size
     * @return
     */
    @ApiOperation(value = "WpUsers条件分页查询",notes = "分页条件查询WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @PostMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@RequestBody(required = false) @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers, @PathVariable  int page, @PathVariable  int size){
        //调用WpUsersService实现分页条件查询WpUsers
        PageInfo<WpUsers> pageInfo = wpUsersService.findPage(wpUsers, page, size);
        return new Result(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * WpUsers分页搜索实现
     * @param page:当前页
     * @param size:每页显示多少条
     * @return
     */
    @ApiOperation(value = "WpUsers分页查询",notes = "分页查询WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "path", name = "page", value = "当前页", required = true, dataType = "Integer"),
            @ApiImplicitParam(paramType = "path", name = "size", value = "每页显示条数", required = true, dataType = "Integer")
    })
    @GetMapping(value = "/search/{page}/{size}" )
    public Result<PageInfo> findPage(@PathVariable  int page, @PathVariable  int size){
        //调用WpUsersService实现分页查询WpUsers
        PageInfo<WpUsers> pageInfo = wpUsersService.findPage(page, size);
        return new Result<PageInfo>(true,StatusCode.OK,"查询成功",pageInfo);
    }

    /***
     * 多条件搜索品牌数据
     * @param wpUsers
     * @return
     */
    @ApiOperation(value = "WpUsers条件查询",notes = "条件查询WpUsers方法详情",tags = {"WpUsersController"})
    @PostMapping(value = "/search" )
    public Result<List<WpUsers>> findList(@RequestBody(required = false) @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers){
        //调用WpUsersService实现条件查询WpUsers
        List<WpUsers> list = wpUsersService.findList(wpUsers);
        return new Result<List<WpUsers>>(true,StatusCode.OK,"查询成功",list);
    }

    /***
     * 根据ID删除品牌数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID删除",notes = "根据ID删除WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @DeleteMapping(value = "/{id}" )
    public Result delete(@PathVariable Long id){
        //调用WpUsersService实现根据主键删除
        wpUsersService.delete(id);
        return new Result(true,StatusCode.OK,"删除成功");
    }

    /***
     * 修改WpUsers数据
     * @param wpUsers
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID修改",notes = "根据ID修改WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @PutMapping(value="/{id}")
    public Result update(@RequestBody @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = false) WpUsers wpUsers,@PathVariable Long id){
        //设置主键值
        wpUsers.setID(id);
        //调用WpUsersService实现修改WpUsers
        wpUsersService.update(wpUsers);
        return new Result(true,StatusCode.OK,"修改成功");
    }

    /***
     * 新增WpUsers数据
     * @param wpUsers
     * @return
     */
    @ApiOperation(value = "WpUsers添加",notes = "添加WpUsers方法详情",tags = {"WpUsersController"})
    @PostMapping
    public Result add(@RequestBody  @ApiParam(name = "WpUsers对象",value = "传入JSON数据",required = true) WpUsers wpUsers){
        //调用WpUsersService实现添加WpUsers
        wpUsersService.add(wpUsers);
        return new Result(true,StatusCode.OK,"添加成功");
    }

    /***
     * 根据ID查询WpUsers数据
     * @param id
     * @return
     */
    @ApiOperation(value = "WpUsers根据ID查询",notes = "根据ID查询WpUsers方法详情",tags = {"WpUsersController"})
    @ApiImplicitParam(paramType = "path", name = "id", value = "主键ID", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public Result<WpUsers> findById(@PathVariable Long id){
        //调用WpUsersService实现根据主键查询WpUsers
        WpUsers wpUsers = wpUsersService.findById(id);
        return new Result<WpUsers>(true,StatusCode.OK,"查询成功",wpUsers);
    }

    /***
     * 查询WpUsers全部数据
     * @return
     */
    @ApiOperation(value = "查询所有WpUsers",notes = "查询所WpUsers有方法详情",tags = {"WpUsersController"})
    @GetMapping
    public Result<List<WpUsers>> findAll(){
        //调用WpUsersService实现查询所有WpUsers
        List<WpUsers> list = wpUsersService.findAll();
        return new Result<List<WpUsers>>(true, StatusCode.OK,"查询成功",list) ;
    }
}
