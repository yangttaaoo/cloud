package com.cist.illegal.controller;

import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.hssf.usermodel.HSSFClientAnchor;
import org.apache.poi.hssf.usermodel.HSSFPatriarch;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.xwpf.model.XWPFHeaderFooterPolicy;
import org.apache.poi.xwpf.usermodel.ParagraphAlignment;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.apache.poi.xwpf.usermodel.XWPFRun;
import org.apache.poi.xwpf.usermodel.XWPFTable;
import org.apache.poi.xwpf.usermodel.XWPFTableRow;
import org.apache.xmlbeans.XmlException;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTP;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTR;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTSectPr;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTTblWidth;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTText;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STShd;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.STTblWidth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.cist.dataexport.util.UrlFilesToZip;
import com.cist.frame.page.PageInfo;
import com.cist.illegal.model.C_plate_keris;
import com.cist.illegal.model.SYS_FRM_CODE;
import com.cist.illegal.model.TBL_OFFE_CATE;
import com.cist.illegal.model.TBL_OFFE_EVDI;
import com.cist.illegal.model.TBL_VERIFY_GROUP;
import com.cist.illegal.service.IllegalService;
import com.cist.illegal.util.XwpfTUtil;
import com.cist.picture.model.Tbl_offe_evdi;
import com.cist.recheck.model.TblOffeEvdiInfo;
import com.cist.redlist.model.DeptInfo;
import com.cist.redlist.service.RedListService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RestController
@SuppressWarnings("unchecked")
@RequestMapping("/illegal")
public class IllegalController {

	@Autowired
	private IllegalService service;

	@Autowired
	private RedListService service1;

	/**
	 * 分页查询违法数据(初审)
	 * 
	 * @return
	 */
	@RequestMapping("queryIllegalFirst")
	public PageInfo<TBL_OFFE_EVDI> querylist(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		
		// 警员
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = service.querywfxwqxbysypi(userPk);
		if(map.get("wfxw")!=null&&!"".equals(map.get("wfxw").toString())) {
			//如果查询条件违法行为存在
			String[] wfxwstr = new String[1];
			wfxwstr[0]=map.get("wfxw").toString();
			map.put("wfxw", wfxwstr);
		}else {
			if(vglist.size()>0) {
				if(vglist.get(0).getTbvg_wfxw()!=null) {
					map.put("wfxw", vglist.get(0).getTbvg_wfxw().split(","));
				}
			}else {
				map.put("wfxw", null);
			}
		}
		
		//设备权限
		if(map.get("sbbh")!=null&&!"".equals(map.get("sbbh").toString())&&map.get("sbbh").toString().length()>2) {
	//			map.put("sbbh", null);
			Object obj = map.get("sbbh");
		}else {
			if(vglist.size()>0) {
				String dev = service.querydevbysypi(vglist.get(0).getTbvg_pk());
				if(dev!=null) {
					String[] str = dev.split(",");
					if(Arrays.asList(str).contains("0")) {
						map.put("zplx", "1");
					}else {
						map.put("sb_pk", dev.split(","));
						String sb_bh = service.querysbbhbysbpk(map);
						if(sb_bh!=null) {
							String[] split = sb_bh.split(",");
							List<String> sbbhlist=new ArrayList<String>();
							for (int i = 0; i < split.length; i++) {
								sbbhlist.add(split[i]);
							}
							map.put("sbbh",sbbhlist);	
						}
					}
				}
			}
			
			
		}
				
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		if("1".equals(map.get("tqFlag"))) {
			Integer tiqu = service.tiqu(map);	
		}
		PageInfo<TBL_OFFE_EVDI> list = (PageInfo<TBL_OFFE_EVDI>) service.queryevdipageList(map, info);
		for (int i = 0; i < list.getList().size(); i++) {
			if (list.getPageNum() == 1 && list.getPages() > list.getPageNum()) {
				// 如果当前页为第一页，且总页数大于当前页
				if (i == 0) {
					list.getList().get(i).setIsnext(1);
					list.getList().get(i).setIsupper(0);
				} else {
					list.getList().get(i).setIsnext(1);
					list.getList().get(i).setIsupper(1);
				}
			} else if (list.getPageNum() > 1 && list.getPages() == list.getPageNum()) {
				// 如果当前页为总页数，且总页数大于1
				if (i == list.getList().size() - 1) {
					list.getList().get(i).setIsnext(0);
					list.getList().get(i).setIsupper(1);
				} else {
					list.getList().get(i).setIsnext(1);
					list.getList().get(i).setIsupper(1);
				}
			} else if (list.getPageNum() == 1&&list.getPages()==1) {
				// 如果当前页为第一页，且总页数等于1
				if (list.getList().size()==1) {
					list.getList().get(i).setIsnext(0);
					list.getList().get(i).setIsupper(0);
				}else if(list.getTotal()==i+1) {
					list.getList().get(i).setIsnext(0);
					list.getList().get(i).setIsupper(1);
				}
				else if (i == 0) {
					list.getList().get(i).setIsnext(1);
					list.getList().get(i).setIsupper(0);
				} else if (i == list.getList().size() - 1) {
					list.getList().get(i).setIsnext(0);
					list.getList().get(i).setIsupper(1);
				} else {
					list.getList().get(i).setIsnext(1);
					list.getList().get(i).setIsupper(1);
				}
			} else {
				list.getList().get(i).setIsnext(1);
				list.getList().get(i).setIsupper(1);
			}
		}

		return list;
	}

