<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Đăng nhập</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
    <!--===============================================================================================-->
<!--    <link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">-->
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="fonts/Linearicons-Free-v1.0.0/icon-font.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
    <!--===============================================================================================-->
    <link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
    <!--===============================================================================================-->
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="css/login-util.css">
    <link rel="stylesheet" type="text/css" href="css/login-main.css">
    <link rel="stylesheet" href="css/style.css">
    <!--===============================================================================================-->
</head>
<body>

<div class="limiter">
    <div class="container-fluid container-header ">
        <div class="row align-items-center py-3 px-xl-5">
            <div class="col-lg-3 d-none d-lg-block">
                <a href="index.jsp" class="text-decoration-none">
                    <img width="250" src="img/Title/logo1.png"  alt="">
                </a>
            </div>
        </div>
    </div>

    <div class="container-login100">

        <div class=" wrap-login100 p-l-110 p-r-110 p-t-10 p-b-33" >

            <form class=" form-login login100-form validate-form flex-sb flex-w" action="login" method="post">
                <span class="login100-form-title p-b-33">
						Đăng Nhập Với
					</span>

                <a href="" class="btn-face m-b-15 text-decoration-none">
                    <i class="fa fa-facebook-official"></i>
                    Facebook
                </a>

                <a href="#" class="btn-google m-b-15 text-decoration-none">
                    <img src="img/icon-google.png" alt="GOOGLE">
                    Google
                </a>
                <p class="text-danger" style="font-size: 20px;">${error}</p>
                <div class="p-t-31 p-b-9">
						<span class="txt1">
							Tên tài khoản
						</span>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Username is required">
                    <input  class="input100" type="text" name="username">
                    <span class="focus-input100"></span>
                </div>

                <div class="p-t-13 p-b-9">
						<span class="txt1">
							Mật khẩu
						</span>

                    <a href="quenMk.html" class="txt2 bo1 m-l-5 text-decoration-none">
                        Quên mật khẩu?
                    </a>
                </div>
                <div class="wrap-input100 validate-input" data-validate="Password is required">
                    <input class="input100" type="password" name="pass">
                    <span class="focus-input100"></span>
                </div>

                <div class="container-login100-form-btn m-t-17">
                    <button class="login100-form-btn">
                        Đăng nhập
                    </button>
                </div>

                <div class="w-full text-center p-t-15">
						<span class="txt2">
							Không phải là thành viên?
						</span>

                    <a href="sign_up.jsp" class="txt2 bo1 text-decoration-none">
                        Đăng ký
                    </a>
                </div>
            </form>

        </div>
    </div>
    </div>

<div id="dropDownSelect1"></div>

<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/login.js"></script>
</div>
    </body>
</html>