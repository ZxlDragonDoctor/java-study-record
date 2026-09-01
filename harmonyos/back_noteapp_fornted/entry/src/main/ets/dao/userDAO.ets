import http from '@ohos.net.http';
import promptAction from '@ohos.promptAction';
import router from '@ohos.router';
import { User } from '../beans/User';
class UserDAO{
  login(user:User):Promise<Boolean>{
    console.log(user.getUsername());
    return new Promise((resolve,reject)=>{
      var htttpRequest = http.createHttp()
      htttpRequest.request('http://127.0.0.1:8080/zxl/user/login',{
        method:http.RequestMethod.POST,
        extraData:user
      }).then(response =>{
          console.log("this responseCode=",response.responseCode);
         let data = JSON.parse(response.result.toString())
        console.log("接收到的code:",data.code);
          if(data.code == "200"){
            promptAction.showToast({
              message:"登录成功",
              duration:5000,
              bottom:440
            })
            router.pushUrl({
              url:'components/Book',
            },router.RouterMode.Single,()=>{
              promptAction.showToast({
                message: "跳转成功",
                duration: 5000,
                bottom: 1080
              })
            })
          }else {
            promptAction.showToast({
              message: "登录失败",
              duration: 5000,
              bottom: 1080
            })
          }
      })
    })
  }
  register(user:User):Promise<Boolean>{
    console.log(user.getUsername());
    return new Promise((resolve,reject)=>{
      var htttpRequest = http.createHttp()
      htttpRequest.request('http://localhost:8080/zxl/user/addUser',{
        method:http.RequestMethod.POST,
        extraData:user
      }).then(response =>{
        console.log("this responseCode=",response.responseCode);
        let data = JSON.parse(response.result.toString())
        console.log("接收到的code:",data.code);
        if(data.code == "200"){
          promptAction.showToast({
            message:"注册成功",
            duration:5000,
            bottom:440
          })
          router.pushUrl({
            url:'pages/login',
          },router.RouterMode.Single,()=>{
            promptAction.showToast({
              message: "跳转成功",
              duration: 5000,
              bottom: 1080
            })
          })
        }else {
          let imessage = JSON.parse(response.result.toString()).message;
          console.log(imessage);
          promptAction.showToast({
            message:imessage,
            duration:5000,
            bottom:1080
          })
        }
      })
    })
  }

}

export default UserDAO;