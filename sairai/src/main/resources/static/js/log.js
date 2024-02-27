/**
 * 
 */
$(function() {
            setTimeout(msgAlert, 300);
});


function msgAlert() {
    var msg = $("#msg").val();
    if (msg) {
        alert(msg);
    }
}