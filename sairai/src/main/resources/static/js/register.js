/**
 * 
 */$(function(){
    var checkName = 0;
    var checkPassword = 0;

    $("#userid").blur(function(){
        var name = $("#userid").val();
        var nameMsg = $("#nameMsg");
        nameMsg.css("color", "red");

        if (!name) {
            nameMsg.text("名称未输入!");
            checkName = 0;
        } else if (/^[a-zA-Z\d_-]{8,20}$/.test(name)) {
            nameMsg.text("👌");
            checkName = 2;
        } else {
            nameMsg.text("用户名格式有误，只可使用字母数字及下划线，且首字母大写!");
            checkName = 1;
        }
    });
   
    $("#password").blur(function(){
        var password = $("#password").val();
        var passwordMsg = $("#passwordMsg");
        passwordMsg.css("color", "red");
    
        if (!password) {
            passwordMsg.text("密码未输入!");
            checkPassword = 0;
        } else if (password.length < 8 || password.length > 15) {
            passwordMsg.text("密码的长度应在8-15位之间");
            checkPassword = 1;
        } else {
            passwordMsg.text("👌");
            checkPassword = 2;
        }
    });

    $("#registerBtn").click(function(){
        var name = ["名称未输入", "名称格式有误"];
        var password = ["密码未输入", "密码格式有误"];

        if(checkName == 2 && checkPassword == 2){
            alert("确认した!");
            //触发表单提交
            $("#registerForm").submit();
        } else {
            alert(name[checkName] + "，" + password[checkPassword] + "，请检查并重试");
        }
    });
});
