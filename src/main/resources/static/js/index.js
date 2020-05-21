//生成菜单
var menuItem = Vue.extend({
    name: 'menu-item',
    props: {item: {}, index: 0},
    template: [
        '<li :class="{active: (item.type===0 && index === 0)}">',
        '<a v-if="item.type === 0" href="javascript:;">',
        '<i v-if="item.icon != null" :class="item.icon"></i>',
        '<span>{{item.name}}</span>',
        '<i class="fa fa-angle-left pull-right"></i>',
        '</a>',
        '<ul v-if="item.type === 0" class="treeview-menu">',
        '<menu-item :item="item" :index="index" v-for="(item, index) in item.list"></menu-item>',
        '</ul>',
        '<a v-if="item.type === 1" :href="\'#\'+item.url">' +
        '<i v-if="item.icon != null" :class="item.icon"></i>' +
        '<i v-else class="fa fa-circle-o"></i> {{item.name}}' +
        '</a>',
        '</li>'
    ].join('')
});

//iframe自适应
$(window).on('resize', function () {
    var $content = $('.content');
    $content.height($(this).height() - 120);
    $content.find('iframe').each(function () {
        $(this).height($content.height());
    });
}).resize();

//注册菜单组件
Vue.component('menuItem', menuItem);

var vm = new Vue({
    el: '#rrapp',
    data: {
        user: {
            status: 1,
            roleIdList: []
        },
        roleList: {},
        menuList: {},
        main: "main.html",
        password: '',
        newPassword: '',
        navTitle: "欢迎页",
        showPassword: true
    },
    methods: {
        getMenuList: function () {
            $.getJSON(baseURL + "sys/menu/nav", function (r) {
                vm.menuList = r.menuList;
                window.permissions = r.permissions;
            });
        },
        getUser: function (userId) {
            $.getJSON(baseURL + "sys/user/info/" + userId, function (r) {
                vm.user = r.user;
                vm.user.password = null;
            });
        }, updateSysUser: function () {
            vm.showPassword = false;
            vm.getUser(vm.user.userId);
            //获取角色信息
            // this.getRoleList();
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "个人信息",
                area: ['550px', '400px'],
                shadeClose: false,
                content: jQuery("#passwordLayer"),
                btn: ['修改', '取消'],
                btn1: function (index) {
                    if (vm.validator()) {
                        return;
                    }
                    $.ajax({
                        type: "POST",
                        url: baseURL + "sys/user/update",
                        data: JSON.stringify(vm.user),
                        contentType: "application/json",
                        success: function (r) {
                            if (r.code == 0) {
                                layer.close(index);
                                layer.alert('操作成功', function () {
                                    location.reload();
                                });
                            } else {
                                layer.alert(r.msg);
                            }
                        }
                    });
                }
            });
        },
        updatePassword: function () {
            vm.showPassword = true;
            layer.open({
                type: 1,
                skin: 'layui-layer-molv',
                title: "修改密码",
                area: ['550px', '270px'],
                shadeClose: false,
                content: jQuery("#passwordLayer"),
                btn: ['修改', '取消'],
                btn1: function (index) {
                    var data = "password=" + vm.password + "&newPassword=" + vm.newPassword;
                    $.ajax({
                        type: "POST",
                        url: baseURL + "sys/user/password",
                        data: data,
                        dataType: "json",
                        success: function (r) {
                            if (r.code == 0) {
                                layer.close(index);
                                layer.alert('修改成功', function () {
                                    location.reload();
                                });
                            } else {
                                layer.alert(r.msg);
                            }
                        }
                    });
                }
            });
        },
        logout: function () {
            $.ajax({
                type: "POST",
                url: baseURL + "sys/logout",
                dataType: "json",
                success: function (r) {
                    //删除本地token
                    localStorage.removeItem("token");
                    //跳转到登录页面
                    location.href = baseURL + 'login.html';
                }
            });
        },
        donate: function () {
            layer.open({
                type: 2,
                title: false,
                area: ['806px', '467px'],
                closeBtn: 1,
                shadeClose: false,
                content: ['http://cdn.gh.io/donate.jpg', 'no']
            });
        },
        validator: function () {
            if (isBlank(vm.user.username)) {
                alert("登录名不能为空");
                return true;
            }

            if (isBlank(vm.user.aliasname)) {
                alert("用户名不能为空");
                return true;
            }
        },
        getRoleList: function () {
            $.get(baseURL + "sys/role/select", function (r) {
                vm.roleList = r.list;
            });
        },
        reload:function(){
            window.location.reload();
        }
    },
    created: function () {
        this.getMenuList();
        this.getUser('');
    },
    updated: function () {
        //路由
        var router = new Router();
        routerList(router, vm.menuList);
        router.start();
    }
});


function routerList(router, menuList) {
    for (var key in menuList) {
        var menu = menuList[key];
        if (menu.type == 0) {
            routerList(router, menu.list);
        } else if (menu.type == 1) {
            router.add('#' + menu.url, function () {
                var url = window.location.hash;

                //替换iframe的url
                vm.main = url.replace('#', '');

                //导航菜单展开
                $(".treeview-menu li").removeClass("active");
                $(".sidebar-menu li").removeClass("active");
                $("a[href='" + url + "']").parents("li").addClass("active");

                vm.navTitle = $("a[href='" + url + "']").text();
            });
        }
    }
}
