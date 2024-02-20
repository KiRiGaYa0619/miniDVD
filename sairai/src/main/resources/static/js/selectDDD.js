/**
 * 
 */function borrowDVD(element) {
	var dvdName = $(element).closest('tr').find('td:eq(2)').text();
	var dvdState = $(element).closest('tr').find('td:eq(1)').text();
	var dvdId = $(element).closest('tr').find('td:eq(0)').text();
	if (dvdState == '已借出') {
		alert(dvdName + '已经被借出，请改日再试');
	} else {
		var sousaValue = $(element).val();
		$('input[name="sousa"]').val(sousaValue);
		alert('借出了 DVD：' + dvdName);
		var dvdId = $(element).closest('tr').find('td:eq(0)').text();
		$('input[name="sousaid"]').val(dvdId);

		$("#sousa2").submit();
	}
}


function returnDVD(element) {
	var dvdName = $(element).closest('tr').find('td:eq(2)').text();
	var dvdState = $(element).closest('tr').find('td:eq(1)').text();
	if (dvdState == '可借') {
		alert(dvdName + '尚未借出，无法归还');
	} else {
		var sousaValue = $(element).val();
		$('input[name="sousa"]').val(sousaValue);
		alert('归还了 DVD：' + dvdName);
		var dvdName2 = $(element).closest('tr').find('td:eq(2)').text();
		$('input[name="sousaname"]').val(dvdName2);

		$("#sousa2").submit();

	}

}

function deleteDVD(element) {
	
	var dvdName = $(element).closest('tr').find('td:eq(2)').text();
	var dvdState = $(element).closest('tr').find('td:eq(1)').text();
	var dvdId = $(element).closest('tr').find('td:eq(0)').text();
	if (dvdState == '已借出') {
		alert(dvdName + '已经被借出，無法執行刪除操作');
	} else {
		var sousaValue = $(element).val();
		$('input[name="sousa"]').val(sousaValue);
		alert('刪除了 DVD：' + dvdName);
		var dvdId = $(element).closest('tr').find('td:eq(0)').text();
		$('input[name="sousaid"]').val(dvdId);

		$("#sousa2").submit();

	}
	}
function detailDVD(id) {

		$('input[name="detailid"]').val(id);
}
//	var dvdName = $(element).closest('tr').find('td:eq(2)').text();
//	var dvdState = $(element).closest('tr').find('td:eq(1)').text();
//	var dvdId = $(element).closest('tr').find('td:eq(0)').text();
	
	



$(function() {
    // 从用戶本地获取count的值
    var countValue = localStorage.getItem('countValue');
    // 如果本地中有count的值，設置成下拉菜單的值
    if (countValue != null) {
        $('#count').val(countValue);
    }
    //綁定一個change事件，下拉菜單value改變時更新本地存入的值
    $('#count').change(function() {
        var newValue = $(this).val();
        localStorage.setItem('countValue', newValue);
    });
});

$(function() {
	//本地獲得checkbox的值
    var checkValue = localStorage.getItem('checkValue');

    if (checkValue != null) {
        $('#check' + checkValue).prop('checked', true);
    }
    // 监听變化
    $('[name="state"]').change(function() {
        // 获取选中的复选框的值
        var newCheck = $('[name="state"]:checked').val();
        // 存储到本地存储中
        localStorage.setItem('checkValue', newCheck);
    });
});

$(function () {
	$('#resultTable').DataTable({
		responsive: true,
		language: {
			url: "http://cdn.datatables.net/plug-ins/9dcbecd42ad/i18n/Japanese.json"
		},
		"selecting": false
	});

	$("#selectBtn").click(selectCheck);

	if ($("#resultTable").length > 0) {
		var height = $('#resultTable').offset().top;
		$("html, body").animate({ scrollTop: height });
	}
})

function selectCheck() {
	var fromdate = $("#fromdate").val();
	var todate = $("#todate").val();

	if (fromdate && todate && fromdate > todate) {
		alert("日付範囲は不正です。");
	} else {
		$("#selectForm").submit();
	}
}

$(document).ready(function() {
    // 重置按钮点击事件处理
    $("#resetBtn").click(function() {
        // 清空表单字段值
        $("input[type='text']").val('');
        $("input[type='date']").val('');
        $("#count").val('');

        // 清空 localStorage 数据
        localStorage.clear();

        // 重定向到指定页面
        window.location.href = "http://localhost:8888/brightstar/dvd/select";
    });
});

