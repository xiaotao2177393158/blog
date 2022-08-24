package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpCommentmetaMapper;
import com.zhang.blogadmin.pojo.WpCommentmeta;
import com.zhang.blogadmin.service.WpCommentmetaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpCommentmeta业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpCommentmetaServiceImpl implements WpCommentmetaService {

    @Autowired
    private WpCommentmetaMapper wpCommentmetaMapper;


    /**
     * WpCommentmeta条件+分页查询
     * @param wpCommentmeta 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpCommentmeta> findPage(WpCommentmeta wpCommentmeta, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpCommentmeta);
        //执行搜索
        return new PageInfo<WpCommentmeta>(wpCommentmetaMapper.selectByExample(example));
    }

    /**
     * WpCommentmeta分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpCommentmeta> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpCommentmeta>(wpCommentmetaMapper.selectAll());
    }

    /**
     * WpCommentmeta条件查询
     * @param wpCommentmeta
     * @return
     */
    @Override
    public List<WpCommentmeta> findList(WpCommentmeta wpCommentmeta){
        //构建查询条件
        Example example = createExample(wpCommentmeta);
        //根据构建的条件查询数据
        return wpCommentmetaMapper.selectByExample(example);
    }


    /**
     * WpCommentmeta构建查询对象
     * @param wpCommentmeta
     * @return
     */
    public Example createExample(WpCommentmeta wpCommentmeta){
        Example example=new Example(WpCommentmeta.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpCommentmeta!=null){
            // 
            if(!StringUtils.isEmpty(wpCommentmeta.getMetaId())){
                    criteria.andEqualTo("metaId",wpCommentmeta.getMetaId());
            }
            // 
            if(!StringUtils.isEmpty(wpCommentmeta.getCommentId())){
                    criteria.andEqualTo("commentId",wpCommentmeta.getCommentId());
            }
            // 
            if(!StringUtils.isEmpty(wpCommentmeta.getMetaKey())){
                    criteria.andEqualTo("metaKey",wpCommentmeta.getMetaKey());
            }
            // 
            if(!StringUtils.isEmpty(wpCommentmeta.getMetaValue())){
                    criteria.andEqualTo("metaValue",wpCommentmeta.getMetaValue());
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
        wpCommentmetaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpCommentmeta
     * @param wpCommentmeta
     */
    @Override
    public void update(WpCommentmeta wpCommentmeta){
        wpCommentmetaMapper.updateByPrimaryKey(wpCommentmeta);
    }

    /**
     * 增加WpCommentmeta
     * @param wpCommentmeta
     */
    @Override
    public void add(WpCommentmeta wpCommentmeta){
        wpCommentmetaMapper.insert(wpCommentmeta);
    }

    /**
     * 根据ID查询WpCommentmeta
     * @param id
     * @return
     */
    @Override
    public WpCommentmeta findById(Long id){
        return  wpCommentmetaMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpCommentmeta全部数据
     * @return
     */
    @Override
    public List<WpCommentmeta> findAll() {
        return wpCommentmetaMapper.selectAll();
    }
}
