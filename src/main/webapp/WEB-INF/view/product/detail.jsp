<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
    <%@ include file="../layout/header.jsp" %>

        <h1>상품 상세 페이지</h1>
        <hr>

        <table border="1">
            <tr>
                <th>번호</th>
                <th>상품명</th>
                <th>가격</th>
                <th>재고</th>
                <th>등록일</th>
            </tr>

            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.qty}</td>
                <td>${product.createdAt}</td>
            </tr>
        </table>

        <c:choose>
            <c:when test="${principle != null}">
                <form action="/product/${product.id}/buy" method="post">
                    <input type="number" name="qty" min="0" max="${product.qty}">
                    <button type="submit">구매</button>
                </form>
            </c:when>

            <c:otherwise>
                <h3><a href="/loginForm"> 로그인 필요</a></h3>
            </c:otherwise>
        </c:choose>


        <%@ include file="../layout/footer.jsp" %>