$(function () {
    var $mchTableForm = $(".mch-table-form");
    var settings = {
        url: ctx + "mchInfo/list",
        pageSize: 10,
        queryParams: function (params) {
            return {
                pageSize: params.limit,
                pageNum: params.offset / params.limit + 1,
                mchId: $mchTableForm.find("#mchId").val(),
                cname: $mchTableForm.find("#cname").val(),
                status: $mchTableForm.find("select[name='status']").val()
            };
        },
        columns: [{
            checkbox: true
        }, {
            field: 'id',
            visible: false
        }, {
            field: 'channel.cname',
            title: '渠道名称'
        }, {
            field: 'mchId',
            title: '商户号'
        }, {
            field: 'mchKey',
            title: '商户秘钥'
        }, {
            title: '分配的通道',
            formatter: function (value, row, index) {
                var passageways = row.passageways;
                if (passageways.length > 0) {
                    var passHtml = "";
                    for (var i = 0; i < passageways.length; i++) {
                        var p = passageways[i];
                        var open = '锁定';
                        var statusColor = 'red';
                        if (p.open) {
                            open = "正常";
                            statusColor = 'blue';
                        }
                        passHtml += "<span>" + p.passagewayName + "&nbsp;(" + p.payType + ")" +
                            "&nbsp;&nbsp;&nbsp;&nbsp;费率:" + p.settlementRate + "</span>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a href='#' style='color: " + statusColor + "'" +
                            " onclick='changeState(" + row.mchId + "," + p.passagewayId + "," + p.open + ")'>" +
                            open +
                            "</a>&nbsp;&nbsp;&nbsp;&nbsp;" +
                            "<a href='#'onclick='deletePassageway(" + row.mchId + "," + p.passagewayId + ")'>解除</a><br>";
                    }
                    return passHtml;
                }
            }
        }, {
            field: 'status',
            title: '状态',
            formatter: function (value, row, index) {
                if (value == true) return '<span class="badge badge-success">有效</span>';
                if (value == false) return '<span class="badge badge-warning">锁定</span>';
            }
        }
        ]
    };
    $MB.initTable('mchTable', settings);
});

function search() {
    $MB.refreshTable('mchTable');
}

function refresh() {
    $(".mch-table-form")[0].reset();
    $MB.refreshTable('mchTable');
}

function deleteMchInfo() {
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

function deletePassageway(mchId,passagewayId) {
    $MB.confirm({
        text: "确定删除此通道？",
        confirmButtonText: "确定删除"
    }, function () {
        $.post(ctx + 'mchInfo/delete', {"mchId": mchId,"passagewayId":passagewayId}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}

function changeState(mchId,passagewayId, valid) {
    var showMsg = "";
    if (valid) {
        valid = false;
        showMsg = "确认要停止该通道";
    } else {
        valid = true;
        showMsg = "确认开启该通道";
    }
    $MB.confirm({
        text: showMsg,
        confirmButtonText: "确定"
    }, function () {
        $.post(ctx + 'mchInfo/changeState', {"mchId": mchId, "passagewayId": passagewayId, "valid": valid}, function (r) {
            if (r.code === 0) {
                $MB.n_success(r.msg);
                refresh();
            } else {
                $MB.n_danger(r.msg);
            }
        });
    });
}
