package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.HttpRequestHandler;

import entity.Items;

/**
 * 
 * <p>Title:ItemsController1 </p>
 * <p>Description: 实现HttpRequestHandler接口的处理器</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 下午9:12:28
 */
public class ItemsController2 implements HttpRequestHandler{

	@Override
	public void handleRequest(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		List<Items> itemsList = new ArrayList<Items>();
		
		Items i1 = new Items();
		i1.setId(1);
		i1.setName("iphoneXR");
		Items i2 = new Items();
		i2.setId(2);
		i2.setName("onePlus6T");
		Items i3 = new Items();
		i3.setId(3);
		i3.setName("huaweiMate20p");
		
		itemsList.add(i1);
		itemsList.add(i2);
		itemsList.add(i3);
		
		//设置模型数据
		request.setAttribute("itemsList", itemsList);
		
		//设置转发的视图
		request.getRequestDispatcher("/WEB-INF/page/jsp/items/items.jsp").forward(request, response);
	}



}
