<%--
  Created by IntelliJ IDEA.
  User: GodDustin
  Date: 2023/5/15
  Time: 8:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">
<html>
<link rel="stylesheet" href="/css/bootstrap.min.css">
<script src="${pageContext.request.contextPath }/js/bootstrap.bundle.min.js"></script>
<script src="${pageContext.request.contextPath }/js/jquery.js"></script>
<script src="${pageContext.request.contextPath }/js/main.js"></script>
<head>
    <title>信息</title>
</head>
<body onload="listAll()">
<div
        class="modal fade"
        id="exampleModal2"
        tabindex="-1"
        aria-labelledby="exampleModalLabel2"
        aria-hidden="true"
>
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel2">修改员工信息</h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body align-content-center justify-content-center">
                <label>输入用户名</label>
                <input
                        type="text"
                        class="form-control"
                        id="updateName"
                />
                <label>输入密码</label>
                <input
                        type="text"
                        class="form-control"
                        id="updatePwd"
                />
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                    取消
                </button>
                <button type="button" class="btn btn-primary" id="update">
                    确认修改
                </button>
            </div>
        </div>
    </div>
</div>
<div
        class="modal fade "
        id="exampleModal"
        tabindex="-1"
        aria-labelledby="exampleModalLabel"
        aria-hidden="true"
>
    <div class="modal-dialog modal-dialog-centered">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">添加数据</h5>
                <button
                        type="button"
                        class="btn-close"
                        data-bs-dismiss="modal"
                        aria-label="Close"
                ></button>
            </div>
            <div class="modal-body ">
                <input
                        type="text"
                        class="form-control mt-2"
                        placeholder="输入用户名"

                        id="addId"
                />
                <input
                        type="text"
                        class="form-control mt-2"
                        placeholder="输入密码"

                        id="addPwd"
                />
            </div>
            <div class="modal-footer">
                <button
                        type="button"
                        class="btn btn-secondary"
                        data-bs-dismiss="modal"
                >
                   取消
                </button>
                <button type="button" class="btn add btn-primary" onclick="add()">
                    添加
                </button>
            </div>
        </div>
    </div>
</div>
<div class="container">

        <div class="row  w-75 mt-3 mb-4">
            <span class=" p-0 text-primary h6">你好，${name}&nbsp;&nbsp;&nbsp;今天是，${date}</span>
        </div>
        <div class="row  d-flex">
            <input
                id="first"
                class="form-control"
                style="width: 10rem;"
                type="text"
                name="f1"
                placeholder="输入ID"

        />
            <input
                id="second"
                class="form-control ms-3"
                style="width: 10rem;"
                type="text"
                name="f2"
                placeholder="输入用户名"
        />
            <button
                    class="btn btn-dark search ms-2"
                    onclick="searchAll()"
                    style="width: 5rem;"
            >
                查询
            </button>
            <input
                id="third"
                class="input-group-text me-3"
                style="width: 10rem; height: 2rem;visibility: hidden"
                type="text"
                name="f3"
        />
        </div>
    <div class="row mt-3">
        <button
                class="btn btn-primary  me-4 p-0"
                data-bs-toggle="modal"
                data-bs-target="#exampleModal"
                style="width: 5rem;"
                onclick="clean_()"
        >
            增加
        </button>

        <button
                class="btn btn-success ms-2 me-4"
                style="width: 5rem;"
                onclick="choseUpdate()"
        >
            修改
        </button>
        <button
                class="btn btn-danger ms-2 me-4"
                style="width: 5rem;"
                onclick="allDel()"
        >
            删除
        </button>
    </div>
        <div>
            <table class="table">
                <thead>
                <tr>
                    <th>
                        <input
                                class="form-check-input"
                                type="checkbox"
                                value=""
                                id="selectAll"
                        />
                    </th>
                    <th>序号</th>
                    <th>ID</th>
                    <th>用户名</th>
                    <th>密码</th>
<%--                    <th>操作</th>--%>
                </tr>
                </thead>
                <tbody id="tb"></tbody>
            </table>
        </div>
    </div>

</body>
</html>
