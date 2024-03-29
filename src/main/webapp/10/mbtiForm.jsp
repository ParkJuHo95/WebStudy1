<%@ page contentType="text/html; charset=UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>MBTI</title>
</head>
<body data-context-path="<%=request.getContextPath() %>">
    <form action="<%=request.getContextPath()%>/10/mbti" onchange="this.requestSubmit();">
        <select name="type">
            
        </select>
    </form>
    <script type="text/javascript" src="<%=request.getContextPath() %>/resources/js/app/10/mbtiForm.js"></script>
</body>
</html>