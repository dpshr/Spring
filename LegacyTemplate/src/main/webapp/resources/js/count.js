//페이지 로드가 끝나면
$(document).ready(request);

var valueById = $('input[name=idx]').val();

function request(){
   $.ajax({
      
      url : 'count', // 요청할 주소
      type : 'get', // get or post
      data : {
         // 요청에 담아 보낼 데이터
         // name : value
         "idx" : valueById
      }, 
      success : function(res){
         // 요청이 성공했을 때 실행되는 콜백함수
         console.log(res);
      },
      error : function(e){
         // 요청이 실패했을 때 실행되는 콜백함수
         console.log("error")
      }
      
   })
}