<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <link  rel="icon" href="img/Title/water.png">
    <title>Máy lọc nước RO - Cao cấp - Trang giỏ hàng</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Free HTML Templates" name="keywords">
    <meta content="Free HTML Templates" name="description">

    <!-- Favicon -->
    <link href="img/favicon.ico" rel="icon">

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">

    <!-- Font Awesome -->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/owlcarousel/assets/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/style.css" rel="stylesheet">
    <link rel="stylesheet" href="css/product.css">
</head>

<body>
<!-- Topbar Start -->
<jsp:include page="menu.jsp"></jsp:include>
<!-- Topbar End -->

<!-- Page Header Start -->
<div class="container-fluid ">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 100px; margin-top: 80px">
        <h1 class="font-weight-semi-bold text-uppercase " style="color: #00aeef; margin-top: 100px; margin-bottom: 25px">Giỏ hàng</h1>
    </div>
</div>
<!-- Page Header End -->


<!-- Cart Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <div class="col-lg-8 table-responsive mb-5">
            <table class="table table-bordered text-center mb-0">
                <thead class="bg-secondary text-dark">
                <tr>
                    <th>Sản phẩm</th>
                    <th>Giá</th>
                    <th>Số lượng</th>
                    <th>Tổng</th>
                    <th>Xóa</th>
                </tr>
                </thead>
                <tbody class="align-middle">
                <c:set value="${sessionScope.cart}" var="c"/>
                <c:forEach items="${c.items}" var="o">
                <tr>
                    <td class="align-middle"><img src="${o.getProduct().getImage()}" alt="" style="width: 60px;
                            height:58px;margin-left: -34px;">${o.getProduct().getName()}</td>
                    <td class="align-middle">${o.getPrice()} VNĐ</td>
                    <td class="align-middle">
                        <div class="input-group quantity mx-auto" style="width: 100px;">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary btn-minus" >
                                    <a href="proccess?num=-1&id=${o.getProduct().getId()}"><i class="fa fa-minus"></i></a>
                                </button>
                            </div>
                            <input type="text" readonly class="form-control form-control-sm bg-secondary text-center" value="${o.getQuantity()}">
                            <div class="input-group-btn">
                                <button class="btn btn-sm btn-primary  btn-plus">
                                    <a href="proccess?num=1&id=${o.getProduct().getId()}"><i class="fa fa-plus"></i></a>
                                </button>
                            </div>
                        </div>
                    </td>
                    <td class="align-middle">${o.getPrice()*o.getQuantity()} VNĐ</td>
                    <td class="align-middle">
                        <%--nut xoa--%>
                        <form action="proccess" method="post">
                            <input type="hidden" name="id" value="${o.getProduct().getId()}">
                            <button class="btn btn-sm btn-primary"><i class="fa fa-times"></i></button>
                        </form>
                    </td>
                </tr>
                </c:forEach>
                </tbody>
            </table>
            <!--                -->
        </div>
        <div class="col-lg-4">
            <form class="mb-1" action="">
                <div class="input-group">
                    <input type="text" class="form-control p-4" placeholder="Mã giảm giá">
                    <div class="input-group-append">
                        <button class="btn btn-primary">Áp dụng</button>
                    </div>
                </div>
            </form>
            <div class="card border-secondary mb-5">
                <div class="card-header bg-secondary border-0">
                    <h4 class="font-weight-semi-bold m-0">Thông tin đơn hàng</h4>
                </div>
                <div class="card-body">
<%--                    <div class="d-flex justify-content-between mb-3 pt-1">--%>
<%--                        <h6 class="font-weight-medium">Tạm tính</h6>--%>
<%--                        <h6 class="font-weight-medium">6,600,00 VNĐ</h6>--%>
<%--                    </div>--%>
                    <div class="d-flex justify-content-between">
                        <h6 class="font-weight-medium">Phí giao hàng</h6>
                        <h6 class="font-weight-medium">0 VNĐ</h6>
                    </div>
                </div>
                <div class="card-footer border-secondary bg-transparent">
                    <c:set var="totalMoney" value="${sessionScope.totalMoney}"/>
                    <div class="d-flex justify-content-between mt-2">
                        <h5 class="font-weight-bold">Tổng</h5>
                        <h5 class="font-weight-bold">${totalMoney} VNĐ</h5>
                    </div>
                    <form action="checkout" method="post">
