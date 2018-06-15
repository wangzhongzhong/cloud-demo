package com.dnt.cloud.demo.service.impl;


import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.dnt.cloud.demo.dao.MerchantReportDAO;
import com.dnt.cloud.demo.domain.NrcReportDomain;
import com.dnt.cloud.demo.model.NrcReport;
import com.dnt.cloud.demo.service.MerchantReportService;

@Service("merchantReportService")
public class MerchantReportServiceImpl implements MerchantReportService {

	@Resource
	private MerchantReportDAO merchantReportDAO;
	
	

	private NrcReportDomain conver2Domain(NrcReport source) {
		if (source == null) {
			return null;
		}

		NrcReportDomain target = new NrcReportDomain();
		BeanUtils.copyProperties(source, target);
		return target;
	}

	@Override
	public List<NrcReportDomain> queryRfidBySpuIdBytime(String time) {
		
		List<NrcReport> reports = merchantReportDAO.queryRfidBySpuIdBytime(time);
		List<NrcReportDomain> reportDomains = new ArrayList<NrcReportDomain>();
		if(reports != null){
			reports.forEach(data -> {
				reportDomains.add(this.conver2Domain(data));
			});
		}
		return reportDomains;
	}

	@Override
	public List<NrcReportDomain> queryRfidClickBySpuIdBytime(String time) {
		List<NrcReport> reports = merchantReportDAO.queryRfidClickBytime(time);
		List<NrcReportDomain> reportDomains = new ArrayList<NrcReportDomain>();
		if(reports != null){
			reports.forEach(data -> {
				reportDomains.add(this.conver2Domain(data));
			});
		}
		return reportDomains;
	}

	@Override
	public List<NrcReportDomain> queryRfidClickCount(String time) {
		List<NrcReportDomain> result = new ArrayList<NrcReportDomain>();
		List<NrcReport> list = merchantReportDAO.queryRfidClickCount(time);
		if(list != null){
			list.forEach(data ->{
				result.add(this.conver2Domain(data));
			});
		}
		return result;
	}


}
