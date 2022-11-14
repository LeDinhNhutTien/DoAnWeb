<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Đăng ký tài khoản</title>
    <link href='https://fonts.googleapis.com/css?family=Nunito:400,300' rel='stylesheet' type='text/css'>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">

    <link rel="stylesheet" href="css/sign_up.css">
    <link rel="stylesheet" href="css/style.css">

</head>
<body>
<div class="container-fluid container-header ">
    <div class="row align-items-center py-3 px-xl-5">
        <div class="col-lg-3 d-none d-lg-block">
            <a href="index.jsp" class="text-decoration-none">
                <img width="250" src="img/Title/logo1.png"  alt="">
            </a>
        </div>
    </div>
</div>

<form action="signUp" class="mt-3" method="post">
    <h1>Đăng ký tài khoản</h1>
    <p class="text-danger">${mess}</p>
    <fieldset>

        <label for="name">Tên:</label>
        <input type="text" id="name" name="user_name">

        <label for="password">Mật khẩu:</label>
        <input type="password" id="password" name="user_password">

        <label for="password">Nhập lại mật khẩu:</label>
        <input type="password" id="password1" name="rePassword">

    </fieldset>
    <button type="submit">Đăng ký</button>
</form>
</div>
</body>
</html>