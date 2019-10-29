package com.ptw.rest;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptw.pojo.SysParams;
import com.ptw.service.SysParamsService;
import com.ptw.utils.PTWResult;

@RestController
public class ParamsController {
	@Autowired
	private SysParamsService paramsService;
	@RequestMapping(value = "/select")
	public PTWResult select(String code) {
		List<SysParams> one = paramsService.selectList(new EntityWrapper<SysParams>().eq("code", code));
		List<Object> result = this.getChildren(0, one);
		return PTWResult.ok(result);
	}

	public List<Object> getChildren(Integer parentId, List<SysParams> depts) {
		List<Object> list = new ArrayList<>();
		for (SysParams d : depts) {
			if (d.getPid().equals(parentId)) {
				JSONObject obj = new JSONObject();
				obj.put("label", d.getLabel());
				obj.put("value", d.getValue());
				obj.put("children", getChildren(d.getId(), depts));
				list.add(obj);
			}
		}
		return list;
	}
}
