var validator;
var $userAddForm = $("#add-form");

$(function () {
    $("input[name='status']").change(function () {
        var checked = $(this).is(":checked");
        var $status_label = $("#status");
        if (checked) $status_label.html('可用');
        else $status_label.html('禁用');
    });

    $("#passageway-add .btn-save").click(function () {
        var name = $(this).attr("name");
        var validator = $userAddForm.validate();
        var flag = validator.form();
        if (flag) {
            if (name === "save") {
                $.post(ctx + "passageway/add", $userAddForm.fx_serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("passagewayTable");
                    } else $MB.n_danger(r.msg);
                });
            }
            if (name === "update") {
                $.post(ctx + "passageway/update", $userAddForm.fx_serialize(), function (r) {
                    if (r.code === 0) {
                        closeModal();
                        $MB.n_success(r.msg);
                        $MB.refreshTable("passagewayTable");
                    } else $MB.n_danger(r.msg);
                });
            }
        }
    });

    $("#passageway-add .btn-close").click(function () {
        closeModal();
    });

});

function closeModal() {
    $("#save-button").attr("name", "save");
    // validator.resetForm();
    // $rolesSelect.multipleSelect('setSelects', []);
    // $rolesSelect.multipleSelect("refresh");
    $userAddForm.find("input[name='status']").prop("checked", true);
    $("#add-modal-title").html('新增通道');
    $("#status").html('可用');
    $MB.closeAndRestModal("passageway-add");
}