<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%> 
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>ToDoList</title>
    <link rel="stylesheet" type="text/css" href="/css/main.css" />
  </head>
  <body>
	<div class="content-box">
	  <div class="right-align">
	    총 ${scheduleList.size()}건의 계획이 검색되었습니다.
	  </div>

	  <div class="table">
	    <div class="table-header">
	      <div>번호</div>
	      <div>완료?</div>
	      <div>TODO Subject</div>
	      <div>기한</div>
	      <div>완료</div>
	      <div>삭제</div>
	    </div>

	    <c:choose>
	    <c:when test="${not empty scheduleList}">
	      <c:forEach items="${scheduleList}" var="board">
	        <div class="row">
	          <div>${board.id}</div>
	          <div>
	            <c:choose>
	              <c:when test="${board.isdone == 'Y'}">DONE</c:when>
	              <c:otherwise>-</c:otherwise>
	            </c:choose>
	          </div>
	          <div>${board.subject}</div>
	          <div>${board.deadLine}</div>
	          <div>
	            <c:choose>
	              <c:when test="${board.isdone == 'N'}">
	                <a href="/schedule/chagestate/${board.id}">완료</a>
	              </c:when>
	              <c:otherwise>-</c:otherwise>
	            </c:choose>
	          </div>
	          <div><a href="/schedule/delete/${board.id}">삭제</a></div>
	        </div>
	      </c:forEach>
	      </c:when>
	      <c:otherwise>
	        <div class="table-row">
	          <div colspan="6">일정이 비어있습니다.</div>
	        </div>
	      </c:otherwise>
	      </c:choose>
	  </div>

	  <div class="right-align">
	    <a href="/schedule/write">새 아이템 추가</a>
	  </div>
	</div>
  </body>
</html>