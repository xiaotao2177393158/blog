package com.zhang.blogadmin.service;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpPermission;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPermission业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpPermissionService {

    /**
     * 找到当前用户的权限
     * */
    List<WpPermission> getUserRolesByUserId(Integer id);

    /***
     * WpPermission多条件分页查询
     * @param wpPermission
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPermission> findPage(WpPermission wpPermission, int page, int size);

    /***
     * WpPermission分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPermission> findPage(int page, int size);

    /***
     * WpPermission多条件搜索方法
     * @param wpPermission
     * @return
     */
    List<WpPermission> findList(WpPermission wpPermission);

    /***
     * 删除WpPermission
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpPermission数据
     * @param wpPermission
     */
    void update(WpPermission wpPermission);

    /***
     * 新增WpPermission
     * @param wpPermission
     */
    void add(WpPermission wpPermission);

    /**
     * 根据ID查询WpPermission
     * @param id
     * @return
     */
     WpPermission findById(Long id);

    /***
     * 查询所有WpPermission
     * @return
     */
    List<WpPermission> findAll();
}
