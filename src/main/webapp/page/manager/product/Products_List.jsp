<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8"/>
    <meta name="renderer" content="webkit|ie-comp|ie-stand">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
    <meta name="viewport"
          content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
    <meta http-equiv="Cache-Control" content="no-siteapp"/>
    <link href="../../../assets/css/bootstrap.min.css" rel="stylesheet"/>
    <link rel="stylesheet" href="../../../css/style.css"/>
    <link rel="stylesheet" href="../../../assets/css/ace.min.css"/>
    <link rel="stylesheet" href="../../../assets/css/font-awesome.min.css"/>
    <link rel="stylesheet" href="../../../Widget/zTree/css/zTreeStyle/zTreeStyle.css" type="text/css">
    <link href="../../../Widget/icheck/icheck.css" rel="stylesheet" type="text/css"/>
    <!--[if IE 7]>
    <link rel="stylesheet" href="../../../assets/css/font-awesome-ie7.min.css"/>
    <![endif]-->
    <!--[if lte IE 8]>
    <link rel="stylesheet" href="../../../assets/css/ace-ie.min.css"/>
    <![endif]-->
    <script src="../../../js/manager/jquery-1.9.1.min.js"></script>
    <script src="../../../assets/js/bootstrap.min.js"></script>
    <script src="../../../assets/js/typeahead-bs2.min.js"></script>
    <!-- page specific plugin scripts -->
    <script src="../../../assets/js/jquery.dataTables.min.js"></script>
    <script src="../../../assets/js/jquery.dataTables.bootstrap.js"></script>
    <script type="text/javascript" src="../../../js/manager/H-ui.js"></script>
    <script type="text/javascript" src="../../../js/manager/H-ui.admin.js"></script>
    <script src="../../../assets/layer/layer.js" type="text/javascript"></script>
    <script src="../../../assets/laydate/laydate.js" type="text/javascript"></script>
    <script type="text/javascript" src="../../../Widget/zTree/js/jquery.ztree.all-3.5.min.js"></script>
    <script src="../../../js/manager/lrtk.js" type="text/javascript"></script>
    <title>????????????</title>
