package com.yedam.app.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration		    //설정		
@EnableWebSecurity		//보안설정
public class SpringSecurityConfig {
	
	//암호화방식등록 무조건해야함 시큐리티 5버전이상
	//1. 암호화 복호화에 사용하는 bean등록
	@Bean
	PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	//2. 시큐리티의 인증 및 인가
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		//시큐리티가 체크하는 경로 및 각 경로별 권한
		http
				.authorizeHttpRequests()
					.antMatchers("/", "/all")												//경로(여러개의 경로에 적용가능) **없이 /들어간건 주소가 딱/ 까지인것에대해서만 권한적용
						.permitAll()															//모두에게 허가
					.antMatchers("/admin/**")											//경로
						.hasRole("ADMIN")												//(=ROLE_ADMIN)을 간단하게 표현 지정자만 권한 허가
					.antMatchers("/user/**")											//경로
//						.hasAuthority("ROLE_USER")									//권한으로 들어오는 이름 전부 맞게 적용돼야함
						.hasAnyAuthority("ROLE_USER", "ROLE_ADMIN")			//이중에 하나라도 권한을 들고있으면 접근 허용
					.anyRequest().authenticated()									//등록한 경로와 권한을 지정한 곳 외에는 인증만 되면 접근 다 허용하게 처리
					.and()
					.formLogin().defaultSuccessUrl("/all")							//로그인폼쓰겠다는뜻
					.and()
					.logout().logoutSuccessUrl("/all");
		
		http.csrf().disable();					//개발시 csrf있으면 통신이 한번에 원할하지 않아서 작업하는 중간에는 disable처리해두고 나중에 지우기~~
		
		return http.build();
	}

	//3. 테스트용 ) 메모리 인증 방식
//	@Bean
//	InMemoryUserDetailsManager inMemoryUserDetailsService() {
//		UserDetails user = User.builder()
//										.username("user1")
//										.password(passwordEncoder().encode("1234"))
//										//.authorities("ROLE_USER")
//										.roles("USER")   //ROLE_USER
//										.build();
//		
//		UserDetails admin = User.builder()
//										.username("admin1")
//										.password(passwordEncoder().encode("1234"))
//										//.authorities("ROLE_USER")
//										.authorities("ROLE_ADMIN")   //ROLE_USER
//										.build();
//		return new InMemoryUserDetailsManager(user,admin);
//	}
	

	

	
	

	
	

	
	

	
	
	
}
