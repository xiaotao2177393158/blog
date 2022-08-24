package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpTermmetaMapper;
import com.zhang.blogadmin.pojo.WpTermmeta;
import com.zhang.blogadmin.service.WpTermmetaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpTermmeta业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpTermmetaServiceImpl implements WpTermmetaService {

    @Autowired
    private WpTermmetaMapper wpTermmetaMapper;


    /**
     * WpTermmeta条件+分页查询
     * @param wpTermmeta 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpTermmeta> findPage(WpTermmeta wpTermmeta, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpTermmeta);
        //执行搜索
        return new PageInfo<WpTermmeta>(wpTermmetaMapper.selectByExample(example));
    }

    /**
     * WpTermmeta分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpTermmeta> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpTermmeta>(wpTermmetaMapper.selectAll());
    }

    /**
     * WpTermmeta条件查询
     * @param wpTermmeta
     * @return
     */
    @Override
    public List<WpTermmeta> findList(WpTermmeta wpTermmeta){
        //构建查询条件
        Example example = createExample(wpTermmeta);
        //根据构建的条件查询数据
        return wpTermmetaMapper.selectByExample(example);
    }


    /**
     * WpTermmeta构建查询对象
     * @param wpTermmeta
     * @return
     */
    public Example createExample(WpTermmeta wpTermmeta){
        Example example=new Example(WpTermmeta.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpTermmeta!=null){
            // 
            if(!StringUtils.isEmpty(wpTermmeta.getMetaId())){
                    criteria.andEqualTo("metaId",wpTermmeta.getMetaId());
            }
            // 
            if(!StringUtils.isEmpty(wpTermmeta.getTermId())){
                    criteria.andEqualTo("termId",wpTermmeta.getTermId());
            }
            // 
            if(!StringUtils.isEmpty(wpTermmeta.getMetaKey())){
                    criteria.andEqualTo("metaKey",wpTermmeta.getMetaKey());
            }
            // 
            if(!StringUtils.isEmpty(wpTermmeta.getMetaValue())){
                    criteria.andEqualTo("metaValue",wpTermmeta.getMetaValue());
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
        wpTermmetaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpTermmeta
     * @param wpTermmeta
     */
    @Override
    public void update(WpTermmeta wpTermmeta){
        wpTermmetaMapper.updateByPrimaryKey(wpTermmeta);
    }

    /**
     * 增加WpTermmeta
     * @param wpTermmeta
     */
    @Override
    public void add(WpTermmeta wpTermmeta){
        wpTermmetaMapper.insert(wpTermmeta);
    }

    /**
     * 根据ID查询WpTermmeta
     * @param id
     * @return
     */
    @Override
    public WpTermmeta findById(Long id){
        return  wpTermmetaMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpTermmeta全部数据
     * @return
     */
    @Override
    public List<WpTermmeta> findAll() {
        return wpTermmetaMapper.selectAll();
    }
}
