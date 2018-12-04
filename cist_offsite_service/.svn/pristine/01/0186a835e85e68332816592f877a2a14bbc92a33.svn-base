package com.cist.picture.model;

import java.io.Serializable;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MenuDetails implements Serializable{
	
	private static final long serialVersionUID = -5202969926436878204L;
	
	private Logger log = LoggerFactory.getLogger(MenuDetails.class);
	
	private Long FUN_ID;

	private String FUN_CODE;
	
	private String FUN_NAME;
	
	private String FUN_URL;
	
	private String FUN_PIC_URL;
	
	private String FUN_TUG;
	
	private Long FUN_PARENT;
	
	private Short FUN_TYPE;
	
	private Boolean selected = false;
	
	private String attributes[];
	
	private List<MenuDetails> children = new ArrayList<MenuDetails>();

	public Long getFUN_ID() {
		return FUN_ID;
	}

	public void setFUN_ID(Long fUN_ID) {
		FUN_ID = fUN_ID;
	}

	public String getFUN_CODE() {
		return FUN_CODE;
	}

	public void setFUN_CODE(String fUN_CODE) {
		FUN_CODE = fUN_CODE;
	}

	public String getFUN_NAME() {
		return FUN_NAME;
	}

	public void setFUN_NAME(String fUN_NAME) {
		FUN_NAME = fUN_NAME;
	}

	public String getFUN_URL() {
		return FUN_URL;
	}

	public void setFUN_URL(String fUN_URL) {
		FUN_URL = fUN_URL;
	}

	public String getFUN_PIC_URL() {
		return FUN_PIC_URL;
	}

	public void setFUN_PIC_URL(String fUN_PIC_URL) {
		FUN_PIC_URL = fUN_PIC_URL;
	}

	public String getFUN_TUG() {
		return FUN_TUG;
	}

	public void setFUN_TUG(String fUN_TUG) {
		FUN_TUG = fUN_TUG;
	}

	public Long getFUN_PARENT() {
		return FUN_PARENT;
	}

	public void setFUN_PARENT(Long fUN_PARENT) {
		FUN_PARENT = fUN_PARENT;
	}

	public String getFUN_TYPE() {
		if(ConstUtils.MENU_TYPE.equals(FUN_TYPE))
		{
			return ConstUtils.MENU_MIS_TYPE;
		}
		return ConstUtils.MENU_GIS_TYPE;
	}

	public void setFUN_TYPE(Short fUN_TYPE) {
		FUN_TYPE = fUN_TYPE;
	}

	public Boolean getSelected() {
		return selected;
	}

	public void setSelected(Boolean selected) {
		this.selected = selected;
	}

	public List<MenuDetails> getChildren(boolean isSort) {
		
		if (children.size() > 0 && isSort) {
			Collections.sort(children, new Comparator<MenuDetails>() {
				public int compare(MenuDetails o1, MenuDetails o2) {
					return o1.getFUN_CODE().compareTo(o2.getFUN_CODE());
				}
			});
		}
		return children;
	}

	public void setChildren(List<MenuDetails> children) {
		this.children = children;
	}

	public List<MenuDetails> getChildren(){
		return this.children;
	}
	
	public String[] getAttributes() {
		return attributes;
	}

	public void setAttributes(String[] attributes) {
		this.attributes = attributes;
	}

	public String toXML(){
		
		try
		{
			String url = URLDecoder.decode(MenuDetails.class.getClassLoader()
					.getResource(ConstUtils.MENU_XML_PATH).getPath(), "UTF-8");
			SAXReader reader = new SAXReader();
			Document document = reader.read(url);
			List<?> list = document.selectNodes(ConstUtils.MENU_ROOT_NODE_NAME);
			Element widgetcontainer = (Element)list.get(1);
			listAsXML(getChildren(true),widgetcontainer);
			Element rootElm = document.getRootElement();
			return rootElm.asXML();
		}
		catch(Exception e)
		{
			log.error(ConstUtils.CREATE_MENU_ERROR, e.fillInStackTrace());
		}
		
		return null;
	}
	
	private void listAsXML(List<MenuDetails>list,Element widgetcontainer){
			
			Element widget = null;
			for(MenuDetails menu:list)
			{
				if(menu.getChildren(true).size()>0)
				{
					if(ConstUtils.MENU_GIS_TYPE.equals(menu.getFUN_TYPE()) && 
							menu.getFUN_URL() == null)
					{
	
						listAsXML(menu.getChildren(true),widgetcontainer);
					}
					else
					{
						if(getFUN_ID().equals(menu.getFUN_PARENT()) && 
								ConstUtils.MENU_MIS_TYPE.equals(menu.getFUN_TYPE()))
						{
							widget = widgetcontainer.addElement(ConstUtils.WIDGETGROUP);
						}
						else
						{
							widget = widgetcontainer.addElement(ConstUtils.WIDGET);
						}
						
						widget.addAttribute(ConstUtils.LABEL, menu.getFUN_NAME());
						widget.addAttribute(ConstUtils.ICON, menu.getFUN_PIC_URL());
						widget.addAttribute(ConstUtils.SIGN, menu.getFUN_TYPE());
						listAsXML(menu.getChildren(true),widget);
					}
					
				}
				else
				{
					widget = widgetcontainer.addElement("widget");
					widget.addAttribute(ConstUtils.LABEL, menu.getFUN_NAME());
					widget.addAttribute(ConstUtils.ICON, menu.getFUN_PIC_URL());
					widget.addAttribute(ConstUtils.SIGN, menu.getFUN_TYPE());
					widget.addAttribute(ConstUtils.URL, menu.getFUN_URL());
				}
				
			}
	}
	
}
