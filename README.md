# PizzaHubAPI

API link:
port: 8081

[done]
{link_server}/user/account/{username}
type: GET
tham số truyền đi username.
Công dụng: Lấy thông tin tài khoản gồm Username và password từ username truyền vào.
Trả về: JSON
{
    "password": "default",
    "userName": "PhatTP"
}

[done]
{link_server}/user/account/{username}
type: GET
tham số truyền đi username.
Công dụng: Lấy thông tin chi tiết về một user từ username truyền vào.
Trả về: JSON
{
    "address": "2",
    "fullName": "Trần Phú Phát",
    "gender": true,
    "dob": "2000-12-19",
    "userID": 1,
    "phone": "1",
    "email": "3"
}
