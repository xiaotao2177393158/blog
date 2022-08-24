package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpTermRelationships;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTermRelationships业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpTermRelationshipsService {

    /***
     * WpTermRelationships多条件分页查询
     * @param wpTermRelationships
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTermRelationships> findPage(WpTermRelationships wpTermRelationships, int page, int size);

    /***
     * WpTermRelationships分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTermRelationships> findPage(int page, int size);

    /***
     * WpTermRelationships多条件搜索方法
     * @param wpTermRelationships
     * @return
     */
    List<WpTermRelationships> findList(WpTermRelationships wpTermRelationships);

    /***
     * 删除WpTermRelationships
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpTermRelationships数据
     * @param wpTermRelationships
     */
    void update(WpTermRelationships wpTermRelationships);

    /***
     * 新增WpTermRelationships
     * @param wpTermRelationships
     */
    void add(WpTermRelationships wpTermRelationships);

    /**
     * 根据ID查询WpTermRelationships
     * @param id
     * @return
     */
     WpTermRelationships findById(Long id);

    /***
     * 查询所有WpTermRelationships
     * @return
     */
    List<WpTermRelationships> findAll();
}
