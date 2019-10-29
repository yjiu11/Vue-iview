package com.ptw.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ptw.service.SysResourceService;
import com.ptw.utils.PTWResult;

@RestController
public class IndexController {
	@Autowired
	private SysResourceService resourceService;
	@RequestMapping(value = "/index")
	public PTWResult index() {
		return PTWResult.ok();
	}

	@RequestMapping("/oneLevelMenu")
	public PTWResult oneLevelMenu(Integer user_id) {
		System.out.println(user_id);
		List<Object> oneLevelMenu = resourceService.oneLevelMenu(user_id);
		return PTWResult.ok(oneLevelMenu);
	}
	@RequestMapping("/twoLevelMenu")
	public PTWResult twoLevelMenu(Integer user_id,Integer oneLevelMenu) {
		List<Object> twoLevelMenu = resourceService.twoLevelMenu(user_id,oneLevelMenu);
		return PTWResult.ok(twoLevelMenu);
	}
}
