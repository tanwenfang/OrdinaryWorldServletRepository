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
		// ��Ӧ������ʽ����
		response.setCharacterEncoding("UTF-8");
		response.setContentType("application/json");
		response.setStatus(HttpServletResponse.SC_OK);
		
		// ����Ǵ�JSPҳ�淢��������������������ķ�ʽ��ȡ�ġ�
//		String parameter = request.getParameter("xxx");
		
		// �����������ַ�ʽ�Ȼ�ȡ���������json��ʽ�ַ���
		BufferedReader reader = new BufferedReader(new InputStreamReader(request.getInputStream(), "utf-8"));
		String body = IOUtils.read(reader); // ��ȡ���������json��ʽ�ַ���
		
		// Ȼ��json�ַ���תΪJava��������ֻ�Բ�����һ����ӡ����������Ҫ�����ѿ���������������������
		CharacterInfo characterInfo = JSON.parseObject(body, new TypeReference<CharacterInfo>() {});
		System.out.println(characterInfo.toString());
		
		// �켸�����ݷ���
		List<CharacterInfo> list = new ArrayList<CharacterInfo>(); 
		CharacterInfo characterInfo1 = new CharacterInfo("����ƽ", "��", "ú����", "������ú��");
		CharacterInfo characterInfo2 = new CharacterInfo("���ٰ�", "��", "ũ����ҵ��", "˫ˮ��");
		CharacterInfo characterInfo3 = new CharacterInfo("����ϼ", "Ů", "����", "��ԭʡ��");
		CharacterInfo characterInfo4 = new CharacterInfo("����Ҷ", "Ů", "��ʦ", "ѧУ");
		list.add(characterInfo1);
		list.add(characterInfo2);
		list.add(characterInfo3);
		list.add(characterInfo4);
		
		response.getWriter().println(list);
	}
}
