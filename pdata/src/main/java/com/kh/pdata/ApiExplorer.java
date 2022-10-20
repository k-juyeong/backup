package com.kh.pdata;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class ApiExplorer {
    private static final String serviceKey = "rhk5cG0d9JWJHbsoRhidTsOXH07KEZLqmODo8sxtTBKrugnclxzDhRS6tCDPBN1gcU6pWoJJBbs4FISRreIscQ%3D%3D";
    public static void main(String[] args) throws IOException {

        StringBuilder urlBuilder = new StringBuilder("http://www.kspo.or.kr/openapi/service/sportsNewFacilInfoService/getNewFacilInfoList"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + serviceKey); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /*페이지번호*/
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("10", "UTF-8")); /*한 페이지 결과 수*/
        urlBuilder.append("&" + URLEncoder.encode("faciNm","UTF-8") + "=" + URLEncoder.encode("요가", "UTF-8")); /*체육시설명*/
        urlBuilder.append("&" + URLEncoder.encode("fcobNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*업종명*/
        urlBuilder.append("&" + URLEncoder.encode("ftypeNm","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시설유형명*/
        urlBuilder.append("&" + URLEncoder.encode("faciRoadAddr1","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*시설유형명*/
        urlBuilder.append("&" + URLEncoder.encode("faciAddr1","UTF-8") + "=" + URLEncoder.encode("", "UTF-8")); /*지번주소*/
        URL url = new URL(urlBuilder.toString());
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");
        System.out.println("Response code: " + conn.getResponseCode());
        BufferedReader rd;
        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
            rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        } else {
            rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
        }
        StringBuilder sb = new StringBuilder();
        String line;
        while ((line = rd.readLine()) != null) {
            sb.append(line);
        }
        rd.close();
        conn.disconnect();
        System.out.println(sb.toString());

        String xmlStr = sb.toString();
//        //xml to json
        XmlMapper xmlMapper = new XmlMapper();
        JsonNode node = xmlMapper.readTree(xmlStr);
        ObjectMapper jsonMapper = new ObjectMapper();
        String json = jsonMapper.writeValueAsString(node);
        System.out.println(json);

        //xml to java Object
        Response res = xmlMapper.readValue(xmlStr,Response.class);
//        System.out.println(res);
        for (Response.Body.Item item : res.getBody().getItems()){
            if (!item.getFaciStat().equals("폐업")){
             System.out.println("시설명:"+item.getFaciNm()+"\n"+"전화번호:"+item.getFmngUserTel()+"\n"+"영업:"+item.getFaciStat()+"\n");
            }
//             System.out.println("시설명:"+item.getFaciNm()+"\n"+"전화번호:"+item.getFmngUserTel()+"\n"+"영업:"+item.getFaciStat()+"\n");
        }

        //json to java Object
        Response2 res2 = jsonMapper.readValue(json,Response2.class);
        System.out.println(res2);
        for (Response2.Body.Items.Item item : res2.getBody().getItems().getItem()) {
            System.out.println("시설명:"+item.getFaciNm());
        }

    }
}
