function updatePassageway() {
    var selected = $("#passagewayTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的通道！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个通道！');
        return;
    }
    var id = selected[0].id;
    $.post(ctx + "passageway/getPassageway", {"id": id}, function (r) {
        if (r.code === 0) {
            var $form = $('#passageway-add');
            $form.modal();
            var passageway = r.msg;
            $("#add-modal-title").html('修改通道');
            $form.find("input[name='id']").val(passageway.id);
            $form.find("input[name='passagewayName']").val(passageway.passagewayName);
            $form.find("input[name='passagewayId']").val(passageway.passagewayId);
            $form.find("input[name='payId']").val(passageway.payId);
            $form.find("input[name='payKey']").val(passageway.payKey);
            $form.find("input[name='appId']").val(passageway.appId);
            $form.find("input[name='payType']").val(passageway.payType);
            $form.find("input[name='signType']").val(passageway.signType);
            $form.find("input[name='publicKey']").val(passageway.publicKey);
            // var roleArr = [];
            // for (var i = 0; i < user.roleIds.length; i++) {
            //     roleArr.push(user.roleIds[i]);
            // }
            // $form.find("select[name='rolesSelect']").multipleSelect('setSelects', roleArr);
            // $form.find("input[name='roles']").val($form.find("select[name='rolesSelect']").val());
            var $status = $form.find("input[name='state']");
            if (passageway.state) {
                $status.prop("checked", true);
                $status.parent().next().html('可用');
            } else {
                $status.prop("checked", false);
                $status.parent().next().html('禁用');
            }
            $("#save-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}