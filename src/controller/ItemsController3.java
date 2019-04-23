package controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import entity.Items;

/**
 * 
 * <p>Title:ItemsController1 </p>
 * <p>Description: 注解方式的处理器</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 下午9:12:28
 */
@Controller
public class ItemsController3{
	
	@RequestMapping("/items/queryItems3")
	public ModelAndView queryItems() throws Exception {
		
		List<Items> itemsList = new ArrayList<Items>();
		
		Items i1 = new Items();
		i1.setId(1);
		i1.setName("vivo");
		Items i2 = new Items();
		i2.setId(2);
		i2.setName("oppo");
		Items i3 = new Items();
		i3.setId(3);
		i3.setName("honor");
		
		itemsList.add(i1);
		itemsList.add(i2);
		itemsList.add(i3);
		
		ModelAndView mav = new ModelAndView();
		//设置模型数据
		mav.addObject("itemsList", itemsList);
		//设置视图
		mav.setViewName("items/items");
		
		return mav;
	}

}
