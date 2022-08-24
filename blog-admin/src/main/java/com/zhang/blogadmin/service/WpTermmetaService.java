package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpTermmeta;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTermmeta业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpTermmetaService {

    /***
     * WpTermmeta多条件分页查询
     * @param wpTermmeta
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTermmeta> findPage(WpTermmeta wpTermmeta, int page, int size);

    /***
     * WpTermmeta分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTermmeta> findPage(int page, int size);

    /***
     * WpTermmeta多条件搜索方法
     * @param wpTermmeta
     * @return
     */
    List<WpTermmeta> findList(WpTermmeta wpTermmeta);

    /***
     * 删除WpTermmeta
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpTermmeta数据
     * @param wpTermmeta
     */
    void update(WpTermmeta wpTermmeta);

    /***
     * 新增WpTermmeta
     * @param wpTermmeta
     */
    void add(WpTermmeta wpTermmeta);

    /**
     * 根据ID查询WpTermmeta
     * @param id
     * @return
     */
     WpTermmeta findById(Long id);

    /***
     * 查询所有WpTermmeta
     * @return
     */
    List<WpTermmeta> findAll();
}
