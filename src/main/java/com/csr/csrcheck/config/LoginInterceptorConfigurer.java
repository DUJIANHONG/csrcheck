package com.csr.csrcheck.config;


import com.csr.csrcheck.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;


@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {

	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		HandlerInterceptor interceptor=new LoginInterceptor();
		List<String>paths=new ArrayList<String>();
		paths.add("/js/**");
		paths.add("/css/**");
		paths.add("/images/**");
		paths.add("/img/**");
		paths.add("/newsFile/**");//上传的图片
		paths.add("/fonts/**");
		paths.add("/bootstrap3/**");
		paths.add("/districts/**");
		paths.add("/web/login.html");//登录
		paths.add("/users/login");//登录
		paths.add("/users/img");
		paths.add("/users/img");
		paths.add("/company/companylist");//查询企业
		paths.add("/company/companylist2");//根据企业名称查询
		paths.add("/news/newlist");//查询新闻
		paths.add("/news/byidnews/{id}");//根据id查询新闻
		paths.add("/flight_check/flight_checkllist");//查企业中的飞行检查
		paths.add("/clinic/cliniclist");//查企业中的临床：
		paths.add("/approvals/approvalslist");//查企业中的批文
		paths.add("/evaluate/evaluatelist");//查企业中的一致评价
		paths.add("/flight_check/flight_checkllist2");//差化妆品中的飞行检查
		paths.add("/military/militarylist");//查医疗器械中的国产器械
		paths.add("/military/militarylist2");//查医疗器械中的出口器械
		paths.add("/flight_check/flight_checkllist3");//差医疗器械中的飞行检查
		paths.add("/actual_controller/actual_controllerlist");//核心人员关联企业
		paths.add("/contend/contendlist");//查询药企核心竞争力动态信息
		paths.add("/organ/organlist");//前十大投资机构
		paths.add("/organ/organlist2");//基本信息
		paths.add("/lawsuit/lawsuitlist");//法律诉讼
		paths.add("/business_risks/business_riskslist");//经营风险
		paths.add("/Instrument_bulletin/Instrument_bulletinlist");//医疗器械重要通报
		paths.add("/Instrument_bulletin/Abnormal_productslist");//医疗器械不合格通报
		paths.add("/guide/guidelist");//行业指导药企CSR指南
		paths.add("/research/researchlist");//药企商务信用研究
		paths.add("/industry/industrylist");//专业行业
		paths.add("/exponent/exponentlist");//指数发布
		paths.add("/other/otherlist");//其他
		paths.add("/speech/speechlist");//社会责任报告撰写咨询
		paths.add("/enabled/enabledlist");//药企产业链生态圈赋能


		registry.addInterceptor(interceptor).addPathPatterns("/**").excludePathPatterns(paths);
	}
	
}
