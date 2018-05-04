/*
 * jQuery validation 验证类型扩展
 *
 * 扩展的验证类型：邮政编码，大陆身份证号码，大陆手机号码,电话号码
 * 
 */
 // 邮政编码验证    
jQuery.validator.addMethod("isZipCode", function(value, element) {    
  var zip = /^[0-9]{6}$/;    
  return this.optional(element) || (zip.test(value));    
}, "请正确填写您的邮政编码!");        
// 身份证号码验证
jQuery.validator.addMethod("isIdCardNo", function(value, element) { 
  var idCard = /^(\d{6})()?(\d{4})(\d{2})(\d{2})(\d{3})(\w)$/;   
  return this.optional(element) || (idCard.test(value));    
}, "请输入正确的身份证号码!"); 

// 手机号码验证    
jQuery.validator.addMethod("isMobile", function(value, element) {    
  var length = value.length;    
  return this.optional(element) || (length == 11 && /^(((13[0-9]{1})|(15[0-9]{1})|(18[0-9]{1}))+\d{8})$/.test(value));    
}, "请正确填写您的手机号码!");

// 电话号码验证    
jQuery.validator.addMethod("isPhone", function(value, element) {    
  var tel = /^(\d{3,4}-?)?\d{7,9}$/g;    
  return this.optional(element) || (tel.test(value));    
}, "请正确填写您的电话号码!")
// 地区验证    
jQuery.validator.addMethod("isArea", function(value, element) {    
  var tel = /(?!.*县级市)^.*$/;   
  return this.optional(element) || (tel.test(value)); //   
}, "请正确选择的地区!")
//设备信息名称验证    
jQuery.validator.addMethod("deviceName", function(value, element) {  ///^[^\|"'<>]*$/     
    return this.optional(element) || /^[^\|"'`<>]+$/.test(value);       
}, "只能包括中文字、英文字母、数字和下划线")
// 用户名字符验证    
jQuery.validator.addMethod("userName", function(value, element) {
  return this.optional(element) || /(?!_)^([a-zA-z][a-zA-z0-9_]{1})([\w]*)$/g.test(value);    
}, "用户名只能使用字母、数字、下划线，需以字母开头!"); 

// 联系电话(手机/电话皆可)验证   
jQuery.validator.addMethod("isTel", function(value,element) {   
    var length = value.length;   
    var mobile = /^(((13[0-9]{1})|(15[0-9]{1}))+\d{8})$/;   
    var tel = /^\d{3,4}-?\d{7,9}$/;   
    return this.optional(element) || (tel.test(value) || mobile.test(value));   
}, "请正确填写您的联系电话!");  

// IP地址验证   
jQuery.validator.addMethod("ip", function(value, element) {    
  return this.optional(element) || /^(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.)(([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))\.){2}([1-9]|([1-9]\d)|(1\d\d)|(2([0-4]\d|5[0-5])))$/.test(value);    
}, "请填写正确的IP地址！");
//密码必须输入字母和数字!
jQuery.validator.addMethod("ismypassword", function(value, element) {
	var number = /[0-9]*/;
	var letter = /[A-Za-z]+/;
	var r =/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]/;
	var b1 = r.test(value);
	var b2 = this.optional(element);
	var b3 = b1 || b2;
    return b3;
 }, "密码不能为纯数字或者纯字母!");
//验证功能配置页面的网址输入框输入的必须是网址
jQuery.validator.addMethod("isurl", function(value, element) {

	var r = /^((https?|ftp|news):\/\/)?([a-z]([a-z0-9\-]*[\.。])+([a-z]{2}|aero|arpa|biz|com|coop|edu|gov|info|int|jobs|mil|museum|name|nato|net|org|pro|travel)|(([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5])\.){3}([0-9]|[1-9][0-9]|1[0-9]{2}|2[0-4][0-9]|25[0-5]))(\/[a-z0-9_\-\.~]+)*(\/([a-z0-9_\-\.]*)(\?[a-z0-9+_\-\.%=&]*)?)?(#[a-z][a-z0-9_]*)?$/;
	var b1 = r.test(value);
	var b2 = this.optional(element);
	var b3 = b1 || b2;
    return b3;
 }, "请输入网址!");
