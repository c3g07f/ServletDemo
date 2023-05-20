function listAll() {
    $("#tb").html("");
    $.ajax({
        type: "get",
        url: "/UserList",
        success(data) {
            var res = JSON.parse(data);
            var reslist;
            for (var i = 0; i < res.length; i++) {
                var s = res[i].id;
                reslist += "<tr>" +
                    "<td>" + "<input class='zi form-check-input' type='checkbox' value="+res[i].id+">" + "</td>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + res[i].id + "</td>" +
                    "<td class='tduser'>" + res[i].username + "</td>" +
                    "<td class='tdpass'>" + res[i].password + "</td>" +
                    // "<td>" + "<button class='btn btn-success change' data-bs-toggle='modal' data-bs-target='#exampleModal2' onclick=change(" + res[i].id + ")>" + "修改"
                    // + "</button>" +
                    // "<button class='btn btn-danger del'" + "onclick=delete1(" + res[i].id + ") " +
                    // ">删除</button>" +
                    "</td>" + "</tr>";
            }
            ;
            $("#tb").html(reslist);
            selectAll();

        }
    })
}
function clean_(){
    $("#addId").val("")
    $("#addPwd").val("");
}
function list() {
    var f1 = $("#first").val();
    var f2 = $("#second").val();
    var f3 = $("#third").val();
    $("#tb").html("");
    $.ajax({
        type: "post",
        url: "/UserList",
        data: {
            "f1": f1,
            "f2": f2,
            "f3": f3
        },
        success(data) {
            console.log(data);
            var res = JSON.parse(data);
            var reslist;
            for (let i = 0; i < res.length; i++) {
                reslist += "<tr>" +
                    "<td>" + "<input class='zi form-check-input' type='checkbox' value="+res[i].id+">" + "</td>" +
                    "<td>" + (i + 1) + "</td>" +
                    "<td>" + res[i].id + "</td>" +
                    "<td>" + res[i].username + "</td>" +
                    "<td>" + res[i].password + "</td>" +
                    // "<td>" + "<button class='btn btn-success change' data-bs-toggle='modal' data-bs-target='#exampleModal2' onclick=change(" + res[i].id + ")>" + "修改"
                    // + "</button>" +
                    // "<button class='btn btn-danger del'" + "onclick=delete1(" + res[i].id + ") " +
                    // ">删除</button>" +
                    "</td>" + "</tr>";
            }
            ;
            $("#tb").html(reslist);
            selectAll();

        }
    })
}
function selectAll(){
    $("#selectAll").click(function () {
        console.log("复选框被点击了");
        if ($("#selectAll").is(":checked")) {
            $(".zi").prop("checked", true);
        } else {
            $(".zi").prop("checked", false);
        }
    });
    $(".zi").click(function () {
        var delIds = [];
        var s = $("input.zi").length;
        var count = 0;
        for (var i = 0; i < s; i++) {
            if ($("input.zi").eq(i).is(":checked")) {
                count++;
            }
        }
        // console.log(delIds);
        if (count == s) {
            $("#selectAll").prop("checked", true);
        } else {
            $("#selectAll").prop("checked", false);
        }

    });

}
function checkList(){
    var idList = [];
    $(".zi").click(function () {
        var delIds = [];
        var s = $("input.zi").length;
        var count = 0;
        for (var i = 0; i < s; i++) {
            if ($("input.zi").eq(i).is(":checked")) {
                delIds.push($("input.zi").eq(i).val())
                count++;
            }
        }
        // console.log(delIds);
        if (count == s) {
            $("#selectAll").prop("checked", true);
        } else {
            $("#selectAll").prop("checked", false);
        }
        idList = delIds;
    });
    return idList;
}
function allDel() {
    const delIds = [];
    const s = $("input.zi").length;
    for (var i = 0; i < s; i++) {
        if ($("input.zi").eq(i).is(":checked")) {
            delIds.push(parseInt($("input.zi").eq(i).val()))
        }
    }
    if(delIds.length ==0){
        alert("请选择要删除的!");
    }else {
        const idJson = JSON.stringify(delIds);
        $.ajax({
            type: "POST",
            url: "/userdel",
            data: {
                "Ids": idJson
            },
            success() {
                alert("删除成功");
                listAll();
            }
        })
    }

}
function searchAll() {
    list();
};

function add() {
    var f2 = $("#addId").val();
    var f3 = $("#addPwd").val();

    if (f2 == "" || f3 == "") {
        alert("参数不能为空！")
    } else {
        $.ajax({
            type: "post",
            url: "/useradd",
            data: {
                "f2": f2,
                "f3": f3
            },
            success() {
                alert("添加成功");
                $("#exampleModal").modal( "hide" );
                listAll();
            }
        })
    }
}

function change(s) {
    var f1 = "";
    f1 =s;
    var f2 = "";
   var f3 = "";
    $("#updateName").val("");
    $("#updatePwd").val("");
    console.log(s)
    $("#update").click(function () {
         f2 = $("#updateName").val();
         f3 = $("#updatePwd").val();
        if (f2 == "" || f3 == "") {
            alert("参数不能为空！");
        return
        }
         else {
            $.ajax({
                type: "post",
                url: "/userupdate",
                data: {
                    "f1": f1,
                    "f2": f2,
                    "f3": f3
                },
                success() {
                    console.log("更新成功!")
                    alert("更新成功");
                    $("#exampleModal2").modal( "hide" );
                    listAll();
                    return
                }
            })
        }
    })
}
function delete1(s) {
    var f1 = s;
    $.ajax({
        type: "delete",
        url: "/UserList?f1=" + f1,
        success() {
            alert("删除成功");
            listAll();
        }
    })
}
function choseUpdate() {
    const updateIds = [];
    const s = $("input.zi").length;
    var updateid = 0;
    var username = "";
    var password = "";
    for (var i = 0; i < s; i++) {
        if ($("input.zi").eq(i).is(":checked")) {
            updateIds.push(parseInt($("input.zi").eq(i).val()));
            username = $("input.zi").eq(i).parent().parent().children().eq(3).text();
            password = $("input.zi").eq(i).parent().parent().children().eq(4).text();
            updateid = parseInt($("input.zi").eq(i).val());
        }
    }
    // console.log(username)
    // console.log(password)
    if (updateIds.length == 0) {
        alert("请选择一项要更新的!");
        $("#exampleModal2").modal('hide');
        return
    } else {
        if (updateIds.length > 1) {
            alert("只能选择一项！");
            $("#exampleModal2").modal('hide');
            return false;
        } else {
            $("#exampleModal2").modal('show')
            $("#updateName").val(username)
            $("#updatePwd").val(password)
            $("#update").click(function () {
                var f1 = updateid;
               var f2 = $("#updateName").val();
               var f3 = $("#updatePwd").val();
                if (f2 == "" || f3 == "") {
                    alert("参数不能为空！");
                    return
                }
                else {
                    $.ajax({
                        type: "post",
                        url: "/userupdate",
                        data: {
                            "f1": f1,
                            "f2": f2,
                            "f3": f3
                        },
                        success() {
                            console.log("更新成功!")
                            alert("更新成功");
                            $("#exampleModal2").modal( "hide" );
                            listAll();
                            return
                        }
                    })
                }
            })
        }
    }
}
function inputUpdate(){
}

