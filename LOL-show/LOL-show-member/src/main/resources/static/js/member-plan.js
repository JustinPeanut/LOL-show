// 设置当前li的样式
function setLiCurrent() {
    // 改变导航条中li的样式
    let li = $(".pagination li");
    if(window.pageNum > 1){
        $(li[li.length - 1]).removeClass("disabled")
        $(li[0]).removeClass("disabled");
        if(window.pageNum == li.length - 2){
            $(li[li.length - 1]).addClass("disabled");
        }
        // 如果当前页码是第一个，那么上一页的标签变灰色
    }else if (window.pageNum == 1){
        $(li[li.length - 1]).removeClass("disabled");
        $(li[0]).addClass("disabled");
    }
    // 将上一个页码的选中状态移除
    $(li[window.prePageNum]).removeClass("active");
    // 设置当前页码为选中状态
    $(li[window.pageNum]).addClass("active");
}

// 实时变化的li添加单机响应函数
function addClickOnLi() {
    let li = $(".pagination li a");
    for(let i = 0 ; i < li.length ; i++){
        $(li[i]).on('click',function () {
            // $("table").delegate("li["+i+"]",'click',function () {
            // 如果i是在上一页和下一页之间，那么直接发送ajax,生成table
            if(i > 0 && i < li.length - 1){
                window.pageNum = i;
                createTable();
                window.prePageNum = pageNum;
            }
            // 按上一页按钮触发的事件
            if(window.pageNum != 1 && i == 0){
                window.pageNum = prePageNum - 1;
                createTable();
                window.prePageNum = pageNum;
            }
            // 按下一页按钮触发的事件
            if(window.pageNum != li.length - 2 && i == li.length - 1){
                window.pageNum = prePageNum + 1;
                createTable();
                window.prePageNum = pageNum;
            }
        });
    }
}

// 生成计划首页的计划表
function createTable() {
    // 先将表格中的数据清空
    $("table tbody").empty();
    let info = getInfo("member/get/page/info.json");
    if(info == null){
        $("table tbody").append(
            "<p style='margin: 20px auto;'>抱歉！没有查询到任何数据</p>"
        );
        return;
    }
    let pageSize = info.pageSize;
    let data = info.list;
    // 生成表格中的数据
    for(let i = 0 ; i < pageSize ; i++){
        // 填充数据
       $("table tbody").append(
           " <tr>" +
           "      <td>"+data[i].id+"</td>" +
           "      <td>"+data[i].planDate+"</td>\n" +
           "      <td>"+data[i].planEvent+"</td>" +
           "      <td>"+data[i].lastTime+"</td>" +
           "      <td width='100px'>" +
           "      <button type='button' class='btn btn-primary btn-xs updateBtn'><i class='glyphicon glyphicon-pencil'></i></button>" +
           "      <button type='button' class='btn btn-danger btn-xs removeBtn'><i class='glyphicon glyphicon-remove'></i></button>" +
           "      </td>" +
           "</tr>"
       );
    }
   setLiCurrent();
}

// 动态生成导航条
function createNavGroup(data,num,callback){
    // 首先将导航条的内容清空
    $(".pagination").empty();
    if(data == null){
        return;
    }
    let pageSize = data.pageSize;
    // 计算需要多少页存放数据，用于生成导航条
    let pageTotalNum = Math.ceil(pageSize/num);
    // 将计算出的页面总共的pageTotal设置为全局变量
    window.pageTotalNum = pageTotalNum;
    // 动态生成导航条
    // 添加上一页标签
    $(".pagination").append("<li class='disabled'><a href='javascript:;'>上一页</a></li>");
    for(let i = 1 ; i <=  pageTotalNum ; i++){
        // 设置当前，第一个li为选中状态，设置样式
        if(i == window.prePageNum){
            $(".pagination").append(" <li class='active'><a href='javascript:;'>"+i+" <span class='sr-only'>(current)</span></a></li>");
        }else{
            $(".pagination").append("<li><a href='javascript:;'>"+i+"</a></li>");
        }
    }
    // 添加下一页的标签
    $(".pagination").append("<li><a href='javascript:;'>下一页</a></li>");
    addClickOnLi();
}

// 获取数据
function getInfo(url){
    let infoData = $.ajax({
        "url": url,
        "type": "post",
        "data": {
            "pageNum": window.pageNum,
            "pageSize": window.pageSize
        },
        "dataType": "json",
        "async":false
    });
    // 判断响应的结果
    let status = infoData.status;
    // 如果响应结果不是200
    if(status != 200){
        // 获取异常信息
        let text = infoData.statusText;
        layer.msg("发生了一个错误！"+text);
    }
    // 如果响应码等于200，说明交互没有问题
    // 判断后台是否有错误信息
    // 获取后台返回的ResultEntity
    let resultEntity = infoData.responseJSON;
    // 获取后台返回状态
    let resultStatus = resultEntity.status;
    if("succeed" != resultStatus){
        let resultText = resultEntity.message;
        layer.msg(resultText);
    }
    // 如果成功，就回显数据
    let data = resultEntity.data;
    return data;
}

// 发送ajax请求，获取plan分页的值
function init(url,num){
    let data = getInfo(url);
    // 动态生成导航条
    createNavGroup(data,num);
}
