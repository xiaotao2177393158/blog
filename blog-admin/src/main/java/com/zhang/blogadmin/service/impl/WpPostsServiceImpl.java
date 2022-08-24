package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpPostsMapper;
import com.zhang.blogadmin.pojo.WpPosts;
import com.zhang.blogadmin.service.WpPostsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpPosts业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpPostsServiceImpl implements WpPostsService {

    @Autowired
    private WpPostsMapper wpPostsMapper;


    /**
     * WpPosts条件+分页查询
     * @param wpPosts 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpPosts> findPage(WpPosts wpPosts, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpPosts);
        //执行搜索
        return new PageInfo<WpPosts>(wpPostsMapper.selectByExample(example));
    }

    /**
     * WpPosts分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpPosts> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpPosts>(wpPostsMapper.selectAll());
    }

    /**
     * WpPosts条件查询
     * @param wpPosts
     * @return
     */
    @Override
    public List<WpPosts> findList(WpPosts wpPosts){
        //构建查询条件
        Example example = createExample(wpPosts);
        //根据构建的条件查询数据
        return wpPostsMapper.selectByExample(example);
    }


    /**
     * WpPosts构建查询对象
     * @param wpPosts
     * @return
     */
    public Example createExample(WpPosts wpPosts){
        Example example=new Example(WpPosts.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpPosts!=null){
            // 
            if(!StringUtils.isEmpty(wpPosts.getID())){
                    criteria.andEqualTo("ID",wpPosts.getID());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostAuthor())){
                    criteria.andEqualTo("postAuthor",wpPosts.getPostAuthor());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostDate())){
                    criteria.andEqualTo("postDate",wpPosts.getPostDate());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostDateGmt())){
                    criteria.andEqualTo("postDateGmt",wpPosts.getPostDateGmt());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostContent())){
                    criteria.andEqualTo("postContent",wpPosts.getPostContent());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostTitle())){
                    criteria.andEqualTo("postTitle",wpPosts.getPostTitle());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostExcerpt())){
                    criteria.andEqualTo("postExcerpt",wpPosts.getPostExcerpt());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostStatus())){
                    criteria.andEqualTo("postStatus",wpPosts.getPostStatus());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getCommentStatus())){
                    criteria.andEqualTo("commentStatus",wpPosts.getCommentStatus());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPingStatus())){
                    criteria.andEqualTo("pingStatus",wpPosts.getPingStatus());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostPassword())){
                    criteria.andEqualTo("postPassword",wpPosts.getPostPassword());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostName())){
                    criteria.andEqualTo("postName",wpPosts.getPostName());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getToPing())){
                    criteria.andEqualTo("toPing",wpPosts.getToPing());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPinged())){
                    criteria.andEqualTo("pinged",wpPosts.getPinged());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostModified())){
                    criteria.andEqualTo("postModified",wpPosts.getPostModified());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostModifiedGmt())){
                    criteria.andEqualTo("postModifiedGmt",wpPosts.getPostModifiedGmt());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostContentFiltered())){
                    criteria.andEqualTo("postContentFiltered",wpPosts.getPostContentFiltered());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostParent())){
                    criteria.andEqualTo("postParent",wpPosts.getPostParent());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getGuid())){
                    criteria.andEqualTo("guid",wpPosts.getGuid());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getMenuOrder())){
                    criteria.andEqualTo("menuOrder",wpPosts.getMenuOrder());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostType())){
                    criteria.andEqualTo("postType",wpPosts.getPostType());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getPostMimeType())){
                    criteria.andEqualTo("postMimeType",wpPosts.getPostMimeType());
            }
            // 
            if(!StringUtils.isEmpty(wpPosts.getCommentCount())){
                    criteria.andEqualTo("commentCount",wpPosts.getCommentCount());
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
        wpPostsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpPosts
     * @param wpPosts
     */
    @Override
    public void update(WpPosts wpPosts){
        wpPostsMapper.updateByPrimaryKey(wpPosts);
    }

    /**
     * 增加WpPosts
     * @param wpPosts
     */
    @Override
    public void add(WpPosts wpPosts){
        wpPostsMapper.insert(wpPosts);
    }

    /**
     * 根据ID查询WpPosts
     * @param id
     * @return
     */
    @Override
    public WpPosts findById(Long id){
        return  wpPostsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpPosts全部数据
     * @return
     */
    @Override
    public List<WpPosts> findAll() {
        return wpPostsMapper.selectAll();
    }
}
