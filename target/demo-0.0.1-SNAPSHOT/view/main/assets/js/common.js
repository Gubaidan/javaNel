function GetUser() {
    $.ajax({
        url: "../../users/getLoginInfo",
        type: "get",
        dataType : "json",
        success: function (data) {
            if(data.name!=null)
            $("#username").html(data['name'])

            else{
                alert("登陆出现异常，请重新登陆！");
                window.location.href = "../Login/login.html";
            }
        },
        error: function (data) {
            if(data.result==error){
                alert("登陆出现异常，请重新登陆！");
                window.location.href = "../Login/login.html";
            }
        }
    });
}

function getCurrentUser() {
    var user='123';
    $.ajax({
        url: "../../users/getLoginInfo",
        type: "get",
        dataType : "json",
        async : false,
        success: function (data){
            user =  data.user;
        }
    });
    return user;
}

function initBaiduMaps(){
    // 百度地图API功能
    var map = new BMap.Map("map");    // 创建Map实例
    map.centerAndZoom(new BMap.Point(116.404, 39.915), 11);  // 初始化地图,设置中心点坐标和地图级别
    map.addControl(new BMap.MapTypeControl());   //添加地图类型控件
    map.setCurrentCity("北京");          // 设置地图显示的城市 此项是必须设置的
    map.enableScrollWheelZoom(true);     //开启鼠标滚轮缩放
}

function Logout() {

    if (confirm("确定退出系统吗?")) {
        $.ajax({
            url: "../../users/logout",
            success: function (resutlt) {
                if (resutlt.IsSuccess) {
                    window.location.href = "../Login/login.html";
                }
                else
                    mini.alert("操作失败。");
            },
        });

    }

}

function respondTrOnclick() {
    var html="";
    if(textStatus.isEqualNode("isClose")) {
        //tr点击监听事件， textStatus为上传Tr行的打开状态
        $('tr').live('click', function() {

            var id = $(this).find('td:eq(0)').text();
            var logo = $(this).find('td:eq(1)').html();
            var name = $(this).find('td:eq(2)').text();
            var sex = $(this).find('td:eq(3)').text();
            var age = $(this).find('td:eq(4)').text();
            var job = $(this).find('td:eq(5)').text();
            var tell = $(this).find('td:eq(6)').text();
            var company = $(this).find('td:eq(7)').text();
            var address = $(this).find('td:eq(8)').text();


            html =
                "<td style='display:none;'> <input type='text' id='company'  class='form-control border-input'  value='" + id + "'></td>" +
                "<td>" + logo + "</td>" +
                "<td> <input type='text'   class='form-control border-input'  value='" + name + "'></td>" +
                "<td> <input type='text' '  class='form-control border-input'  value='" + sex + "'></td>" +
                "<td> <input type='text'   class='form-control border-input'  value='" + age + "'></td>" +
                "<td> <input type='text'   class='form-control border-input'  value='" + job + "'></td>" +
                "<td style='display:none;'> <input type='text'  class='form-control border-input'  value='" + tell + "'></td>" +
                "<td> <input type='text'   class='form-control border-input'  value='" + company + "'></td>"+
                "<td style='display:none;'> <input type='text'  class='form-control border-input'  value='" + address + "'></td>";

            $(this).html(html);
            changeStatus();

        });
        textStatus="isOpen";

    }else
    {
        $(this).find("input").blur(function () {
            /* $.ajax({
                 url: "../../users/getLoginInfo",
                 type: "get",
                 dataType : "json",
                 success: function (data) {
                     if(data.name!=null)
                         $("#username").html(data['name'])

                     else{
                         alert("登陆出现异常，请重新登陆！");
                         window.location.href = "../Login/login.html";
                     }
                 },
                 error: function (data) {
                     if(data.result==error){
                         alert("登陆出现异常，请重新登陆！");
                         window.location.href = "../Login/login.html";
                     }
                 }
             });*/
            window.alert("ok");
        });

//                            html=
//                                "<td style='display:none;'>"+id+"</td>"+
//                                "<td> + logo+</td>"+
//                                "<td>"+name+"</td>"+
//                                "<td>"+sex+"</td>"+
//                                "<td>"+age+"</td>"+
//                                "<td>"+job+"</td>"+
//                                "<td style='display:none;'>"+tell+"</td>"+
//                                "<td>"+company+"</td>"+
//                                "<td style='display:none;'>"+address+"</td>";
//
//                            $(this).html(html);

        textStatus="isClose";
    }



}
