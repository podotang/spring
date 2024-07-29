package com.yujin.app;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URI;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;

@RestController
@RequestMapping("/samplerest")
@Log4j2
@RequiredArgsConstructor
public class SampleRestController {
	
	@GetMapping(value = "/apitest", produces = MediaType.APPLICATION_XML_VALUE)
	public String callapihttp() throws Exception {
        StringBuilder urlBuilder = new StringBuilder("https://apis.data.go.kr/B554287/LocalGovernmentWelfareInformations/LcgvWelfarelist"); /*URL*/
        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=" + "odp3R%2BAnv93%2BqG0hMhsxznQIF589DFV7I%2BJbKgPbJu2h86CikqZnQN0weoWc9r1FZqDwWOL3YsDVzXFd%2BvX7%2Bw%3D%3D"); /*Service Key*/
        urlBuilder.append("&" + URLEncoder.encode("pageNo","UTF-8") + "=" + URLEncoder.encode("1", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("numOfRows","UTF-8") + "=" + URLEncoder.encode("1285", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("lifeArray","UTF-8") + "=" + URLEncoder.encode("006", "UTF-8"));
        urlBuilder.append("&" + URLEncoder.encode("arrgOrd","UTF-8") + "=" + URLEncoder.encode("001", "UTF-8"));
        
        URI uri = new URI(urlBuilder.toString());
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
