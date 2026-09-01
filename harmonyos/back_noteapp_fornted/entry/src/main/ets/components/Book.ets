
import { BookNote } from '../beans/BookNote'
import bookNoteDAO from '../dao/BookNoteDAO'

import {AddDialog} from '../components/AddDialog'
import router from '@ohos.router'
import promptAction from '@ohos.promptAction'
@Preview
@Entry
@Component
struct Book{
  @State notes:BookNote[] = []
  @State note:BookNote = new BookNote()


  /**
   * 自定义函数
   */
  dialogController:CustomDialogController = new CustomDialogController({
    builder:AddDialog()
  })
  /**
   * 周期函数
   */
  aboutToAppear(){
    this.getData()
    console.log("页面数据渲染完成")
    console.log("数据为"+this.notes);
  }
  /**
   * 初始化数据
   */
  getData(){
    bookNoteDAO.getNotes().then(data=>{
       this.notes = data
    })
  }
  build(){
    Column() {

        Row() {
          Image($r('app.media.return')).height(30)
            .interpolation(ImageInterpolation.High).onClick(()=>{
            router.pushUrl({
              url:"pages/login" //返回登录页面
            })
          })
          Text("读书札记").width(80).height(50)
            .fontSize(20).fontWeight(FontWeight.Bolder)
          Image($r('app.media.add')).height(30)
            .interpolation(ImageInterpolation.High).onClick(()=>{
             this.dialogController.open()
          })
        }
        .width("100%")
        .height(50)
        .shadow({ radius: 10 })
        .justifyContent(FlexAlign.SpaceBetween)
        .padding(10)

        List({space:10}){
          ForEach(this.notes,(item,index)=>{
            ListItem(){
              Column({ space: 20 }) {
                Row() {
                  Text(`${item.title}`).fontWeight(FontWeight.Bolder)
                  Blank()
                  Text(`${item.ctime}`).fontSize(10).fontWeight(FontWeight.Bolder)
                }.width('100%').justifyContent(FlexAlign.SpaceBetween)
                .padding(10)
                Divider()
                Row(){
                  Text(`${item.content}`).textOverflow({ overflow: TextOverflow.Ellipsis }).maxLines(4)
                    .textAlign(TextAlign.Start)

                }
                Row(){
                  Text(`作者:${item.author}`).fontWeight(FontWeight.Bolder)
                  Image($r('app.media.delete')).width(25).height(25)
                    .interpolation(ImageInterpolation.High).onClick(() => { //删除
                    ActionSheet.show({
                      title: "消息",
                      message: "确认需要删除该数据吗？",
                      sheets: [],
                      confirm: {
                        value: "确定",
                        action: () => {
                          bookNoteDAO.remove(item.noteid).then(flag => {
                            if (flag) {
                              promptAction.showToast({ message: '删除成功' })
                              this.getData()
                            } else {
                              promptAction.showToast({ message: '删除失败' })
                            }
                          })
                        }
                      }
                    })
                  })
                }.width('100%').justifyContent(FlexAlign.SpaceBetween)

              }.width('100%').height(250).shadow({ radius: 10, color: Color.Blue, offsetX: 20, offsetY: 20 })
              .onClick(()=>{  //跳转详情页
                router.pushUrl({
                  url:"components/Detail",
                  params:{note:item}
                })
              })
            }
          })
        }
      }.width("100%").height("100%")
  }
}