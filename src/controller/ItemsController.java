package controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import controller.validation.ValidationGroup1;
import entity.ItemsCustom;
import entity.ItemsQueryVo;
import service.ItemsService;

/**
 * 
 * <p>Title:ItemsController </p>
 * <p>Description: 商品的controller</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午5:59:33
 */
@Controller
//添加根路径：为了对URL进行分类管理
@RequestMapping("/items")
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	//商品查询
	@RequestMapping("/queryItems")
	public ModelAndView queryItems(HttpServletRequest request, ItemsQueryVo itemsQueryVo) throws Exception{

		//调用service查找数据库，查询商品列表
		List<ItemsCustom> itemsList = itemsService.findItemsList(itemsQueryVo);
		
		ModelAndView mav = new ModelAndView();
		//设置模型数据
		mav.addObject("itemsList", itemsList);
		//设置视图
		mav.setViewName("items/items");
		
		return mav;	
	}
	
	//商品详情页面显示(返回ModelAndView)
	//@RequestMapping("/editItem")
	//限制http请求方法
	@RequestMapping(value="/editItem",method={RequestMethod.POST,RequestMethod.GET})
	//@RequestParam里面指定request传入参数名称和形参进行绑定
	public ModelAndView editItem(@RequestParam(value="id",required=true,defaultValue="")Integer itemId) throws Exception {
		
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(itemId);
		
		ModelAndView mav = new ModelAndView();
		mav.addObject("itemsCustom", itemsCustom);
		//商品修改页面
		mav.setViewName("items/editItem");
		
		return mav;
	}
	/**
	//商品详情页面显示(返回String)
	//限制http请求方法
	@RequestMapping(value="/editItem",method={RequestMethod.POST,RequestMethod.GET})
	public String editItem(Model model) throws Exception {
			
		//调用service根据商品id查询商品信息
		ItemsCustom itemsCustom = itemsService.findItemsById(1);
			
		//通过形参中的model将模型数据传到页面
		model.addAttribute("itemsCustom", itemsCustom);
			
		return "items/editItem";
	}*/
	
	//修改提交
	//在需要校验的pojo前边添加@Validated，在后边添加BindingResult接受校验出错信息，注意：@Validated和BindingResult配对出现，顺序固定
	@RequestMapping("/editItemSubmit")
	public ModelAndView editItemSubmit(Model model, Integer id, @Validated(value={ValidationGroup1.class}) ItemsCustom itemsCustom, BindingResult bindingResult) throws Exception {
		
		ModelAndView mav = new ModelAndView();
		
		//获取校验错误信息
		if(bindingResult.hasErrors()) {
			//输出错误信息
			List<ObjectError> allErrors = bindingResult.getAllErrors();
			
			for(ObjectError objectError : allErrors) {
				System.out.println("这是111ssss打的" +objectError.getDefaultMessage());
			}
			
			//将错误信息传到页面
			mav.addObject("allErrors", allErrors);
			mav.setViewName("items/editItems");
			return mav;
		}
		
		//调用service更新商品信息
		itemsService.updateItems(id, itemsCustom);
		
		//添加数据到模型
		mav.addObject("itemsCustom", itemsCustom);
		//修改结束页面
		mav.setViewName("success");
		
		return mav;
	}
	/**
	//修改提交
	@RequestMapping("/editItemSubmit")
	public String editItemSubmit(HttpServletRequest request) throws Exception {

		// 重定向
		return "redirct:queryItems.action";
		//页面转发
		return "forward:queryItems.action";
	}*/
	
	//批量删除商品信息
	@RequestMapping("/deleteItems")
	public String deleteItems(Integer[] ids) throws Exception {
		
		return "success";
	}
}
