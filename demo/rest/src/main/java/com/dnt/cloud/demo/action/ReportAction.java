/**
 * 
 */
package com.dnt.cloud.demo.action;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.dnt.cloud.demo.domain.NrcReportDomain;
import com.dnt.cloud.demo.service.MerchantReportService;
import com.dnt.cloud.demo.web.common.BaseAction;
import com.dnt.cloud.demo.web.util.DateUtil;

/**
 * @author wzz
 *
 */
@Controller
public class ReportAction extends BaseAction {
	
	@Resource
	private MerchantReportService merchantReportService;
	
	private final String INDEX_LIST = "/index";
	
	private final String RFID_PAGE = "/report/rfidPage";
	
	
	@RequestMapping(value = "/report/getIndexPage",method = RequestMethod.GET)
	public ModelAndView getIndexPage(){
		return new ModelAndView(INDEX_LIST);
	}
	
	@RequestMapping(value = "/report/viewGetRfidByTime",method = RequestMethod.GET)
	public ModelAndView viewRfidByTimeCount(){
		return new ModelAndView(RFID_PAGE);
	}
	
	/****
	 * RFID的查询数量
	 * @param time
	 * @return
	 */
	@RequestMapping(value = "/report/getRfidByTime",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Integer>> getRfidBytimeCount(){
		Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
		//把日期进行格式化一下
		String time = DateUtil.getWebDateString(new Date());
		//还需要创建一个hashSet用来保存我们的商品名称
		Set<String> set = new HashSet<String>();
		//总的数据
		List<NrcReportDomain> domains = merchantReportService.queryRfidBySpuIdBytime(time);
		//循环总的数据,存放我们的商品的数据
		for (NrcReportDomain domain : domains) {
			set.add(domain.getSpuName());
		}
		
		//然后循环我们的set
		for (String str : set) {
			//创建时间
			List<Integer> date = new ArrayList<Integer>();
			for (int i = 0 ;i <= 13 ; i++) {
				date.add(0);
			}
			//在接着遍历我们的数据库中取出来的数据
			for (NrcReportDomain domain : domains) {
				if(domain.getSpuName().equals(str)){
					int lef = Integer.parseInt(domain.getStatisticsHour());
					if(lef >= 9 && lef <= 22){
						date.set(lef-9, domain.getFlowData());
					}
				}
			}
			
			//然后在把这个商品+数量存放在我们的map中
			result.put(str, date);
		}
		
		return result;
	}
	
	/*****
	 * RFID设备的点击数
	 * @param time
	 * @return
	 */
	@RequestMapping(value = "/report/getRfidClickByTime",method = RequestMethod.GET)
	@ResponseBody
	public Map<String, List<Integer>> getRfidClickBytimeCount(String time){
		Map<String, List<Integer>> result = new HashMap<String, List<Integer>>();
		if(time == null){
			//把日期进行格式化一下
			time = DateUtil.getWebDateString(new Date());
		}
		//还需要创建一个hashSet用来保存我们的商品名称
		Set<String> set = new HashSet<String>();
		//总的数据
		List<NrcReportDomain> domains = merchantReportService.queryRfidClickBySpuIdBytime(time);
		//循环总的数据,存放我们的商品的数据
		for (NrcReportDomain domain : domains) {
			set.add(domain.getDeviceName());
		}
		
		//然后循环我们的set
		for (String str : set) {
			//创建时间
			List<Integer> date = new ArrayList<Integer>();
			for (int i = 0 ;i <= 13 ; i++) {
				date.add(0);
			}
			//在接着遍历我们的数据库中取出来的数据
			for (NrcReportDomain domain : domains) {
				if(domain.getDeviceName().equals(str)){
					int lef = Integer.parseInt(domain.getStatisticsHour());
					if(lef >= 9 && lef <= 22){
						date.set(lef-9, domain.getFlowData());
					}
				}
			}
			
			//然后在把这个商品+数量存放在我们的map中
			result.put(str, date);
		}
		
		return result;
	}
	
	/***
	 * 客流的数据对接经过量和关注量，显示到界面上,按照设备的分组数据
	 * @param time
	 * @return
	 */
	@RequestMapping(value = "/report/queryPassFocusTime",method = RequestMethod.GET)
	@ResponseBody
	public String queryPassFocusTimeByTime(String time){
		if(time == null){
			time = DateUtil.getWebDateString(new Date());
		}
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("http://www.scanall-nrc.com/cloud-behavior/nrcReportController/queryPassFocusTime?time="+time);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK){
				InputStream inputStream = conn.getInputStream();
				//获取响应
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String line = null; 
                while ((line = reader.readLine()) != null){  
                    sb.append(line);
                }  
                reader.close();  
                //关闭连接  
                conn.disconnect();  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}
	
	
	/**
	 * 客流的数据对接，显示到界面上,查询出总的数据
	 * @param time
	 * @return
	 */
	@RequestMapping(value = "/report/queryPassFocusCount",method = RequestMethod.GET)
	@ResponseBody
	public String queryPassFocusByTime(String time){
		if(time == null){
			time = DateUtil.getWebDateString(new Date());
		}
		//取出RFID和CLICK的数据
		List<NrcReportDomain> list = merchantReportService.queryRfidClickCount(time);
		int rfid = 0;
		int click = 0;
		if( list != null ){
			for (NrcReportDomain domain : list) {
				if(domain.getVisitType().equals("RFID")){
					rfid = domain.getFlowData();
				}else{
					click = domain.getFlowData();
				}
			}
		}
		StringBuffer sb = new StringBuffer();
		try {
			URL url = new URL("http://www.scanall-nrc.com/cloud-behavior/nrcReportController/queryPassFocusCount?time="+time);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			conn.connect();
			int responseCode = conn.getResponseCode();
			if(responseCode == HttpURLConnection.HTTP_OK){
				InputStream inputStream = conn.getInputStream();
				//获取响应
				BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
				String line = null; 
                while ((line = reader.readLine()) != null){  
                    sb.append(line);
                }
                reader.close();  
                //关闭连接  
                conn.disconnect();  
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		String result = "";
		String[] str = sb.toString().split(",");
		if(str.length > 1){
			result = str[0] + ",\"RFID\":"+rfid+",\"CLICK\":"+click+","+str[1];
		}else{
			result = "{\"RFID\":"+rfid+",\"CLICK\":"+click+",\"PASS\":0,\"FOCUS\":0}";
		}
		return result;
	}
	
}