</head>
<body>
<div class=" page-content clearfix">
    <div id="products_style">
        <div class="search_style" style="display: none">

            <ul class="search_content clearfix">
                <li><label class="l_f">????????????</label><input name="" type="text" class="text_add" placeholder="??????????????????"
                                                          style=" width:250px"/></li>
                <li><label class="l_f">????????????</label><input class="inline laydate-icon" id="start"
                                                          style=" margin-left:10px;"></li>
                <li style="width:90px;">
                    <button type="button" class="btn_search"><i class="icon-search"></i>??????</button>
                </li>
            </ul>
        </div>
        <div class="border clearfix">
       <span class="l_f">
        <a href="/admin/product/product_add" title="????????????" class="btn btn-warning Order_form"><i
                class="icon-plus"></i>????????????</a>
       </span>
            <span class="r_f">??????<b>${fn:length(goods)}</b>?????????</span>
        </div>
        <!--??????????????????-->
        <div class="h_products_list clearfix" id="products_list">
            <div id="scrollsidebar" class="left_Treeview">
                <div class="show_btn" id="rightArrow"><span></span></div>
                <div class="widget-box side_content">
                    <div class="side_title"><a title="??????" class="close_btn"><span></span></a></div>
                    <div class="side_list">
                        <div class="widget-header header-color-green2"><h4 class="lighter smaller">??????????????????</h4></div>
                        <div class="widget-body">
                            <div class="widget-main padding-8">
                                <div id="treeDemo" class="ztree"></div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="table_menu_list" id="testIframe">
                <table class="table table-striped table-bordered table-hover" id="sample-table">
                    <thead>
                    <tr>
                        <th>????????????</th>
                        <th>????????????</th>
                        <th>??????</th>
                        <th>??????</th>
                        <th>??????</th>
                        <th>????????????</th>
                        <th>??????</th>
                        <th>??????</th>
                        <th>??????</th>
                    </tr>
                    </thead>
                    <tbody id="tbody">
                    <c:forEach items="${goods}" var="goods" varStatus="state">
                        <tr class="product ${goods.category.categoryId}">
                            <td width="25px"><label><input type="checkbox" class="ace"><span class="lbl"></span></label>
                            </td>
                            <td width="80px">${goods.goodsId}</td>
                            <td width="250px"><u style="cursor:pointer" class="text-primary"
                                                 onclick="">${goods.name}</u></td>
                            <td width="100px">${goods.unitPrice}</td>
                            <td width="100px">${goods.inventory}</td>
                            <td width="100px">${goods.saleCount}</td>
                            <td width="180px">${goods.onsaleTime}</td>
                            <td width="100px">
                                <c:forEach items="${goods.goodsAttrs}" var="attrs">
                                    ${attrs.name}:${attrs.value}<br/>
                                </c:forEach>
                            </td>
                            <td class="td-status">
                                <c:if test="${goods.status == 0}">
                                    <span class="label label-success radius">?????????</span></c:if>
                                <c:if test="${goods.status == 1}">
                                    <span class="label label-defaunt radius">?????????</span></c:if>
                            </td>
                            <td class="td-manage">
                                <c:if test="${goods.status == 0}">
                                    <a onClick="member_stop(this,${goods.goodsId})" href="javascript:;" title="??????"
                                       class="btn btn-xs btn-success"><i class="icon-ok bigger-120"></i></a>
                                </c:if>
                                <c:if test="${goods.status == 1}">
                                    <a onClick="member_start(this,${goods.goodsId})" href="javascript:;" title="??????"
                                       class="btn btn-xs btn-defaunt"><i class="icon-ok bigger-120"></i></a>
                                </c:if>

                                <a title="??????" onclick="member_edit('??????',${goods.goodsId},'4','','510')"
                                   href="javascript:;" class="btn btn-xs btn-info"><i class="icon-edit bigger-120"></i></a>
                                <a title="??????" href="javascript:;" onclick="member_del(this,${goods.goodsId})"
                                   class="btn btn-xs btn-warning"><i class="icon-trash  bigger-120"></i></a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
