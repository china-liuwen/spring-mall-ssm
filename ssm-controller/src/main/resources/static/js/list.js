
$(function(){
    $(document).ajaxError(function(){
        alert("一个错误发生")
    })
	/*function getAll(){
		$.getJSON("/employee/list",function(data){

			$.each(data,function(index,employee){
				var $tr=$("<tr>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td>"+
                    "<a href='#' class='delete btn btn-danger'>删除</a>"+
					"<a href='#' class='edit btn btn-info'>编辑</a>" +
                    "<a href='#' class='add btn btn-info'>新增</a>" +
                    "</td></tr>")

				$tr.find("td:first").text(employee.eid);
				$tr.find("td:eq(1)").text(employee.ename);
				$tr.find("td:eq(2)").text(employee.sex);
                $tr.find("td:eq(3)").text(employee.section);
                $tr.find("td:eq(4)").text(employee.post);

				$tr.find("td a:eq(0)").data("eid",employee.eid);
				$tr.find("td a:eq(1)").data("eid",employee.eid);
                $tr.find("td a:eq(2)").data("eid",employee.eid);
				$tr.appendTo("tbody");
			})
		})
	}

	getAll();*/
	
	//删除
	$("tbody").on("click",".delete",function (e) {
        e.preventDefault();
        var $that = $(this);
        if (confirm("确定要删除吗?")) {
            $.post("/employee/delete",{eid:$(this).data("eid")},function () {
                console.log($that);
                $that.closest("tr").remove();
            });
        }
    });
	//修改
	$("tbody").on("click",".edit",function () {
		
		$("#myModalLabel").html("修改信息");
        $("#save").data("op", "update");
        $("#eid").val($(this).data("eid"));
        $("#ename").val($(this).closest("tr").find("td:eq(1)").text());
        $("#sex").val($(this).closest("tr").find("td:eq(2)").text());
        $("#section").val($(this).closest("tr").find("td:eq(3)").text());
        $("#post").val($(this).closest("tr").find("td:eq(4)").text());
        $("#eid").prop("disabled", "disabled");
        $("#myModal").modal('show');
    });
	
	
	$("#save").click(function(){
        var op = $("#save").data("op");
        if(op!="update"){
            return;
        }
        $("#myModal").modal('hide');
        var obj = {eid:$("#eid").val(),
                    ename:$("#ename").val(),
                    sex:$("#sex").val(),
                    section:$("#section").val(),
                    post:$("#post").val()};
        console.log(obj);
        $.post("/employee/update",obj,function () {
            location.href="/employee/index";
        });})


    //新增信息
    $("#content").on("click",".add",function () {
        alert("123");
        $("#myModalLabel").html("新增信息");
        $("#save").data("op", "insert");
        $("#myModal").modal('show');
    });
  //新增操作
    $("#save").click(function(){
        var op = $("#save").data("op");
        if(op!="insert"){
            return;
        }
        $("#myModal").modal('hide');
        var obj = {
            ename:$("#ename").val(),
            sex:$("#sex").val(),
            section:$("#section").val(),
            post:$("#post").val()};
            console.log(obj);
        $.post("/employee/insert",obj,function () {
            $("tbody").empty();
            getAll();
        });
    });
});

