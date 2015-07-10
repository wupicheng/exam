<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<div class="header">

    <h1 class="page-title">新建用户</h1>
    <ul class="breadcrumb">
        <li><a href="index.html">Home</a></li>
        <li><a href="users.html">Users</a></li>
        <li class="active">jsmith</li>
    </ul>
</div>
<div class="main-content">

    <ul class="nav nav-tabs">
        <li class="active"><a href="#home" data-toggle="tab">基本信息</a></li>
        <li><a href="#profile" data-toggle="tab">详细信息</a></li>
    </ul>

    <div class="row">
        <div class="col-md-4">
            <br>

            <div id="myTabContent" class="tab-content">
                <div class="tab-pane active in" id="home">

                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h3 class="panel-title">账户信息</h3>
                        </div>
                        <div class="panel-body">
                            <form id="tab" class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">用户名</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="student_name" class="form-control"
                                               placeholder="请输入账户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">电话</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="student_phone_num" class="form-control"
                                               placeholder="请输入账户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">地址</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="addr" class="form-control" placeholder="请输入账户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">出生日期</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="student_birthday" class="form-control"
                                               placeholder="请输入账户名">
                                    </div>
                                </div>

                                <div  class="col-sm-2 col-sm-push-8">
                                    <div class="btn-toolbar list-toolbar">
                                        <button class="btn btn-primary "><i class="fa fa-save"></i>保存</button>
                                        <%--<a href="#myModal" data-toggle="modal" class="btn btn-danger">Delete</a>--%>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>
                </div>

                <div class="tab-pane fade" id="profile">
                    <div class="panel panel-default">

                        <div class="panel-heading">
                            <h3 class="panel-title">学生信息</h3>
                        </div>
                        <div class="panel-body">
                            <form id="tab2" class="form-horizontal">
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">学生姓名</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="student_name" class="form-control"
                                               placeholder="请输入账户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">班级</label>

                                        <div class="col-sm-8">
                                            <select class="form-control">
                                                <option>1</option>
                                                <option>1</option>
                                                <option>2</option>
                                                <option>3</option>
                                                <option>4</option>
                                                <option>5</option>
                                            </select>
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">地址</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="addr" class="form-control" placeholder="请输入账户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">出生日期</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="student_birthday" class="form-control"
                                               placeholder="请输入账户名">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label class="col-sm-4 control-label">Email</label>

                                    <div class="col-sm-8">
                                        <input type="text" name="student_email" class="form-control"
                                               placeholder="xx@xx.com">
                                    </div>
                                </div>
                                <div  class="col-sm-2 col-sm-push-8">
                                    <div class="btn-toolbar list-toolbar">
                                        <button class="btn btn-primary "><i class="fa fa-save"></i>保存</button>
                                        <%--<a href="#myModal" data-toggle="modal" class="btn btn-danger">Delete</a>--%>
                                    </div>
                                </div>

                            </form>
                        </div>
                    </div>




                </div>
            </div>


        </div>
    </div>

    <div class="modal small fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel"
         aria-hidden="true">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <button type="button" class="close" data-dismiss="modal" aria-hidden="true">×</button>
                    <h3 id="myModalLabel">Delete Confirmation</h3>
                </div>
                <div class="modal-body">

                    <p class="error-text"><i class="fa fa-warning modal-icon"></i>Are you sure you want to delete the
                        user?</p>
                </div>
                <div class="modal-footer">
                    <button class="btn btn-default" data-dismiss="modal" aria-hidden="true">Cancel</button>
                    <button class="btn btn-danger" data-dismiss="modal">Delete</button>
                </div>
            </div>
        </div>
    </div>


</div>
<script>
    $('#tab').bootstrapValidator({
//        live: 'disabled',
        message: '输入有误',
        feedbackIcons: {
            valid: 'glyphicon glyphicon-ok',
            invalid: 'glyphicon glyphicon-remove',
            validating: 'glyphicon glyphicon-refresh'
        },
        fields: {

            student_name: {
                message: '用户名有误',
                validators: {
                    notEmpty: {
                        message: '用户名不能为空'
                    },
                    stringLength: {
                        min: 6,
                        max: 30,
                        message: '用户名长度必须在6-30字符之间'
                    },
                    regexp: {
                        regexp: /^[a-zA-Z0-9_\.]+$/,
                        message: '用户名必须由数字字母下划线构成'
                    },
//                            remote: {
//                                url: 'remote.php',
//                                message: '用户名不存在'
//                            },
                    different: {
                        field: 'password',
                        message: '用户名不能与密码相同'
                    }
                }
            },
            student_email: {
                validators: {
                    emailAddress: {
                        message: 'Email地址不合法'
                    }
                }
            },
            student_birthday: {
                validators: {
                    notEmpty: {
                        message: '生日不能为空'
                    },
                    date: {
                        format: 'YYYY/MM/DD',
                        message: '日期格式不正确'
                    }
                }
            },
            student_sex: {
                validators: {
                    notEmpty: {
                        message: '性别是必选'
                    }
                }
            },
            student_phone_num: {
                message: '电话号码有误',
                validators: {
                    notEmpty: {
                        message: '电话号码不能为空'
                    },
                    stringLength: {
                        min: 11,
                        max: 11,
                        message: '电话号码为11位'
                    },
                    regexp: {
                        regexp: /^[0-9]+$/,
                        message: '用户名必须由数字字母下划线构成'
                    }

                }
            }

        }
    }).on('fail.form.bv', function (e) {
                // e.preventDefault();

            });

</script>
