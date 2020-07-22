package com.zdxj.config;

import java.util.List;

import javax.annotation.Resource;

import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import com.google.common.collect.Lists;
import com.zdxj.converter.MyUsernameNotFoundException;
import com.zdxj.core.Result;
import com.zdxj.feignclient.ManagerRoleRelFeignClient;
import com.zdxj.feignclient.SystemManagerFeignClient;
import com.zdxj.model.SystemManagerEntity;
import com.zdxj.util.RedisUtils;

@Component
public class CustomUserDetailService implements UserDetailsService {

    @Autowired
    private SystemManagerFeignClient systemManagerFeignClient ;
    @Autowired
    private ManagerRoleRelFeignClient managerRoleRelFeignClient ;
    @Resource
	public RedisUtils redisService;
    
    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
    	
    	Result<SystemManagerEntity> byLoginName = systemManagerFeignClient.getByLoginName(userName);
    	SystemManagerEntity manager = byLoginName.getResult();
        if(manager == null) {
            throw new MyUsernameNotFoundException("用户名或密码错误");
        }
        if(!manager.getEnable()) {
        	throw new MyUsernameNotFoundException("该账号已被冻结");
        }
        Integer userId = manager.getId();
        String password = manager.getLoginPassword();
        //获取权限
        List<GrantedAuthority> authorities = Lists.newArrayList();
        Result<List<Integer>> listRoleIdByManagerId = managerRoleRelFeignClient.listRoleIdByManagerId(userId);
        List<Integer> roleIds = listRoleIdByManagerId.getResult();
        if(CollectionUtils.isNotEmpty(roleIds)) {
        	for(Integer roleId:roleIds) {
        		authorities.add(new SimpleGrantedAuthority(roleId.toString()));
        	}
        }
        CustomUser userDetails = new CustomUser(userName,password,authorities);
        userDetails.setUserId(userId);
        return userDetails;
    }
	
	/**
	 * 自定义登录方式
	 * @author zhaodx
	 * @date 2020-03-14 19:09:08
	 * @param loginType
	 * @return
	 * @throws UsernameNotFoundException
	 */
	public UserDetails loadUserByCustomType(String loginType) throws UsernameNotFoundException{
		
		return null;
	}


}
