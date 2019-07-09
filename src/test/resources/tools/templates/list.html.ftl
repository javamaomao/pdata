<!DOCTYPE html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>私域数据 | </title>

    <!-- Bootstrap -->
    <link href="/assets/vendors/bootstrap/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Font Awesome -->
    <link href="/assets/vendors/font-awesome/css/font-awesome.min.css" rel="stylesheet">
    <!-- NProgress -->
    <link href="/assets/vendors/nprogress/nprogress.css" rel="stylesheet">
    <!-- iCheck -->
    <link href="/assets/vendors/iCheck/skins/flat/green.css" rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="/assets/css/custom.min.css" rel="stylesheet">

</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">
        <div th:replace="common::left_col"></div>

        <!-- top navigation -->
        <div th:replace="common::top_nav"></div>
        <!-- /top navigation -->

        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">
                <div class="page-title">
                    <div class="title_left">
                        <h3>管理员列表
                            <small>这里可以对管理员进行管理</small>
                        </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="关键字">
                                <span class="input-group-btn">
<button class="btn btn-default" type="button">搜索</button>
</span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12 col-sm-12 col-xs-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>管理员列表
                                    <small>所有管理员</small>
                                </h2>
                                <ul class="nav navbar-right panel_toolbox">
                                    <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                    </li>
                                    <li><a class="close-link"><i class="fa fa-close"></i></a>
                                    </li>
                                </ul>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <table class="table">
                                    <thead>
                                    <tr>
                                        <#list fieldMapList as item>
                                        <th>${item.keyName}</th>
                                        </#list>

                                    </tr>
                                    </thead>
                                    <tbody>
                                    <tr th:each="item: ${r'${datas}'}" th:data-id="*{item.id}">
                                        <#list fieldMapList as item>
                                        <td th:text="*{item.${item.keyId}}">${item.keyName}</td>
                                        </#list>

                                        <td>
                                            <button class="btn btn-info btn-modify-item">修改</button>
                                            <button class="btn btn-danger btn-delete-item">删除</button>
                                        </td>
                                    </tr>
                                    </tbody>
                                    <tfoot>
                                    <tr>
                                        <td colspan="7">
                                            <p class="text-muted">
                                                <span class="page-link" th:text="${r"${' 当前是第' + datas.pageNum.toString() +'页，一共有'+ datas.pages+'页,一共有 '+ datas.total.toString() + '个用户'}"}"></span></p>

                                            <div class="btn-group">
                                                <a class="btn btn-default" type="button" th:href="${r"${'?page='+(datas.pageNum-1).toString()}"}">&laquo;</a>
                                                <a class="btn btn-default" type="button" th:each="i: ${r"${#numbers.sequence(1,datas.pages)}"}" th:classappend="${r"${datas.pageNum==i?'btn-danger':'btn-default'}"}" th:text="*{i}" th:href="${r"${'?page='+i.toString()}"}">1</a>
                                                <a class="btn btn-default" type="button"  th:href="${r"'?page='+(datas.pageNum+1).toString()}"}">&raquo;</a>
                                                <div class="btn-group">
                                                    <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button"> 选择其他页 <span class="caret"></span> </button>
                                                    <ul class="dropdown-menu">
                                                        <li th:each="i: ${r'${#numbers.sequence(1,datas.pages)}'}" th:classappend="${r"${datas.pageNum==i?'':''}"}"><a th:href="*{'?page='+i}"  th:text="*{i}">Dropdown link 1</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                            </div>
                                        </td>
                                    </tr>
                                    </tfoot>
                                </table>

                                <div>
                                    <button type="button" class="btn btn-success" id="btn-add-admin">增加用户
                                    </button>
                                </div>
                            </div>
                        </div>
                    </div>


                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer th:replace="common::footer"></footer>
        <!-- /footer content -->
    </div>
</div>

<!-- Large modal -->

