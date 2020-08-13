package com.project2.board.configuration;


import com.project2.board.authenticate.AuthenticationFilter;
import com.project2.board.authenticate.SimpleAuthenticationFailureHandler;
import com.project2.board.authenticate.SimpleAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests()
				//접근 제어를 하지 않을 경로 입력
				.antMatchers("/error","/resources/**","/sign-in","/login","/logout").permitAll()
				.antMatchers("/board/**").access("hasRole('ROLE_USER')")
				.anyRequest().authenticated()//설정되지 않은 모든url을 인가된 사용자만이 이용할 수 있도록함.
				.and()//연결
				//로그인
				//필터적용해서 유효성검사하기.
				.addFilterAt(authenticationFilter(), UsernamePasswordAuthenticationFilter.class)
				.formLogin()
				.loginPage("/login")
				.defaultSuccessUrl("/main")
				.loginProcessingUrl("/login")//post 방식으로 인증을 요청하는 경로
				//로그인성공 시 이동url
				.failureUrl("/login?error")//로그인실패시 에러보여주기
				.usernameParameter("user_id")//체크할 값 요소.
				.passwordParameter("password").and()
				.logout()
				.invalidateHttpSession(true)
				.clearAuthentication(true)
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?logout")
				.and()
				.csrf().disable();


	}


	@Override
	public void configure(WebSecurity web) {
		web.ignoring().antMatchers("/static/**", "/js/**", "/css/**", "/images/**", "/favicon.ico");
	}

	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public AuthenticationFilter authenticationFilter() throws Exception {
		AuthenticationFilter authenticationFilter = new AuthenticationFilter();
		authenticationFilter.setAuthenticationSuccessHandler(authenticationSuccessHandler());
		authenticationFilter.setAuthenticationFailureHandler(authenticationFailureHandler());
		authenticationFilter.setAuthenticationManager(authenticationManagerBean());
		return authenticationFilter;
	}

	@Bean
	public AuthenticationSuccessHandler authenticationSuccessHandler() {
		return new SimpleAuthenticationSuccessHandler();
	}

	@Bean
	public AuthenticationFailureHandler authenticationFailureHandler() {
		return new SimpleAuthenticationFailureHandler();
	}



}
