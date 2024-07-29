package com.yujin.app.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

import com.yujin.app.mapper.WelfareMapper;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;

public class SampleService {
	@Autowired
    private WelfareMapper mapper;

    public void fetchAndSaveServId() throws Exception {
        String response = callapihttp();

        // XML 파싱
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = factory.newDocumentBuilder();
        Document doc = builder.parse(new InputSource(new StringReader(response)));

        NodeList nodeList = doc.getElementsByTagName("servId");
        for (int i = 0; i < nodeList.getLength(); i++) {
            String servId = nodeList.item(i).getTextContent();

            // servId DB 저장
            DetailInfoVO vo = new DetailInfoVO();
            vo.setServId(servId);
            mapper.insertServId(vo);
        }
    }

    public void fetchAndUpdateDetailInfo() throws Exception {
        List<DetailInfoVO> servIdList = mapper.getAllServId();

        for (DetailInfoVO info : servIdList) {
            String servId = info.getServId();
            String response = getDetailedInfo(servId);

            // XML 파싱
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(new InputSource(new StringReader(response)));

            // 필요한 필드 추출
            String servNm = doc.getElementsByTagName("servNm").item(0).getTextContent();
            String enfcBgngYmd = doc.getElementsByTagName("enfcBgngYmd").item(0).getTextContent();
            String enfcEndYmd = doc.getElementsByTagName("enfcEndYmd").item(0).getTextContent();
            String bizChrDeptNm = doc.getElementsByTagName("bizChrDeptNm").item(0).getTextContent();
            String ctpvNm = doc.getElementsByTagName("ctpvNm").item(0).getTextContent();
            String sggNm = doc.getElementsByTagName("sggNm").item(0).getTextContent();
            String servDgst = doc.getElementsByTagName("servDgst").item(0).getTextContent();
            String trgterIndvdlNmArray = doc.getElementsByTagName("trgterIndvdlNmArray").item(0).getTextContent();
            String intrsThemaNmArray = doc.getElementsByTagName("intrsThemaNmArray").item(0).getTextContent();
            String sprtCycNm = doc.getElementsByTagName("sprtCycNm").item(0).getTextContent();
            String srvPvsnNm = doc.getElementsByTagName("srvPvsnNm").item(0).getTextContent();
            String aplyMtdNm = doc.getElementsByTagName("aplyMtdNm").item(0).getTextContent();
            String sprtTrgtCn = doc.getElementsByTagName("sprtTrgtCn").item(0).getTextContent();
            String slctCritCn = doc.getElementsByTagName("slctCritCn").item(0).getTextContent();
            String alwServCn = doc.getElementsByTagName("alwServCn").item(0).getTextContent();
            String aplyMtdCn = doc.getElementsByTagName("aplyMtdCn").item(0).getTextContent();
            String inqNum = doc.getElementsByTagName("inqNum").item(0).getTextContent();
            String lastModYmd = doc.getElementsByTagName("lastModYmd").item(0).getTextContent();

            // 상세 정보 DB 업데이트
            DetailInfoVO detailInfo = new DetailInfoVO();
            detailInfo.setServId(servId);
            detailInfo.setServNm(servNm);
            detailInfo.setEnfcBgngYmd(enfcBgngYmd);
            detailInfo.setEnfcEndYmd(enfcEndYmd);
            detailInfo.setBizChrDeptNm(bizChrDeptNm);
            detailInfo.setCtpvNm(ctpvNm);
            detailInfo.setSggNm(sggNm);
            detailInfo.setServDgst(servDgst);
            detailInfo.setTrgterIndvdlNmArray(trgterIndvdlNmArray);
            detailInfo.setIntrsThemaNmArray(intrsThemaNmArray);
            detailInfo.setSprtCycNm(sprtCycNm);
            detailInfo.setSrvPvsnNm(srvPvsnNm);
            detailInfo.setAplyMtdNm(aplyMtdNm);
            detailInfo.setSprtTrgtCn(sprtTrgtCn);
            detailInfo.setSlctCritCn(slctCritCn);
            detailInfo.setAlwServCn(alwServCn);
            detailInfo.setAplyMtdCn(aplyMtdCn);
            detailInfo.setInqNum(inqNum);
            detailInfo.setLastModYmd(lastModYmd);

            mapper.updateDetailInfo(detailInfo);
        }
    }

    private String getDetailedInfo(String servId) throws Exception {
        String key = "your_api_key";  // 실제 API 키로 변경 필요
        String urlStr = "https://apis.data.go.kr/B554287/LocalGovernmentWelfareInformations/LcgvWelfaredetailed?serviceKey=" + URLEncoder.encode(key, "UTF-8") + "&servId=" + URLEncoder.encode(servId, "UTF-8");
        URI uri = new URI(urlStr);
        URL url = uri.toURL();

        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml");

        BufferedReader rd;
        if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
        return sb.toString();
    }

    private String callapihttp() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/6410000/busrouteservice/getBusRouteInfoItem"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + "odp3R%2BAnv93%2BqG0hMhsxznQIF589DFV7I%2BJbKgPbJu2h86CikqZnQN0weoWc9r1FZqDwWOL3YsDVzXFd%2BvX7%2Bw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1285", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("lifeArray","UTF-8") + "=" + URLEncoder.encode("006", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("arrgOrd","UTF-8") + "=" + URLEncoder.encode("001", "UTF-8"));
        
        URI uri = new URI(urlBuilder.toString()); // StringBuilder의 문자열을 URI로 변환
        URL url = uri.toURL();
        
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-type", "application/xml");
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
        return sb.toString();
    }
}
