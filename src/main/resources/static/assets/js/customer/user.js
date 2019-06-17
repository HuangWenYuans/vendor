$(function () {

//	订单页面  修改地址
    $(".edit").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });

    $(".bc>input").click(function () {
        if ($(this).val() == "保存") {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide();
        } else {
            $(".mask").hide();
            $(".adddz").hide();
            $(".bj").hide();
            $(".xg").hide();
            $(".remima").hide();
            $(".pj").hide();
            $(".chak").hide();
        }
    });


//	我的订单tab切换
    $("#wa li").click(function () {
        //点击哪个li就给哪个li添加on类，并移除其他li的on类
        $(this).addClass("on").siblings().removeClass("on");
        //点击哪个li就找到哪个a标签中的文本
        var txt1 = $(this).find("a").text();
        $(".dkuang").find("p.one").each(function () {
            var txt2 = $(this).text();
            if (txt1 === txt2) {
                //去除其他类型不一样的数据
                $(this).parent(".dkuang").show().siblings(".dkuang").hide();
                // $(this).parent(".dkuang").show();
                // $(".dkuang").attr('style', 'display: block ');
            }
            $("#wa li").eq(0).click(function () {
                $(".dkuang").show();
            });
            //
            // $("#wa li").eq(1).click(function () {
            //     $(".dkuang").attr('style', 'display: block ');
            // });
            // $("#wa li").eq(2).click(function () {
            //     $(".dkuang").attr('style', 'display: block ');
            // });
            // $("#wa li").eq(3).click(function () {
            //     $(".dkuang").attr('style', 'display: block ');
            // });
        });

    });


//	个人信息 编辑
    $("#edit1").click(function () {
        $(".mask").show();
        $(".bj").show();
    });
    $("#edit2").click(function () {
        $(".mask").show();
        $(".xg").show();
    });

//修改头像
    $("#avatar").click(function () {
        $(".mask").show();
        $(".avatar").show();
    });

//	弹框关闭按钮
    $(".gb").click(function () {
        $(".mask").hide();
        $(".bj").hide();
        $(".xg").hide();
        $(".remima").hide();
        $(".avatar").hide();
        $(".pj").hide();
        $(".chak").hide();
    });


//	address
    $("#addxad").click(function () {
        $(".mask").show();
        $(".adddz").show();
    });
    $("#dizhi").hover(function () {
        var txt = "";
        txt = '<p class="addp"><a href="#"  id="readd">修改</a><a href="#" id="deladd">删除</a></p>'
        $(this).append(txt);
        $("#readd").click(function () {
            $(".mask").show();
            $(".readd").show();
        });
        $("#deladd").click(function () {
            $(this).parents("#dizhi").remove();
        });
    }, function () {
        $(".bc>input").click(function () {
            if ($(this).val() == "保存") {
                $(".mask").hide();
                $(".readd").hide();
            } else {
                $(".mask").hide();
                $(".readd").hide();
            }
        });
        $(".addp").remove();
    });

//	查看物流
    $(".vewwl").hover(function () {
        $(this).children(".wuliu").fadeIn(100);
    }, function () {
        $(this).children(".wuliu").fadeOut(100);
    });

});