<%--                        <a href="thanh_toan.html" style="text-decoration: none"> </a>--%>
<%--                            <button type="submit" class="btn btn-block btn-primary my-3 py-3">Xác nhận mua hàng</button>--%>
                    <input type="submit" class="btn btn-block btn-primary my-3 py-3" value="Xác nhận mua hàng">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!-- Cart End -->


    <!-- Footer Start -->
    <div style="padding-left: 0;padding-right: 0%;" class="container-fluid bg-secondary text-dark mt-5 pt-5">
        <div class="row px-xl-5 pt-5">
            <div class="col-lg-4 col-md-12 mb-5 pr-3 pr-xl-5">
                <a href="" class="text-decoration-none">
                    <img width="400" src="img/Title/logo1.png" >
                </a>
                <p>Chúng tôi luôn trân trọng và mong đợi nhận được mọi ý kiến đóng góp từ khách hàng để có thể nâng cấp trải nghiệm dịch vụ và sản phẩm tốt hơn nữa.</p>
                <p class="mb-2"><i class="fa fa-map-marker-alt text-primary mr-3"></i>Thủ Đức, Linh Trung, Việt Nam</p>
                <p class="mb-2"><i class="fa fa-envelope text-primary mr-3"></i>info@st.hcmuaf.edu.vn</p>
                <p class="mb-0"><i class="fa fa-phone-alt text-primary mr-3"></i>+081 *** ****</p>
            </div>
            <div class="col-lg-8 col-md-12">
                <div class="row">
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Khám phá AQUAWATER</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.jsp"></i>Máy lọc nước Karofi</a>
                            <a class="text-dark mb-2" href="shop.html">Máy lọc nước Kangaroo </a>
                            <a class="text-dark mb-2" href="introduce.html">Máy lọc nước Hyundai </a>
                            <a class="text-dark mb-2" href="cart.jsp">Máy lọc nước Sunhouse </a>
                            <a class="text-dark mb-2" href="checkout.html">Máy Lọc Nước Kangen </a>
                            <a class="text-dark" href="contact.html">Máy lọc nước Fujie </a>

                        </div>
                        <h5 style="margin-top: 1.5rem;" class="font-weight-bold text-dark mb-4">Phụ kiện khác</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.jsp"></i>Lõi lọc nước</a>
                            <a class="text-dark mb-2" href="shop.html">Bút thử nước </a>
                            <a class="text-dark mb-2" href="introduce.html">Cốc lọc nước </a>

                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5 class="font-weight-bold text-dark mb-4">Dịch vụ khách hành </h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="#"> Chính sách đổi trả</a>
                            <a class="text-dark mb-2" href="#">Liên hệ</a>
                            <a class="text-dark mb-2" href="#">Khách hàng hài lòng</a>
                            <a class="text-dark mb-2" href="#">Chính sách giao hàng </a>
                            <a class="text-dark mb-2" href="#"></i>Hỏi đáp - FAQs</a>
                            <a class="text-dark" href="#"></i>Chính sách  khuyến mãi</a>
                        </div>
                        <h5 style="margin-top: 1.5rem;" class="font-weight-bold text-dark mb-4">Về AQUAWATER</h5>
                        <div class="d-flex flex-column justify-content-start">
                            <a class="text-dark mb-2" href="index.jsp"></i>Câu chuyền về AQUAWATER</a>
                            <a class="text-dark mb-2" href="shop.html">Nhà Máy </a>
                            <a class="text-dark mb-2" href="introduce.html">Blog </a>

                        </div>
                    </div>
                    <div class="col-md-4 mb-5">
                        <h5  class="font-weight-bold text-dark mb-4" style="text-align: center">Đăng Ký Nhận Thông Tin</h5>
                        <form action="">
                            <div class="form-group">
                                <input type="text" class="form-control border-0 py-4" placeholder="Tên của bạn" required="required" />
                            </div>
                            <div class="form-group">
                                <input type="email" class="form-control border-0 py-4" placeholder="Email của bạn"
                                       required="required" />
                            </div>
                            <div>
                                <button class="btn btn-primary btn-block border-0 py-3" style="border-radius: 10px ;height: 40px" type="submit">Đăng Ký Bây Giờ</button>
                            </div>

                        </form>
                        <div class="social-media">
                            <ul class="icon-media">
                                <li class="icon 1"><a href="#"> <img src="img/Title/facebook%20(1).png"></a></li>
                                <li class="icon 2"><a href="#"> <img src="img/Title/email.png"></a></li>
                                <li class="icon 3"><a href="#"> <img src="img/Title/twitter.png"></a></li>
                            </ul>
                        </div>

                    </div>
                </div>
            </div>
        </div>
        <div>
            <div class="  site-footer__copyright  ">
                <p>2022 © All Rights Reserved | Designed and Developed by :Phạm Nguyễn Đức Thiện, Huỳnh Anh Tài, Lê Đình Nhựt Tiến</p>
            </div>
        </div>
    </div>
    <!-- Footer End -->


    <!-- Back to Top -->
    <a href="#" class="btn btn-primary back-to-top"><i class="fa fa-angle-double-up"></i></a>


    <!-- JavaScript Libraries -->
    <script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.bundle.min.js"></script>
    <script src="lib/easing/easing.min.js"></script>
    <script src="lib/owlcarousel/owl.carousel.min.js"></script>

    <!-- Contact Javascript File -->
    <script src="mail/jqBootstrapValidation.min.js"></script>
    <script src="mail/contact.js"></script>

    <!-- Template Javascript -->
    <script src="js/main.js"></script>
<!--PupUpSmart-->
<script type="text/javascript" src="https://popupsmart.com/freechat.js"></script><script> window.start.init({ title: "Xin Chào", message:
        "Chúng tôi có thể giúp gì cho bạn ? Xin để lại lại câu hỏi.", color: "#1C86FA", position: "left", placeholder: "Viết tin nhắn của bạn", withText: "Viết bằng", viaWhatsapp:
        "hoặc liên hệ chúng tôi qua", gty: "đế của bạn", awu: "và viết cho chúng tôi", connect: "Kết nối ngay bây giờ", button: "Viết cho chúng tôi", device: "everywhere",
    logo: "https://d2r80wdbkwti6l.cloudfront.net/pTmhkmIzK9pqU36Pv1Zl93h2oBNK9DFU.jpg", services:
        [{"name":"whatsapp","content":null}]})</script>

</body>

</html>
