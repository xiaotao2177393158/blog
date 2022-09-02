package com.zhang.blogadmin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zhang.blogadmin.mapper.WpPermissionMapper;
import com.zhang.blogadmin.pojo.WpPermission;
import com.zhang.blogadmin.service.WpPermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPermission业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpPermissionServiceImpl implements WpPermissionService {

    @Autowired
    private WpPermissionMapper wpPermissionMapper;


    @Override
    public List<WpPermission> getUserRolesByUserId(Integer id) {



        return null;
    }

    /**
     * WpPermission条件+分页查询
     * @param wpPermission 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpPermission> findPage(WpPermission wpPermission, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpPermission);
        //执行搜索
        return new PageInfo<WpPermission>(wpPermissionMapper.selectByExample(example));
    }

    /**
     * WpPermission分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpPermission> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpPermission>(wpPermissionMapper.selectAll());
    }

    /**
     * WpPermission条件查询
     * @param wpPermission
     * @return
     */
    @Override
    public List<WpPermission> findList(WpPermission wpPermission){
        //构建查询条件
        Example example = createExample(wpPermission);
        //根据构建的条件查询数据
        return wpPermissionMapper.selectByExample(example);
    }


    /**
     * WpPermission构建查询对象
     * @param wpPermission
     * @return
     */
    public Example createExample(WpPermission wpPermission){
        Example example=new Example(WpPermission.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpPermission!=null){
            // 编号
            if(!StringUtils.isEmpty(wpPermission.getID())){
                    criteria.andEqualTo("ID",wpPermission.getID());
            }
            // 权限码
            if(!StringUtils.isEmpty(wpPermission.getCode())){
                    criteria.andEqualTo("code",wpPermission.getCode());
            }
            // 权限名称
            if(!StringUtils.isEmpty(wpPermission.getName())){
                    criteria.andLike("name","%"+wpPermission.getName()+"%");
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
        wpPermissionMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpPermission
     * @param wpPermission
     */
    @Override
    public void update(WpPermission wpPermission){
        wpPermissionMapper.updateByPrimaryKey(wpPermission);
    }

    /**
     * 增加WpPermission
     * @param wpPermission
     */
    @Override
    public void add(WpPermission wpPermission){
        wpPermissionMapper.insert(wpPermission);
    }

    /**
     * 根据ID查询WpPermission
     * @param id
     * @return
     */
    @Override
    public WpPermission findById(Long id){
        return  wpPermissionMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpPermission全部数据
     * @return
     */
    @Override
    public List<WpPermission> findAll() {
        return wpPermissionMapper.selectAll();
    }
}
