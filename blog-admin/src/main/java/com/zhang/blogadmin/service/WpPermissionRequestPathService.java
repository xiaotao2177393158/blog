package com.zhang.blogadmin.service;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpPermissionRequestPath;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPermissionRequestPath业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpPermissionRequestPathService {

    /***
     * WpPermissionRequestPath多条件分页查询
     * @param wpPermissionRequestPath
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPermissionRequestPath> findPage(WpPermissionRequestPath wpPermissionRequestPath, int page, int size);

    /***
     * WpPermissionRequestPath分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPermissionRequestPath> findPage(int page, int size);

    /***
     * WpPermissionRequestPath多条件搜索方法
     * @param wpPermissionRequestPath
     * @return
     */
    List<WpPermissionRequestPath> findList(WpPermissionRequestPath wpPermissionRequestPath);

    /***
     * 删除WpPermissionRequestPath
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpPermissionRequestPath数据
     * @param wpPermissionRequestPath
     */
    void update(WpPermissionRequestPath wpPermissionRequestPath);

    /***
     * 新增WpPermissionRequestPath
     * @param wpPermissionRequestPath
     */
    void add(WpPermissionRequestPath wpPermissionRequestPath);

    /**
     * 根据ID查询WpPermissionRequestPath
     * @param id
     * @return
     */
     WpPermissionRequestPath findById(Long id);

    /***
     * 查询所有WpPermissionRequestPath
     * @return
     */
    List<WpPermissionRequestPath> findAll();
}
