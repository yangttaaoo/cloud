package com.cist.illegalbehavior.model;
import java.util.List;  

public class Series {  
    public String name;  
    public String type;  
   private Integer barMaxWidth;
    public List<?> data;// 这里要用int 不能用String 不然前台显示不正常（特别是在做数学运算的时候）  
      
    public String getName() {  
        return name;  
    }  
  
    public void setName(String name) {  
        this.name = name;  
    }  
  
    public String getType() {  
        return type;  
    }  
  
    public void setType(String type) {  
        this.type = type;  
    }  
    public List<?> getData() {
		return data;
	}

	public void setData(List<?> data) {
		this.data = data;
	}



	public Series(String name, String type, Integer barMaxWidth, List<?> data) {
		super();
		this.name = name;
		this.type = type;
		this.barMaxWidth = barMaxWidth;
		this.data = data;
	}
	public Series(String name, String type, List<?> data) {
		super();
		this.name = name;
		this.type = type;
		this.data = data;
	}

	public Integer getBarMaxWidth() {
		return barMaxWidth;
	}

	public void setBarMaxWidth(Integer barMaxWidth) {
		this.barMaxWidth = barMaxWidth;
	}  
}  
