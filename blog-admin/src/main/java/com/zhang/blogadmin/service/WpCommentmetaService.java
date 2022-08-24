package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpCommentmeta;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpCommentmeta业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpCommentmetaService {

    /***
     * WpCommentmeta多条件分页查询
     * @param wpCommentmeta
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpCommentmeta> findPage(WpCommentmeta wpCommentmeta, int page, int size);

    /***
     * WpCommentmeta分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpCommentmeta> findPage(int page, int size);

    /***
     * WpCommentmeta多条件搜索方法
     * @param wpCommentmeta
     * @return
     */
    List<WpCommentmeta> findList(WpCommentmeta wpCommentmeta);

    /***
     * 删除WpCommentmeta
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpCommentmeta数据
     * @param wpCommentmeta
     */
    void update(WpCommentmeta wpCommentmeta);

    /***
     * 新增WpCommentmeta
     * @param wpCommentmeta
     */
    void add(WpCommentmeta wpCommentmeta);

    /**
     * 根据ID查询WpCommentmeta
     * @param id
     * @return
     */
     WpCommentmeta findById(Long id);

    /***
     * 查询所有WpCommentmeta
     * @return
     */
    List<WpCommentmeta> findAll();
}
