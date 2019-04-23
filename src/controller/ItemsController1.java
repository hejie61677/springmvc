package controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import entity.Items;

/**
 * 
 * <p>Title:ItemsController1 </p>
 * <p>Description: 实现controller接口的处理器</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 下午9:12:28
 */
public class ItemsController1 implements Controller{

	@Override
	public ModelAndView handleRequest(HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
		List<Items> itemsList = new ArrayList<Items>();
		
		Items i1 = new Items();
		i1.setId(1);
		i1.setName("iphoneX");
		Items i2 = new Items();
		i2.setId(2);
		i2.setName("onePlus5T");
		Items i3 = new Items();
		i3.setId(3);
		i3.setName("huaweiMate20");
		
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
