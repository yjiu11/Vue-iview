

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.ptw.App;
import com.ptw.pojo.SysResource;
import com.ptw.service.SysResourceService;

@RunWith(SpringJUnit4ClassRunner.class) // 让junit与spring环境进行整合
@SpringBootTest(classes = { App.class }) // 自动加载spring相关的配置文件
public class TestMain {
	@Autowired
	private SysResourceService resourceService;
	@Test
	public void t1() {
		List<SysResource> one = resourceService.selectList(new EntityWrapper<SysResource>().eq("available", 1));
		List<Object> result = resourceService.getChildren(0, one);
		System.out.println(result);
	}
	@Test
	public void t2() {
		List<SysResource> one = resourceService.selectList(new EntityWrapper<SysResource>().eq("available", 1).eq("parent_id", 0));
		List<Object> result = resourceService.getChildren(0, one);
		System.out.println(result);
	}
	@Test
	public void t3() {
		List<Object> menus = resourceService.oneLevelMenu(1);
		System.out.println(menus);
	}
	@Test
	public void t4() {
		List<Object> menus = resourceService.twoLevelMenu(1,1);//后面1表示：点击的一级菜单：系统管理
		System.out.println(menus);
	}
}
