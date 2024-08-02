package com.yedam.app.security.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor			//기본생성자 사용안함
@Getter
public class LoginUserVO implements UserDetails{
	
	
	private UserVO uvo;
	
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {		//GrantedAuthority 인터페이스를 를 상속받은 것만 제네릭타입사용가능
		List<GrantedAuthority> auths = new ArrayList<>();		//롤네임 리스트로 여러개의 권한 가져옴
		auths.add(new SimpleGrantedAuthority(uvo.getRoleName()));
		return auths;		
	}

	@Override
	public String getPassword() {
		return uvo.getPassword();
	}

	@Override
	public String getUsername() {
		return uvo.getLoginId();
	}
	
	
	//계정정보
	@Override
	public boolean isAccountNonExpired() {	//계정 만료여부
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {	//계정 잠금여부
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {		//계정 패스워드만료여부
		return true;
	}

	@Override
	public boolean isEnabled() {		//계정 
		return true;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
