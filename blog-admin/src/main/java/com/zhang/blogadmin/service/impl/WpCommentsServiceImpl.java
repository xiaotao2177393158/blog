package com.zhang.blogadmin.service.impl;
import com.zhang.blogadmin.mapper.WpCommentsMapper;
import com.zhang.blogadmin.pojo.WpComments;
import com.zhang.blogadmin.service.WpCommentsService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import tk.mybatis.mapper.entity.Example;
import java.util.List;
/****
 * @Author:xiaotao
 * @Description:WpComments业务层接口实现类
 * @Date 2019/6/14 0:16
 *****/
@Service
public class WpCommentsServiceImpl implements WpCommentsService {

    @Autowired
    private WpCommentsMapper wpCommentsMapper;


    /**
     * WpComments条件+分页查询
     * @param wpComments 查询条件
     * @param page 页码
     * @param size 页大小
     * @return 分页结果
     */
    @Override
    public PageInfo<WpComments> findPage(WpComments wpComments, int page, int size){
        //分页
        PageHelper.startPage(page,size);
        //搜索条件构建
        Example example = createExample(wpComments);
        //执行搜索
        return new PageInfo<WpComments>(wpCommentsMapper.selectByExample(example));
    }

    /**
     * WpComments分页查询
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageInfo<WpComments> findPage(int page, int size){
        //静态分页
        PageHelper.startPage(page,size);
        //分页查询
        return new PageInfo<WpComments>(wpCommentsMapper.selectAll());
    }

    /**
     * WpComments条件查询
     * @param wpComments
     * @return
     */
    @Override
    public List<WpComments> findList(WpComments wpComments){
        //构建查询条件
        Example example = createExample(wpComments);
        //根据构建的条件查询数据
        return wpCommentsMapper.selectByExample(example);
    }


    /**
     * WpComments构建查询对象
     * @param wpComments
     * @return
     */
    public Example createExample(WpComments wpComments){
        Example example=new Example(WpComments.class);
        Example.Criteria criteria = example.createCriteria();
        if(wpComments!=null){
            // 
            if(!StringUtils.isEmpty(wpComments.getCommentID())){
                    criteria.andEqualTo("commentID",wpComments.getCommentID());
            }
            // 文章ID
            if(!StringUtils.isEmpty(wpComments.getCommentPostID())){
                    criteria.andEqualTo("commentPostID",wpComments.getCommentPostID());
            }
            // 评论用户
            if(!StringUtils.isEmpty(wpComments.getCommentAuthor())){
                    criteria.andEqualTo("commentAuthor",wpComments.getCommentAuthor());
            }
            // 评论邮箱
            if(!StringUtils.isEmpty(wpComments.getCommentAuthorEmail())){
                    criteria.andEqualTo("commentAuthorEmail",wpComments.getCommentAuthorEmail());
            }
            // 评论url
            if(!StringUtils.isEmpty(wpComments.getCommentAuthorUrl())){
                    criteria.andEqualTo("commentAuthorUrl",wpComments.getCommentAuthorUrl());
            }
            // 评论ip
            if(!StringUtils.isEmpty(wpComments.getCommentAuthorIP())){
                    criteria.andEqualTo("commentAuthorIP",wpComments.getCommentAuthorIP());
            }
            // 评论时间
            if(!StringUtils.isEmpty(wpComments.getCommentDate())){
                    criteria.andEqualTo("commentDate",wpComments.getCommentDate());
            }
            // 评论格林尼治时间
            if(!StringUtils.isEmpty(wpComments.getCommentDateGmt())){
                    criteria.andEqualTo("commentDateGmt",wpComments.getCommentDateGmt());
            }
            // 评论内容
            if(!StringUtils.isEmpty(wpComments.getCommentContent())){
                    criteria.andEqualTo("commentContent",wpComments.getCommentContent());
            }
            // 评论
            if(!StringUtils.isEmpty(wpComments.getCommentKarma())){
                    criteria.andEqualTo("commentKarma",wpComments.getCommentKarma());
            }
            // 评论核准
            if(!StringUtils.isEmpty(wpComments.getCommentApproved())){
                    criteria.andEqualTo("commentApproved",wpComments.getCommentApproved());
            }
            // 评论设备
            if(!StringUtils.isEmpty(wpComments.getCommentAgent())){
                    criteria.andEqualTo("commentAgent",wpComments.getCommentAgent());
            }
            // 评论类型
            if(!StringUtils.isEmpty(wpComments.getCommentType())){
                    criteria.andEqualTo("commentType",wpComments.getCommentType());
            }
            // 评论
            if(!StringUtils.isEmpty(wpComments.getCommentParent())){
                    criteria.andEqualTo("commentParent",wpComments.getCommentParent());
            }
            // 评论
            if(!StringUtils.isEmpty(wpComments.getUserId())){
                    criteria.andEqualTo("userId",wpComments.getUserId());
            }
            // 评论markdown
            if(!StringUtils.isEmpty(wpComments.getCommentMarkdown())){
                    criteria.andEqualTo("commentMarkdown",wpComments.getCommentMarkdown());
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
        wpCommentsMapper.deleteByPrimaryKey(id);
    }

    /**
     * 修改WpComments
     * @param wpComments
     */
    @Override
    public void update(WpComments wpComments){
        wpCommentsMapper.updateByPrimaryKey(wpComments);
    }

    /**
     * 增加WpComments
     * @param wpComments
     */
    @Override
    public void add(WpComments wpComments){
        wpCommentsMapper.insert(wpComments);
    }

    /**
     * 根据ID查询WpComments
     * @param id
     * @return
     */
    @Override
    public WpComments findById(Long id){
        return  wpCommentsMapper.selectByPrimaryKey(id);
    }

    /**
     * 查询WpComments全部数据
     * @return
     */
    @Override
    public List<WpComments> findAll() {
        return wpCommentsMapper.selectAll();
    }
}
