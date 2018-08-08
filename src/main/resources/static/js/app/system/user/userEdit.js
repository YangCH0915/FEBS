function updateUser() {
    var selected = $("#userTable").bootstrapTable('getSelections');
    var selected_length = selected.length;
    if (!selected_length) {
        $MB.n_warning('请勾选需要修改的用户！');
        return;
    }
    if (selected_length > 1) {
        $MB.n_warning('一次只能修改一个用户！');
        return;
    }
    var userId = selected[0].userId;
    $.post(ctx + "user/getUser", {"userId": userId}, function (r) {
        if (r.code === 0) {
            var $form = $('#user-add');
            $form.modal();
            var user = r.msg;
            console.log("查询的用户："+user);
            $form.find(".user_password").hide();
            $("#user-add-modal-title").html('修改用户');
            $form.find("input[name='cname']").val(user.cname);
            $form.find("input[name='username']").val(user.username).attr("readonly", true);
            $form.find("input[name='userId']").val(user.userId);
            $form.find("input[name='mobile']").val(user.mobile);
            $form.find("input[name='description']").val(user.description);
            $form.find("input[name='dividePer']").val(user.dividePer);
            $form.find("input[name='accountName']").val(user.accountName);
            $form.find("input[name='bankAccount']").val(user.bankAccount);
            $form.find("input[name='openingBank']").val(user.openingBank);
            var roleArr = [];
            for (var i = 0; i < user.roleIds.length; i++) {
                roleArr.push(user.roleIds[i]);
            }
            $form.find("select[name='rolesSelect']").multipleSelect('setSelects', roleArr);
            $form.find("input[name='roles']").val($form.find("select[name='rolesSelect']").val());
            var $status = $form.find("input[name='status']");
            if (user.status === '1') {
                $status.prop("checked", true);
                $status.parent().next().html('可用');
            } else {
                $status.prop("checked", false);
                $status.parent().next().html('禁用');
            }
            $("#user-add-button").attr("name", "update");
        } else {
            $MB.n_danger(r.msg);
        }
    });
}