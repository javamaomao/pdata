<!DOCTYPE html>
<html lang="en">
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <!-- Meta, title, CSS, favicons, etc. -->
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <meta name="viewport" content="width=device-width, initial-scale=1">

  <title>Gentelella Alela! | </title>

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
            <h3>${tableName}列表 <small>这里可以对${tableName}进行管理</small></h3>
          </div>

          <div class="title_right">
            <div class="col-md-5 col-sm-5 col-xs-12 form-group pull-right top_search">
              <div class="input-group">
                <input type="text" class="form-control" placeholder="关键字">
                <span class="input-group-btn">
                      <button class="btn btn-default" type="button">搜索!</button>
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
                <h2>增加${tableName} <small></small></h2>
                <ul class="nav navbar-right panel_toolbox">
                  <li></li>
                  <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                  </li>
                  <li><a class="close-link"><i class="fa fa-close"></i></a>
                  </li>
                </ul>
                <div class="clearfix"></div>
              </div>
              <div class="x_content">

                <br />
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


        </div>
      </div>
    </div>
    <!-- /page content -->

    <!-- footer content -->
    <footer>
      <div class="pull-right">
        Gentelella - Bootstrap Admin Template by Colorlib. More Templates <a href="/http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="/http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a>
      </div>
      <div class="clearfix"></div>
    </footer>
    <!-- /footer content -->
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
</body>
</html>