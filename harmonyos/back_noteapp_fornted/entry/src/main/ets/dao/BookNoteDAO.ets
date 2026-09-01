import http from '@ohos.net.http'
import promptAction from '@ohos.promptAction'
import { BookNote } from '../beans/BookNote'
class BookNoteDAO{
  getNotes():Promise<BookNote[]>{
    return new Promise((resolve,reject)=>{
      let httpRequest = http.createHttp()
      httpRequest.request("http://localhost:8080/zxl/note/get/notes",{
        method:http.RequestMethod.GET
      }).then(response =>{
        console.log(response.result.toString());
        let data = JSON.parse(response.result.toString())
        console.log(data.code);
        if(data.code == "200"){
          console.log("请求成功");
          resolve(data.data)
        }else {
          let imessage = JSON.parse(response.result.toString()).message;
          promptAction.showToast({
            message: imessage
          })
        }
      }).catch(()=>{
        promptAction.showToast({
          message: "网路请求失败，检查网络"
        })
      })
    })
  }
  /**
   *保存札记请求
   * @param note
   * @returns
   */
  save(note: BookNote): Promise<boolean> {
    return new Promise((resolve, reject) => {
      let httpRequest = http.createHttp();
      httpRequest.request('http://localhost:8080/zxl/note/save', {
        method: http.RequestMethod.POST,
        extraData: note
      }).then(response => {
        if (response.responseCode === 200) {
          console.log(response.result.toString());
          resolve(JSON.parse(response.result.toString()));
          console.log("post请求成功")
          this.getNotes();
        } else {
          promptAction.showToast({
            message: '保存数据失败，请检查服务端'
          });
        }
      }).catch(() => {
        promptAction.showToast({
          message: '网络请求失败，请检查网络'
        });
      });
    });
  }
  /**
   * 删除札记请求
   * @param noteid
   * @returns
   */
  remove(noteid:number): Promise<boolean> {
    return new Promise((resolve, reject) => {
      let httpRequest = http.createHttp()
      httpRequest.request('http://localhost:8080/zxl/note/' + noteid, {
        method: http.RequestMethod.DELETE
      }
      ).then(response => {
        console.log("执行remove方法")
        if (JSON.parse(response.result.toString()).code == 200) {
          resolve(JSON.parse(response.result.toString()).code)
        } else {
          let message = JSON.parse(response.result.toString()).message
          console.log("message:"+message);
          promptAction.showToast({
            message: message
          })
        }
      }).catch(() => {
        promptAction.showToast({
          message: '网络请求失败，请检查网络'
        })
      })
    })
  }
}

export default new BookNoteDAO();