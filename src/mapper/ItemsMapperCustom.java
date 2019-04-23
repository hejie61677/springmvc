package mapper;

import entity.ItemsCustom;
import entity.ItemsQueryVo;
import java.util.List;

/**
 * 
 * <p>Title:ItemsMapperCustom </p>
 * <p>Description: 商品定制mapper接口</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午5:00:53
 */
public interface ItemsMapperCustom {
   
	//商品查询列表
	public List<ItemsCustom> findItemsList(ItemsQueryVo itemsQueryVo) throws Exception;
	
}