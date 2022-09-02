package com.zhang.blogadmin.service;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpRoles;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpRoles业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpRolesService {

    /***
     * WpRoles多条件分页查询
     * @param wpRoles
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpRoles> findPage(WpRoles wpRoles, int page, int size);

    /***
     * WpRoles分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpRoles> findPage(int page, int size);

    /***
     * WpRoles多条件搜索方法
     * @param wpRoles
     * @return
     */
    List<WpRoles> findList(WpRoles wpRoles);

    /***
     * 删除WpRoles
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpRoles数据
     * @param wpRoles
     */
    void update(WpRoles wpRoles);

    /***
     * 新增WpRoles
     * @param wpRoles
     */
    void add(WpRoles wpRoles);

    /**
     * 根据ID查询WpRoles
     * @param id
     * @return
     */
     WpRoles findById(Long id);

    /***
     * 查询所有WpRoles
     * @return
     */
    List<WpRoles> findAll();
}
