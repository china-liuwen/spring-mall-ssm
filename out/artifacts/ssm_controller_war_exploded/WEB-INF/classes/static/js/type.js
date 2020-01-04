
$(function(){
    $(document).ajaxError(function(){
        alert("一个错误发生")
    })
    function getAll(){
        $.getJSON("/type/list",function(data){

            $.each(data,function(index,type){
                var $tr=$("<tr>" +
                    "<td></td>" +
                    "<td></td>" +
                    "<td>"+
                    "<a href='#' class='delete btn btn-danger'>删除</a>"+
                    "<a href='#' class='edit btn btn-info'>编辑</a>" +
                    "<a href='#' class='inset btn btn-info'>新增</a>" +
                    "</td></tr>")

                $tr.find("td:first").text(type.tid);
                $tr.find("td:eq(1)").text(type.tname);

                $tr.find("td a:eq(0)").data("tid",type.tid);
                $tr.find("td a:eq(1)").data("tid",type.tid);
                $tr.find("td a:eq(2)").data("tid",type.tid);
                $tr.appendTo("tbody");
            })
        })
    }

    getAll();

    //删除
    $("tbody").on("click",".delete",function (e) {
        e.preventDefault();
        var $that = $(this);
        if (confirm("确定要删除吗?")) {
            $.post("/type/delete",{tid:$(this).data("tid")},function () {
                console.log($that);
                $that.closest("tr").remove();
            });
        }
    });
    //修改
    $("tbody").on("click",".edit",function () {

        $("#myModalLabel").html("修改信息");
        $("#save").data("op", "update");
        $("#tid").val($(this).data("eid"));
        $("#tname").val($(this).closest("tr").find("td:eq(1)").text());

        $("#tid").prop("disabled", "disabled");
        $("#myModal").modal('show');
    });


    $("#save").click(function(){
        var op = $("#save").data("op");
        if(op!="update"){
            return;
        }
        $("#myModal").modal('hide');
        var obj = {tid:$("#tid").val(),
            tname:$("#tname").val()};

        console.log(obj);
        $.post("/type/update",obj,function () {
            location.href="/type/index";
        });})


    //新增信息
    $("#content").on("click",".add",function () {
        $("#myModalLabel").html("新增信息");
        $("#save").data("op", "insert");
        $("#eid").val($(this).data("eid"));
        $("#ename").val($(this).closest("tr").find("td:eq(1)").text());
        $("#sex").val($(this).closest("tr").find("td:eq(2)").text());
        $("#section").val($(this).closest("tr").find("td:eq(3)").text());
        $("#post").val($(this).closest("tr").find("td:eq(4)").text());
        $("#eid").prop("disabled", "disabled");
        $("#myModal").modal('show');
    });
    //新增操作
    $("#save").click(function(){
        var op = $("#save").data("op");
        if(op!="insert"){
            return;
        }
        $("#myModal").modal('hide');
        $.getJSON("/employee/select",function(data){
            var obj = {eid:$("#eid").val(),
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
    })});

