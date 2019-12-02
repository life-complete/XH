package com.sybercare.hospital;

import org.hibernate.SessionFactory;
import org.hibernate.jpa.HibernateEntityManagerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Import;
import org.springframework.scheduling.annotation.EnableScheduling;

import com.sybercare.hospital.common.ds.DynamicDataSourceRegister;

@EnableScheduling
@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
public class HospitalAdapterApplication extends SpringBootServletInitializer {

	protected static final Logger LOGGER = LoggerFactory.getLogger(HospitalAdapterApplication.class);

	@Bean
	public SessionFactory sessionFactory(HibernateEntityManagerFactory hemf) {
		return hemf.getSessionFactory();
	}

	public static void main(String[] args) {
		SpringApplication.run(HospitalAdapterApplication.class, args);
	}
}
