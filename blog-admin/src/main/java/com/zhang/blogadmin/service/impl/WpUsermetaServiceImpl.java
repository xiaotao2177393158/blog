package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpUsermetaMapper;
import com.zhang.blogadmin.pojo.WpUsermeta;
import com.zhang.blogadmin.service.WpUsermetaService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpUsermeta业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpUsermetaServiceImpl implements WpUsermetaService {

    @Autowired
    private WpUsermetaMapper wpUsermetaMapper;


    /**
     * WpUsermeta条件+分页查询
     * @param wpUsermeta 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpUsermeta> findPage(WpUsermeta wpUsermeta, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpUsermeta);
        //执行搜索
        return new PageInfo<WpUsermeta>(wpUsermetaMapper.selectByExample(example));
    }

    /**
     * WpUsermeta分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpUsermeta> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpUsermeta>(wpUsermetaMapper.selectAll());
    }

    /**
     * WpUsermeta条件查询
     * @param wpUsermeta
     * @return
     */
    @Override
    public List<WpUsermeta> findList(WpUsermeta wpUsermeta){
        //构建查询条件
        Example example = createExample(wpUsermeta);
        //根据构建的条件查询数据
        return wpUsermetaMapper.selectByExample(example);
    }


    /**
     * WpUsermeta构建查询对象
     * @param wpUsermeta
     * @return
     */
    public Example createExample(WpUsermeta wpUsermeta){
        Example example=new Example(WpUsermeta.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpUsermeta!=null){
            // 
            if(!StringUtils.isEmpty(wpUsermeta.getUmetaId())){
                    criteria.andEqualTo("umetaId",wpUsermeta.getUmetaId());
            }
            // 
            if(!StringUtils.isEmpty(wpUsermeta.getUserId())){
                    criteria.andEqualTo("userId",wpUsermeta.getUserId());
            }
            // 
            if(!StringUtils.isEmpty(wpUsermeta.getMetaKey())){
                    criteria.andEqualTo("metaKey",wpUsermeta.getMetaKey());
            }
            // 
            if(!StringUtils.isEmpty(wpUsermeta.getMetaValue())){
                    criteria.andEqualTo("metaValue",wpUsermeta.getMetaValue());
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
        wpUsermetaMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpUsermeta
     * @param wpUsermeta
     */
    @Override
    public void update(WpUsermeta wpUsermeta){
        wpUsermetaMapper.updateByPrimaryKey(wpUsermeta);
    }

    /**
     * 增加WpUsermeta
     * @param wpUsermeta
     */
    @Override
    public void add(WpUsermeta wpUsermeta){
        wpUsermetaMapper.insert(wpUsermeta);
    }

    /**
     * 根据ID查询WpUsermeta
     * @param id
     * @return
     */
    @Override
    public WpUsermeta findById(Long id){
        return  wpUsermetaMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpUsermeta全部数据
     * @return
     */
    @Override
    public List<WpUsermeta> findAll() {
        return wpUsermetaMapper.selectAll();
    }
}
