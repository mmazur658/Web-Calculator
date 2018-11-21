package pl.mazurmarcin.webcalculator;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.jdbcAuthentication().dataSource(dataSource);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {

		http.authorizeRequests().antMatchers("/").permitAll().and().authorizeRequests()
				.antMatchers("/administrator-panel/**").hasRole("ADMIN").and().authorizeRequests()
				.antMatchers("/admin-action/**").hasRole("ADMIN").and().formLogin().loginPage("/login-form")
				.loginProcessingUrl("/authenticateTheUser").permitAll().and().logout();

		// .and().exceptionHandling().accessDeniedPage("/access-denied");
	}
}