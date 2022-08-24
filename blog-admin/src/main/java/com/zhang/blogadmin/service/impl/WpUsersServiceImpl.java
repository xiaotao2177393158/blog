package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpUsersMapper;
import com.zhang.blogadmin.pojo.WpUsers;
import com.zhang.blogadmin.service.WpUsersService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpUsers业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpUsersServiceImpl implements WpUsersService {

    @Autowired
    private WpUsersMapper wpUsersMapper;


    /**
     * WpUsers条件+分页查询
     * @param wpUsers 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpUsers> findPage(WpUsers wpUsers, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpUsers);
        //执行搜索
        return new PageInfo<WpUsers>(wpUsersMapper.selectByExample(example));
    }

    /**
     * WpUsers分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpUsers> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpUsers>(wpUsersMapper.selectAll());
    }

    /**
     * WpUsers条件查询
     * @param wpUsers
     * @return
     */
    @Override
    public List<WpUsers> findList(WpUsers wpUsers){
        //构建查询条件
        Example example = createExample(wpUsers);
        //根据构建的条件查询数据
        return wpUsersMapper.selectByExample(example);
    }


    /**
     * WpUsers构建查询对象
     * @param wpUsers
     * @return
     */
    public Example createExample(WpUsers wpUsers){
        Example example=new Example(WpUsers.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpUsers!=null){
            // 
            if(!StringUtils.isEmpty(wpUsers.getID())){
                    criteria.andEqualTo("ID",wpUsers.getID());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserLogin())){
                    criteria.andEqualTo("userLogin",wpUsers.getUserLogin());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserPass())){
                    criteria.andEqualTo("userPass",wpUsers.getUserPass());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserNicename())){
                    criteria.andLike("userNicename","%"+wpUsers.getUserNicename()+"%");
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserEmail())){
                    criteria.andEqualTo("userEmail",wpUsers.getUserEmail());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserUrl())){
                    criteria.andEqualTo("userUrl",wpUsers.getUserUrl());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserRegistered())){
                    criteria.andEqualTo("userRegistered",wpUsers.getUserRegistered());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserActivationKey())){
                    criteria.andEqualTo("userActivationKey",wpUsers.getUserActivationKey());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getUserStatus())){
                    criteria.andEqualTo("userStatus",wpUsers.getUserStatus());
            }
            // 
            if(!StringUtils.isEmpty(wpUsers.getDisplayName())){
                    criteria.andEqualTo("displayName",wpUsers.getDisplayName());
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
        wpUsersMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpUsers
     * @param wpUsers
     */
    @Override
    public void update(WpUsers wpUsers){
        wpUsersMapper.updateByPrimaryKey(wpUsers);
    }

    /**
     * 增加WpUsers
     * @param wpUsers
     */
    @Override
    public void add(WpUsers wpUsers){
        wpUsersMapper.insert(wpUsers);
    }

    /**
     * 根据ID查询WpUsers
     * @param id
     * @return
     */
    @Override
    public WpUsers findById(Long id){
        return  wpUsersMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpUsers全部数据
     * @return
     */
    @Override
    public List<WpUsers> findAll() {
        return wpUsersMapper.selectAll();
    }
}
