package com.dnt.cloud.demo.query;

import java.io.Serializable;

/**
 * 商户查询
 * 
 * @author hazyhao
 *
 */
public class MerchantReportQuery implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1210192350379512618L;

	/**
	 * 商户Id
	 */
	private Long merchantId;
	/**
	 * 区域Id
	 */
	private Long regionId;
	/**
	 * 门店Id
	 */
	private Long storeId;
	/**
	 * 设备Id
	 */
	private Long deviceId;

	private String beginDateStr;

	private String endDateStr;
	/**
	 * 查询标记
	 */
	private String queryTimeFlag;

	public Long getMerchantId() {
		return merchantId;
	}

	public void setMerchantId(Long merchantId) {
		this.merchantId = merchantId;
	}

	public Long getStoreId() {
		return storeId;
	}

	public void setStoreId(Long storeId) {
		this.storeId = storeId;
	}

	public Long getDeviceId() {
		return deviceId;
	}

	public void setDeviceId(Long deviceId) {
		this.deviceId = deviceId;
	}

	public String getBeginDateStr() {
		return beginDateStr;
	}

	public void setBeginDateStr(String beginDateStr) {
		this.beginDateStr = beginDateStr;
	}

	public String getEndDateStr() {
		return endDateStr;
	}

	public void setEndDateStr(String endDateStr) {
		this.endDateStr = endDateStr;
	}

	public String getQueryTimeFlag() {
		return queryTimeFlag;
	}

	public void setQueryTimeFlag(String queryTimeFlag) {
		this.queryTimeFlag = queryTimeFlag;
	}

	public Long getRegionId() {
		return regionId;
	}

	public void setRegionId(Long regionId) {
		this.regionId = regionId;
	}

}
