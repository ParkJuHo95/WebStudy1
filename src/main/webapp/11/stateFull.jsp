<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>11/stateFull.jsp</title>
</head>
<body>
<h4>HTTP (ConnectLess, StateLess) 보완하고, 상태를 유지하기(StateFull) 위한 저장 구조</h4>
<pre>
	1. session : 상태 유지를 위한 정보가 서버측에 저장되는 개념.
		세션(HttpSession)
			database - connectFull --> connection == session
			http -> connectLess --> 시간의 의미로 세션을 표현함.
		세션의 생명주기	
			생성 : 한클라이언트가 사용하고 있는 하나의 에이전트(브라우저)에 대해 최초의 요청이 발생했을때 세션이 생성됨.
				  각 세션은 식별자로 세션 아이디를 발급받음.	
				  세션 아이디 : <%=session.getId() %>
				  세션 생성시점 : <%=new Date(session.getCreationTime()) %>
			유지 방법 : 서버와 클라이언트가 동일한 세션 아이디를 공유하는 상황.(tracking mode)
				세션 timeout : <%=session.getMaxInactiveInterval() %>s
					<%
						session.setMaxInactiveInterval(4*60);
					%>
				세션 timeout : <%=session.getMaxInactiveInterval() %>s
				마지막 요청 시점 : <%=new Date(session.getLastAccessedTime()) %>
				1) COOKIE(***) : request/response 헤더를 통해 세션 아이디 공유
				2) URL : request line 을 통해 세션 아이디 공유(보안 취약함)
					<a href="stateFull.jsp;jsessionid=<%=session.getId()%>">세션 파라미터를 통한 세션 유지</a>
				3) SSL : Secure Socket Layer(https) 를 통해 암호화 전송 구조를 이용한 공유.
			소멸 : 만료 시간(timeout)이내에 새로운 요청이 발생하지 않는 경우.
				1) 브라우저 종료
				2) 쿠키 삭제
				3) 직접 로그아웃(session invalidate)
				<%
// 					session.invalidate();
				%>
	2. cookie : 상태 유지를 위한 정보가 클라이언트측에 저장되는 개념.
</pre>
</body>
</html>












