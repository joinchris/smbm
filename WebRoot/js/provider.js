/**
 * 
 */
function addProvider() {
	var modifyJson = {proCode:$("#proCode").val(),proName:$("#proName").val(),
			proContact:$("#proContact").val(),proPhone:$("#proPhone").val(),proAddress:$("#proAddress").val(),
			proFax:$("#proFax").val(),proDesc:$("#proDesc").val()};
	$.ajax({
		type:"post",
		url:"provider/addProvider.com",
		data:modifyJson,
		dataType:"json",
		success:function(data) {
			if(data.result == "添加成功") {
				alert("添加成功");
				window.location.href="provider/selectList.com";
			}else {
				alert("添加失败");
			}
		}
	});
} 

$(".removeProvider").bind('click',function() {
	var id = $(this).attr("pid");
	var $tr = $(this).parents("tr");
	$.ajax({
		type:"post",
		url:"provider/deleteProvider.com",
		data:{id:id},
		dataType:"json",
			success:function(data) {
				if(data.result == "删除成功") {
					$tr.remove();
					alert("删除成功");
				}else {
					alert("删除失败");
				}
			}
	});
});

function modifyProvider() {
	var modifyJson = {id:$("#id").val(),proCode:$("#proCode").val(),proName:$("#proName").val(),
			proContact:$("#proContact").val(),proPhone:$("#proPhone").val(),proAddress:$("#proAddress").val(),
			proFax:$("#proFax").val(),proDesc:$("#proDesc").val()};
	$.ajax({
		type:"post",
		url:"provider/modifyProvider.com",
		data:modifyJson,
		dataType:"json",
		success:function(data) {
			if(data.result == "修改成功") {
				alert("修改成功");
				window.location.href="provider/selectList.com";
			}else {
				alert("修改失败");
			}
		}
	});
}

function selectLike() {
	var selectLikeJson = {proName:$("#proName").val()};
	$.ajax({
		type:"post",
		url:"provider/selectLike.com",
		data:selectLikeJson,
		dataType:"json",
		success:function(data) {
				$(".providerTable").html("<tr class='firstTr'>"+
	                "<th width='10%'>供应商编码</th>" +
	                "<th width='20%'>供应商名称</th>" + 
	                "<th width='10%'>联系人</th>" +
	                "<th width='10%'>联系电话</th>" +
	                "<th width='10%'>传真</th>" +
	                "<th width='10%'>创建时间</th>" +
	                "<th width='30%'>操作</th>" +
	                "</tr>" 
	                );
				
			for (var i = 0; i < data.length; i++) {
				$(".providerTable").append(
						"<tr>" +
		                "<td>" + data[i].proCode +"</td>" +
		                "<td>" + data[i].proName + "</td>" +
		               "<td>" + data[i].proContact + "</td>" +
		                "<td>" + data[i].proPhone + "</td>" +
		               "<td>" + data[i].creationDate + "</td>" +
		               "<td><fmt:formatDate value=" + data[i].creationDate + " pattern='yyyy-MM-dd'/></td>" +
		                "<td>" +
		                    "<a href='http://localhost:8080/smbm/provider/viewJsp.com?id=" + data[i].id + "'><img src='http://localhost:8080/smbm/img/read.png' alt='查看' title='查看'/></a>" +
		                    "<a href='http://localhost:8080/smbm/provider/updateJsp.com?id=" + data[i].id + "'><img src='http://localhost:8080/smbm/img/xiugai.png' alt='修改' title='修改'/></a>" +
		                    "<a pid=" + data[i].id + " class='removeProvider'><img src='http://localhost:8080/smbm/img/schu.png' alt='删除' title='删除'/></a>" +
		                "</td>"
				);
			}
			$(".removeProvider").bind('click',function() {
				var id = $(this).attr("pid");
				var $tr = $(this).parents("tr");
				$.ajax({
					type:"post",
					url:"provider/deleteProvider.com",
					data:{id:id},
					dataType:"json",
						success:function(data) {
							if(data.result == "删除成功") {
								$tr.remove();
								alert("删除成功");
							}else {
								alert("删除失败");
							}
						}
				});
			});
		}
	});
}