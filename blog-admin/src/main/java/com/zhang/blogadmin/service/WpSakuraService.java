package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpSakura;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpSakura业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpSakuraService {

    /***
     * WpSakura多条件分页查询
     * @param wpSakura
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpSakura> findPage(WpSakura wpSakura, int page, int size);

    /***
     * WpSakura分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpSakura> findPage(int page, int size);

    /***
     * WpSakura多条件搜索方法
     * @param wpSakura
     * @return
     */
    List<WpSakura> findList(WpSakura wpSakura);

    /***
     * 删除WpSakura
     * @param id
     */
    void delete(String id);

    /***
     * 修改WpSakura数据
     * @param wpSakura
     */
    void update(WpSakura wpSakura);

    /***
     * 新增WpSakura
     * @param wpSakura
     */
    void add(WpSakura wpSakura);

    /**
     * 根据ID查询WpSakura
     * @param id
     * @return
     */
     WpSakura findById(String id);

    /***
     * 查询所有WpSakura
     * @return
     */
    List<WpSakura> findAll();
}
