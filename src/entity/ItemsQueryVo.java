package entity;

import java.util.List;

/**
 * <p>Title:ItemsQueryVo </p>
 * <p>Description: 商品包装类</p>
 * <p>Company: test</p>
 * @author 何杰
 * @date 下午4:14:00
 */
public class ItemsQueryVo {
	
	private Items items;
	private ItemsCustom itemsCustom;
	private List<ItemsCustom> itemsList;//批量商品信息
	
	public Items getItems() {
		return items;
	}
	public void setItems(Items items) {
		this.items = items;
	}
	public ItemsCustom getItemsCustom() {
		return itemsCustom;
	}
	public void setItemsCustom(ItemsCustom itemsCustom) {
		this.itemsCustom = itemsCustom;
	}
	public List<ItemsCustom> getItemsList() {
		return itemsList;
	}
	public void setItemsList(List<ItemsCustom> itemsList) {
		this.itemsList = itemsList;
	}
}
