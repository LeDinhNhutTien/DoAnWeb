<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Topbar Start -->
<div class="header-container" style="margin: auto">
    <div class="container-fluid container-header ">
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="" class="text-decoration-none">
                    <img width="250" src="img/Title/logo1.png" alt="">
                </a>
            </div>
            <div class="col-lg-6 col-6 text-left">
                <form action="search"  method="post">
                    <div class="input-group">
                        <input value="${txtS}" name="txt" type="text" class="form-control" placeholder="Bạn tìm gì...">
                        <div class="input-group-append">
                            <button type="submit" class="input-group-text bg-transparent text-primary">
                                <i class="fa fa-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
            <div class="col-lg-3 col-6 text-right">
                <c:set var="size" value="${sessionScope.size}"/>
                <a href="cart.jsp" class="btn gio_hang">
                    <i class="fas blue fa-shopping-cart text-primary"></i>
                    <span class="badge">Giỏ hàng ${size}</span>
                </a>
                <div class="btn user-toggle" onclick="menuToggle()" style="margin-right: -15px">
                    <c:if test="${sessionScope.acc == null}">
                        <a href="taikhoan.html" class="btn user" style="margin-right: -15px">
                            <i class="fas blue fa-solid fa-user text-primary"></i>
                            <span class="badge">Tài khoản</span>
                        </a>
                    </c:if>
                    <c:if test="${sessionScope.acc != null}">
                        <a href="taikhoan.html" class="btn user" style="margin-right: -15px">
                            <i class="fas blue fa-solid fa-user text-primary"></i>
                            <span class="badge">Xin chào ${sessionScope.acc.username}</span>
                        </a>
                    </c:if>
                    <!--                        <i class="fas blue fa-solid fa-user text-primary"></i>-->
                    <!--                        <span class="badge" >Tài khoản</span>-->
                    <!--                        <div class="action-1">-->
                    <!--                            <div class="menu-1">-->
                    <!--                                    <img src="img/product/avt.jpg">-->
                    <!--                                <h3>Tài Tiến Thiện</h3>-->
                    <!--                                <ul style="padding: 0">-->
                    <!--                                    <li><i class="fas fa-user"></i><a href="#">Hồ sơ của tôi</a></li>-->
                    <!--                                    <li><i class="fas fa-edit"></i><a href="#">Chỉnh sửa hồ sơ</a></li>-->
                    <!--                                    <li><i class="fas fa-envelope"></i><a href="#">Liên hệ</a></li>-->
                    <!--                                    <li><i class="fas fa-cog"></i><a href="#">Cài đặt</a></li>-->
                    <!--                                    <li><i class="fas fa-hands-helping"></i><a href="#">Hỗ trợ</a></li>-->
                    <!--                                    <li><i class="fas fa-sign-out-alt"></i><a href="#">Đăng xuất</a></li>-->
                    <!--                                </ul>-->
                    <!--                            </div>-->
                    <!--                        </div>-->
                </div>
            </div>
        </div>
    </div>
    <!-- Topbar 2   -->
    <div class="container-fluid container-header2 pt-0">
        <div class="row align-items-center py-3 px-xl-5"style="justify-content: space-between;">
            <nav class="navbar navbar-expand-lg bg-light navbar-light py-3 py-lg-0 px-0">
                <div class="collapse navbar-collapse justify-content-between" id="navbarCollapse">
                    <div class="navbar-nav mr-auto py-0 ">
                        <a href="home" class="nav-item nav-link active">Trang chủ</a>
                        <div class="nav-item dropdown">
                            <a href="shop.html" class="nav-link" data-toggle="dropdown">Sản phẩm</a>
<%--                            <a href="shop.html" class="nav-link dropdown-toggle" data-toggle="dropdown">Sản phẩm</a>--%>
<%--                            <div class="dropdown-menu rounded-0 m-0">--%>
<%--                                <c:forEach items="${listC}" var="o">--%>
<%--                                    <a href="listProducts" class="dropdown-item">${o.cname}</a>--%>
<%--                                </c:forEach>--%>
<%--                            </div>--%>
                        </div>
                        <a href="introduce.html" class="nav-item nav-link">Giới thiệu</a>
                        <a href="contact.html" class="nav-item nav-link">Liên hệ</a>
                    </div>
                </div>
            </nav>

            <div class="col-lg-3 col-6 ml-5 text-right " style="display: flex;padding: 0 15px;justify-content: flex-end ;gap: 50px">
                <a href="sign_up.jsp" class="btn border border-back">
                    Đăng ký
                </a>
                <c:if test="${sessionScope.acc != null}">
                    <a href="logout" class="btn border border-back float-left">
                        Đăng xuất
                    </a>
                </c:if>
                <c:if test="${sessionScope.acc == null}">
                    <a href="login.jsp" class="btn border border-back">
                        Đăng nhập
                    </a>
                </c:if>
            </div>
        </div>
    </div>
</div>
<!-- Topbar End -->
