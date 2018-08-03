/**
 * 
 */
$(".deleteUser").bind({
	click:function() {
		var id = $(this).attr("uid");
		var $tr = $(this).parents("tr");
		$.ajax({
			type:"post",
			url:"user/deleteUser.com",
			data:{id:id},
			dataType:"json",
			success:function(data) {
				if(data.result == "删除失败") {
					alert("删除失败");
				}else if(data.result == "删除成功") {
					$tr.remove();
					alert("删除成功");
				}
			}
		});
	}
});


function addUser() {
	var addJson = {userCode:$("#userCode").val(),userName:$("#userName").val(),userpassword:$("#userpassword").val(),
			gender:$("#gender").val(),data:$("#data").val(),userphone:$("#userphone").val(),
			userAddress:$("#userAddress").val(),userLei:$("#userLei").val()};
	$.ajax({
		type:"post",
		url:"user/addUser.com",
		data:addJson,
		datatype:"json",
		success:function(data) {
			if(JSON.parse(data).result ==  "添加成功") {
				alert("添加成功");
				window.location.href="user/selectList.com";
			}else {
				alert("添加失败");
			}
		}
	});
}

function modifyUser() {
	var modifyJson = {id:$("#id").val(),userName:$("#userName").val(),
			gender:$("#gender").val(),data:$("#data").val(),userphone:$("#userphone").val(),
			userAddress:$("#userAddress").val(),userLei:$("#userLei").val()};
	$.ajax({
		type:"post",
		url:"user/modifyUser.com",
		data:modifyJson,
		dataType:"json",
		success:function(data) {
			if(data.result == "修改失败") {
				alert("修改失败");
			}else if(data.result == "修改成功") {
				alert("修改成功");
				window.location.href="user/selectList.com";
			}
		}
	});
}

function selectUser() {
	var selectUserJson = {userName:$("#userName").val()};
	$.ajax({
		type:"post",
		url:"user/selectLike.com",
		data:selectUserJson,
		success:function(data) {
			$(".providerTable").html(JSON.parse(data).html);
			$(".deleteUser").bind({
				click:function() {alert(11);
					var id = $(this).attr("uid");
					var $tr = $(this).parents("tr");
					$.ajax({
						type:"post",
						url:"user/deleteUser.com",
						data:{id:id},
						dataType:"json",
						success:function(data) {
							if(data.result == "删除失败") {
								alert("删除失败");
							}else if(data.result == "删除成功") {
								$tr.remove();
								alert("删除成功");
							}
						}
					});
				}
			});
		}
	});
}

function password() {
	var passwordJson = {oldPassword:$("#oldPassword").val(),newPassword:$("#newPassword").val(),
			reNewPassword:$("#reNewPassword").val()};
	$.ajax({
		type:"post",
		url:"user/password.com",
		data:passwordJson,
		dataType:"json",
		success:function(data) {
			if(data.result == "修改成功") {
				alert("修改成功");
				window.location.href="user/loginOut.com";
			}else {
				alert("修改失败");
			}
		}
	});
}