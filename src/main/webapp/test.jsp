<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
div {
  margin: 20px;
}
</style>
</head>
<body>
<h1>Convert file input to Blob</h1>
<div>
  <label for="load-file">Load a file:</label>
  <input type="file" id="load-file">
</div>
<div>
  <label for="file-type">File type: </label>
  <input type="text" id="file-type" value="image/png">
</div>
<div>
  <button type="button" id="done-button">Convert to Blob (look in the console)</button>
</div>

<script src="//cdn.jsdelivr.net/jquery/2.1.4/jquery.js"></script>
<script src="//wzrd.in/standalone/blob-util@latest"></script>
<script>
(function ($) {
$('#done-button').on('click', function () {
  var file = $('#load-file')[0].files[0];
  var fileReader = new FileReader();
  fileReader.onloadend = function (e) {
    var arrayBuffer = e.target.result;
    var fileType = $('#file-type').val();
    blobUtil.arrayBufferToBlob(arrayBuffer, fileType).then(function (blob) {
      console.log('here is a blob', blob);
      console.log('its size is', blob.size);
      console.log('its type is', blob.type);
    }).catch(console.log.bind(console));
  };
  fileReader.readAsArrayBuffer(file);
});
})(jQuery);
</script>
</body>
</html>