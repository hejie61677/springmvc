package service.impl;

import java.util.List;

import mapper.ItemsMapper;
import mapper.ItemsMapperCustom;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import entity.Items;
import entity.ItemsCustom;
import entity.ItemsQueryVo;
import service.ItemsService;

/**
 * 
 * <p>Title:ItemsServiceImpl </p>
 * <p>Description: 商品管理</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午5:05:18
 */
public class ItemsServiceImpl implements ItemsService{
	
	@Autowired
	private ItemsMapperCustom itemsMapperCustom;
	
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo)
			throws Exception {
		//通过ItemsMapperCustom查询数据库
		return itemsMapperCustom.findItemsList(itemsQueryVo);
	}

	@Override
	public ItemsCustom findItemsById(Integer id) throws Exception {
		
		Items items = itemsMapper.selectByPrimaryKey(id);
		ItemsCustom itemsCustom = new ItemsCustom();
		//将items的值拷贝到itemsCustom
		BeanUtils.copyProperties(items, itemsCustom);
		return itemsCustom;
	}

	@Override
	public void updateItems(Integer id, ItemsCustom itemsCustom) throws Exception {
		
		itemsCustom.setId(id);
		itemsMapper.updateByPrimaryKey(itemsCustom);
		
	}

}
