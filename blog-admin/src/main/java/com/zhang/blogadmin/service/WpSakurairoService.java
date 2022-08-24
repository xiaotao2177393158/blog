package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpSakurairo;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpSakurairo业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpSakurairoService {

    /***
     * WpSakurairo多条件分页查询
     * @param wpSakurairo
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpSakurairo> findPage(WpSakurairo wpSakurairo, int page, int size);

    /***
     * WpSakurairo分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpSakurairo> findPage(int page, int size);

    /***
     * WpSakurairo多条件搜索方法
     * @param wpSakurairo
     * @return
     */
    List<WpSakurairo> findList(WpSakurairo wpSakurairo);

    /***
     * 删除WpSakurairo
     * @param id
     */
    void delete(String id);

    /***
     * 修改WpSakurairo数据
     * @param wpSakurairo
     */
    void update(WpSakurairo wpSakurairo);

    /***
     * 新增WpSakurairo
     * @param wpSakurairo
     */
    void add(WpSakurairo wpSakurairo);

    /**
     * 根据ID查询WpSakurairo
     * @param id
     * @return
     */
     WpSakurairo findById(String id);

    /***
     * 查询所有WpSakurairo
     * @return
     */
    List<WpSakurairo> findAll();
}
