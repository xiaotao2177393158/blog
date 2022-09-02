package com.zhang.blogadmin.mapper;
import com.zhang.blogadmin.pojo.WpUsers;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

/****
 * @Author:xiaotao
 * @Description:WpUsers的Dao
 * @Date 2022/8/30
 *****/
public interface WpUsersMapper extends Mapper<WpUsers> {
//    @Select("select id, user_login, user_pass, user_nicename, user_email, user_url, user_registered, user_activation_key, user_status, display_name from `blog-admin`.wp_users where user_login = '${user}' and user_pass = '${password}';")
//    WpUsers login(String user, String password);
}
