package com.ds.home.Focus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.DispatcherServletAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;

import static javax.servlet.ServletRegistration.Dynamic;

@ComponentScan
@EnableAutoConfiguration
@SpringBootApplication()
public class FocusApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(FocusApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(FocusApplication.class);
	}

	@Override
	public void onStartup(ServletContext container) throws ServletException {
		AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
		context.setConfigLocation(FocusApplication.class.getName());

		Dynamic registration = container.addServlet("dispatcher", new DispatcherServlet(context));
		registration.setLoadOnStartup(1);
		registration.addMapping("/*");
		super.onStartup(container);
	}
}