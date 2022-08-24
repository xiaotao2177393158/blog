package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpUsermeta;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpUsermeta业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpUsermetaService {

    /***
     * WpUsermeta多条件分页查询
     * @param wpUsermeta
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpUsermeta> findPage(WpUsermeta wpUsermeta, int page, int size);

    /***
     * WpUsermeta分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpUsermeta> findPage(int page, int size);

    /***
     * WpUsermeta多条件搜索方法
     * @param wpUsermeta
     * @return
     */
    List<WpUsermeta> findList(WpUsermeta wpUsermeta);

    /***
     * 删除WpUsermeta
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpUsermeta数据
     * @param wpUsermeta
     */
    void update(WpUsermeta wpUsermeta);

    /***
     * 新增WpUsermeta
     * @param wpUsermeta
     */
    void add(WpUsermeta wpUsermeta);

    /**
     * 根据ID查询WpUsermeta
     * @param id
     * @return
     */
     WpUsermeta findById(Long id);

    /***
     * 查询所有WpUsermeta
     * @return
     */
    List<WpUsermeta> findAll();
}