	/**
	 * 分页查询违法数据(上传)
	 * 
	 * @return
	 */
	@RequestMapping("queryIllegalUpload")
	public PageInfo<TBL_OFFE_EVDI> querylistupload(@RequestBody HashMap<String, Object> map) {
		PageInfo info = new PageInfo();
		info.setPageNum(Integer.parseInt(map.get("currentPage").toString()));
		info.setPageSize(Integer.parseInt(map.get("pageSize").toString()));
		PageInfo<TBL_OFFE_EVDI> list = (PageInfo<TBL_OFFE_EVDI>) service.queryuploadpageList(map, info);
		return list;
	}

	/**
	 * 查询基础数据 注：必须给fct_code值，查找相应的基础数据
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("queryfrm")
	public List<SYS_FRM_CODE> queryfrm(@RequestBody HashMap<String, Object> map) {
		return service.queryfrms(map);
	}

	/**
	 * 查询号牌号码前2位
	 * 
	 * @return
	 */
	@RequestMapping("/queryPlateKeris")
	public List<C_plate_keris> queryPlateKeris() {
		return service.queryPlateKeris();
	}

	/**
	 * 查询违法行为
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/selectwfxw")
	public List<TBL_OFFE_CATE> selectwfxw() {
		return service.selectwfxw(null);
	}

	/**
	 * 更新违法数据信息（上传/初审）
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/updateIllegal")
	public String updateIllegal(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		
		
		Integer count = null;
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		String deptCode = userMap.get("sypi_dept_pk")==null?null:userMap.get("sypi_dept_pk").toString();
		map.put("tool_user", userPk);//操作人pk
		map.put("tool_dept_code", deptCode);//操作部门代码
		//获取ip
		  String remoteAddr = request.getRemoteAddr();
	        String forwarded = request.getHeader("X-Forwarded-For");
	        String realIp = request.getHeader("X-Real-IP");
	        String ip = null;
	        if (realIp == null) {
	            if (forwarded == null) {
	                ip = remoteAddr;
	            } else {
	                ip = remoteAddr + "/" + forwarded;
	            }
	        } else {
	            if (realIp.equals(forwarded)) {
	                ip = realIp;
	            } else {
	                ip = realIp + "/" + forwarded.replaceAll(", " + realIp, "");
	            }
	        }
	       map.put("tool_ip", forwarded);//客户端ip地址
		// 根据前端页面给出的标记判断是初审还是上传 0:表示初审 1：表示上传
		if ("0".equals(map.get("shbj").toString())) {
			//审核结果为“有效”时，保存审核结果时需判断违法信息中的“号牌号码”、“号牌种类”、“车身颜色”与车辆信息中的“号牌号码”、“号牌种类”、“车身颜色”一致
			if(map.get("shbz")=="1"&&map.get("dataList")!=null)//1为初审通过
			{
				Map object = (Map) map.get("dataList");
				if(!map.get("hphm").equals(object.get("hphm"))||!map.get("hpzl").equals(object.get("hpzl"))||((String)object.get("csys")).indexOf((String)map.get("csys"))!=-1)
				{
					return "{\"result\":\"信息不一致\"}";
				}
			}
			//判断界面类表中该条违法数据状态与数据库该条数据状态是否一致，否则提交失败
			TBL_OFFE_EVDI selectStatus = service.selectStatus(map);
			if(selectStatus==null)
			{
				return "{\"result\":\"已审核\"}";
				
			}
			//判断该车辆在同一地点同一时间，在数据库中是否已存在有效违法数据，如存在该条违法数据自动作废
			if(map.get("shbz")=="1")//1 为初审通过
			{
				if(service.selectValid(map)!=null)
				{
					map.put("shbz", "3");//若数据库存在有效数据时自动作废当前数据3为初审作废
				}
			}
			//限行违法数据同一天相同车辆只允许存在一条有效限行违法数据，如果已存则数据自动作废；
			if(map.get("shbz")=="1"&&map.get("shbz").equals("1344"))//1 为初审通过
			{
				if(service.selectRestriction(map)!=null)
				{
					map.put("shbz", "3");//若数据库存在有效数据时自动作废当前数据3为初审作废
				}
			}
			map.put("csr", userPk);
			map.put("yxqz", map.get("jyyxqz"));
			//&&("".equals(map.get("clbz").toString()))       
			int b = service.updateIllegal(map);
			
			count = b;
		} else if ("1".equals(map.get("shbj").toString())) {
//			map.put("shbj", null);
			count = service.updateIllegal(map);
		}
		if(count>0)
		{
			return "{\"result\":\"审核成功\"}";
		}
		else
		{
			return "{\"result\":\"审核失败\"}";
		}
	}

	/**
	 * zip图片导出
	 * 
	 * @param map
	 * @param request
	 * @param response
	 */
	@RequestMapping("downloadFiles")
	public void downloadFiles(@RequestBody HashMap<String, Object> map, HttpServletRequest request,
			HttpServletResponse response) {
		String wfdd = map.get("wfdz")==null?"未知":map.get("wfdz").toString();
		String kkbh = map.get("kkbh")==null?"未知":map.get("kkbh").toString();
		String sbbh = map.get("sbbh")==null?"未知":map.get("sbbh").toString();
		String wfxw = map.get("wfxw")==null?"未知":map.get("wfxw").toString();
		String hphm = map.get("hphm")==null?"未知":map.get("hphm").toString();
		try {
			// 获取当前时间当做文件夹名
			Date da = new Date();
			SimpleDateFormat sf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_SS");// 格式化日期
			int rd = (int) (Math.random() * 1000) + 100;// 第一层文件夹名的末尾的随机数
			String format = sf.format(da) + "_" + rd;// 时间文件名结尾加三位随机数
			// 控制文件名编码
			// 响应头的设置
			response.reset();
			response.setCharacterEncoding("utf-8");
			response.setContentType("multipart/form-data");
			// 设置压缩包的名字
			// 解决不同浏览器压缩包名字含有中文时乱码的问题
			String downloadName = format + ".zip";
			String agent = request.getHeader("USER-AGENT");
			try {
				if (agent.contains("MSIE") || agent.contains("Trident")) {
					downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
				} else {
					downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			response.setHeader("Content-Disposition", "attachment;fileName=\"" + downloadName + "\"");
			// 设置压缩流：直接写入response，实现边压缩边下载
			ZipOutputStream zipos = null;
			zipos = new ZipOutputStream(new BufferedOutputStream(response.getOutputStream()));
			zipos.setMethod(ZipOutputStream.DEFLATED); // 设置压缩方法
			ArrayList<String> urls = new ArrayList<String>();// 存放图片路径
			UrlFilesToZip s = new UrlFilesToZip();
			// 循环将文件写入压缩流
			DataOutputStream os = null;
			try {
				if(map.get("wfzj1")!=null) {
					urls.add(map.get("wfzj1").toString());
				}
				if(map.get("wfzj2")!=null) {
					urls.add(map.get("wfzj2").toString());
				}
				if(map.get("wfzj3")!=null) {
					urls.add(map.get("wfzj3").toString());
				}
				
				
				for (String oneFile : urls) {
					// 根据实体字段名生成压缩包内文件路径
					zipos.putNextEntry(new ZipEntry(format + "/" + wfdd + "(" + kkbh + ")" + "/" + sbbh + "/" + wfxw
							+ "/" + hphm + "/" + oneFile.substring(21)));
					byte[] bytes = s.getImageFromURL(oneFile);
					os = new DataOutputStream(zipos);
					os.write(bytes, 0, bytes.length);
					zipos.closeEntry();
				}
				urls.clear();// 操作完一条记录清除一次图片路径
				// 关闭流
				zipos.close();
				// os.flush();
				os.close();
			} catch (IOException e) {
				// 此异常不打印，用户在下载途中点击取消中断流的输出会报此异常
			}
			// 更改已导出数据的状态为导出

		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	/**
	 * 证据设备报修
	 * 
	 * @param response
	 * @throws IOException
	 */
	@RequestMapping("excelphoto")
	public void excelphoto(@RequestParam HashMap<String, Object> map, HttpServletResponse response) throws IOException {
		// 多张图片的导出

		List<BufferedImage> images = new ArrayList<BufferedImage>();
		String wfzj1 = map.get("wfzj1").toString();
		String wfzj2 = map.get("wfzj2").toString();
		String wfzj3 = map.get("wfzj2").toString();
		images.add(ImageIO.read(new File(wfzj1)));
		images.add(ImageIO.read(new File(wfzj2)));
		images.add(ImageIO.read(new File(wfzj3)));
		HSSFWorkbook wb = new HSSFWorkbook();
		HSSFSheet sheet1 = wb.createSheet("证据设备保修");
		HSSFPatriarch patriarch = sheet1.createDrawingPatriarch();
		short i = 0;
		for (BufferedImage image : images) {
			ByteArrayOutputStream byteArrayOut = new ByteArrayOutputStream();
			ImageIO.write(image, "jpg", byteArrayOut);
			HSSFClientAnchor anchor = new HSSFClientAnchor(0, 0, 0, 0, (short) (i * 4), 0, (short) (i * 4 + 4), 8);
			// 插入图片
			patriarch.createPicture(anchor, wb.addPicture(byteArrayOut.toByteArray(), HSSFWorkbook.PICTURE_TYPE_JPEG));
			i++;
		}
		response.setContentType("application/vnd.ms-excel");
		response.addHeader("Content-Disposition",
				"attachment;filename=" + java.net.URLEncoder.encode("证据设备保修", "UTF-8") + ".xls");
		OutputStream outputStream = response.getOutputStream();
		wb.write(outputStream);
		outputStream.flush();
		outputStream.close();
	}

	/**
	 * 根据wfpk查询下一条数据（初审）
	 * 
	 * @param ill
	 * @return
	 */
	@RequestMapping("/selectNextByWfpk")
	public List<TBL_OFFE_EVDI> selectNextByWfpk(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = service.querywfxwqxbysypi(userPk);
		if(map.get("wfxw")!=null&&!"".equals(map.get("wfxw").toString())) {
			//如果查询条件违法行为存在
			String[] wfxwstr = new String[1];
			wfxwstr[0]=map.get("wfxw").toString();
			map.put("wfxw", wfxwstr);
		}else {
			if(vglist.size()>0) {
				if(vglist.get(0).getTbvg_wfxw()!=null) {
					map.put("wfxw", vglist.get(0).getTbvg_wfxw().split(","));
				}
			}else {
				map.put("wfxw", null);
			}
		}
		
		//设备权限
				if(map.get("sbbh")!=null&&!"".equals(map.get("sbbh").toString())&&map.get("sbbh").toString().length()>2) {
			//			map.put("sbbh", null);
					Object obj = map.get("sbbh");
				}else {
					if(vglist.size()>0) {
						String dev = service.querydevbysypi(vglist.get(0).getTbvg_pk());
						if(dev!=null) {
							String[] str = dev.split(",");
							if(Arrays.asList(str).contains("0")) {
								map.put("zplx", "1");
							}else {
								map.put("sb_pk", dev.split(","));
								String sb_bh = service.querysbbhbysbpk(map);
								if(sb_bh!=null) {
									String[] split = sb_bh.split(",");
									List<String> sbbhlist=new ArrayList<String>();
									for (int i = 0; i < split.length; i++) {
										sbbhlist.add(split[i]);
									}
									map.put("sbbh",sbbhlist);	
								}
							}
						}
					}
					
					
				}

		List<TBL_OFFE_EVDI> list = service.selectNextByWfpk(map);
		if(list.size()>0) {
			if(map.get("isupper")!=null&&"0".equals(map.get("isupper").toString())&&map.get("flag")!=null&&true==(boolean)map.get("flag")) {
				list.get(0).setIsupper(0);
			}else {
				list.get(0).setIsupper(1);
			}
			
			map.put("wfpk", list.get(0).getWfpk());
			if (service.selectNextByWfpk(map).size() > 0) {
				list.get(0).setIsnext(1);
			} else {
				list.get(0).setIsnext(0);
			}
		}
		return list;
	}

	/**
	 * 根据wfpk查询上一条数据（初审）
	 * 
	 * @param ill
	 * @return
	 */
	@RequestMapping("/selectUpperByWfpk")
	public List<TBL_OFFE_EVDI> selectUpperByWfpk(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = service.querywfxwqxbysypi(userPk);
		if(map.get("wfxw")!=null&&!"".equals(map.get("wfxw").toString())) {
			//如果查询条件违法行为存在
			String[] wfxwstr = new String[1];
			wfxwstr[0]=map.get("wfxw").toString();
			map.put("wfxw", wfxwstr);
		}else {
			if(vglist.size()>0) {
				if(vglist.get(0).getTbvg_wfxw()!=null) {
					map.put("wfxw", vglist.get(0).getTbvg_wfxw().split(","));
				}
			}else {
				map.put("wfxw", null);
			}
		}
		
		//设备权限
				if(map.get("sbbh")!=null&&!"".equals(map.get("sbbh").toString())&&map.get("sbbh").toString().length()>2) {
			//			map.put("sbbh", null);
					Object obj = map.get("sbbh");
				}else {
					if(vglist.size()>0) {
						String dev = service.querydevbysypi(vglist.get(0).getTbvg_pk());
						if(dev!=null) {
							String[] str = dev.split(",");
							if(Arrays.asList(str).contains("0")) {
								map.put("zplx", "1");
							}else {
								map.put("sb_pk", dev.split(","));
								String sb_bh = service.querysbbhbysbpk(map);
								if(sb_bh!=null) {
									String[] split = sb_bh.split(",");
									List<String> sbbhlist=new ArrayList<String>();
									for (int i = 0; i < split.length; i++) {
										sbbhlist.add(split[i]);
									}
									map.put("sbbh",sbbhlist);	
								}
							}
						}
					}
					
					
				}
		List<TBL_OFFE_EVDI> list = service.selectUpperByWfpk(map);
		if(list.size()>0) {
			list.get(0).setIsnext(1);
			map.put("wfpk", list.get(0).getWfpk());
			if (service.selectUpperByWfpk(map).size() > 0) {
				list.get(0).setIsupper(1);
			} else {
				list.get(0).setIsupper(0);
			}
		}
		return list;
	}

	/**
	 * 部门树
	 * 
	 * @return
	 * @throws JsonProcessingException
	 */
	@RequestMapping("deptinfo")
	public String deptinfo() throws JsonProcessingException {
		// 顶级部门
		List<DeptInfo> departinfo = service1.depart_infolist(null);
		ObjectMapper mapper = new ObjectMapper();
		List<DeptInfo> list = departinfodg(departinfo);
		String json = mapper.writeValueAsString(getdiwfdidian(list));
		return json.substring(1, json.length() - 1);
	}

	public List<HashMap<String, Object>> getdiwfdidian(List<DeptInfo> list) {
		List<HashMap<String, Object>> listmap = new ArrayList<HashMap<String, Object>>();
		for (DeptInfo depart_info : list) {
			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put("title", depart_info.getName());
			map.put("key", depart_info.getDept_code());
			map.put("selectable", depart_info.getSelectable());
			map.put("isLeaf", depart_info.getIsLeaf());
			if (null != depart_info.getChildren()) {// 下级
				map.put("children", getdiwfdidian(depart_info.getChildren()));
				listmap.add(map);
			} else {
				listmap.add(map);
			}
		}
		return listmap;
	}

	public List<DeptInfo> departinfodg(List<DeptInfo> departinfo) {
		for (DeptInfo depart_info : departinfo) {
			// 部门
			List<DeptInfo> list = service1.depart_infolist(depart_info.getDept_pk());
			if (list.size() != 0) {
				depart_info.setChildren(list);
				departinfodg(list);
			}
		}
		return departinfo;
	}

	/**
	 * 页面审核统计（初审）
	 * 
	 * @return
	 */
	@RequestMapping("sycivalue")
	public HashMap<String, Object> sycivalue(HttpServletRequest request) {
		HashMap<String, Object> modelMap = new HashMap<String, Object>();
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = service.querywfxwqxbysypi(userPk);
		if (vglist.size() > 0) {
			if (vglist.get(0).getTbvg_wfxw() != null) {
				modelMap.put("tboc_code", vglist.get(0).getTbvg_wfxw().split(","));
			}
		}
		//设备权限
		modelMap.put("sbbh",new ArrayList<String>());
		if(vglist.size()>0) {
			String dev = service.querydevbysypi(vglist.get(0).getTbvg_pk());
			if(dev!=null) {
				String[] str = dev.split(",");
				if(Arrays.asList(str).contains("0")) {
					modelMap.put("zplx", "1");
				}else {
					modelMap.put("sb_pk", dev.split(","));
					String sb_bh = service.querysbbhbysbpk(modelMap);
					if(sb_bh!=null) {
						String[] split = sb_bh.split(",");
						List<String> sbbhlist=new ArrayList<String>();
						for (int i = 0; i < split.length; i++) {
							sbbhlist.add(split[i]);
						}
						modelMap.put("sbbh",sbbhlist);	
					}
			
				}
			}
		}
		int sycivalue = service.sycivalue(modelMap);
		modelMap.put("sycivalue", sycivalue);// 违法数据有效期，默认值为12天
		modelMap.put("wfkssj", gettime(sycivalue));// 开始时间
		modelMap.put("wfjssj", gettime(0));// 结束时间
		modelMap.put("auditnumber", service.auditnumber(modelMap));// 违法数据有效期内多少违法数据
		Integer queryjrgzl = service.queryjrgzl(userPk);
		modelMap.put("jrshl", queryjrgzl==null?0:queryjrgzl);// 今日已审核量
		List<TBL_VERIFY_GROUP> querywfxwqxbysypi = service.querywfxwqxbysypi(userPk);
		if(querywfxwqxbysypi.get(0).getTbvg_job()!=null)
		{
			modelMap.put("jrgzl", querywfxwqxbysypi.get(0).getTbvg_job());// 今日工作量	
		}
		else
		{
			modelMap.put("jrgzl", 0);// 今日工作量
		}
		 
		return modelMap;
	}

	public String gettime(Integer day) {
		Date date = new Date();// 取时间
		Calendar calendar = new GregorianCalendar();
		calendar.setTime(date);
		calendar.add(calendar.DATE, -day);// 把日期往后增加一天.整数往后推,负数往前移动
		date = calendar.getTime(); // 这个时间就是日期往后推一天的结果
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String dateString = formatter.format(date);

		return dateString;
	}

	/**
	 * 根据权限查询违法行为
	 * 
	 * @param map
	 * @return
	 */
	@RequestMapping("/querywfxw")
	public List<TBL_OFFE_CATE> querywfxw(@RequestBody HashMap<String, Object> map,HttpServletRequest request) {
		List<TBL_OFFE_CATE> list = null;
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = service.querywfxwqxbysypi(userPk);
		if (vglist.size() > 0) {
			if (vglist.get(0).getTbvg_wfxw() != null) {
				map.put("tboc_code", vglist.get(0).getTbvg_wfxw().split(","));
				list = service.querywfxw(map);
			} else {
				list = service.querywfxw(null);
			}
		} else {
			list = service.querywfxw(null);
		}
		return list;
	}
	/**
	 * 证据设备报修导出word文档
	 * @throws IOException 
	 * @throws XmlException 
	 */
	@RequestMapping("getword")
	public void getword(@RequestBody HashMap<String,Object> map,HttpServletResponse response) throws IOException, XmlException {
		 Map<String, Object> params = new HashMap<String, Object>(); 
		 params.put("${date}", map.get("tbsj")); 
		 params.put("${pName}", map.get("tbr")); 
		 params.put("${name}", map.get("sbmc")); 
		 params.put("${didian}", map.get("szdd")); 
		 params.put("${desc}", map.get("gzms")); 
		 params.put("${header2}", map.get("")); 
		 UrlFilesToZip s=new UrlFilesToZip();
		 XwpfTUtil xwpfTUtil = new XwpfTUtil();  
         XWPFDocument doc;  
         String fileNameInResource = "sta.docx"; 
         InputStream is;  
         /*is = new FileInputStream(filePath);*/  
         is = getClass().getClassLoader().getResourceAsStream(fileNameInResource);      //本身就在编译路径下。。。。
         
         doc = new XWPFDocument(is);  
         
         xwpfTUtil.replaceInPara(doc, params);  
         //替换表格里面的变量  
         xwpfTUtil.replaceInTable(doc, params);  
         OutputStream os = response.getOutputStream();  
         
         String downloadName="证据设备报修.docx";
         downloadName = java.net.URLEncoder.encode(downloadName, "UTF-8");
         downloadName = new String(downloadName.getBytes("UTF-8"), "ISO-8859-1");
	

         response.setContentType("application/vnd.ms-excel");  
         response.setHeader("Content-disposition","attachment;filename="+downloadName);  
   
         doc.write(os);  
   
         xwpfTUtil.close(os);  
         xwpfTUtil.close(is);  
   
         os.flush();  
         os.close();  
	}
	
	/**
	 * 查询权限下违法初审数据总数
	 * @return
	 */
	@RequestMapping("quantity")
	public Integer quantity(HttpServletRequest request){
		HashMap<String,Object> map = new HashMap<String,Object>();
		// 警员
		HttpSession session = request.getSession();
		Map<String,Object> userMap = (Map<String,Object>)session.getAttribute("userInfo"+session.getId());
		String userPk = userMap.get("sypi_pk")==null?null:userMap.get("sypi_pk").toString();
		List<TBL_VERIFY_GROUP> vglist = service.querywfxwqxbysypi(userPk);
		if(vglist.size()>0) {
			if(vglist.get(0).getTbvg_wfxw()!=null) {
				map.put("wfxw", vglist.get(0).getTbvg_wfxw().split(","));
			}
			String dev = service.querydevbysypi(vglist.get(0).getTbvg_pk());
			if(dev!=null) {
				String[] str = dev.split(",");
				if(Arrays.asList(str).contains("0")) {
					map.put("zplx", "1");
				}else {
					map.put("sb_pk", dev.split(","));
					String sb_bh = service.querysbbhbysbpk(map);
					if(sb_bh!=null) {
						map.put("sbbh", sb_bh.split(","));	
					}
				}
			}
		}
		 return service.querycsnum(map);
	}
	
	/**
	 * 根据wfpk查询一条数据
	 * @param map
	 * @return
	 */
	@RequestMapping("databywfpk")
	public TBL_OFFE_EVDI querydatabywfpk(@RequestBody HashMap<String,Object> map) {
		
		return service.querydatabywfpk(map.get("wfpk").toString());
		
	}
	
	/**
	 * 查询六合一数据
	 * @param map
	 * @return
	 */
	@RequestMapping("selectCarInfo")
	public TBL_OFFE_EVDI selectCarInfo(@RequestBody HashMap<String,Object> map) {
		TBL_OFFE_EVDI selectCarInfo = service.selectCarInfo(map);
		return selectCarInfo;
		
	}
	
	/**
	 * 更新六合一数据
	 * @param map
	 * @return
	 */
	@RequestMapping("updateCarInfo")
	public String updateCarInfo(@RequestBody HashMap<String,Object> map) {
		Integer updateCarInfo = service.updateCarInfo(map);
		if(updateCarInfo>0)
		{
			return "{\"result\":\"更新成功\"}";
		}
		else
		{
			return "{\"result\":\"更新失败\"}";
		}
	}
	
}
