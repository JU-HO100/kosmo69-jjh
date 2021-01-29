<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
  <script src="//code.jquery.com/jquery-1.11.0.min.js"></script>
  
    <script type="text/javascript">
    
        $(function() {
            $("#upload_file").on('change', function(){
                
                readURL(this);
            });
        });
        function readURL(input) {
            if (input.files && input.files[0]) {
            var reader = new FileReader();
 
            reader.onload = function (e) {
                    $('#blah').attr('src', e.target.result);
                }
              reader.readAsDataURL(input.files[0]);
            }
        }
    </script>
</head>
<body>
<input type='file' id="upload_file" name="upload_file" />
<img id="blah" src="/YouSoSick/image/ready.png" alt="이미지 없음" width="300" height="300" />
</body>
</html>