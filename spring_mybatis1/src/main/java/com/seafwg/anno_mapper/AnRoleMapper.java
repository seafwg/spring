package com.seafwg.anno_mapper;

import com.seafwg.domain.Role;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AnRoleMapper {
    /**
     * 多表查询的分部查询：根据查出user的id去查询role
     *
     * @param uid
     * @return
     */
    @Select("select * from sys_role r,sys_user_role ur where r.id=ur.roleId and ur.userId=#{uid}")
    public List<Role> findRoleByUid(int uid);
}
