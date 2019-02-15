package com.cist.interfaceajk.service;

import java.util.HashMap;
import java.util.List;

import com.cist.interfaceajk.model.SjgxInterfaces;
import com.cist.interfaceajk.model.Sjgxinterfaceconnect;

public interface PortsService {
	//接口总数
	public List<SjgxInterfaces> listSjgxInterface();
	//接口总数统计
    public List<SjgxInterfaces> sjgxInterfacecount();
    //查询使用接口调用信息
    public List<Sjgxinterfaceconnect> sjgxinterfaceconnect();
    //接口调用日环比
    public Integer sjgxinterfacez();//昨天成功率
    public Integer sjgxinterfacej();//今日成功率
    //日同比
    public Integer sjgxinterfacertb();
    //接口调用量（周）每天
    public List<SjgxInterfaces> listSjgxInterfaceweekday();
    //接口调用量（周） 总
    public Integer sjgxinterfacezong();
    //接口调用总量（月）
    public Integer monthly();
    //接口调用总量（月） 上个月
    public Integer monthlyshang();
    //接口调用总量（月） 去年的这个月
    public Integer monthlyshangyue();
    //接口调用次数排名
    public List<SjgxInterfaces> numberOfranking(HashMap<String,Object> map);
    //接口调用 Top 5
    //接口调用次数排名
    public List<SjgxInterfaces> numberOfrankingTop(HashMap<String,Object> map);
    public Integer kingTop(HashMap<String,Object> map);
    
}
