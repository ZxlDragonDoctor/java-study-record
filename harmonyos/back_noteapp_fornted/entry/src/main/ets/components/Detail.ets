import router from '@ohos.router'

@Preview
@Entry
@Component
struct Detail {
  @State params: any =router.getParams()
  build() {
    Column({ space: 10}) {
      Row() {
        Image($r("app.media.return")).width(25).height(25).interpolation(ImageInterpolation.High)
          .onClick(() => {
            //返回上一页
            router.back();
          })
        Text('札记详情').fontSize(18).fontWeight(FontWeight.Bold)
      }.height(50).width('100%').padding(5)
      .shadow({ radius: 10 })
      List(){
        ListItem(){
          Column({space:10}){

            Image(this.params['note'].images).width('100%').height('30%').shadow({ radius: 2 })
            Row(){
              Text(this.params['note'].title).fontWeight(FontWeight.Bold)
              Blank()
              Text(this.params['note'].author).fontWeight(FontWeight.Bold)
            }.width('100%')
            Text(this.params['note'].content).width('100%')

          }.width('100%').layoutWeight(1)
        }
      }.width('100%').width('100%')

    }.width('100%').height('100%')
  }
}