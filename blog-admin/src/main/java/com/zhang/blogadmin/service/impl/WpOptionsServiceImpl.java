package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpOptionsMapper;
import com.zhang.blogadmin.pojo.WpOptions;
import com.zhang.blogadmin.service.WpOptionsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpOptions业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpOptionsServiceImpl implements WpOptionsService {

    @Autowired
    private WpOptionsMapper wpOptionsMapper;


    /**
     * WpOptions条件+分页查询
     * @param wpOptions 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpOptions> findPage(WpOptions wpOptions, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpOptions);
        //执行搜索
        return new PageInfo<WpOptions>(wpOptionsMapper.selectByExample(example));
    }

    /**
     * WpOptions分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpOptions> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpOptions>(wpOptionsMapper.selectAll());
    }

    /**
     * WpOptions条件查询
     * @param wpOptions
     * @return
     */
    @Override
    public List<WpOptions> findList(WpOptions wpOptions){
        //构建查询条件
        Example example = createExample(wpOptions);
        //根据构建的条件查询数据
        return wpOptionsMapper.selectByExample(example);
    }


    /**
     * WpOptions构建查询对象
     * @param wpOptions
     * @return
     */
    public Example createExample(WpOptions wpOptions){
        Example example=new Example(WpOptions.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpOptions!=null){
            // 
            if(!StringUtils.isEmpty(wpOptions.getOptionId())){
                    criteria.andEqualTo("optionId",wpOptions.getOptionId());
            }
            // 
            if(!StringUtils.isEmpty(wpOptions.getOptionName())){
                    criteria.andEqualTo("optionName",wpOptions.getOptionName());
            }
            // 
            if(!StringUtils.isEmpty(wpOptions.getOptionValue())){
                    criteria.andEqualTo("optionValue",wpOptions.getOptionValue());
            }
            // 
            if(!StringUtils.isEmpty(wpOptions.getAutoload())){
                    criteria.andEqualTo("autoload",wpOptions.getAutoload());
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
        wpOptionsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpOptions
     * @param wpOptions
     */
    @Override
    public void update(WpOptions wpOptions){
        wpOptionsMapper.updateByPrimaryKey(wpOptions);
    }

    /**
     * 增加WpOptions
     * @param wpOptions
     */
    @Override
    public void add(WpOptions wpOptions){
        wpOptionsMapper.insert(wpOptions);
    }

    /**
     * 根据ID查询WpOptions
     * @param id
     * @return
     */
    @Override
    public WpOptions findById(Long id){
        return  wpOptionsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpOptions全部数据
     * @return
     */
    @Override
    public List<WpOptions> findAll() {
        return wpOptionsMapper.selectAll();
    }
}
