<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>新增</title>
    <meta name="renderer" content="webkit">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
    <link rel="stylesheet" type="text/css" href="/js/layui/css/layui.css">
    <link rel="stylesheet" type="text/css" href="/js/layui/css/public.css">
    <style>
        body {
            background-color: #ffffff;
        }
    </style>
</head>
<body>
<div class="layui-form layuimini-form">
    <div class="layui-form-item">
        <label class="layui-form-label required">姓名</label>
        <div class="layui-input-block">
            <input type="text" name="name" lay-verify="required" lay-reqtext="姓名" placeholder="请输入姓名" value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">地址</label>
        <div class="layui-input-block">
            <input type="text" name="address" lay-verify="required" lay-reqtext="地址" placeholder="请输入地址" value="" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label required">电话</label>
        <div class="layui-input-block">
            <input type="number" name="phone" lay-verify="required" lay-reqtext="手机不能为空" placeholder="请输入手机" value="" class="layui-input">
        </div>
    </div>

    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="saveBtn">确认保存</button>
        </div>
    </div>
</div>
<script src="/js/layui/layui.js" charset="utf-8"></script>
<script src="/js/jquery.min.js" charset="utf-8"></script>

<script>
    layui.use(['form'], function () {
        var form = layui.form,
            layer = layui.layer;

        //监听提交
        form.on('submit(saveBtn)', function (data) {

            $.ajax({
                //请求方式
                type : "POST",
                //请求的媒体类型
                contentType: "application/json;charset=UTF-8",
                //请求地址
                url:"/resumer/add",
                //数据，json字符串
                data : JSON.stringify(data.field),
                //请求成功
                success : function(result) {
                    console.log(result);
                },
                //请求失败，包含具体的错误信息
                error : function(e){
                    console.log(e.status);
                    console.log(e.responseText);
                }
            });
            var index=parent.layer.getFrameIndex(window.name);//获取当前弹出层的层级
            window.parent.location.reload();//刷新父页面
            parent.layer.close(index);//关闭弹出层
            return false;
        });

    });
</script>
</body>
</html>
