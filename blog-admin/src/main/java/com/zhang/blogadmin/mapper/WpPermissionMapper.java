package com.zhang.blogadmin.mapper;
import com.zhang.blogadmin.pojo.WpPermission;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/****
 * @Author:xiaotao
 * @Description:WpPermission的Dao
 * @Date 2019/6/14 0:12
 *****/
public interface WpPermissionMapper extends Mapper<WpPermission> {
    @Select("SELECT\n" +
            "    p.*\n" +
            "FROM\n" +
            "    `blog-admin`.wp_users AS u\n" +
            "        LEFT JOIN `blog-admin`.wp_user_role AS ur ON u.id = ur.UID\n" +
            "        LEFT JOIN `blog-admin`.wp_roles AS r ON r.id = ur.RID\n" +
            "        LEFT JOIN `blog-admin`.wp_permission_role AS rp ON r.id = rp.RID\n" +
            "        LEFT JOIN `blog-admin`.wp_permission AS p ON p.id = rp.PID\n" +
            "WHERE u.id = #{id} ")
    List<WpPermission> getUserRolesByUserId(Long id);

    @Select("select p.*\n" +
            "from `blog-admin`.wp_permission as p\n" +
            "         left join `blog-admin`.wp_permission_request_path as srp\n" +
            "                   on p.id = srp.PID\n" +
            "         left join `blog-admin`.wp_request_path as sr\n" +
            "                   on srp.url_id = sr.id\n" +
            "where sr.url = #{requestUrl} ")
    List<WpPermission> selectListByPath(@Param("requestUrl") String requestUrl);
}
