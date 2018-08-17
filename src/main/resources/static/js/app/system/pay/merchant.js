$(function () {
    var $userTableForm = $(".passageway-table-form");
    var settings = {
        url: ctx + "passageway/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                status: $userTableForm.find("select[name='status']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            visible: false
        }, {
            field: 'cname',
            title: '渠道名称'
        }, {
            field: 'mchId',
            title: '商户号'
        }, {
            field: 'mchKey',
            title: '商户秘钥'
        }, {
            title: '操作',
            formatter: function (value, row, index) {
                return "<a href='#' data-toggle='modal' " +
                    "onclick='distribution(\"" + row.passagewayId + "\",\"" + row.status + "\",\"" + row.passagewayName + "\")'></a>";
            }
        }, {
            field: 'status',
            title: '状态',
            formatter: function (value, row, index) {
                if (value == true) return '<span class="badge badge-success">有效</span>';
                if (value == false) return '<span class="badge badge-warning">锁定</span>';
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
