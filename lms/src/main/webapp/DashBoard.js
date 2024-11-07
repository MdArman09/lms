document.getElementById('menuButton').onclick = function() {
    document.getElementById('sideMenu').style.width = '250px';
}

document.getElementById('closeMenu').onclick = function() {
    document.getElementById('sideMenu').style.width = '0';
}

function logout() {
           
           window.location.href = 'login.jsp'; 
       }