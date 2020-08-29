var timer;
function move(item,target,speed){
    clearInterval(timer);
    var current = item.offsetLeft;
    if(current>target){
        speed = -speed;
    }
    timer = setInterval(function(){
        var oldValue = item.offsetLeft;
        var newValue = oldValue+speed;
        if(speed>0&&(newValue>target)||speed<0&&newValue<target){
            // 结束
            newValue = target;
            // 在这后面要判断是否是最后一张
            clearInterval(timer);
        }
        item.style.left = newValue +"px";
    },1);

}
window.onload = function () {
    var a = document.getElementsByClassName("picBoxA");
    console.log(a[0].id);
    let inner = document.getElementById("inner");
    // 用来记录第几张图片
    var index = 0;
    // 初始化

    a[index].style.backgroundColor = "black";

    for(var i = 0 ; i < a.length ; i++){
        a[i].onclick = function () {
            index = parseInt(this.id);
            move(inner,index*(-1000),10);
            this.style.backgroundColor = "black";
            for(var i=0;i<a.length;i++){
                if(index!=i){
                    a[i].style.backgroundColor="red";
                    // 让hover生效
                    a[i].style.backgroundColor="";
                }
            }
        }
    }
    var timer1 = setInterval(function(){
        index++;
        if(index>=a.length){
            index=0;
        }
        move(inner,index*(-1000),15);
        a[index].style.backgroundColor="black";
        for(var i=0;i<a.length;i++){
            if(index!=i){
                a[i].style.background="red";
                a[i].style.backgroundColor="";
            }
        }
    },5000);
};