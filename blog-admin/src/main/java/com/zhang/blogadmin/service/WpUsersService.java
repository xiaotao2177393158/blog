package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpUsers;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpUsers业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpUsersService {

    /***
     * WpUsers多条件分页查询
     * @param wpUsers
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpUsers> findPage(WpUsers wpUsers, int page, int size);

    /***
     * WpUsers分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpUsers> findPage(int page, int size);

    /***
     * WpUsers多条件搜索方法
     * @param wpUsers
     * @return
     */
    List<WpUsers> findList(WpUsers wpUsers);

    /***
     * 删除WpUsers
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpUsers数据
     * @param wpUsers
     */
    void update(WpUsers wpUsers);

    /***
     * 新增WpUsers
     * @param wpUsers
     */
    void add(WpUsers wpUsers);

    /**
     * 根据ID查询WpUsers
     * @param id
     * @return
     */
     WpUsers findById(Long id);

    /***
     * 查询所有WpUsers
     * @return
     */
    List<WpUsers> findAll();
}
