package com.zhang.blogadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.mapper.WpPermissionRequestPathMapper;
import com.zhang.blogadmin.pojo.WpPermissionRequestPath;
import com.zhang.blogadmin.service.WpPermissionRequestPathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPermissionRequestPath业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpPermissionRequestPathServiceImpl implements WpPermissionRequestPathService {

    @Autowired
    private WpPermissionRequestPathMapper wpPermissionRequestPathMapper;


    /**
     * WpPermissionRequestPath条件+分页查询
     * @param wpPermissionRequestPath 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpPermissionRequestPath> findPage(WpPermissionRequestPath wpPermissionRequestPath, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpPermissionRequestPath);
        //执行搜索
        return new PageInfo<WpPermissionRequestPath>(wpPermissionRequestPathMapper.selectByExample(example));
    }

    /**
     * WpPermissionRequestPath分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpPermissionRequestPath> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpPermissionRequestPath>(wpPermissionRequestPathMapper.selectAll());
    }

    /**
     * WpPermissionRequestPath条件查询
     * @param wpPermissionRequestPath
     * @return
     */
    @Override
    public List<WpPermissionRequestPath> findList(WpPermissionRequestPath wpPermissionRequestPath){
        //构建查询条件
        Example example = createExample(wpPermissionRequestPath);
        //根据构建的条件查询数据
        return wpPermissionRequestPathMapper.selectByExample(example);
    }


    /**
     * WpPermissionRequestPath构建查询对象
     * @param wpPermissionRequestPath
     * @return
     */
    public Example createExample(WpPermissionRequestPath wpPermissionRequestPath){
        Example example=new Example(WpPermissionRequestPath.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpPermissionRequestPath!=null){
            // 编号
            if(!StringUtils.isEmpty(wpPermissionRequestPath.getID())){
                    criteria.andEqualTo("ID",wpPermissionRequestPath.getID());
            }
            // 
            if(!StringUtils.isEmpty(wpPermissionRequestPath.getPID())){
                    criteria.andEqualTo("PID",wpPermissionRequestPath.getPID());
            }
            // 
            if(!StringUtils.isEmpty(wpPermissionRequestPath.getURLID())){
                    criteria.andEqualTo("URLID",wpPermissionRequestPath.getURLID());
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
        wpPermissionRequestPathMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpPermissionRequestPath
     * @param wpPermissionRequestPath
     */
    @Override
    public void update(WpPermissionRequestPath wpPermissionRequestPath){
        wpPermissionRequestPathMapper.updateByPrimaryKey(wpPermissionRequestPath);
    }

    /**
     * 增加WpPermissionRequestPath
     * @param wpPermissionRequestPath
     */
    @Override
    public void add(WpPermissionRequestPath wpPermissionRequestPath){
        wpPermissionRequestPathMapper.insert(wpPermissionRequestPath);
    }

    /**
     * 根据ID查询WpPermissionRequestPath
     * @param id
     * @return
     */
    @Override
    public WpPermissionRequestPath findById(Long id){
        return  wpPermissionRequestPathMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpPermissionRequestPath全部数据
     * @return
     */
    @Override
    public List<WpPermissionRequestPath> findAll() {
        return wpPermissionRequestPathMapper.selectAll();
    }
}
