package com.zhang.blogadmin.service;
import com.zhang.blogadmin.pojo.WpTermTaxonomy;
import com.github.pagehelper.PageInfo;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTermTaxonomy业务层接口
 * @Date 2019/6/14 0:16
 *****/
public interface WpTermTaxonomyService {

    /***
     * WpTermTaxonomy多条件分页查询
     * @param wpTermTaxonomy
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTermTaxonomy> findPage(WpTermTaxonomy wpTermTaxonomy, int page, int size);

    /***
     * WpTermTaxonomy分页查询
     * @param page
     * @param size
     * @return
     */
    PageInfo<WpTermTaxonomy> findPage(int page, int size);

    /***
     * WpTermTaxonomy多条件搜索方法
     * @param wpTermTaxonomy
     * @return
     */
    List<WpTermTaxonomy> findList(WpTermTaxonomy wpTermTaxonomy);

    /***
     * 删除WpTermTaxonomy
     * @param id
     */
    void delete(Long id);

    /***
     * 修改WpTermTaxonomy数据
     * @param wpTermTaxonomy
     */
    void update(WpTermTaxonomy wpTermTaxonomy);

    /***
     * 新增WpTermTaxonomy
     * @param wpTermTaxonomy
     */
    void add(WpTermTaxonomy wpTermTaxonomy);

    /**
     * 根据ID查询WpTermTaxonomy
     * @param id
     * @return
     */
     WpTermTaxonomy findById(Long id);

    /***
     * 查询所有WpTermTaxonomy
     * @return
     */
    List<WpTermTaxonomy> findAll();
}
