package com.dnt.cloud.demo.test;

import org.junit.Test;

import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.ItemsOnsaleGetRequest;
import com.taobao.api.response.ItemsOnsaleGetResponse;

public class TestTianMao {

	@Test
	public void test(){
		TaobaoClient client = 
				new DefaultTaobaoClient("http://gw.api.taobao.com/router/rest", 
						"24905638", "118542725ee4eff54931d61b20d2d15e");
		ItemsOnsaleGetRequest req = new ItemsOnsaleGetRequest();
		req.setFields("19.6");
		try {
			ItemsOnsaleGetResponse response = client.execute(req ,
					"6102728d9f92168724209f0e573aa3801b551d9ce8a08e03955370139");
		} catch (ApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
