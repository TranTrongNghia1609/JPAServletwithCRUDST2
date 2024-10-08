<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="fmt" uri="jakarta.tags.fmt"%>
<%@taglib prefix="c" uri="jakarta.tags.core"%>
<%@taglib prefix="fn" uri="jakarta.tags.functions"%>





<!-- BEGIN CONTENT -->
<div class="col-md-9 col-sm-9">
	<h1>Create an account</h1>
	<div class="content-form-page">
	  <div class="row">
		<div class="col-md-7 col-sm-7">
		<c:if test="${alert !=null}">
	<h3 class="alert alert danger">${alert}</h3>
</c:if>
		  <form action="${pageContext.request.contextPath }/register" method="post" class="form-horizontal" role="form">
			<fieldset>
			  <legend>Your personal details</legend>
			  <div class="form-group">
				<label for="username" class="col-lg-4 control-label">Username <span class="require">*</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="username" name = "username">
				</div>
			  </div>
			  <div class="form-group">
				<label for="fullname" class="col-lg-4 control-label">Full Name <span class="require">*</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="fullname" name = "fullname">
				</div>
			  </div>
			  <div class="form-group">
				<label for="email" class="col-lg-4 control-label">Email <span class="require">*</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="email" name = "email">
				</div>
				<div class="form-group">
					<label for="phone" class="col-lg-4 control-label">Phone <span class="require">*</span></label>
					<div class="col-lg-8">
					  <input type="text" class="form-control" id="phone" name = "phone">
					</div>
			  </div>
			</fieldset>
			<fieldset>
			  <legend>Your password</legend>
			  <div class="form-group">
				<label for="password" class="col-lg-4 control-label">Password <span class="require">*</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="password" name = "password">
				</div>
			  </div>
			  <div class="form-group">
				<label for="repassword" class="col-lg-4 control-label">Repassword <span class="require">*</span></label>
				<div class="col-lg-8">
				  <input type="text" class="form-control" id="repassword" name = "repassword">
				</div>
			  </div>
			</fieldset>
			<fieldset>
			  <legend>Newsletter</legend>
			  <div class="checkbox form-group">
				<label>
				  <div class="col-lg-4 col-sm-4">Singup for Newsletter</div>
				  <div class="col-lg-8 col-sm-8">
					<input type="checkbox">
				  </div>
				</label>
			  </div>
			</fieldset>
			<div class="row">
			  <div class="col-lg-8 col-md-offset-4 padding-left-0 padding-top-20">                        
				<button type="submit" class="btn btn-primary">Create an account</button>
				<button type="button" class="btn btn-default">Cancel</button>
			  </div>
			</div>
		  </form>
		</div>
		<div class="col-md-4 col-sm-4 pull-right">
		  <div class="form-info">
			<h2><em>Important</em> Information</h2>
			<p>Lorem ipsum dolor ut sit ame dolore  adipiscing elit, sed sit nonumy nibh sed euismod ut laoreet dolore magna aliquarm erat sit volutpat. Nostrud exerci tation ullamcorper suscipit lobortis nisl aliquip  commodo quat.</p>

			<p>Duis autem vel eum iriure at dolor vulputate velit esse vel molestie at dolore.</p>

			<button type="button" class="btn btn-default">More details</button>
		  </div>
		</div>
	  </div>
	</div>
  </div>
  <!-- END CONTENT -->






<%-- </head>
<body>
	<form action="register" method="post">
		<h2>Tạo tài khoản mới</h2>
		<c:if test="${alert !=null}">
			<h3 class="alert alert danger">${alert}</h3>
		</c:if>
		<div class="container">
			<label for="username"><input type="text"
				placeholder="Username" name="username" required></label> <label
				for="fullname"> <input type="text" placeholder="Full Name"
				name="fullname" required></label> <label for="email"> <input
				type="text" placeholder="Email" name="email" required></label> <label
				for="phone"> <input type="text" placeholder="Phone"
				name="phone" required></label> <label for="password"> <input
				type="password" placeholder="Password" name="password" required></label>
			<label for="repassword"> <input type="password"
				placeholder="Repeat Password" name="repassword" required></label>
			<button type="submit">Register</button>
			<a href="/Helloworld/login">Login</a>
		</div>
	</form>
</body>
</html> --%>