package com.zhang.blogadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.mapper.WpRequestPathMapper;
import com.zhang.blogadmin.pojo.WpRequestPath;
import com.zhang.blogadmin.service.WpRequestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpRequestPath业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpRequestPathServiceImpl implements WpRequestPathService {

    @Autowired
    private WpRequestPathMapper wpRequestPathMapper;


    /**
     * WpRequestPath条件+分页查询
     * @param wpRequestPath 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpRequestPath> findPage(WpRequestPath wpRequestPath, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpRequestPath);
        //执行搜索
        return new PageInfo<WpRequestPath>(wpRequestPathMapper.selectByExample(example));
    }

    /**
     * WpRequestPath分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpRequestPath> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpRequestPath>(wpRequestPathMapper.selectAll());
    }

    /**
     * WpRequestPath条件查询
     * @param wpRequestPath
     * @return
     */
    @Override
    public List<WpRequestPath> findList(WpRequestPath wpRequestPath){
        //构建查询条件
        Example example = createExample(wpRequestPath);
        //根据构建的条件查询数据
        return wpRequestPathMapper.selectByExample(example);
    }


    /**
     * WpRequestPath构建查询对象
     * @param wpRequestPath
     * @return
     */
    public Example createExample(WpRequestPath wpRequestPath){
        Example example=new Example(WpRequestPath.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpRequestPath!=null){
            // 编号
            if(!StringUtils.isEmpty(wpRequestPath.getID())){
                    criteria.andEqualTo("ID",wpRequestPath.getID());
            }
            // url
            if(!StringUtils.isEmpty(wpRequestPath.getUrl())){
                    criteria.andEqualTo("url",wpRequestPath.getUrl());
            }
            // 描述
            if(!StringUtils.isEmpty(wpRequestPath.getDescription())){
                    criteria.andEqualTo("description",wpRequestPath.getDescription());
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
        wpRequestPathMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpRequestPath
     * @param wpRequestPath
     */
    @Override
    public void update(WpRequestPath wpRequestPath){
        wpRequestPathMapper.updateByPrimaryKey(wpRequestPath);
    }

    /**
     * 增加WpRequestPath
     * @param wpRequestPath
     */
    @Override
    public void add(WpRequestPath wpRequestPath){
        wpRequestPathMapper.insert(wpRequestPath);
    }

    /**
     * 根据ID查询WpRequestPath
     * @param id
     * @return
     */
    @Override
    public WpRequestPath findById(Long id){
        return  wpRequestPathMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpRequestPath全部数据
     * @return
     */
    @Override
    public List<WpRequestPath> findAll() {
        return wpRequestPathMapper.selectAll();
    }
}
