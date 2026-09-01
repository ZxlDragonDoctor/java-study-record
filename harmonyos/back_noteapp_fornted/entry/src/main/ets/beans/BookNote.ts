export class BookNote{
  noteid:number
  title:string
  author:string
  content:string
  ctime:string
  images:string

  constructor(noteid?: number, title?: string, author?:string,content?: string, ctime?: string, images?: string) {
    this.noteid = noteid
    this.title = title
    this.author = author
    this.content = content
    this.ctime = ctime
    this.images = images

  }

}