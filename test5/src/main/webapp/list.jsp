<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script type="text/javascript">
	function page(idx) {
		var pagenum = idx;
		var contentnum = $("#contentnum option:selected").val();
		location.href="${pageContext.request.contextPath}/list.do?pagenum="+pagenum+"&contentnum="+contentnum;
	}
</script>
</head>
<body>
	<select name="contentnum" id="contentnum">
		<option value="10">10</option>
		<option value="20">20</option>
		<option value="30">30</option>
	</select>
	<table>
		<thead>
			<tr>
				<th>번호</th>
				<th>제목</th>
				<th>작성자</th>
				<th>등록일</th>
				<th>조회수</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="k" items="${list}">
			<tr>
				<th>${k.seq}</th>
				<th>${k.title}</th>
				<th>${k.writer}</th>
				<th>${k.regDate}</th>
				<th>${k.cnt}</th>
			</tr>
			</c:forEach>
		</tbody>
		<tfoot>
			<td colspan="2">
				<c:if test="${page.prev}">
					<a style="text-decoration: none;" href="javascript:page(${page.getStartPage()-1});">&laquo;</a>
				</c:if>
				<c:forEach begin="${page.getStartPage()}" end="${page.getEndPage()}" var=idx>
					<a style="text-decoration: none;" href="javascript:page(${idx});">${idx}</a>
				</c:forEach>
				<c:if test="${page.prev}">
					<a style="text-decoration: none;" href="javascript:page(${page.getEndPage()-1});">&raquo;</a>
				</c:if>
			</td>
		</tfoot>
	</table>
</body>
</html>