package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpTerms;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTerms业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpTermsService {

    /***
     * WpTerms多条件分页查询
     * @param wpTerms
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTerms> findPage(WpTerms wpTerms, int page, int size);

    /***
     * WpTerms分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTerms> findPage(int page, int size);

    /***
     * WpTerms多条件搜索方法
     * @param wpTerms
     * @return
     */
    List<WpTerms> findList(WpTerms wpTerms);

    /***
     * 删除WpTerms
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpTerms数据
     * @param wpTerms
     */
    void update(WpTerms wpTerms);

    /***
     * 新增WpTerms
     * @param wpTerms
     */
    void add(WpTerms wpTerms);

    /**
     * 根据ID查询WpTerms
     * @param id
     * @return
     */
     WpTerms findById(Long id);

    /***
     * 查询所有WpTerms
     * @return
     */
    List<WpTerms> findAll();
}
