package com.dnt.cloud.demo.dao;


import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.dnt.cloud.demo.model.NrcReport;

@Mapper
public interface MerchantReportDAO {
	
	/****
	 * 按照时间来进行查询出对应的数据
	 * @param time
	 * @return
	 */
	public List<NrcReport> queryRfidBySpuIdBytime(String time);
	
	/****
	 * 按照时间来进行查询出对应的数据
	 * @param time
	 * @return
	 */
	public List<NrcReport> queryRfidClickBytime(String time);
	
	/**
	 * 查询出rfid和click的所有总数
	 * @param time
	 * @return
	 */
	public List<NrcReport> queryRfidClickCount(String time);
	
}