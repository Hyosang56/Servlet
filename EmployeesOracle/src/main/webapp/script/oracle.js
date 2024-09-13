/**
 * 
 */

function loginCheck() {
   if (document.frm.id.value.length == 0) {
      alert("아이디를 써주세요");
      frm.id.focus();
      return false;
   }
   if (document.frm.pass.value == "") {
      alert("암호는 반드시 입력해야 합니다.");
      frm.pass.focus();
      return false;
   }
   return true;
  
}
function joinCheck() {
   if (document.frm.name.value.length == 0) {
      alert("이름을 써주세요.");
      frm.name.focus();
      return false;
   }
   if (document.frm.id.value.length == 0) {
      alert("아이디를 써주세요");
      frm.id.focus();
      return false;
   }
   if (document.frm.id.value.length < 4) {
      alert("아이디는 4글자이상이어야 합니다.");
      frm.id.focus();
      return false;
   }
   if (document.frm.pass.value == "") {
      alert("암호는 반드시 입력해야 합니다.");
      frm.pass.focus();
      return false;
   }
   if (document.frm.pass.value != document.frm.pass_check.value) {
      alert("암호가 일치하지 않습니다.");
      frm.pass.focus();
      return false;
   }
   if (document.frm.reid.value.length == 0) {
      alert("중복 체크를 하지 않았습니다.");
      frm.id.focus();
      return false;
   }   
   
   return true;
}