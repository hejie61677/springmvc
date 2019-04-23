package controller.converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <p>Title:CustomDateConverter </p>
 * <p>Description: 日期转换器</p>
 * <p>Company: </p>
 * @author 何杰
 * @date 下午3:46:22
 */
public class CustomDateConverter implements Converter<String, Date>{

	@Override
	public Date convert(String source) {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			return sdf.parse(source);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		//如果参数绑定失败，返回null
		return null;
	}

}
