package com.dnt.cloud.demo.service;

import java.util.List;

import com.dnt.cloud.demo.domain.NrcReportDomain;

public interface MerchantReportService {
	
	/***
	 * 查询出每个时刻所对应的商品的RFID数量
	 * @param time
	 * @return
	 */
	public List<NrcReportDomain> queryRfidBySpuIdBytime(String time);
	
	
	/***
	 * 查询出每个时刻所对应的商品的RFID数量
	 * @param time
	 * @return
	 */
	public List<NrcReportDomain> queryRfidClickBySpuIdBytime(String time);
	
	/**
	 * 查询出rfid和click的总数
	 * @param time
	 * @return
	 */
	public List<NrcReportDomain> queryRfidClickCount(String time);
}
