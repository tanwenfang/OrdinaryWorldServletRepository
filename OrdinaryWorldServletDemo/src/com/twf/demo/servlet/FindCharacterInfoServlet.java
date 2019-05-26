package com.twf.demo.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.dubbo.common.utils.IOUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.twf.demo.po.CharacterInfo;

@WebServlet("/FindCharacterInfoServlet")
public class FindCharacterInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 响应参数格式设置
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		
		// 如果是从JSP页面发起的请求，则参数是以下面的方式获取的。
//		String parameter = request.getParameter("xxx");
		
		// 现在是以这种方式先获取请求参数得json格式字符串
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String body = IOUtils.read(reader); // 获取请求参数的json格式字符串
		
		// 然后将json字符串转为Java对象，这里只对参数做一个打印操作，有需要的朋友可以自行做其做其他操作
		CharacterInfo characterInfo = JSON.parseObject(body, new TypeReference<CharacterInfo>() {});
		System.out.println(characterInfo.toString());
		
		// 造几条数据返回
		List<CharacterInfo> list = new ArrayList<CharacterInfo>(); 
		CharacterInfo characterInfo1 = new CharacterInfo("孙少平", "男", "煤矿工人", "大牙湾煤矿");
		CharacterInfo characterInfo2 = new CharacterInfo("孙少安", "男", "农民企业家", "双水村");
		CharacterInfo characterInfo3 = new CharacterInfo("田晓霞", "女", "记者", "黄原省城");
		CharacterInfo characterInfo4 = new CharacterInfo("田润叶", "女", "教师", "学校");
		list.add(characterInfo1);
		list.add(characterInfo2);
		list.add(characterInfo3);
		list.add(characterInfo4);
		
		response.getWriter().println(list);
	}
}
