package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpPosts;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPosts业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpPostsService {

    /***
     * WpPosts多条件分页查询
     * @param wpPosts
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPosts> findPage(WpPosts wpPosts, int page, int size);

    /***
     * WpPosts分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpPosts> findPage(int page, int size);

    /***
     * WpPosts多条件搜索方法
     * @param wpPosts
     * @return
     */
    List<WpPosts> findList(WpPosts wpPosts);

    /***
     * 删除WpPosts
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpPosts数据
     * @param wpPosts
     */
    void update(WpPosts wpPosts);

    /***
     * 新增WpPosts
     * @param wpPosts
     */
    void add(WpPosts wpPosts);

    /**
     * 根据ID查询WpPosts
     * @param id
     * @return
     */
     WpPosts findById(Long id);

    /***
     * 查询所有WpPosts
     * @return
     */
    List<WpPosts> findAll();
}
