

$(function(){
	$.ajaxSetup({
		beforeSend:function(){
			$("#load-gif").toggleClass("loading");
		},
		complete:function(){
			$("#load-gif").toggleClass("loading");
		}
		
	})
		/* 界面打开执行方法调用数据进行显示*/		
			refresh();	
		
		/* 单个查询 */
		$("#btnQuery").click(function(){
			if($("#queryname").val() !=""){
				//$.get方法 第一个参数是指向地址，第二个参数是传递参数,第三参数是回调函数收到返回结果				
				$.get("categoryfuzzyquery",{name:$("#queryname").val()},function(data){
				
					if(data.code == "200"){
						var $tbody = $("tbody");
						$tbody.empty();//清空文本与子节点
						$.each(data.data,function(index,ele){		
							var $tr = $("<tr><td></td><td></td><td><input type='button' class='btnDel' value='删除'/><input type='button' class='btnUpdate' value='修改'/></td></tr>");
							$tr.find("td:first").html(ele.cid);
							$tr.find("td:nth-child(2)").html(ele.cname);
							$tbody.append($tr);
							dele();
							update();
						})
						$("#queryname").val("");
					} else {
						alert("找到不对象,请重新输入");
						$("#queryname").val("");
					}
					
				})//get end
			} else {
				refresh();
			}
		
		})
		
		/* 这是一个添加的点击事件 */
		$("#btnOk").click(function(){
			$("#msg").empty();//清空文本与子节点
			$.ajax({
				url:"addcategory",//传递到的地址
				type:"post",//设置传递数据的方式
				data:{name:$("#shopname").val()},//获取文本框的值
				success:function(data){//回调函数 可以获得响应回来的数据
					if(data.code == "200"){
						alert(data.msg);
						$("tbody").append("<tr><td>"+data.data+"</td><td>"+$("#shopname").val()+"</td><td><input type='button' class='btnDel' value='删除'/><input type='button' class='btnUpdate' value='修改'/></td></tr>");
						$("#msg").html("你添加了一个"+$("#shopname").val()+"商品！");
						dele();
						update();
					} else {
						alert(data.msg);
					}
				}
			});
		})//add end
		var id;
		var $shopname;
		var $textshopname;
		function update(){		
			$(".btnUpdate").unbind().click(function(){	
				id=$(this).parent().parent().find(":first").text();
				$shopname = $(this).parent().parent().find(":nth-child(2)").text();	
				$textshopname =$(this).parent().parent().find(":nth-child(2)");
				$("#updatename").val($shopname);			
			});
		
		}
		$("#btnUpdate").unbind().click(function(){
			$.ajax({
				url:"categoryupdate",//传递到的地址
				type:"post",//设置传递数据的方式
				data:{name:$("#updatename").val(),id:id},//获取文本框的值
				success:function(data){//回调函数 可以获得响应回来的数据
					if(data>0){
						$textshopname.html($("#updatename").val());			
						alert("修改成功...");
					}
				}
			});	
		})//update end
		
		
		//刷新的方法
		function refresh(){
			$.get("querycategory",function(data){
				var $tbody = $("tbody");
				$tbody.empty();//清空文本与子节点
				$.each(data,function(index,ele){		
					var $tr = $("<tr><td></td><td></td><td><input type='button' class='btnDel' value='删除'/><input type='button' class='btnUpdate' value='修改'/></td></tr>");
					$tr.find("td:first").html(ele.cid);
					$tr.find("td:nth-child(2)").html(ele.cname);
					$tbody.append($tr);
					dele();
					update();
				})
				
			});	//query end
			}
		
		/**这是一个删除的点击事件*/
		function dele(){
			$(".btnDel").unbind().click(function(){			
					$(this).parent().parent().remove();	
					$.ajax({
						url:"categorydele",//传递到的地址
						type:"post",//设置传递数据的方式
						data:{id:$(this).parent().parent().find(":first").text()},//获取文本框的值
						success:function(data){//回调函数 可以获得响应回来的数据
							if(data != "" && data !=null){
								alert("删除成功...");
							}
						}
					});	
			})
		}//dele end
		
		
	})