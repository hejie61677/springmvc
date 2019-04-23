package entity;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import controller.validation.ValidationGroup1;
import controller.validation.ValidationGroup2;

public class Items {
	//非空校验
	@NotNull(message="",groups={ValidationGroup1.class,ValidationGroup2.class})
    private Integer id;
    
    //校验名称在30字符内 ，message是提示信息
    @Size(min=1,max=30,message="{items.name.length.error}",groups={ValidationGroup1.class})
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }
}