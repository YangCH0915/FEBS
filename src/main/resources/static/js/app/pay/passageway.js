$(function () {
    var $userTableForm = $(".passageway-table-form");
    var settings = {
        url: ctx + "passageway/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                passagewayName: $userTableForm.find("input[name='passagewayName']").val().trim(),
                username: $userTableForm.find("input[name='payId']").val().trim(),
                status: $userTableForm.find("select[name='status']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            visible: false
        }, {
            field: 'passagewayName',
            title: '通道名称'
        }, {
            field: 'passagewayId',
            title: '通道标识'
        }, {
            field: 'payId',
            title: '支付商户号'
        }, {
            field: 'payKey',
            title: '支付秘钥'
        }, {
            field: 'payType',
            title: '支付类型'
        }, {
            field: 'signType',
            title: '签名类型'
        }, {
            field: 'publicKey',
            title: '平台公钥'
        }, {
            field: 'appId',
            title: 'appId'
        }, {
            field: 'createTime',
            title: '创建时间'
        }, {
            field: 'modifyTime',
            title: '修改时间'
        }, {
            field: 'state',
            title: '状态',
            formatter: function (value, row, index) {
                if (value) return '<span class="badge badge-success">有效</span>';
               return '<span class="badge badge-warning">锁定</span>';
            }
        }, {
            title: '操作',
            formatter: function (value, row, index) {
                return "<a href='#' data-toggle='modal' " +
                    "onclick='distribution(\"" + row.passagewayId + "\",\"" + row.status + "\",\"" + row.passagewayName + "\")'>分配</a>";
            }
        }]
    };
    $MB.initTable('passagewayTable', settings);
});

function search() {
    $MB.refreshTable('passagewayTable');
}

function refresh() {
    $(".passageway-table-form")[0].reset();
    $MB.refreshTable('passagewayTable');
}

function deletePassageway() {
    var selected = $("#passagewayTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要删除的用户！');
        return;
    }
    var ids = "";
    for (var i = 0; i < selected_length; i++) {
        ids += selected[i].passagewayId;
        if (i !== (selected_length - 1)) ids += ",";
    }

    $MB.confirm({
        text: "确定删除选中用户？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'passageway/delete', {"ids": ids}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function distribution(id, status,passagewayName) {
    if (status === "false") {
        $MB.n_warning("该通道已停用！！");
        return;
    }
    $("#passagewayName").html(passagewayName);
    $("#passagewayId").html(id);
    //查找该通道未绑定的渠道
    findNacs(id);
    //显示弹窗
    $('#distribution').modal('show');
    //监听关闭弹窗，清除数据
    $("#distribution").on("hidden.bs.modal", function () {
        $("#channels").empty();
        $("#settlementRate").val("");
        $("#distribution-form").find("input[name='status']").prop("checked", true);
    });
}