<div class="modal fade" id="add-admin-modal" tabindex="-1" role="dialog" aria-hidden="true">
    <div class="modal-dialog modal-lg">
        <div class="modal-content">
            <form id="add-form" data-parsley-validate class="form-horizontal form-label-left" action="/${tableId}/add_save" method="post" th:object="${r'${'}${tableId}${r'}'}">
                <#list fieldMapList as item>
                    <div class="form-group">
                        <label class="control-label col-md-3 col-sm-3 col-xs-12" for="${item["keyId"]}">${item["keyName"]} <span class="required">*</span>
                        </label>
                        <div class="col-md-6 col-sm-6 col-xs-12">
                            <input type="text" id="${item["keyId"]}" name="${item["keyId"]}" th:value="*{${item["keyId"]}}" required="required" class="form-control col-md-7 col-xs-12">
                        </div>
                    </div>
                </#list>
                <div class="ln_solid"></div>
                <div class="form-group">
                    <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                        <button class="btn btn-primary" type="reset">重置</button>
                        <button type="submit" class="btn btn-success">提交</button>
                    </div>
                </div>

            </form>
        </div>
    </div>
</div>

<!-- jQuery -->
<script src="/assets/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="/assets/vendors/bootstrap/dist/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="/assets/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="/assets/vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="/assets/vendors/iCheck/icheck.min.js"></script>

<!-- Custom Theme Scripts -->
<script src="/assets/js/custom.min.js"></script>

<script src="https://cdn.bootcss.com/sweetalert/2.1.2/sweetalert.min.js"></script>

<script>
    $(document).ready(function() {
        //
        const $addAdminModal = $('#add-admin-modal');

        // 增加管理员信息
        $("#btn-add-admin").click(function(){
            $addAdminModal.data("edit_mode", false);
            $addAdminModal.modal();
        });

        // 提交表单
        $("#btn-add-admin-submit").click(function () {
            const formData = $('#add-form').serialize();
            const url = $addAdminModal.data("url");
            $.ajax({
                type: "POST",
                dataType: "json",
                url: url,
                data: formData,
                success: function (result) {
                    if (result.result === "ok") {
                        $('#add-admin-modal').modal('hide');//隐藏modal
                        location.reload();
                    } else {
                        alert("数据保存失败," + result.msg)
                    }
                },
                error: function(data) {
                    alert("error:"+data.responseText);
                }
            });
        });

        // 修改管理员信息
        $(".btn-modify-item").click(function () {
            $id = $(this).closest('tr').attr("data-id");
            $.get({dataType: "json",
                url: "get_info?id=" + $id,
                success: function(result){
                    //
                    if (result == null) {
                        alert("失败了");
                    } else {
                        // alert(JSON.stringify(result));
                        $("#add-form").find("#userId").val(result.userId);
                        $addAdminModal.data("edit_mode", true);
                        $addAdminModal.modal({show: true}, result);

                    }
                },
                error: function(data){

                }
            })
        });

        // 绑定弹框显示事件
        $addAdminModal.on('show.bs.modal', function (event) {
            $editMode = $('#add-admin-modal').data("edit_mode");
            if ($editMode === true) {
                $addAdminModal.data("url", "edit_save");
                //
                $addAdminModal.find(".modal-title").text("修改用户");

                const target = event.relatedTarget; //触发事件的对象

                const modal = $(this);  //当前模态框
                modal.find('#id').val(target.id);
                modal.find('#userId').val(target.userId);
                modal.find('#userName').val(target.userName);
                modal.find('#tel').val(target.tel);
                modal.find('#userPassword').val("");
                modal.find('#groupId').val(target.groupId);
                modal.find('#userPassword').attr("placeholder", "不修改密码请留空");

            } else {
                $addAdminModal.data("url", "add_save");
                //
                $addAdminModal.find(".modal-title").text("增加用户");
                //
                const modal = $(this);  //当前模态框
                modal.find('#id').val("");
                modal.find('#userId').val("");
                modal.find('#userName').val("");
                modal.find('#userPassword').val("");
                modal.find('#userPassword').attr("placeholder", "请输入密码");
                modal.find('#tel').val("");
            }

            //modal.find('#sex').val(btnThis.sex);
            // var modalId = btnThis.data('id');   //解析出data-id的内容
            // var content = btnThis.closest('tr').find('td').eq(2).text();
            // modal.find('.content').val(content);
        });

        // 删除管理员信息
        $(".btn-delete-item").click(function () {
            swal("您确实要删除吗?", {
                icon: "warning",
                dangerMode: true,
                buttons: ["取消", "确认"],
            })
                .then( (value) => {
                    if (value === true) {
                        $id = $(this).closest('tr').attr("data-id");
                        location.href="/admin/del?id=" + $id;
                    }
                })
            ;
            //swal( "删除确认" ,  "您确实要删除吗？" ,  "error" );
        });


    });

</script>
</body>
</html>