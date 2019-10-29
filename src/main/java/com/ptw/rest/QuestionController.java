package com.ptw.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;

import java.text.DecimalFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptw.pojo.Question;
import com.ptw.service.QuestionService;
import com.ptw.utils.PTWResult;
import com.ptw.utils.SimilarityUtil;

@RestController
public class QuestionController {
	private String[] choose = {"A","B","C","D","E","F","G"};
	@Autowired
	private QuestionService qService;
	@RequestMapping(value = "/question/list")
	public PTWResult select(String category) {
		List<Question> db_list = qService.selectList(new EntityWrapper<Question>().eq("category", category));
		for (Question question : db_list) {
			String currentName = question.getName();
			if(question.getType() == 2) {
				String answer = question.getAnswer();
				JSONArray array = JSON.parseArray(answer);//[{"item":"数据库管理"},{"item":"哪年"}]
				for (int i=0;i<array.size();i++) {
					JSONObject object = JSON.parseObject(array.get(i).toString());
					String item = object.getString("item");
					currentName = currentName.replace(item, "____________");
				}
				question.setName(currentName);
			}
		}
		return PTWResult.ok(db_list);
	}
	/**
	 * 检测填空题是否正确
	 * @param question_id
	 * @param curr_question_index
	 * @param input_value
	 * @return
	 */
	@RequestMapping(value = "/question/check")
	public PTWResult sel(String question_id,Integer curr_question_index,String input_value) {
		try {
			DecimalFormat    df   = new DecimalFormat("######0.00");
			Question db_question = qService.selectById(question_id);
			String answer = db_question.getAnswer();
			JSONArray array = JSON.parseArray(answer);
			JSONObject object = JSON.parseObject(array.get(curr_question_index).toString());
			String value = object.getString("item");
			double similarity = SimilarityUtil.getSimilarity(value, input_value);
			System.out.println("======================="+similarity);
			String result = df.format(similarity);
			if(similarity>0.6D) {
				return PTWResult.ok(result);
			}else {
				return PTWResult.build(501, result);
			}
		} catch (Exception e) {
			return PTWResult.build(501, "答题错误");
		}
	}
	@RequestMapping("/question/save")
	public PTWResult save(String dynamicTags,String name,String category,Integer type,String answer) {
		try {
			Question qa = new Question();
			qa.setName(name).setCreateTime(new Date()).setUpdateTime(new Date()).setCategory(category).setType(type);
			//填空题
			if(type == 2) {
				String[] split = dynamicTags.split(",");
				//[{"item":"DBMS数据库管理系统"}]
				JSONArray arr = new JSONArray();
				for (String tag : split) {
					JSONObject obj = new JSONObject();
					obj.put("item", tag);
					arr.add(obj);
				}
				qa.setAnswer(arr.toJSONString());
			}else if(type ==1) {//单选题
				String[] split = dynamicTags.split(",");
				//options [{"item":"20世纪50年代","value":"A"},{"item":"20世纪40年代前","value":"B"},{"item":"20世纪90年代后","value":"C"}]
				JSONArray arr = new JSONArray();
				for (int i=0;i<split.length;i++) {
					JSONObject obj = new JSONObject();
					obj.put("item", split[i]);
					obj.put("value", choose[i]);
					arr.add(obj);
				}
				//answer
				JSONArray an = new JSONArray();
				JSONObject obj = new JSONObject();
				obj.put("item", answer);
				an.add(obj);
				qa.setOptions(arr.toJSONString()).setAnswer(an.toJSONString());
			}
			
			qService.insert(qa);
			return PTWResult.ok();
		} catch (Exception e) {
			return PTWResult.build(500, e.getMessage());
		}
	}
	private void add(Object put) {
		// TODO Auto-generated method stub
		
	}
}
