/**
 * 
 */
function addBill() {
	var addJson = {billCode:$("#billCode").val(),productName:$("#productName").val(),productUnit:$("#productUnit").val(),
			productCount:$("#productCount").val(),totalPrice:$("#totalPrice").val(),providerId:$("#providerId").val(),
			isPayment:$("#isPayment").val()};
		$.ajax({
		type:"post",
		url:"bill/addBill.com",
		data:addJson,
		dataType:"json",
		success:function(data) {
			if(data.result == "添加成功") {
				alert("添加成功");
				window.location.href="bill/selectList.com";
			} else {
				alert("添加失败");
			}
		}
		
	});
}

$(".deleteBill").bind("click",function() {
	var id = $(this).attr("bid");
	var $tr = $(this).parents("tr");
	$.ajax({
		type:"post",
		url:"bill/deleteBill.com",
		data:{id:id},
		dataType:"json",
		success:function(data) {
			if(data.result == "删除成功") {
				$tr.remove();
				alert("删除成功");
			} else {
				alert("删除失败");
			}
		}
		
	});
});

function modifyBill() {
	var modifyJson = {billCode:$("#billCode").val(),productName:$("#productName").val(),productUnit:$("#productUnit").val(),
			productCount:$("#productCount").val(),totalPrice:$("#totalPrice").val(),providerId:$("#providerId").val(),
			isPayment:$("#isPayment").val(),id:$("#id").val()};
		$.ajax({
		type:"post",
		url:"bill/modifyBill.com",
		data:modifyJson,
		dataType:"json",
		success:function(data) {
			if(data.result == "修改失败") {
				alert("修改失败");
			}else if(data.result == "修改成功") {
				alert("修改成功");
				window.location.href="bill/selectList.com";
			}
		}
	});
}

function selectLike() {
	var selectLikeJson = {productName:$("#productName").val(),providerId:$("#providerId").val(),
			isPayment:$("#isPayment").val()};
		$.ajax({
		type:"post",
		url:"bill/selectLike.com",
		data:selectLikeJson,
		dataType:"json",
		success:function(data) {
			 $(".providerTable").html("<tr class='firstTr'>" +
            "<th width='10%'>账单编码</th>" +
            "<th width='20%'>商品名称</th>" +
            "<th width='10%'>供应商</th>" +
            "<th width='10%'>账单金额</th>" +
            "<th width='10%'>是否付款</th>" +
            "<th width='10%'>创建时间</th>" +
            "<th width='30%'>操作</th>" +
        "</tr>");
			 	var isPayment = null;
				for (var i = 0; i < data.length; i++) {
					if(data[i].isPayment == 1) {
						isPayment = "已付款";
					}else if(data[i].isPayment == 2) {
						isPayment = "待付款";
					}
					$(".providerTable").append("<tr>" +
                    "<td>" + data[i].billCode + "</td>" +
                    "<td>" + data[i].productName + "</td>" +
                    "<td>" + data[i].providerName + "</td>" +
                    "<td>" + data[i].totalPrice + "</td>" +
                   "<td>" +  isPayment +"</td>" +
                    "<td><fmt:formatDate value=" + data[i].creationDate + " pattern='yyyy-MM-dd'/></td>" +
                    "<td>" +
                        "<a href='http://localhost:8080/smbm/bill/viewJsp.com?id=" + data[i].id + "'><img src='http://localhost:8080/smbm/img/read.png' alt='查看' title='查看'/></a>" +
                        "<a href='http://localhost:8080/smbm/bill/updateJsp.com?id=" + data[i].id + "'><img src='http://localhost:8080/smbm/img/xiugai.png' alt='修改' title='修改'/></a>" +
                        "<a bid=" + data[i].id + " class='deleteBill'><img src='http://localhost:8080/smbm/img/schu.png' alt='删除' title='删除'/></a>" +
                    "</td>" +
                "</tr>");
				}
				$(".deleteBill").bind("click",function() {
					var id = $(this).attr("bid");
					var $tr = $(this).parents("tr");
					$.ajax({
						type:"post",
						url:"bill/deleteBill.com",
						data:{id:id},
						dataType:"json",
						success:function(data) {
							if(data.result == "删除成功") {
								$tr.remove();
								alert("删除成功");
							} else {
								alert("删除失败");
							}
						}
						
					});
				});
			}
	});
}