package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpTermsMapper;
import com.zhang.blogadmin.pojo.WpTerms;
import com.zhang.blogadmin.service.WpTermsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTerms业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpTermsServiceImpl implements WpTermsService {

    @Autowired
    private WpTermsMapper wpTermsMapper;


    /**
     * WpTerms条件+分页查询
     * @param wpTerms 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpTerms> findPage(WpTerms wpTerms, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpTerms);
        //执行搜索
        return new PageInfo<WpTerms>(wpTermsMapper.selectByExample(example));
    }

    /**
     * WpTerms分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpTerms> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpTerms>(wpTermsMapper.selectAll());
    }

    /**
     * WpTerms条件查询
     * @param wpTerms
     * @return
     */
    @Override
    public List<WpTerms> findList(WpTerms wpTerms){
        //构建查询条件
        Example example = createExample(wpTerms);
        //根据构建的条件查询数据
        return wpTermsMapper.selectByExample(example);
    }


    /**
     * WpTerms构建查询对象
     * @param wpTerms
     * @return
     */
    public Example createExample(WpTerms wpTerms){
        Example example=new Example(WpTerms.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpTerms!=null){
            // 
            if(!StringUtils.isEmpty(wpTerms.getTermId())){
                    criteria.andEqualTo("termId",wpTerms.getTermId());
            }
            // 
            if(!StringUtils.isEmpty(wpTerms.getName())){
                    criteria.andLike("name","%"+wpTerms.getName()+"%");
            }
            // 
            if(!StringUtils.isEmpty(wpTerms.getSlug())){
                    criteria.andEqualTo("slug",wpTerms.getSlug());
            }
            // 
            if(!StringUtils.isEmpty(wpTerms.getTermGroup())){
                    criteria.andEqualTo("termGroup",wpTerms.getTermGroup());
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
        wpTermsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpTerms
     * @param wpTerms
     */
    @Override
    public void update(WpTerms wpTerms){
        wpTermsMapper.updateByPrimaryKey(wpTerms);
    }

    /**
     * 增加WpTerms
     * @param wpTerms
     */
    @Override
    public void add(WpTerms wpTerms){
        wpTermsMapper.insert(wpTerms);
    }

    /**
     * 根据ID查询WpTerms
     * @param id
     * @return
     */
    @Override
    public WpTerms findById(Long id){
        return  wpTermsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpTerms全部数据
     * @return
     */
    @Override
    public List<WpTerms> findAll() {
        return wpTermsMapper.selectAll();
    }
}
