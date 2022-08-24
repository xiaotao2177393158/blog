package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpTermRelationshipsMapper;
import com.zhang.blogadmin.pojo.WpTermRelationships;
import com.zhang.blogadmin.service.WpTermRelationshipsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTermRelationships业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpTermRelationshipsServiceImpl implements WpTermRelationshipsService {

    @Autowired
    private WpTermRelationshipsMapper wpTermRelationshipsMapper;


    /**
     * WpTermRelationships条件+分页查询
     * @param wpTermRelationships 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpTermRelationships> findPage(WpTermRelationships wpTermRelationships, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpTermRelationships);
        //执行搜索
        return new PageInfo<WpTermRelationships>(wpTermRelationshipsMapper.selectByExample(example));
    }

    /**
     * WpTermRelationships分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpTermRelationships> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpTermRelationships>(wpTermRelationshipsMapper.selectAll());
    }

    /**
     * WpTermRelationships条件查询
     * @param wpTermRelationships
     * @return
     */
    @Override
    public List<WpTermRelationships> findList(WpTermRelationships wpTermRelationships){
        //构建查询条件
        Example example = createExample(wpTermRelationships);
        //根据构建的条件查询数据
        return wpTermRelationshipsMapper.selectByExample(example);
    }


    /**
     * WpTermRelationships构建查询对象
     * @param wpTermRelationships
     * @return
     */
    public Example createExample(WpTermRelationships wpTermRelationships){
        Example example=new Example(WpTermRelationships.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpTermRelationships!=null){
            // 
            if(!StringUtils.isEmpty(wpTermRelationships.getObjectId())){
                    criteria.andEqualTo("objectId",wpTermRelationships.getObjectId());
            }
            // 
            if(!StringUtils.isEmpty(wpTermRelationships.getTermTaxonomyId())){
                    criteria.andEqualTo("termTaxonomyId",wpTermRelationships.getTermTaxonomyId());
            }
            // 
            if(!StringUtils.isEmpty(wpTermRelationships.getTermOrder())){
                    criteria.andEqualTo("termOrder",wpTermRelationships.getTermOrder());
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
        wpTermRelationshipsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpTermRelationships
     * @param wpTermRelationships
     */
    @Override
    public void update(WpTermRelationships wpTermRelationships){
        wpTermRelationshipsMapper.updateByPrimaryKey(wpTermRelationships);
    }

    /**
     * 增加WpTermRelationships
     * @param wpTermRelationships
     */
    @Override
    public void add(WpTermRelationships wpTermRelationships){
        wpTermRelationshipsMapper.insert(wpTermRelationships);
    }

    /**
     * 根据ID查询WpTermRelationships
     * @param id
     * @return
     */
    @Override
    public WpTermRelationships findById(Long id){
        return  wpTermRelationshipsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpTermRelationships全部数据
     * @return
     */
    @Override
    public List<WpTermRelationships> findAll() {
        return wpTermRelationshipsMapper.selectAll();
    }
}