</div>
</body>
</html>
<script>


    var products = [];

    var add = [];
    <c:forEach items = "${goods}" var = "goods" varStatus="state">
    if (typeof (products[${goods.category.categoryId}]) == "undefined") {
        products[${goods.category.categoryId}] = [];
    }
    <%--console.log(typeof (products[${goods.category.categoryId}]))--%>
    add = {
        "????????????": "${goods.goodsId}",
        "????????????": "${goods.name}",
        "??????": "${goods.unitPrice}",
        "??????": "${goods.inventory}",
        "??????": "${goods.saleCount}",
        "????????????": "${goods.onsaleTime}",
        "??????":
            <c:forEach items="${goods.goodsAttrs}" var="attrs">
            "${attrs.name}:${attrs.value}<br/>" +
            </c:forEach>
            "",
        "??????":
            <c:if test="${goods.status == 0}">
            "<span class=\"label label-success radius\">?????????</span>",
        </c:if>
        <c:if test="${goods.status == 1}">
        "<span class=\"label label-defaunt radius\">?????????</span>",
        </c:if>

        "??????":
            <c:if test="${goods.status == 0}">
            "<a onClick=\"member_stop(this,${goods.goodsId})\"  href=\"javascript:;\" title=\"??????\"  class=\"btn btn-xs btn-success\"><i class=\"icon-ok bigger-120\"></i></a> <a title=\"??????\" onclick=\"member_edit('??????',${goods.goodsId},'4','','510')\" href=\"javascript:;\"  class=\"btn btn-xs btn-info\" ><i class=\"icon-edit bigger-120\"></i></a><a title=\"??????\" href=\"javascript:;\"  onclick=\"member_del(this,${goods.goodsId})\" class=\"btn btn-xs btn-warning\" ><i class=\"icon-trash  bigger-120\"></i></a>"
        </c:if>
        <c:if test="${goods.status == 1}">
        "<a onClick=\"member_start(this,${goods.goodsId})\"  href=\"javascript:;\" title=\"??????\"  class=\"btn btn-xs btn-defaunt\"><i class=\"icon-ok bigger-120\"></i></a> <a title=\"??????\" onclick=\"member_edit('??????',${goods.goodsId},'4','','510')\" href=\"javascript:;\"  class=\"btn btn-xs btn-info\" ><i class=\"icon-edit bigger-120\"></i></a><a title=\"??????\" href=\"javascript:;\"  onclick=\"member_del(this,${goods.goodsId})\" class=\"btn btn-xs btn-warning\" ><i class=\"icon-trash  bigger-120\"></i></a>"
        </c:if>

    }
    products[${goods.category.categoryId}].push(add);
    </c:forEach>

    //    console.log(products)

    function showCatagory(id) {
        var table = $('#sample-table').DataTable();
        table.destroy();
        $("#tbody").empty();
        $('#sample-table').DataTable({
            data: products[id],
            columns: [
                {data: "????????????", "width": "10%"},
                {data: "????????????", "width": "15%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "????????????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "15%"},
            ],
            "autoWidth": true,
            "aaSorting": [[1, "desc"]],//?????????????????????
            "bStateSave": true,//????????????
            "aoColumnDefs": [
                {"orderable": false, "aTargets": [0, 1, 6, 8]}// ????????????????????????
            ]
        });
    }

    showAll()

    function showAll() {
        var init = [];
        $.each(products, function (key, value) {
            if (typeof (value) != "undefined") {
                $.each(value, function (k, v) {
                    init.push(v)
                })
            }
        })
        var table = $('#sample-table').DataTable();
        table.destroy();
        $("#tbody").empty();
        $('#sample-table').DataTable({
            data: init,
            columns: [
                {data: "????????????", "width": "10%"},
                {data: "????????????", "width": "15%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "????????????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "10%"},
                {data: "??????", "width": "15%"},
            ],
            "aaSorting": [[1, "desc"]],//?????????????????????
            "bStateSave": true,//????????????
            "aoColumnDefs": [
                //{"bVisible": false, "aTargets": [ 3 ]} //????????????????????????
                {"orderable": false, "aTargets": [0, 1, 6, 8]}// ????????????????????????
            ]
        });
    }
