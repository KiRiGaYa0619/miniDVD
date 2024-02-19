$(function() {
    $("#nam").blur(nameCheck);
            setTimeout(msgAlert, 300);
});

$("#insert").click(function(event) {
    event.preventDefault(); // 阻止默认的表单提交行为
    var name = $("#nam").val();
    if (name) {
        $("#myForm").submit(); // 手动提交表单
    } else {
        alert("DVD名称不可为空");
    }
});

function nameCheck() {
    var name = $("#nam").val();

    if (name) {
        $("#nameMsg").text("").css("color", "black");
        $("#insert").prop("disabled", false);
    } else {
        $("#nameMsg").text("DVD名称不可以为空！").css("color", "red");
        $("#insert").prop("disabled", true);
    }
}

function msgAlert() {
    var msg = $("#msg").val();
    if (msg) {
        alert(msg);
    }
}
