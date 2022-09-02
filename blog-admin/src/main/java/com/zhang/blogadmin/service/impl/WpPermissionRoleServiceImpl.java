package com.zhang.blogadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.mapper.WpPermissionRoleMapper;
import com.zhang.blogadmin.pojo.WpPermissionRole;
import com.zhang.blogadmin.service.WpPermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPermissionRole业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpPermissionRoleServiceImpl implements WpPermissionRoleService {

    @Autowired
    private WpPermissionRoleMapper wpPermissionRoleMapper;


    /**
     * WpPermissionRole条件+分页查询
     * @param wpPermissionRole 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpPermissionRole> findPage(WpPermissionRole wpPermissionRole, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpPermissionRole);
        //执行搜索
        return new PageInfo<WpPermissionRole>(wpPermissionRoleMapper.selectByExample(example));
    }

    /**
     * WpPermissionRole分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpPermissionRole> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpPermissionRole>(wpPermissionRoleMapper.selectAll());
    }

    /**
     * WpPermissionRole条件查询
     * @param wpPermissionRole
     * @return
     */
    @Override
    public List<WpPermissionRole> findList(WpPermissionRole wpPermissionRole){
        //构建查询条件
        Example example = createExample(wpPermissionRole);
        //根据构建的条件查询数据
        return wpPermissionRoleMapper.selectByExample(example);
    }


    /**
     * WpPermissionRole构建查询对象
     * @param wpPermissionRole
     * @return
     */
    public Example createExample(WpPermissionRole wpPermissionRole){
        Example example=new Example(WpPermissionRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpPermissionRole!=null){
            // 编号
            if(!StringUtils.isEmpty(wpPermissionRole.getID())){
                    criteria.andEqualTo("ID",wpPermissionRole.getID());
            }
            // 
            if(!StringUtils.isEmpty(wpPermissionRole.getPID())){
                    criteria.andEqualTo("PID",wpPermissionRole.getPID());
            }
            // 
            if(!StringUtils.isEmpty(wpPermissionRole.getRID())){
                    criteria.andEqualTo("RID",wpPermissionRole.getRID());
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
        wpPermissionRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpPermissionRole
     * @param wpPermissionRole
     */
    @Override
    public void update(WpPermissionRole wpPermissionRole){
        wpPermissionRoleMapper.updateByPrimaryKey(wpPermissionRole);
    }

    /**
     * 增加WpPermissionRole
     * @param wpPermissionRole
     */
    @Override
    public void add(WpPermissionRole wpPermissionRole){
        wpPermissionRoleMapper.insert(wpPermissionRole);
    }

    /**
     * 根据ID查询WpPermissionRole
     * @param id
     * @return
     */
    @Override
    public WpPermissionRole findById(Long id){
        return  wpPermissionRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpPermissionRole全部数据
     * @return
     */
    @Override
    public List<WpPermissionRole> findAll() {
        return wpPermissionRoleMapper.selectAll();
    }
}
