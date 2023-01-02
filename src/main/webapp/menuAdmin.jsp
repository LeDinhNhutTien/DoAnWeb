<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<aside class="app-sidebar">
    <div class="app-sidebar__user"><img class="app-sidebar__user-avatar" src="img/Title/admin.png" width="50px"
                                        alt="User Image">
        <div>
            <p class="app-sidebar__user-name"><b>Quản Lý</b></p>
            <c:if test="${sessionScope.acc !=null}">
                <p class="app-sidebar__user-designation">Xin chào ${sessionScope.acc.username}</p>
            </c:if>
        </div>
    </div>
    <hr>
    <ul class="app-menu">
<%--        <li><a class="app-menu__item haha" href="phan-mem-ban-hang.html"><i class='app-menu__icon bx bx-cart-alt'></i>--%>
<%--            <span class="app-menu__label">POS Bán Hàng</span></a></li>--%>
        <li><a class="app-menu__item " href="admin"><i class='app-menu__icon bx bx-tachometer'></i><span
                class="app-menu__label">Bảng điều khiển</span></a></li>
        <li><a class="app-menu__item " href="listUser"><i class='app-menu__icon bx bx-id-card'></i> <span
                class="app-menu__label">Quản lý người dùng</span></a></li>
        <li><a class="app-menu__item" href="listCustomer"><i class='app-menu__icon bx bx-user-voice'></i><span
                class="app-menu__label">Quản lý khách hàng</span></a></li>
        <li><a class="app-menu__item" href="table-data-product.html"><i class='app-menu__icon bx bx-purchase-tag-alt'>
        </i><span class="app-menu__label">Quản lý sản phẩm</span></a></li>
        <li><a class="app-menu__item" href="listOder"><i class='app-menu__icon bx bx-task'></i><span
                class="app-menu__label">Quản lý đơn hàng</span></a></li>
<%--        <li><a class="app-menu__item" href="table-data-banned.html"><i class='app-menu__icon bx bx-run'></i><span--%>
<%--                class="app-menu__label">Quản lý nội bộ--%>
<%--          </span></a></li>--%>
<%--        <li><a class="app-menu__item" href="table-data-money.html"><i class='app-menu__icon bx bx-dollar'></i><span--%>
<%--                class="app-menu__label">Bảng kê lương</span></a></li>--%>
<%--        <li><a class="app-menu__item active" href="quan-ly-bao-cao.jsp"><i--%>
<%--                class='app-menu__icon bx bx-pie-chart-alt-2'></i><span class="app-menu__label">Báo cáo doanh thu</span></a>--%>
<%--        </li>--%>
<%--        <li><a class="app-menu__item" href="page-calendar.html"><i class='app-menu__icon bx bx-calendar-check'></i><span--%>
<%--                class="app-menu__label">Lịch công tác </span></a></li>--%>
<%--        <li><a class="app-menu__item" href="#"><i class='app-menu__icon bx bx-cog'></i><span class="app-menu__label">Cài--%>
<%--            đặt hệ thống</span></a></li>--%>
    </ul>
</aside>
