<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="utf-8">
    <link  rel="icon" href="img/Title/water.png">
    <title>Máy lọc nước RO - Cao cấp, Chính hãng, Đảm bảo an toàn</title>
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
    <div class="container-fluid bg-secondary mb-5">
    <div class="d-flex flex-column align-items-center justify-content-center" style="min-height: 250px;margin-top: 111px">
        <h1 class="font-weight-semi-bold text-uppercase mb-3" style="font-size: 24px;">Sản phẩm</h1>
        <div class="d-inline-flex">
            <p class="m-0"><a href="index.jsp" style="font-size: 15px">Trang chủ</a></p>
            <p class="m-0 px-2">-</p>
            <p class="m-0"><a href="shop" style="font-size: 15px">Sản phẩm</a></p>
        </div>
    </div>
</div>
<!-- Page Header End -->

<!-- Shop Start -->
<div class="container-fluid pt-5">
    <div class="row px-xl-5">
        <!-- Shop Sidebar Start -->
        <div class="col-lg-3 col-md-12">
            <div class="shop-categories">
                <div class="shop-list" style="box-shadow: rgba(149, 157, 165, 0.2) 0px 8px 24px;">
                        <div class="shop-item" style="margin-left: 20px">
                             <c:forEach items="${listC}" var="o">
                                <img src="${o.image}">
                                  <a href="category?cid=${o.cid}"><span class="shop-categories_karofi">${o.cname}</span></a>
                             </c:forEach>
                        </div>
                </div>
            </div>
        </div>
        <!-- Shop Sidebar End -->


        <!-- Shop Product Start -->
        <div class="col-lg-9 col-md-12">
            <div class="row pb-3">
                <div class="col-12 pb-1">
                    <div class="d-flex align-items-center justify-content-between mb-4">
                        <form action="search"  method="post">
                            <div class="input-group">
                                <input value="${txtS}" name="txt" type="text" class="form-control" placeholder="Tìm kiếm theo tên">
                                <div class="input-group-append">
                                        <button class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </button>
                                </div>
                            </div>
                        </form>
                        <div class="dropdown ml-4">
                            <button class="btn border dropdown-toggle" type="button" id="triggerId" data-toggle="dropdown" aria-haspopup="true"
                                    aria-expanded="false">
                                Lọc theo
                            </button>
                            <div class="dropdown-menu dropdown-menu-right" aria-labelledby="triggerId">
                                <a class="dropdown-item" href="#">Sản phẩm mới</a>
                                <a class="dropdown-item" href="#">Phổ biến</a>
                                <a class="dropdown-item" href="#">Đánh giá tốt nhất</a>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- load sp -->
                <form name="f" action="" method="post">
                  <div class="shop-overview">
                    <ul class="products">
<%--                        so luong mon hang moi lan them vao gio hang--%>
                      <input type="hidden" name="num" value="1"/>
                        <c:forEach items="${listPage}" var="o">
                            <li style="width: 31.5%; height: 100%;margin: 30px 0">
                                <div class="product-item">
                                    <div class="product-image" style="position: relative">
                                        <a href="" class="product-image-maskup">
                                            <img src="${o.image}">
                                        </a>
                                    </div>
                                    <div class="item-icons">
                                        <ul style="list-style: none; padding-left: 0; border-right: 1px solid #555">
                                            <li class="icon-wifi" style="padding: 0 5px">
                                                <i class="fas fa-wifi text-primary" style="color: #6c757d;font-size: 10px"></i>
                                                <p style="padding-right: 10px; margin-bottom: 0; color: #6c757d;font-size: 10px">AloTec</p>
                                            </li>
                                        </ul >
                                        <ul style="list-style: none; padding-left: 5px;">
                                            <li class="icon-droplet">
                                                <i class="fas fa-water text-primary" style="color: #6c757d;font-size: 10px"></i>
                                                <p style="margin-bottom: 0;color: #6c757d; font-size: 10px">Tinh Khuyết</p>
                                            </li>
                                        </ul>
                                    </div>
                                    <div class="product-title">${o.name}</div>
                                    <div class="product-deal">
                                        <div class="product-buy"><a href="#" onclick="buy(${o.id})">Mua ngay</a></div>
<%--                                        <div class="product-buy">--%>
<%--                                            <input type="submit" onclick="buy('${o.id}')" value="Mua ngay"/>--%>
<%--                                        </div>--%>
                                        <div class="product-price">${o.price} VNĐ</div>
                                    </div>
                                    <div class="product-detail">
                                        <a href="detail?pid=${o.id}" class="product-cat">Xem chi tiết</a>
                                    </div>
                                </div>
                            </li>
                        </c:forEach>

                     </ul>
                  </div>
                </form>
                <div class="col-12 pb-1">
                    <nav aria-label="Page navigation">
                        <ul class="pagination justify-content-center mb-3">
<%--                             Phần phân trang --%>
                            <c:if test="${tag >1}">
                            <li class="page-item">
                                <a class="page-link" href="listProducts?index=${tag-1}" aria-label="Previous">
                                    <span aria-hidden="true">&laquo;</span>
                                    <span class="sr-only">Previous</span>
                                </a>
                            </li>
                            </c:if>

                            <c:forEach begin="1" end="${endP}" var="i">
                          <li class="page-item ${tag == i?"active":""}"><a class="page-link" href="listProducts?index=${i}">${i}</a></li>
                            </c:forEach>
                            <c:if test="${tag <endP}">
                            <li class="page-item">
                                <a class="page-link" href="listProducts?index=${tag+1}" aria-label="Next">
                                    <span aria-hidden="true">&raquo;</span>
                                    <span class="sr-only">Next</span>
                                </a>
                            </li>
                            </c:if>
                        </ul>
                    </nav>
                </div>
            </div>
        </div>
        <!-- Shop Product End -->
    </div>
</div>
<!-- Shop End -->
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
        <div class="  site-footer__copyright  " style="padding-top: 15px">
            <p>2022 © All Rights Reserved | Designed and Developed by :Phạm Nguyễn Đức Thiện, Huỳnh Anh Tài, Lê Đình Nhựt Tiến</p>
        </div>
    </div>
</div>
<!-- Footer End -->


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
//
<script type="text/javascript">
    function buy(id){
        document.f.action="buy?id="+id;
        document.f.submit();
    }
</script>
</body>
</html>
