package com.zhang.blogadmin.service;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpPermissionRole;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPermissionRole业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpPermissionRoleService {

    /***
     * WpPermissionRole多条件分页查询
     * @param wpPermissionRole
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPermissionRole> findPage(WpPermissionRole wpPermissionRole, int page, int size);

    /***
     * WpPermissionRole分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPermissionRole> findPage(int page, int size);

    /***
     * WpPermissionRole多条件搜索方法
     * @param wpPermissionRole
     * @return
     */
    List<WpPermissionRole> findList(WpPermissionRole wpPermissionRole);

    /***
     * 删除WpPermissionRole
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpPermissionRole数据
     * @param wpPermissionRole
     */
    void update(WpPermissionRole wpPermissionRole);

    /***
     * 新增WpPermissionRole
     * @param wpPermissionRole
     */
    void add(WpPermissionRole wpPermissionRole);

    /**
     * 根据ID查询WpPermissionRole
     * @param id
     * @return
     */
     WpPermissionRole findById(Long id);

    /***
     * 查询所有WpPermissionRole
     * @return
     */
    List<WpPermissionRole> findAll();
}
