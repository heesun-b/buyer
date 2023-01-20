<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

    <%@ include file="../layout/header.jsp" %>

        <h1>상품 목록 페이지</h1>
        <hr />
        <table border="1">
            <tr>
                <th>번호</th>
                <th>고객명</th>
                <th>상품명</th>
                <th>구매개수</th>
                <th></th>
            </tr>
            <c:forEach items="${purchaseList}" var="purchase">
                <tr>
                    <td>${purchase.id}</td>
                    <td>${purchase.username}</td>
                    <td>${purchase.name}</td>
                    <td>${purchase.count}</td>
                    <td>
                        <form action="/purchase/${purchase.id}/delete" method="post">
                            <button type="submit">구매취소</button>
                        </form>
                    </td>
                </tr>
            </c:forEach>

        </table>


        <%@ include file="../layout/footer.jsp" %>