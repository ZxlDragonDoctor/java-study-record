
import promptAction from '@ohos.promptAction'
import { BookNote } from '../beans/BookNote'
import bookNoteDAO from '../dao/BookNoteDAO'
@CustomDialog
export struct AddDialog{
  controller: CustomDialogController
  @State note:BookNote = new BookNote()
  build(){
    Column(){
      Row(){
        Text('添加札记').width('100%').textAlign(TextAlign.Center).fontWeight(FontWeight.Bold)
      }.width('100%').height(80)
      Column({space:10}){
        TextInput({placeholder:'请输入札记标题'})
          .fontSize(20)
          .margin({top:10,bottom:10}).onChange((value)=>{
           this.note.title = value
        })
        TextInput({placeholder:'请输入网络图片地址'})
          .fontSize(20)
          .margin({top:10,bottom:10}).onChange((value)=>{
          this.note.images = value;
        })
        TextInput({placeholder:'请输入札记作者'})
          .fontSize(20)
          .margin({top:10,bottom:10}).onChange((value)=>{
          this.note.author = value;
        })
        TextInput({placeholder:'请输入札记内容'})
          .fontSize(20)
          .margin({top:10,bottom:10}).onChange((value)=>{
          this.note.content = value;
        })
        Button('保存').type(ButtonType.Normal).width('100%').onClick(()=>{
          if(this.note.title && this.note.content && this.note.author && this.note.images){
            bookNoteDAO.save(this.note).then(flag =>{
              if(flag){
                promptAction.showToast({message:'保存成功'})
                this.controller.close()
              }else {
                promptAction.showToast({message:'保存失败'})
              }
            })
          }else {
            promptAction.showToast({message:'请输入完整信息'})
          }
        })
      }.layoutWeight(1)
    }.width('100%').height('70%').padding(10)
  }
}