package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpComments;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpComments业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpCommentsService {

    /***
     * WpComments多条件分页查询
     * @param wpComments
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpComments> findPage(WpComments wpComments, int page, int size);

    /***
     * WpComments分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpComments> findPage(int page, int size);

    /***
     * WpComments多条件搜索方法
     * @param wpComments
     * @return
     */
    List<WpComments> findList(WpComments wpComments);

    /***
     * 删除WpComments
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpComments数据
     * @param wpComments
     */
    void update(WpComments wpComments);

    /***
     * 新增WpComments
     * @param wpComments
     */
    void add(WpComments wpComments);

    /**
     * 根据ID查询WpComments
     * @param id
     * @return
     */
     WpComments findById(Long id);

    /***
     * 查询所有WpComments
     * @return
     */
    List<WpComments> findAll();
}
