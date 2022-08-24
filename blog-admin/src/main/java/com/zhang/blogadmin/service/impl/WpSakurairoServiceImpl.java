package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpSakurairoMapper;
import com.zhang.blogadmin.pojo.WpSakurairo;
import com.zhang.blogadmin.service.WpSakurairoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpSakurairo业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpSakurairoServiceImpl implements WpSakurairoService {

    @Autowired
    private WpSakurairoMapper wpSakurairoMapper;


    /**
     * WpSakurairo条件+分页查询
     * @param wpSakurairo 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpSakurairo> findPage(WpSakurairo wpSakurairo, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpSakurairo);
        //执行搜索
        return new PageInfo<WpSakurairo>(wpSakurairoMapper.selectByExample(example));
    }

    /**
     * WpSakurairo分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpSakurairo> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpSakurairo>(wpSakurairoMapper.selectAll());
    }

    /**
     * WpSakurairo条件查询
     * @param wpSakurairo
     * @return
     */
    @Override
    public List<WpSakurairo> findList(WpSakurairo wpSakurairo){
        //构建查询条件
        Example example = createExample(wpSakurairo);
        //根据构建的条件查询数据
        return wpSakurairoMapper.selectByExample(example);
    }


    /**
     * WpSakurairo构建查询对象
     * @param wpSakurairo
     * @return
     */
    public Example createExample(WpSakurairo wpSakurairo){
        Example example=new Example(WpSakurairo.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpSakurairo!=null){
            // 
            if(!StringUtils.isEmpty(wpSakurairo.getMateKey())){
                    criteria.andEqualTo("mateKey",wpSakurairo.getMateKey());
            }
            // 
            if(!StringUtils.isEmpty(wpSakurairo.getMateValue())){
                    criteria.andEqualTo("mateValue",wpSakurairo.getMateValue());
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
        wpSakurairoMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpSakurairo
     * @param wpSakurairo
     */
    @Override
    public void update(WpSakurairo wpSakurairo){
        wpSakurairoMapper.updateByPrimaryKey(wpSakurairo);
    }

    /**
     * 增加WpSakurairo
     * @param wpSakurairo
     */
    @Override
    public void add(WpSakurairo wpSakurairo){
        wpSakurairoMapper.insert(wpSakurairo);
    }

    /**
     * 根据ID查询WpSakurairo
     * @param id
     * @return
     */
    @Override
    public WpSakurairo findById(String id){
        return  wpSakurairoMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpSakurairo全部数据
     * @return
     */
    @Override
    public List<WpSakurairo> findAll() {
        return wpSakurairoMapper.selectAll();
    }
}
