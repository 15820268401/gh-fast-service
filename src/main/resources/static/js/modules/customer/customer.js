$(function () {
    var hasPer = hasPermission("customer:user:update");
    $("#jqGrid").jqGrid({
        url: baseURL + 'customer/user/list',
        datatype: "json",
        colModel: [
            {label: '用户ID', name: 'id', width: 45, key: true},
            {
                label: '用户名', name: 'aliasname', width: 75, formatter: function (value, options, row) {
                var result = "";
                if (hasPer) {
                    result = "<a onclick='vm.update(" + row.id + ")' style='cursor:pointer;'>" + row.aliasname + "</a>";
                } else {
                    result = row.aliasname;
                }
                return result;
            }
            },
            // {label: '手机号', name: 'phone', width: 100},
            // {label: '数据上传时间', name: 'uploadTime', index: "upload_time", width: 100},
            // {label: '数据下发时间', name: 'downloadTime', index: "download_time", width: 100},
            // {label: '创建时间', name: 'createrTime', index: "creater_time", width: 80},
            {
                label: '客户等级',
                name: 'clientGrade',
                index: "client_grade",
                width: 100,
                formatter: function (value, options, row) {
                    var result = '';
                    if (value == 1) {
                        result = '<span class="label label-default">★★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-success">★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">无星</span>';
                    } else if (value == 2) {
                        result = '<span class="label label-default">★★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-success">★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">无星</span>';
                    } else if (value == 3) {
                        result = '<span class="label label-default">★★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-success">★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">无星</span>';
                    } else if (value == 4) {
                        result = '<span class="label label-success">★★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">无星</span>';
                    } else {
                        result = '<span class="label label-default">★★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★★</span>&nbsp;&nbsp;' +
                            '<span class="label label-default">★</span>&nbsp;&nbsp;' +
                            '<span class="label label-success">无星</span>';
                    }
                    return result;
                }
            }

        ],
        viewrecords: true,
        height: 385,
        rowNum: 10,
        rowList: [10, 30, 50],
        rownumbers: true,
        rownumWidth: 25,
        autowidth: true,
        multiselect: true,
        pager: "#jqGridPager",
        jsonReader: {
            root: "page.list",
            page: "page.currPage",
            total: "page.totalPage",
            records: "page.totalCount"
        },
        prmNames: {
            page: "page",
            rows: "limit",
            order: "order"
        },
        gridComplete: function () {
            //隐藏grid底部滚动条
            $("#jqGrid").closest(".ui-jqgrid-bdiv").css({"overflow-x": "hidden"});
            $("#jqGrid").setGridParam().hideCol("id");
            // $("#jqGrid").setGridParam().hideCol("phone");
            // $("#jqGrid").setGridParam().hideCol("uploadTime");
            // $("#jqGrid").setGridParam().hideCol("downloadTime");
            // $("#jqGrid").setGridParam().hideCol("createrTime");
        }
    });
});

var vm = new Vue({
    el: '#rrapp',
    data: {
        q: {
            aliasname: null
            // phone: null
        },
        showList: true,
        title: "新增",
        customer: {}
    },
    methods: {
        query: function () {
            vm.reload();
        },
        resetQuery: function () {
            vm.q.aliasname = null;
            // vm.q.phone = null;
            vm.reload();
        },
        add: function () {
            vm.showList = false;
            vm.title = "新增";
            vm.customer = {};
        },
        update: function (id) {
            // var id = getSelectedRow();
            if (id == null) {
                return;
            }

            vm.showList = false;
            vm.title = "修改";

            vm.getCustomer(id);
        },
        uploadData: function () {
            var customerIds = getSelectedRows();
            if (customerIds == null) {
                return;
            }

            confirm("确认要上传选中的数据吗？", function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "customer/user/uploadData",
                    contentType: "application/json",
                    data: JSON.stringify(customerIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        del: function () {
            var customerIds = getSelectedRows();
            if (customerIds == null) {
                return;
            }
            confirm('确定要删除选中的记录？', function () {
                $.ajax({
                    type: "POST",
                    url: baseURL + "customer/user/delete",
                    contentType: "application/json",
                    data: JSON.stringify(customerIds),
                    success: function (r) {
                        if (r.code == 0) {
                            alert('操作成功', function () {
                                vm.reload();
                            });
                        } else {
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function () {
            if (vm.validator()) {
                return;
            }
            var url = vm.customer.id == null ? "customer/user/save" : "customer/user/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.customer),
                success: function (r) {
                    if (r.code === 0) {
                        alert('操作成功', function () {
                            vm.reload();
                        });
                    } else {
                        alert(r.msg);
                    }
                }
            });
        },
        getCustomer: function (id) {
            $.get(baseURL + "customer/user/info/" + id, function (r) {
                vm.customer = r.customer;
            });
        },
        reload: function () {
            vm.showList = true;
            var page = $("#jqGrid").jqGrid('getGridParam', 'page');
            $("#jqGrid").jqGrid('setGridParam', {
                postData: {/*'phone': vm.q.phone,*/ 'aliasname': vm.q.aliasname},
                page: page
            }).trigger("reloadGrid");
        },
        validator: function () {
            if (isBlank(vm.customer.aliasname)) {
                alert("姓名不能为空！");
                return true;
            }
        }
    }
});