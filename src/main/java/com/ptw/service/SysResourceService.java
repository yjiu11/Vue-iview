package com.ptw.service;

import java.util.List;

import com.baomidou.mybatisplus.service.IService;
import com.ptw.pojo.SysResource;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author yjiu
 * @since 2019-09-29
 */
public interface SysResourceService extends IService<SysResource> {
	/**
	 * 获取一级菜单
	 * @param user_id
	 * @return
	 */
	public List<Object> oneLevelMenu(Integer user_id);
	/**
	 * 获取二级菜单
	 * @param user_id
	 * @return
	 */
	public List<Object> twoLevelMenu(Integer user_id,Integer oneLevelMenu);
	/**
	 * 根据用户编号 ，获取所有菜单项
	 * @param user_id
	 * @return
	 */
	public List<SysResource> getMenusByUserId(Integer user_id);
	public List<Object> getChildren(Integer parentId,List<SysResource> depts);
}
