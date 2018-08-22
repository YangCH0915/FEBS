$(function () {
    var $orderTableForm = $(".order-table-form");
    var settings = {
        url: ctx + "order/list",
        pageSize: 15,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                username: $orderTableForm.find("input[name='username']").val().trim(),
                status: $orderTableForm.find("select[name='status']").val()
            };
        },
        columns: [{
            field: 'id',
            title: '订单ID'
        }, {
            field: 'cname',
            title: '渠道名称'
        }, {
            field: 'passagewayName',
            title: '支付通道'
        }, {
            field:'mchId',
            title:'商户号'
        }, {
            field: 'orderNo',
            title: '订单号'
        }, {
            field: 'tradeNo',
            title: '平台订单号'
        }, {
            field: 'payType',
            title: '支付类型'
        }, {
            field: 'amount',
            title: '金额'
        }, {
            field: 'createTime',
            title: '创建时间'
        }, {
            field: 'userIp',
            title: '用户IP'
        }, {
            field: 'status',
            title: '支付状态',
            formatter: function (value, row, index) {
                if (value) return '<span class="badge badge-success">有效</span>';
                return '<span class="badge badge-warning">锁定</span>';
            }
        },{
            field: 'callbackStatus',
            title: '同步状态',
            formatter: function (value, row, index) {
                if (value) return '<span class="badge badge-success">有效</span>';
                return '<span class="badge badge-warning">锁定</span>';
            }
        }
        ]
    };
    $MB.initTable('orderTable', settings);
});

function search() {
    $MB.refreshTable('orderTable');
}

function refresh() {
    $(".order-table-form")[0].reset();
    $MB.refreshTable('orderTable');
}

function deleteUsers() {
    var selected = $("#userTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    var contain = false;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].userId;
        if (i !== (selected_length - 1)) ids += ",";
        if (userName === selected[i].username) contain = true;
    }
    if (contain) {
        $MB.n_warning('勾选用户中包含当前登录用户，无法删除！');
        return;
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'user/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function exportUserExcel() {
    $.post(ctx + "user/excel", $(".user-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}

function exportUserCsv() {
    $.post(ctx + "user/csv", $(".user-table-form").serialize(), function (r) {
        if (r.code === 0) {
            window.location.href = "common/download?fileName=" + r.msg + "&delete=" + true;
        } else {
            $MB.n_warning(r.msg);
        }
    });
}