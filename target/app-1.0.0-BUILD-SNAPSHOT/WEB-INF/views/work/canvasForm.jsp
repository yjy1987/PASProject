<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<div class="col-md-10" id="content">
	<div class="literally watermark"></div>
</div>
	<script>
  $(document).ready(function() {
    var watermarkImage = new Image();
    watermarkImage.src = '/resources/img/logo.png';
    LC.init(document.getElementsByClassName('literally watermark')[0],
    		{ watermarkImage: watermarkImage, watermarkScale: 0.5  // you can scale it
      });
  });
</script>
</body>
</html>