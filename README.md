# PizzaHubAPI

API link:

port: 8081


<hr>
[done]<br>
{link_server}/user/account/{username}<br>
type: GET <br>
tham số truyền đi username. <br>
Công dụng: Lấy thông tin tài khoản gồm Username và password từ username truyền vào.<br>
Trả về: JSON<br>
{<br>
    "password": "default",<br>
    "userName": "PhatTP"
    <br>
}<br>
<hr>
[done]<br>
{link_server}/user/info/{username}<br>
type: GET<br>
tham số truyền đi username.<br>
Công dụng: Lấy thông tin chi tiết về một user từ username truyền vào.<br>
Trả về: JSON<br>
{<br>
    "address": "2",<br>
    "fullName": "Trần Phú Phát",<br>
    "gender": true,<br>
    "dob": "2000-12-19",<br>
    "userID": 1,<br>
    "phone": "1",<br>
    "email": "3"<br>
}<br>
<hr>
[done]<br>
{link_server}/user/info/<br>
type: PUT<br>
bodyRequest: JSON.<br>
{// Thông tin thay đổi <br>
    "address": "2",<br>
    "fullName": "Trần Phú Phát",<br>
    "gender": true,<br>
    "dob": "2000-12-19",<br>
    "userID": 1,<br>
    "phone": "1",<br>
    "email": "3"<br>
}<br>
Công dụng: Thay đổi thông tin chi tiết của một User.<br>
Trả về: JSON<br>
{// Thông tin đã thay đổi và được đọc lại từ trong database<br>
    "address": "2",<br>
    "fullName": "Trần Phú Phát",<br>
    "gender": true,<br>
    "dob": "2000-12-19",<br>
    "userID": 1,<br>
    "phone": "1",<br>
    "email": "3"<br>
}<br>
<hr>
[done]<br>
{link_server}/user/account/<br>
type: POST<br>
bodyRequest: JSON.<br>
{<br>
    "password": "default",<br>
    "userName": "PhatTP"
    <br>
}<br>
Công dụng: Tạo một tài khoản mới.<br>
Trả về: Text<br>
8 //id của tài khoản mới.
