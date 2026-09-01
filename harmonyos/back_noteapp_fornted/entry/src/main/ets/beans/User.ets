export class User{
  private username:string
  private password:string
  private avatar:string = ""
  private nickname:string = ""

  constructor(username:string,password:string,avatar?:string,nickname?:string) {
    this.username = username
    this.password = password
    this.avatar = avatar
    this.nickname = nickname
  }

  public getUsername():string{
    return this.username
  }
  public getPassword():string{
    return this.password
  }
  public getAvatar():string{
    return this.avatar
  }
  public getNickname():string{
    return this.nickname
  }
  public setUsername(username:string):void{this.username = username}
  public setPassword(password:string):void{this.password = password}
  public setAvatar(avatar:string):void{this.avatar = avatar}
  public setNickname(nickname:string):void{this.nickname = nickname}
}
