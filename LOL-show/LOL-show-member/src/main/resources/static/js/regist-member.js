function setBtn(){
        let numCode = $("#codeText").val();
        if(numCode.length == 4 && window.passwordSize && window.passwordProof){
            $("#registBtn").prop("disabled",false);
        }else{
            $("#registBtn").prop("disabled",true);
        }
}

function verfiyDetail() {
    // 判断是否为空
    if($("#password").val() == "") {
        $("#verPassword").attr("class", "cr");
        $("#verPassword").html("密码不一致");
        window.passwordProof = false;
        // 为空直接返回，跳过比较
        return;
    }
    // 不为空则比较
    let text = $("#verfiyPassword").val();
    let password = $("#password").val();
    if(password == text){
        $("#verPassword").attr("class","normal");
        $("#verPassword").html("密码正确");
        window.passwordProof = true;
    }else{
        $("#verPassword").attr("class","cr");
        $("#verPassword").html("密码不一致");
        window.passwordProof = false;
    }
    setBtn()
}
function verfiyPassword(){
    $("#verfiyPassword").on("input",function () {
        // 初始化
        if($(this).val() == ""){
            $("#verPassword").attr("class","cr");
            $("#verPassword").html("密码不一致");
            window.passwordProof = false;
            return;
        }
        $("#verPassword").attr("class","cr");
        $("#verPassword").html("密码不一致");
        window.passwordProof = false;
        verfiyDetail();
    });
}

function fillBar(number) {
    // 清空
    $("#processBar").attr("class","");
    switch (number) {
        case 1: {
            $("#processBar").attr("class","progress-bar progress-bar-danger");
            $("#processBar").attr("aria-valuenow","25");
            $("#processBar").attr("style","width: 25%");
            $("#tmpP").html("密码强度：  弱")
        } break;
        case 2: {
            $("#processBar").attr("class","progress-bar progress-bar-warning");
            $("#processBar").attr("aria-valuenow","50");
            $("#processBar").attr("style","width: 50%");
            $("#tmpP").html("密码强度：  较弱")
        } break;
        case 3: {
            $("#processBar").attr("class","progress-bar progress-bar-info");
            $("#processBar").attr("aria-valuenow","75");
            $("#processBar").attr("style","width: 75%");
            $("#tmpP").html("密码强度：  较强")
        } break;
        case 4: {
            $("#processBar").attr("class","progress-bar progress-bar-success");
            $("#processBar").attr("aria-valuenow","100");
            $("#processBar").attr("style","width: 100%");
            $("#tmpP").html("密码强度：  强")
        } break;
    }
}
function judgeStrength(text){
    let length = text.length;
    // 判断密码长度是否大于6位
    if(length < 6){
        $("#tmpP").html("密码至少由6位数组成")
        $("#processBar").attr("class","progress-bar progress-bar-danger");
        $("#processBar").attr("aria-valuenow","25");
        $("#processBar").attr("style","width: 25%");
        return ;
    }
    window.passwordSize = true;
    // 是否有数字
    let numIf = false;
    // 是否有英文字母
    let eWordIf = false;
    // 是否有大写字母
    let upperEWordIf = false;
    // 是否有特殊字符
    let specialWord = false;
    let strength = 0;
    for(let i = 0 ; i < length ; i++){
        let tmp = text[i];
        if(tmp >= 'a' && tmp <= 'z'){
            eWordIf = true;
        }else if(tmp >= '0' && tmp <= '9'){
            numIf = true;
        }else if(tmp >= 'A' && tmp <= 'Z'){
            upperEWordIf = true;
        }else{
            specialWord = true;
        }
    }
    strength += numIf == true ? 1 : 0;
    strength += eWordIf == true ? 1 : 0;
    strength += upperEWordIf == true ? 1 : 0;
    strength += specialWord == true ? 1 : 0;
    return strength
}
function initBar(text){
    // 判断text是否为空
    if(text != ''){
        $("#tmpP").attr("class","normal");
        // 判断输入的text的强度
        let number = judgeStrength(text);
        fillBar(number);
    }else {
        $("#processBar").attr("aria-valuenow","0");
        $("#processBar").attr("style","width: 0%");
        $("#tmpP").attr("class","");
        $("#tmpP").attr("class","cr");
        $("#tmpP").html("密码不能为空")
    }
}