package com.yujin.app.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import kr.co.shineware.nlp.komoran.constant.DEFAULT_MODEL;
import kr.co.shineware.nlp.komoran.core.Komoran;
import kr.co.shineware.nlp.komoran.model.KomoranResult;
import kr.co.shineware.nlp.komoran.model.Token;

@Service
public class KomoranService {
	
	public List<String> analyzeText(String document) {
	    Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
	    String[] words = document.split(" ");
	    List<String> result = new ArrayList<>();

	    for (String word : words) {
	        KomoranResult analyzeResultList = komoran.analyze(word);
	        List<Token> tokenList = analyzeResultList.getTokenList();
	        
	        for (Token token : tokenList) {
	            String pos = token.getPos();
	            if (pos.equals("NNG") || pos.equals("NNP")) {
	                result.add(token.getMorph());
	            }
	        }
	    }
	    return result;
	}
	
	
	
	
	
	
	
//	
//	public void action() {
//		Komoran komoran = new Komoran(DEFAULT_MODEL.FULL);
//		String document = "반면에 한국어는 조사가 너무 많이 있고, 신조어도 많이 나오고 규칙이 명확하지 않기 때문에 외국에서 만든 기술로 한국어를 적용시킬 수 없다는 문제가 있습니다. ";
//		
////		KomoranResult analyzeResultList = komoran.analyze(document);
////		System.out.println(analyzeResultList.getPlainText());
////		List<Token> tokenList = analyzeResultList.getTokenList();
////		for (Token token : tokenList) {
////			System.out.format("(%2d, %2d)%s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(),
////					token.getPos());
////		}
//		
//	    String[] words = document.split(" ");
//	    
//	    for (String word : words) {
//	        KomoranResult analyzeResultList = komoran.analyze(word);
//	        List<Token> tokenList = analyzeResultList.getTokenList();
//	        
//	        for (Token token : tokenList) {
//	        	String pos = token.getPos();
//	            if (pos.equals("NNG") || pos.equals("NNP")) {
////	            System.out.format("(%d, %d) %s/%s\n", token.getBeginIndex(), token.getEndIndex(), token.getMorph(), token.getPos());
//	                System.out.println(token.getMorph());
//
//	            }
//	        }
//	    }
//
//	} 

}
