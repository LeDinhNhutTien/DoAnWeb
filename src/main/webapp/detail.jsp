<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <link rel="icon" href="img/Title/water.png">
  <title>Máy lọc nước RO - Cao cấp, Chính hãng, Đảm bảo an toàn</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="Free HTML Templates" name="keywords">
  <meta content="Free HTML Templates" name="description">

  <!-- Favicon -->
  <link href="img/favicon.ico" rel="icon">

  <!-- Google Web Fonts -->
  <link rel="preconnect" href="https://fonts.gstatic.com">
  <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
        rel="stylesheet">

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
    <h1 class="font-weight-semi-bold text-uppercase mb-3" style="font-size: 24px;"> Chi tiết Sản phẩm </h1>
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
            <form action="">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="Tìm kiếm theo tên">
                <div class="input-group-append">
                                        <span class="input-group-text bg-transparent text-primary">
                                            <i class="fa fa-search"></i>
                                        </span>
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
        <!--               bắt đầu chi tiết sản phẩm-->
        <div class="product_hyundai-detail">
          <div class="product-detail">
            <img src="${detail.image}">
            <div class="product-info">
              <div class="product-title"> ${detail.name}  </div>
              <div class="product-price">Giá: ${detail.price} VNĐ</div>
          <!--    <div class="product-brand"> Hãng: HYUNDAI - MODEL: KAD-I55</div> -->
              <div class="product-content">
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>${detail.description}</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>Tiết kiệm điện năng 40% với công nghệ bảo vệ nhiệt đa lớp</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>Công nghệ làm lạnh Block siêu nhanh</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>3 lõi lọc thô Smax Pro 1,2,3</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>Màng lọc SMAX RO Purifilm chuẩn Mỹ</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>Hệ 6 lõi Smax hiệu suất cao ngăn ngừa rò rỉ tối đa, thay thế dễ dàng</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>Tủ kính IQ tràn viền sang trọng, mạnh mẽ</p>
                </div>
                <div class="product-item" style="display:flex;">
                  <i class="fas fa-check-circle text-primary"></i>
                  <p>Giá đã bao gồm VAT</p>
                </div>

              </div>
            </div>
          </div>
          <div class="product-choose" style="display: flex">
            <div class="product-deal">
              <i class="fas fa-cart-plus text-primary"></i>
              <a href="cart.html"style="text-decoration: none;"><div class="product-cart">Thêm vào giỏ hàng</div></a>
            </div>
            <div class="product-buy"><a href="buynow.html">Mua ngay</a></div>
          </div>


          <div class="comment-box" style="margin-bottom: 50px; margin-top: 20px">
            <h4>Ý KIẾN KHÁCH HÀNG</h4>
            <div class="reviews" style="margin-bottom: 20px">
              <h6>Đánh giá của bạn</h6>
              <select class="rating">
                <option >Xếp hạng...</option>
                <option >Rất tốt</option>
                <option >Tốt</option>
                <option >Trung bình</option>
                <option >Không tệ</option>
                <option >Tệ</option>
              </select>
            </div>
            <div class="comment">
              <h4>Bình luận</h4>
              <form action="#">
                <input type="text" name="full-name" placeholder="Tên của bạn...">
                <input type="email" name="email" placeholder="Địa chỉ email...">
                <textarea name="comment" placeholder="Nhận xét của bạn..."></textarea>
                <div>
                <button type="submit" style="margin-bottom: 50px">Gửi đi</button></div>
              </form>
            </div>
            <div class="post-comment" style="display:flex;">
              <div class="image">
                <img style="width: 56px; height: 56px;" src="img/product/avt.jpg">
              </div>
              <div class="input-comment" onclick="commentToggel()" style="margin-left: 10px">
                <textarea type="text" name="full-name" placeholder="Thêm nhận xét của bạn..." ></textarea>
                <div class="post">
                  <button value="submit">Post</button>
                </div>
              </div>
            </div>
          </div>
        </div>
        <!--                kết thúc chi tiết sản phẩm-->
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
            <a class="text-dark mb-2" href="cart.html">Máy lọc nước Sunhouse </a>
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
              <input type="text" class="form-control border-0 py-4" placeholder="Your Name" required="required" />
            </div>
            <div class="form-group">
              <input type="email" class="form-control border-0 py-4" placeholder="Your Email"
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