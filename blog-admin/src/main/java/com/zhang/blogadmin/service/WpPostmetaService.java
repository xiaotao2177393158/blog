package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpPostmeta;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPostmeta业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpPostmetaService {

    /***
     * WpPostmeta多条件分页查询
     * @param wpPostmeta
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPostmeta> findPage(WpPostmeta wpPostmeta, int page, int size);

    /***
     * WpPostmeta分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPostmeta> findPage(int page, int size);

    /***
     * WpPostmeta多条件搜索方法
     * @param wpPostmeta
     * @return
     */
    List<WpPostmeta> findList(WpPostmeta wpPostmeta);

    /***
     * 删除WpPostmeta
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpPostmeta数据
     * @param wpPostmeta
     */
    void update(WpPostmeta wpPostmeta);

    /***
     * 新增WpPostmeta
     * @param wpPostmeta
     */
    void add(WpPostmeta wpPostmeta);

    /**
     * 根据ID查询WpPostmeta
     * @param id
     * @return
     */
     WpPostmeta findById(Long id);

    /***
     * 查询所有WpPostmeta
     * @return
     */
    List<WpPostmeta> findAll();
}
