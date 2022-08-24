package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpLinks;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpLinks业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpLinksService {

    /***
     * WpLinks多条件分页查询
     * @param wpLinks
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpLinks> findPage(WpLinks wpLinks, int page, int size);

    /***
     * WpLinks分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpLinks> findPage(int page, int size);

    /***
     * WpLinks多条件搜索方法
     * @param wpLinks
     * @return
     */
    List<WpLinks> findList(WpLinks wpLinks);

    /***
     * 删除WpLinks
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpLinks数据
     * @param wpLinks
     */
    void update(WpLinks wpLinks);

    /***
     * 新增WpLinks
     * @param wpLinks
     */
    void add(WpLinks wpLinks);

    /**
     * 根据ID查询WpLinks
     * @param id
     * @return
     */
     WpLinks findById(Long id);

    /***
     * 查询所有WpLinks
     * @return
     */
    List<WpLinks> findAll();
}