</script>
<script type="text/javascript">
    //????????????????????????
    $(".widget-box").height($(window).height() - 215);
    $(".table_menu_list").width($(window).width() - 260);
    $(".table_menu_list").height($(window).height() - 215);
    //?????????????????????????????? ??????
    $(window).resize(function () {
        $(".widget-box").height($(window).height() - 215);
        $(".table_menu_list").width($(window).width() - 260);
        $(".table_menu_list").height($(window).height() - 215);
    })

    /*******?????????*******/
    var setting = {
        view: {
            dblClickExpand: false,
            showLine: false,
            selectedMulti: false
        },
        data: {
            simpleData: {
                enable: true,
                idKey: "id",
                pIdKey: "pId",
                rootPId: ""
            }
        },
        callback: {
//            beforeClick: function(treeId, treeNode) {
//                console.log(treeId);
//                console.log(treeId);
//                var zTree = $.fn.zTree.getZTreeObj("tree");
//                if (treeNode.isParent) {
//                    zTree.expandNode(treeNode);
//                    return false;
//                } else {
//                    demoIframe.attr("src",treeNode.file + ".html");
//                    return true;
//                }
//            }
        }
    };

    var zNodes = [
        {id: 1, pId: 0, name: "??????????????????", open: true, "click": "showAll()"},
        <c:forEach items = "${catalogList}" var = "catalogList" varStatus="state">
        {id: '1' + '${catalogList.key.catalog_id}', pId: 1, name: "${catalogList.key.name}"},
        <c:forEach items = "${catalogList.value}" var = "category" varStatus="state">
        {
            id: '2' + '${category.categoryId}',
            pId: '1' + '${catalogList.key.catalog_id}',
            name: "${category.name}",
            "click": "showCatagory(${category.categoryId})"
        },
        </c:forEach>
        </c:forEach>
    ];

    var code;

    function showCode(str) {
        if (!code) code = $("#code");
        code.empty();
        code.append("<li>" + str + "</li>");
    }

    $(document).ready(function () {

        var t = $("#treeDemo");
        t = $.fn.zTree.init(t, setting, zNodes);
        demoIframe = $("#testIframe");
        demoIframe.bind("load", loadReady);
        var zTree = $.fn.zTree.getZTreeObj("tree");
        zTree.selectNode(zTree.getNodeByParam("id", '11'));
    });

    /*??????-??????*/
    function member_stop(obj, id) {
        layer.confirm('?????????????????????', function (index) {
            statusChange(id, false);
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs " onClick="member_start(this,id)" href="javascript:;" title="??????"><i class="icon-ok bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-defaunt radius">?????????</span>');
            $(obj).remove();
            layer.msg('?????????!', {icon: 5, time: 1000});
        });
    }

    /*??????-??????*/
    function member_start(obj, id) {
        layer.confirm('?????????????????????', function (index) {
            statusChange(id, true);
            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" class="btn btn-xs btn-success" onClick="member_stop(this,id)" href="javascript:;" title="??????"><i class="icon-ok bigger-120"></i></a>');
            $(obj).parents("tr").find(".td-status").html('<span class="label label-success radius">?????????</span>');
            $(obj).remove();
            layer.msg('?????????!', {icon: 6, time: 1000});
        });
    }

    function statusChange(id, boolean) {
        $.ajax({
            url: '/admin/product/change_status',
            type: 'POST',
            dataType: "JSON",
            data: {status: boolean, id: id},
            success: function (data) {
                if (data.status) {
                    layer.msg("????????????", {icon: data.status, time: 1000}, function () {
                    });
                } else {
                    layer.msg("????????????", {icon: data.status, time: 1000}, function () {
                    });
                }
            }
        })
    }

    /*??????-??????*/
    function member_edit(title, url, id, w, h) {
        location = '/admin/product/product_add?id=' + url;
    }

    /*??????-??????*/
    function member_del(obj, id) {
        layer.confirm('?????????????????????', function (index) {
            $.ajax({
                url: '/admin/product/delete_good',
                type: 'POST',
                dataType: "JSON",
                data: {id: id},
                success: function (data) {
                    if (data.status) {
                        $(obj).parents("tr").remove();
                        layer.msg('?????????!', {icon: 1, time: 1000});
                    } else {
                        layer.msg("????????????", {icon: data.status, time: 1000}, function () {
                        });
                    }
                }
            })

        });
    }

    //??????????????????
    var index = parent.layer.getFrameIndex(window.name);
    parent.layer.iframeAuto(index);
    $('.Order_form').on('click', function () {
        var cname = $(this).attr("title");
        var chref = $(this).attr("href");
        var cnames = parent.$('.Current_page').html();
        var herf = parent.$("#iframe").attr("src");
        parent.$('#parentIframe').html(cname);
        parent.$('#iframe').attr("src", chref).ready();
        ;
        parent.$('#parentIframe').css("display", "inline-block");
        parent.$('.Current_page').attr({"name": herf, "href": "javascript:void(0)"}).css({
            "color": "#4c8fbd",
            "cursor": "pointer"
        });
        //parent.$('.Current_page').html("<a href='javascript:void(0)' name="+herf+" class='iframeurl'>" + cnames + "</a>");
        parent.layer.close(index);

    });
</script>
