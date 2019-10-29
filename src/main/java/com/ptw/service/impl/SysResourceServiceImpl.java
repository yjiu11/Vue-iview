package com.ptw.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.ptw.mapper.SysResourceMapper;
import com.ptw.pojo.SysResource;
import com.ptw.pojo.SysRole;
import com.ptw.pojo.SysUser;
import com.ptw.service.SysResourceService;
import com.ptw.service.SysRoleService;
import com.ptw.service.SysUserService;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author yjiu
 * @since 2019-09-29
 */
@Service
public class SysResourceServiceImpl extends ServiceImpl<SysResourceMapper, SysResource> implements SysResourceService {
	@Autowired
	private SysUserService userService;
	@Autowired
	private SysRoleService roleService;
	@Override
	public List<Object> getChildren(Integer parentId, List<SysResource> depts) {
		List<Object> list = new ArrayList<>();
		for (SysResource d : depts) {
			if (d.getParentId().equals(parentId)) {
				boolean flag;
				if (StringUtils.equals(d.getAvailable(), "1")) {
					flag = false;
				} else {
					flag = true;
				}
				JSONObject obj = new JSONObject();
				obj.put("id", d.getId());
				obj.put("title", d.getName());
				obj.put("icon", d.getIcon());
				obj.put("url", d.getUrl());
				obj.put("spread", d.getOpen() != null && d.getOpen() == 1 ? true : false);
				obj.put("disabled", flag);
				obj.put("children", getChildren(d.getId(), depts));
				list.add(obj);
			}
		}
		return list;
	}
	@Override
	public List<Object> twoLevelMenu(Integer user_id,Integer oneLevelMenu) {
		List<SysResource> menus = this.getMenusByUserId(user_id);
		List<SysResource> result = new ArrayList<>();
		for (SysResource sysResource : menus) {
			if(sysResource.getParentId()!=0) {
				//menus.remove(sysResource);
				result.add(sysResource);
			}
		}
		List<Object> children = this.getChildren(oneLevelMenu, result);
		return children;
	}
	@Override
	public List<Object> oneLevelMenu(Integer user_id) {
		List<SysResource> menus = this.getMenusByUserId(user_id);
		List<SysResource> result = new ArrayList<>();
		for (SysResource sysResource : menus) {
			if(sysResource.getParentId()==0) {
				result.add(sysResource);
			}
		}
		List<Object> children = this.getChildren(0, result);
		return children;
	}

	@Override
	public List<SysResource> getMenusByUserId(Integer user_id) {
		SysUser db_user = userService.selectById(user_id);
		String db_user_roles = db_user.getRoleIds();
		String[] roles = db_user_roles.split(",");
		Set<String> roleSets = new HashSet<>();
		for (String role : roles) {
			roleSets.add(role);
		}
		//去重菜单，获取菜单编号
		Set<String> menuSet = new HashSet<>();
		List<SysRole> db_roles = roleService.selectBatchIds(roleSets);
		for (SysRole role : db_roles) {
			String[] db_resources = role.getResourceIds().split(",");
			for (String curr : db_resources) {
				menuSet.add(curr);
			}
		}
		//最终获取List<SysResource>
		List<SysResource> db_all_menus = this.selectBatchIds(menuSet);
		return db_all_menus;
	}
}
