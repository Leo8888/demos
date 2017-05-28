package com.leo.main;

import com.leo.weather.ArrayOfString;
import com.leo.weather.GetSupportDataSetResponse.GetSupportDataSetResult;
import com.leo.weather.WeatherWebService;
import com.leo.weather.WeatherWebServiceSoap;

public class TestWeather {

	public static void main(String[] args) throws Exception {
		WeatherWebService weatherWebService = new WeatherWebService();
		WeatherWebServiceSoap  soap = weatherWebService.getWeatherWebServiceSoap();

		System.out.println("--------supportCity--------");
		ArrayOfString supportCity = soap.getSupportCity("ºþÄÏ");
		for(String str : supportCity.getString()) {
			System.out.println("supportCity: " + str);
		}
		
		System.out.println("--------supportDataSet--------");
		GetSupportDataSetResult dataSet = soap.getSupportDataSet();
		System.out.println("dataSet: " + dataSet);
		
		System.out.println("--------supportProvince--------");
		ArrayOfString supportProvince = soap.getSupportProvince();
		for(String str : supportProvince.getString()) {
			System.out.println("supportProvince: " + str);
		}
		
		System.out.println("--------weatherInfo--------");
		ArrayOfString weatherInfo = soap.getWeatherbyCityName("ÉÏº£");
		for(String str : weatherInfo.getString()) {
			System.out.println("weatherInfo: " + str);
		}
		
		System.out.println("--------provinces&citys--------");
		ArrayOfString supportProvinces =  soap.getSupportProvince();
		for(String province : supportProvinces.getString()) {
			System.out.println("--------" + province + "--------");
			ArrayOfString supportCitys = soap.getSupportCity(province);
			for(String city : supportCitys.getString()) {
				System.out.print(city + " ");
			}
			System.out.println("");
		}
	}
	
}
