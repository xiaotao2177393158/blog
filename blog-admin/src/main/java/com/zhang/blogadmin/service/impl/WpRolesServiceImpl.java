package com.zhang.blogadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.mapper.WpRolesMapper;
import com.zhang.blogadmin.pojo.WpRoles;
import com.zhang.blogadmin.service.WpRolesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpRoles业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpRolesServiceImpl implements WpRolesService {

    @Autowired
    private WpRolesMapper wpRolesMapper;


    /**
     * WpRoles条件+分页查询
     * @param wpRoles 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpRoles> findPage(WpRoles wpRoles, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpRoles);
        //执行搜索
        return new PageInfo<WpRoles>(wpRolesMapper.selectByExample(example));
    }

    /**
     * WpRoles分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpRoles> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpRoles>(wpRolesMapper.selectAll());
    }

    /**
     * WpRoles条件查询
     * @param wpRoles
     * @return
     */
    @Override
    public List<WpRoles> findList(WpRoles wpRoles){
        //构建查询条件
        Example example = createExample(wpRoles);
        //根据构建的条件查询数据
        return wpRolesMapper.selectByExample(example);
    }


    /**
     * WpRoles构建查询对象
     * @param wpRoles
     * @return
     */
    public Example createExample(WpRoles wpRoles){
        Example example=new Example(WpRoles.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpRoles!=null){
            // 编号
            if(!StringUtils.isEmpty(wpRoles.getID())){
                    criteria.andEqualTo("ID",wpRoles.getID());
            }
            // 角色名称
            if(!StringUtils.isEmpty(wpRoles.getROLENAME())){
                    criteria.andEqualTo("ROLENAME",wpRoles.getROLENAME());
            }
            // 角色描述
            if(!StringUtils.isEmpty(wpRoles.getROLEDESC())){
                    criteria.andEqualTo("ROLEDESC",wpRoles.getROLEDESC());
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
        wpRolesMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpRoles
     * @param wpRoles
     */
    @Override
    public void update(WpRoles wpRoles){
        wpRolesMapper.updateByPrimaryKey(wpRoles);
    }

    /**
     * 增加WpRoles
     * @param wpRoles
     */
    @Override
    public void add(WpRoles wpRoles){
        wpRolesMapper.insert(wpRoles);
    }

    /**
     * 根据ID查询WpRoles
     * @param id
     * @return
     */
    @Override
    public WpRoles findById(Long id){
        return  wpRolesMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpRoles全部数据
     * @return
     */
    @Override
    public List<WpRoles> findAll() {
        return wpRolesMapper.selectAll();
    }
}
