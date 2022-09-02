package com.zhang.blogadmin.service;

import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.pojo.WpRequestPath;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpRequestPath业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpRequestPathService {

    /***
     * WpRequestPath多条件分页查询
     * @param wpRequestPath
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpRequestPath> findPage(WpRequestPath wpRequestPath, int page, int size);

    /***
     * WpRequestPath分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpRequestPath> findPage(int page, int size);

    /***
     * WpRequestPath多条件搜索方法
     * @param wpRequestPath
     * @return
     */
    List<WpRequestPath> findList(WpRequestPath wpRequestPath);

    /***
     * 删除WpRequestPath
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpRequestPath数据
     * @param wpRequestPath
     */
    void update(WpRequestPath wpRequestPath);

    /***
     * 新增WpRequestPath
     * @param wpRequestPath
     */
    void add(WpRequestPath wpRequestPath);

    /**
     * 根据ID查询WpRequestPath
     * @param id
     * @return
     */
     WpRequestPath findById(Long id);

    /***
     * 查询所有WpRequestPath
     * @return
     */
    List<WpRequestPath> findAll();
}
