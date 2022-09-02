package com.zhang.blogadmin.service;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpUserRole;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpUserRole业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpUserRoleService {

    /***
     * WpUserRole多条件分页查询
     * @param wpUserRole
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpUserRole> findPage(WpUserRole wpUserRole, int page, int size);

    /***
     * WpUserRole分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpUserRole> findPage(int page, int size);

    /***
     * WpUserRole多条件搜索方法
     * @param wpUserRole
     * @return
     */
    List<WpUserRole> findList(WpUserRole wpUserRole);

    /***
     * 删除WpUserRole
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpUserRole数据
     * @param wpUserRole
     */
    void update(WpUserRole wpUserRole);

    /***
     * 新增WpUserRole
     * @param wpUserRole
     */
    void add(WpUserRole wpUserRole);

    /**
     * 根据ID查询WpUserRole
     * @param id
     * @return
     */
     WpUserRole findById(Long id);

    /***
     * 查询所有WpUserRole
     * @return
     */
    List<WpUserRole> findAll();
}
