package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpLinksMapper;
import com.zhang.blogadmin.pojo.WpLinks;
import com.zhang.blogadmin.service.WpLinksService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpLinks业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpLinksServiceImpl implements WpLinksService {

    @Autowired
    private WpLinksMapper wpLinksMapper;


    /**
     * WpLinks条件+分页查询
     * @param wpLinks 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpLinks> findPage(WpLinks wpLinks, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpLinks);
        //执行搜索
        return new PageInfo<WpLinks>(wpLinksMapper.selectByExample(example));
    }

    /**
     * WpLinks分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpLinks> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpLinks>(wpLinksMapper.selectAll());
    }

    /**
     * WpLinks条件查询
     * @param wpLinks
     * @return
     */
    @Override
    public List<WpLinks> findList(WpLinks wpLinks){
        //构建查询条件
        Example example = createExample(wpLinks);
        //根据构建的条件查询数据
        return wpLinksMapper.selectByExample(example);
    }


    /**
     * WpLinks构建查询对象
     * @param wpLinks
     * @return
     */
    public Example createExample(WpLinks wpLinks){
        Example example=new Example(WpLinks.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpLinks!=null){
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkId())){
                    criteria.andEqualTo("linkId",wpLinks.getLinkId());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkUrl())){
                    criteria.andEqualTo("linkUrl",wpLinks.getLinkUrl());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkName())){
                    criteria.andEqualTo("linkName",wpLinks.getLinkName());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkImage())){
                    criteria.andEqualTo("linkImage",wpLinks.getLinkImage());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkTarget())){
                    criteria.andEqualTo("linkTarget",wpLinks.getLinkTarget());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkDescription())){
                    criteria.andEqualTo("linkDescription",wpLinks.getLinkDescription());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkVisible())){
                    criteria.andEqualTo("linkVisible",wpLinks.getLinkVisible());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkOwner())){
                    criteria.andEqualTo("linkOwner",wpLinks.getLinkOwner());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkRating())){
                    criteria.andEqualTo("linkRating",wpLinks.getLinkRating());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkUpdated())){
                    criteria.andEqualTo("linkUpdated",wpLinks.getLinkUpdated());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkRel())){
                    criteria.andEqualTo("linkRel",wpLinks.getLinkRel());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkNotes())){
                    criteria.andEqualTo("linkNotes",wpLinks.getLinkNotes());
            }
            // 
            if(!StringUtils.isEmpty(wpLinks.getLinkRss())){
                    criteria.andEqualTo("linkRss",wpLinks.getLinkRss());
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
        wpLinksMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpLinks
     * @param wpLinks
     */
    @Override
    public void update(WpLinks wpLinks){
        wpLinksMapper.updateByPrimaryKey(wpLinks);
    }

    /**
     * 增加WpLinks
     * @param wpLinks
     */
    @Override
    public void add(WpLinks wpLinks){
        wpLinksMapper.insert(wpLinks);
    }

    /**
     * 根据ID查询WpLinks
     * @param id
     * @return
     */
    @Override
    public WpLinks findById(Long id){
        return  wpLinksMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpLinks全部数据
     * @return
     */
    @Override
    public List<WpLinks> findAll() {
        return wpLinksMapper.selectAll();
    }
}
