package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpSakuraMapper;
import com.zhang.blogadmin.pojo.WpSakura;
import com.zhang.blogadmin.service.WpSakuraService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpSakura业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpSakuraServiceImpl implements WpSakuraService {

    @Autowired
    private WpSakuraMapper wpSakuraMapper;


    /**
     * WpSakura条件+分页查询
     * @param wpSakura 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpSakura> findPage(WpSakura wpSakura, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpSakura);
        //执行搜索
        return new PageInfo<WpSakura>(wpSakuraMapper.selectByExample(example));
    }

    /**
     * WpSakura分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpSakura> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpSakura>(wpSakuraMapper.selectAll());
    }

    /**
     * WpSakura条件查询
     * @param wpSakura
     * @return
     */
    @Override
    public List<WpSakura> findList(WpSakura wpSakura){
        //构建查询条件
        Example example = createExample(wpSakura);
        //根据构建的条件查询数据
        return wpSakuraMapper.selectByExample(example);
    }


    /**
     * WpSakura构建查询对象
     * @param wpSakura
     * @return
     */
    public Example createExample(WpSakura wpSakura){
        Example example=new Example(WpSakura.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpSakura!=null){
            // 
            if(!StringUtils.isEmpty(wpSakura.getMateKey())){
                    criteria.andEqualTo("mateKey",wpSakura.getMateKey());
            }
            // 
            if(!StringUtils.isEmpty(wpSakura.getMateValue())){
                    criteria.andEqualTo("mateValue",wpSakura.getMateValue());
            }
        }
        return example;
    }

    /**
     * 删除
     * @param id
     */
    @Override
    public void delete(String id){
        wpSakuraMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpSakura
     * @param wpSakura
     */
    @Override
    public void update(WpSakura wpSakura){
        wpSakuraMapper.updateByPrimaryKey(wpSakura);
    }

    /**
     * 增加WpSakura
     * @param wpSakura
     */
    @Override
    public void add(WpSakura wpSakura){
        wpSakuraMapper.insert(wpSakura);
    }

    /**
     * 根据ID查询WpSakura
     * @param id
     * @return
     */
    @Override
    public WpSakura findById(String id){
        return  wpSakuraMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpSakura全部数据
     * @return
     */
    @Override
    public List<WpSakura> findAll() {
        return wpSakuraMapper.selectAll();
    }
}
