package com.zhang.blogadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.mapper.WpUserRoleMapper;
import com.zhang.blogadmin.pojo.WpUserRole;
import com.zhang.blogadmin.service.WpUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpUserRole业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpUserRoleServiceImpl implements WpUserRoleService {

    @Autowired
    private WpUserRoleMapper wpUserRoleMapper;


    /**
     * WpUserRole条件+分页查询
     * @param wpUserRole 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpUserRole> findPage(WpUserRole wpUserRole, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpUserRole);
        //执行搜索
        return new PageInfo<WpUserRole>(wpUserRoleMapper.selectByExample(example));
    }

    /**
     * WpUserRole分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpUserRole> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpUserRole>(wpUserRoleMapper.selectAll());
    }

    /**
     * WpUserRole条件查询
     * @param wpUserRole
     * @return
     */
    @Override
    public List<WpUserRole> findList(WpUserRole wpUserRole){
        //构建查询条件
        Example example = createExample(wpUserRole);
        //根据构建的条件查询数据
        return wpUserRoleMapper.selectByExample(example);
    }


    /**
     * WpUserRole构建查询对象
     * @param wpUserRole
     * @return
     */
    public Example createExample(WpUserRole wpUserRole){
        Example example=new Example(WpUserRole.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpUserRole!=null){
            // 编号
            if(!StringUtils.isEmpty(wpUserRole.getID())){
                    criteria.andEqualTo("ID",wpUserRole.getID());
            }
            // 
            if(!StringUtils.isEmpty(wpUserRole.getUID())){
                    criteria.andEqualTo("UID",wpUserRole.getUID());
            }
            // 
            if(!StringUtils.isEmpty(wpUserRole.getRID())){
                    criteria.andEqualTo("RID",wpUserRole.getRID());
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
        wpUserRoleMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpUserRole
     * @param wpUserRole
     */
    @Override
    public void update(WpUserRole wpUserRole){
        wpUserRoleMapper.updateByPrimaryKey(wpUserRole);
    }

    /**
     * 增加WpUserRole
     * @param wpUserRole
     */
    @Override
    public void add(WpUserRole wpUserRole){
        wpUserRoleMapper.insert(wpUserRole);
    }

    /**
     * 根据ID查询WpUserRole
     * @param id
     * @return
     */
    @Override
    public WpUserRole findById(Long id){
        return  wpUserRoleMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpUserRole全部数据
     * @return
     */
    @Override
    public List<WpUserRole> findAll() {
        return wpUserRoleMapper.selectAll();
    }
}
