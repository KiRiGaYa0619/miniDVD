/**
 * 
 */
function lend(id,name,state) {
var result = confirm("DVD「" + name + "」を借出してもよろしいでしょうか？");
	if (result && state == 0 ) {
		// AJAX通信を開始
		$.ajax({
			// データの送信先
			url: "/brightstar/dvd/lend"
			// メソッド
			, type: "post"
			// 送信するデータ
			, data: {
				"id": id
				, "name": name
			}
			, success: function (map) {
				 // 更新页面元素内容
            		$('.success td:eq(1)').text(map.info.stateStr);
            		$('.info td:eq(1)').text(map.info.nameStr);
            		$('.warning td:eq(1)').text(map.info.dateStr);
            		$('.danger td:eq(1)').text(map.info.countStr);
            		detailDVD = map.info;
					setTimeout(function () {
					alert(map.msg);
				}, 300);
			}
			, error: function () { 
			}
		});
	}else{
		alert("DVD「" + name + "」已被借出");
	}
}


function returndvd(id,name,state) {
var result = confirm("DVD「" + name + "」を归还してもよろしいでしょうか？");
	if (result && state == 1 ) {
		// AJAX通信を開始
		$.ajax({
			// データの送信先
			url: "/brightstar/dvd/return"
			// メソッド
			, type: "post"
			// 送信するデータ
			, data: {
				"id": id
				, "name": name
			}
			, success: function (map) {
					setTimeout(function () {
					alert(map.msg);
				}, 300);
			}
			, error: function () { 
			}
		});
	}else{
		alert("DVD「" + name + "」尚未借出");
	}
}

/**
 * DVD詳細画面
 */



