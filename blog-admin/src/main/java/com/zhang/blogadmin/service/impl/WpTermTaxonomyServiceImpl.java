package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpTermTaxonomyMapper;
import com.zhang.blogadmin.pojo.WpTermTaxonomy;
import com.zhang.blogadmin.service.WpTermTaxonomyService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTermTaxonomy业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpTermTaxonomyServiceImpl implements WpTermTaxonomyService {

    @Autowired
    private WpTermTaxonomyMapper wpTermTaxonomyMapper;


    /**
     * WpTermTaxonomy条件+分页查询
     * @param wpTermTaxonomy 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpTermTaxonomy> findPage(WpTermTaxonomy wpTermTaxonomy, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpTermTaxonomy);
        //执行搜索
        return new PageInfo<WpTermTaxonomy>(wpTermTaxonomyMapper.selectByExample(example));
    }

    /**
     * WpTermTaxonomy分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpTermTaxonomy> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpTermTaxonomy>(wpTermTaxonomyMapper.selectAll());
    }

    /**
     * WpTermTaxonomy条件查询
     * @param wpTermTaxonomy
     * @return
     */
    @Override
    public List<WpTermTaxonomy> findList(WpTermTaxonomy wpTermTaxonomy){
        //构建查询条件
        Example example = createExample(wpTermTaxonomy);
        //根据构建的条件查询数据
        return wpTermTaxonomyMapper.selectByExample(example);
    }


    /**
     * WpTermTaxonomy构建查询对象
     * @param wpTermTaxonomy
     * @return
     */
    public Example createExample(WpTermTaxonomy wpTermTaxonomy){
        Example example=new Example(WpTermTaxonomy.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpTermTaxonomy!=null){
            // 
            if(!StringUtils.isEmpty(wpTermTaxonomy.getTermTaxonomyId())){
                    criteria.andEqualTo("termTaxonomyId",wpTermTaxonomy.getTermTaxonomyId());
            }
            // 
            if(!StringUtils.isEmpty(wpTermTaxonomy.getTermId())){
                    criteria.andEqualTo("termId",wpTermTaxonomy.getTermId());
            }
            // 
            if(!StringUtils.isEmpty(wpTermTaxonomy.getTaxonomy())){
                    criteria.andEqualTo("taxonomy",wpTermTaxonomy.getTaxonomy());
            }
            // 
            if(!StringUtils.isEmpty(wpTermTaxonomy.getDescription())){
                    criteria.andEqualTo("description",wpTermTaxonomy.getDescription());
            }
            // 
            if(!StringUtils.isEmpty(wpTermTaxonomy.getParent())){
                    criteria.andEqualTo("parent",wpTermTaxonomy.getParent());
            }
            // 
            if(!StringUtils.isEmpty(wpTermTaxonomy.getCount())){
                    criteria.andEqualTo("count",wpTermTaxonomy.getCount());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(Long id){
        wpTermTaxonomyMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpTermTaxonomy
     * @param wpTermTaxonomy
     */
    @Override
    public void update(WpTermTaxonomy wpTermTaxonomy){
        wpTermTaxonomyMapper.updateByPrimaryKey(wpTermTaxonomy);
    }

    /**
     * 增加WpTermTaxonomy
     * @param wpTermTaxonomy
     */
    @Override
    public void add(WpTermTaxonomy wpTermTaxonomy){
        wpTermTaxonomyMapper.insert(wpTermTaxonomy);
    }

    /**
     * 根据ID查询WpTermTaxonomy
     * @param id
     * @return
     */
    @Override
    public WpTermTaxonomy findById(Long id){
        return  wpTermTaxonomyMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpTermTaxonomy全部数据
     * @return
     */
    @Override
    public List<WpTermTaxonomy> findAll() {
        return wpTermTaxonomyMapper.selectAll();
    }
}
