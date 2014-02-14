var _global = {
    "js": {
        "js_compress": true,
        "message_report": true,
        "checkbrowser": true,
        "hide_wx_nav": true
    },
};

function wxReady(a) {
    if (window.WeixinJSBridge) a && a();
    else {
        var b = setTimeout(function() {
            window.WeixinJSBridge && a && a()
        }, 1e3);
        document.addEventListener("WeixinJSBridgeReady", function() {
            clearTimeout(b), a && a()
        })
    }
}

function needConfirm(a, b, c) {
    var d = window.confirm(a);
    d ? b && "function" == typeof b && b.apply() : c && "function" == typeof c && c.apply()
}
document.addEventListener("touchstart", function() {}, !0), $(function() {
    _global.js.hide_wx_nav ? wxReady(function() {
        WeixinJSBridge.call("hideToolbar")
    }) : wxReady(function() {
        WeixinJSBridge.call("showToolbar")
    })
}),
function() {
    var a = window._ = window._ || {};
    a.throttle = function(a, b) {
        var c, d, e, f, g = 0,
            h = function() {
                g = new Date, e = null, f = a.apply(c, d)
            };
        return function() {
            var i = new Date,
                j = b - (i - g);
            return c = this, d = arguments, 0 >= j ? (clearTimeout(e), e = null, g = i, f = a.apply(c, d)) : e || (e = setTimeout(h, j)), f
        }
    }, a.debounce = function(a, b, c) {
        var d, e;
        return function() {
            var f = this,
                g = arguments,
                h = function() {
                    d = null, c || (e = a.apply(f, g))
                }, i = c && !d;
            return clearTimeout(d), d = setTimeout(h, b), i && (e = a.apply(f, g)), e
        }
    }, $.wdz = $.wdz || {}, $.extend($.wdz, {
        isIOS: function() {
            return /(iPhone|iPad|iPod)/i.test(navigator.userAgent) ? !0 : !1
        },
        isAndroid: function() {
            return /Android/i.test(navigator.userAgent) ? !0 : !1
        },
        isWeixin: function() {
            return $.wdz._weixinEle = $.wdz._weixinEle || $(document.documentElement), $.wdz._weixinEle.hasClass("wx_mobile")
        },
        isMobile: function() {
            return window._global.is_mobile
        },                   
           
    })
}(),


function() {
    var a = function(a) {
        var b = $.extend({
            element: "",
            footer: "",
            margin_footer: 0,
            margin_top: 0,
            fixed_top: 0
        }, a),
            c = $(b.element),
            d = $(b.footer),
            e = b.margin_top ? b.margin_top : c.position().top,
            f = c.height(),
            g = $(window).height(),
            h = d.position().top - b.margin_footer;
        $(window).scroll(function() {
            var a = $(this).scrollTop(),
                d = h - a;
            a > e && g > f ? c.css({
                position: "fixed",
                top: f > d ? d - f : b.fixed_top
            }) : c.css("position", "relative")
        })
    }, b = {
            showSubmenu: function(a) {
                var b = $(a.target),
                    c = b.parents(".one"),
                    d = b.hasClass(".js-mainmenu") ? b : c.find(".js-mainmenu"),
                    e = c.find(".js-submenu"),
                    f = e.find(".arrow"),
                    g = b.parents(".js-navmenu"),
                    h = g.find(".one"),
                    i = h.length,
                    j = h.index(c),
                    k = d.outerWidth(),
                    l = (e.outerWidth() - d.outerWidth()) / 2,
                    m = e.outerWidth() / 2;
                if (0 === e.size()) $(".js-submenu:visible").hide();
                else {
                    var n = e.outerWidth(),
                        o = c.outerWidth(),
                        p = "auto",
                        q = "auto",
                        r = "auto",
                        s = "auto";
                    0 === j ? n > o ? (p = 8, q = k / 2 - p) : (p = d.position().left - l, q = m - f.outerWidth() / 2) : j === i - 1 ? n > o ? (r = 8, s = k / 2 - r) : (p = d.position().left - l, q = m - f.outerWidth() / 2) : (p = d.position().left - l, q = m - f.outerWidth() / 2), e.css({
                        left: p,
                        right: r
                    }), f.css({
                        left: q,
                        right: s
                    }), $(".js-submenu:visible").not(e).hide(), e.toggle()
                }
            },
            openNavmenu: function(a) {
                var b = $(".js-navmenu");
                b.slideToggle("fast"), $(".js-submenu:visible").hide(), $(".js-open-navmenu .caret").toggleClass("up-arrow"), a.stopPropagation()
            }
        };
    $.wdz.isMobile() ? ($("body").on("touchstart", function() {
        $(".js-submenu:visible").hide(0), $(".js-open-navmenu .caret").removeClass("up-arrow")
    }), $("body").on("touchstart", ".js-navmenu", function(a) {
        a.stopPropagation()
    }), $("body").on("touchstart", ".js-submenu", function(a) {
        a.stopPropagation()
    }), $("body").on("touchstart", ".js-mainmenu", function(a) {
        b.showSubmenu(a)
    }), $("body").on("touchstart", ".js-open-navmenu", function(a) {
        b.openNavmenu(a)
    })) : ($("body").on("click", function() {
        $(".js-submenu:visible").hide(0), $(".js-open-navmenu .caret").removeClass("up-arrow")
    }), $("body").on("click", ".js-navmenu", function(a) {
        a.stopPropagation()
    }), $("body").on("click", ".js-submenu", function(a) {
        a.stopPropagation()
    }), $("body").on("click", ".js-mainmenu", function(a) {
        b.showSubmenu(a)
    }), $("body").on("click", ".js-open-navmenu", function(a) {
        b.openNavmenu(a)
    }));
    var c = ".nav-on-top";
    $(c).size() > 0 && ($(c).css("position", "relative"), $(".js-mini-height").css("padding-top", $(".js-navmenu").height()), a({
        element: c,
        footer: ".js-footer",
        margin_top: $(".header").height()
    }));
    var d = ".nav-on-top-hide",
        e = ".js-nav-goods";
    $(d).size() > 0 && 0 === $(e).size() && a({
        element: d,
        footer: ".js-footer",
        margin_top: $(".header").height()
    });
    var f = ".nav-on-bottom",
        g = $(".js-custom-paginations");
    $(f).size() + g.size() > 0 && $("body").css("padding-bottom", $(".js-navmenu").height() || g.height())
}();