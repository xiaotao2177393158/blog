package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpPostmetaMapper;
import com.zhang.blogadmin.pojo.WpPostmeta;
import com.zhang.blogadmin.service.WpPostmetaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPostmeta业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpPostmetaServiceImpl implements WpPostmetaService {

    @Autowired
    private WpPostmetaMapper wpPostmetaMapper;


    /**
     * WpPostmeta条件+分页查询
     * @param wpPostmeta 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpPostmeta> findPage(WpPostmeta wpPostmeta, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpPostmeta);
        //执行搜索
        return new PageInfo<WpPostmeta>(wpPostmetaMapper.selectByExample(example));
    }

    /**
     * WpPostmeta分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpPostmeta> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpPostmeta>(wpPostmetaMapper.selectAll());
    }

    /**
     * WpPostmeta条件查询
     * @param wpPostmeta
     * @return
     */
    @Override
    public List<WpPostmeta> findList(WpPostmeta wpPostmeta){
        //构建查询条件
        Example example = createExample(wpPostmeta);
        //根据构建的条件查询数据
        return wpPostmetaMapper.selectByExample(example);
    }


    /**
     * WpPostmeta构建查询对象
     * @param wpPostmeta
     * @return
     */
    public Example createExample(WpPostmeta wpPostmeta){
        Example example=new Example(WpPostmeta.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpPostmeta!=null){
            // 
            if(!StringUtils.isEmpty(wpPostmeta.getMetaId())){
                    criteria.andEqualTo("metaId",wpPostmeta.getMetaId());
            }
            // 
            if(!StringUtils.isEmpty(wpPostmeta.getPostId())){
                    criteria.andEqualTo("postId",wpPostmeta.getPostId());
            }
            // 
            if(!StringUtils.isEmpty(wpPostmeta.getMetaKey())){
                    criteria.andEqualTo("metaKey",wpPostmeta.getMetaKey());
            }
            // 
            if(!StringUtils.isEmpty(wpPostmeta.getMetaValue())){
                    criteria.andEqualTo("metaValue",wpPostmeta.getMetaValue());
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
        wpPostmetaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpPostmeta
     * @param wpPostmeta
     */
    @Override
    public void update(WpPostmeta wpPostmeta){
        wpPostmetaMapper.updateByPrimaryKey(wpPostmeta);
    }

    /**
     * 增加WpPostmeta
     * @param wpPostmeta
     */
    @Override
    public void add(WpPostmeta wpPostmeta){
        wpPostmetaMapper.insert(wpPostmeta);
    }

    /**
     * 根据ID查询WpPostmeta
     * @param id
     * @return
     */
    @Override
    public WpPostmeta findById(Long id){
        return  wpPostmetaMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpPostmeta全部数据
     * @return
     */
    @Override
    public List<WpPostmeta> findAll() {
        return wpPostmetaMapper.selectAll();
    }
}
