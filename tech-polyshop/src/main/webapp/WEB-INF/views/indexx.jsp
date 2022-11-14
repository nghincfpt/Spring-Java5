<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Send mail</title>
</head>
<body>
	<form class="formMailer" action="/mailer/send" method="post">
		<h2>Gữi email</h2>
		<div class="form-group">
			<label for="formControlInput"> Gữi đến</label> <input type="email"
				class="form-control" id="formControlInput" name="txtTo"
				placeholder="Nhập tiêu đề....">
		</div>

		<div class="form-group">
			<label for="formControlInput2"> Tiêu đề</label> <input type="text"
				class="form-control" id="formControlInput2" name="txtSubject"
				placeholder="Nhập tiêu đề....">
		</div>

		<div class="form-group">
			<label for="formControlTextarea"> nội dung</label>
			<textarea class="form-control" id="formControlTextarea"
				name="txtContent" rows="4" placeholder="Nhập tiêu đề...."></textarea>
		</div>
		<button class="btn btn-success btnSend">Gửi</button>
	</form>
</body>
</html>