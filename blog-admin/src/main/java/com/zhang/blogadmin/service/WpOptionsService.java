package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpOptions;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpOptions业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpOptionsService {

    /***
     * WpOptions多条件分页查询
     * @param wpOptions
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpOptions> findPage(WpOptions wpOptions, int page, int size);

    /***
     * WpOptions分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpOptions> findPage(int page, int size);

    /***
     * WpOptions多条件搜索方法
     * @param wpOptions
     * @return
     */
    List<WpOptions> findList(WpOptions wpOptions);

    /***
     * 删除WpOptions
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpOptions数据
     * @param wpOptions
     */
    void update(WpOptions wpOptions);

    /***
     * 新增WpOptions
     * @param wpOptions
     */
    void add(WpOptions wpOptions);

    /**
     * 根据ID查询WpOptions
     * @param id
     * @return
     */
     WpOptions findById(Long id);

    /***
     * 查询所有WpOptions
     * @return
     */
    List<WpOptions> findAll();
}
