var validator;
var $distributionAddForm = $("#distribution-form");
var $status = $("#distribution-form").find("input[name='status']");

$(function () {
    $status.change(function () {
        var checked = $(this).is(":checked");
        var $status_label = $("#distribution-form #status");
        if (checked) {
            $status_label.html('可用');
        } else {
            $status_label.html('禁用');
        }
    });

    $("#distribution .btn-save").click(function () {
        var validator = $distributionAddForm.validate();
        var flag = validator.form();
        if (flag) {
            var userIds = "";
            $('#distribution-form').find("input[name='userId']").each(function () {
                if ($(this).is(":checked")) {
                    userIds += $(this).val()+",";
                }
            });
            var passageId = $('#passagewayId').text();
            var status = $status.is(":checked");
            $.post(ctx + "passageway/distribution",
                {"userIds": userIds, "passageId": passageId, "status": status,"settlementRate":$('#settlementRate').val()},
                function (r) {
                    if (r.code === 0) {
                        $MB.n_success(r.msg);
                        $('#distribution').modal('hide');
                    } else $MB.n_danger(r.msg);
                });
        }
    });
});


function findNacs(passagewayId) {
    $.post(ctx + "user/getNacs", {"passagewayId": passagewayId}, function (r) {
        if (r.code === 0) {
            var users = r.msg;
            if (users.length > 0) {
                for (var i = 0; i < users.length; i++) {
                    var user = users[i];
                    var htmlStr = '<input type="checkbox" name="userId" value="' + user.userId + '">' + user.cname;
                    $("#channels").append(htmlStr + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;");
                }
            } else {
                $("#channels").append("<span>没有可以选择的渠道</span>");
            }
        } else $MB.n_danger(r.msg);
    });
}