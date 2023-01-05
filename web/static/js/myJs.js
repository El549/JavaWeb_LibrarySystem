function open_sidebar() {

    var mySidebar = document.getElementById("mySidebar")
    var openSidebar = document.getElementById("openSidebar")
    var container = document.getElementById("container_1")
    document.getElementById("mySidebar").style.display = "block";
    var s_left = -9, c_width = 97
    var open1 = setInterval(() => {
        s_left = s_left + 0.1
        mySidebar.style.left = s_left + 'vw'
        openSidebar.style.left = s_left + 'vw'
        if (s_left >= -0.1) {
            window.clearInterval(open1)
        }
    }, 0.1)
    var open2 = setInterval(() => {
        c_width = c_width - 0.1
        container.style.width = c_width + '%'
        if (c_width < 88.1) {
            window.clearInterval(open2)
        }
    }, 1)
    document.getElementById("openSidebar").style.display = "none"
}

function close_sidebar() {
    var mySidebar = document.getElementById("mySidebar")
    var openSidebar = document.getElementById("openSidebar")
    var container = document.getElementById("container_1")
    document.getElementById("openSidebar").style.display = "block"
    var s_left = 0, c_width = 88.0
    var close = setInterval(() => {
        s_left = s_left - 0.1
        mySidebar.style.left = s_left + 'vw'
        openSidebar.style.left = s_left + 'vw'
        if (s_left <= -8.8) {
            window.clearInterval(close)
        }
    }, 1)
    var close2 = setInterval(() => {
        c_width = c_width + 0.1
        container.style.width = c_width + '%'
        if (c_width > 96.9) {
            window.clearInterval(close2)
        }
    }, 0., 1)
    document.getElementById("mySidebar").style.display = "none"
    document.getElementById("openSidebar").style.display = "block"
}