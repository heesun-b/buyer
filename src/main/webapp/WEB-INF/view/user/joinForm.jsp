<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <h1>회원 가입</h1>
        <hr>
        <form action="/join" method="post">
            <input type="text" name="username" placeholder="Enter username" required><br>
            <input type="password" name="password" placeholder="Enter password" required><br>
            <input type="email" name="email" placeholder="Enter email" required><br>
            <button type="submit">회원가입</button>
        </form>

        <%@ include file="../layout/footer.jsp" %>