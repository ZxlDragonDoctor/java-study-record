package NIOTest;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.*;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Set;

public class NioTest1 {
//        **1）使用通道完成文件的复制（非直接缓冲区）**
    public static   void test1(){
        try{
            FileInputStream fileInputStream = new FileInputStream("a.text");
            FileOutputStream fileOutputStream = new FileOutputStream("b.text");
            //获取通道
            FileChannel fileInputStreamChannel = fileInputStream.getChannel();
            FileChannel fileOutputStreamChannel = fileOutputStream.getChannel();

            ByteBuffer allocate = ByteBuffer.allocate(1024);

            while (fileInputStreamChannel.read(allocate) != -1){
                allocate.flip(); //切换为读
                fileOutputStreamChannel.write(allocate);
                allocate.clear();
            }
            fileInputStreamChannel.close();
            fileOutputStreamChannel.close();
            fileInputStream.close();
            fileOutputStream.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    //方式一：
    public static void test2() throws Exception {
        try {
            // 使用直接缓冲区完成文件的复制(内存映射文件)
            /**
             * 使用 open 方法来获取通道
             * 需要两个参数
             * 参数1：Path 是 JDK1.7 以后给我们提供的一个类，代表文件路径
             * 参数2：Option  就是针对这个文件想要做什么样的操作
             *      --StandardOpenOption.READ ：读模式
             *      --StandardOpenOption.WRITE ：写模式
             *      --StandardOpenOption.CREATE ：如果文件不存在就创建，存在就覆盖
             */
            FileChannel inChannel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
            FileChannel outChannel = FileChannel.open(Paths.get("c.txt"), StandardOpenOption.WRITE,
                    StandardOpenOption.READ, StandardOpenOption.CREATE);

            /**
             * 内存映射文件
             * 这种方式缓冲区是直接建立在物理内存之上的，  零拷贝
             * 所以我们就不需要通道了
             */
            MappedByteBuffer inMapped = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
            MappedByteBuffer outMapped = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

            // 直接对缓冲区进行数据的读写操作
            byte[] dst = new byte[inMapped.limit()];
            inMapped.get(dst);  // 把数据读取到 dst 这个字节数组中去
            outMapped.put(dst); // 把字节数组中的数据写出去

            inChannel.close();
            outChannel.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    //方式二：
    public static void test3() throws Exception {
        /**
         * 通道之间的数据传输（直接缓冲区的方式）   零拷贝
         * transferFrom
         * transferTo
         */
        FileChannel inChannel = FileChannel.open(Paths.get("a.txt"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("d.txt"), StandardOpenOption.READ, StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        inChannel.transferTo(0, inChannel.size(), outChannel);
        // 或者可以使用下面这种方式
        //outChannel.transferFrom(inChannel, 0, inChannel.size());
        inChannel.close();
        outChannel.close();
    }

    //NIOServer
    //Selector使用手示例
    public static void test4(String[] args) throws  Exception{
        try {
            //创建ServerSocketChannel，-->> ServerSocket
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            InetSocketAddress inetSocketAddress = new InetSocketAddress(5555);
            serverSocketChannel.socket().bind(inetSocketAddress);
            serverSocketChannel.configureBlocking(false); //设置成非阻塞

            //开启selector,并注册accept事件
            Selector selector = Selector.open();
            serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);

            while(true) {
                selector.select(2000);  //阻塞监听所有通道（2000ms）
                //遍历就绪通道selectionKeys
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> iterator = selectionKeys.iterator();
                while (iterator.hasNext()) {
                    SelectionKey key = iterator.next();
                    if(key.isAcceptable()) {  //处理连接事件
                        ServerSocketChannel server = (ServerSocketChannel) key.channel();
                        SocketChannel socketChannel = server.accept(); // 获得和客户端连接的通道
                        socketChannel.configureBlocking(false);  //设置为非阻塞
                        System.out.println("client:" + socketChannel.getLocalAddress() + " is connect");
                        socketChannel.register(selector, SelectionKey.OP_READ); //注册客户端读取事件到selector
                    } else if (key.isReadable()) {  //处理读取事件
                        SocketChannel channel = (SocketChannel) key.channel(); // 服务器可读取消息:得到事件发生的Socket通道
                        ByteBuffer byteBuffer = ByteBuffer.allocate(1024); // 创建读取的缓冲区
                        channel.read(byteBuffer);
                        System.out.println("client:" + channel.getLocalAddress() + " send " + new String(byteBuffer.array()));
                    }
                    iterator.remove();  //事件处理完毕，要记得清除
                }
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }



}
//NIOClient
class NIOClient {

    public static void main(String[] args) throws Exception{
        SocketChannel socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        InetSocketAddress inetSocketAddress = new InetSocketAddress("127.0.0.1", 5555);

        if(!socketChannel.connect(inetSocketAddress)) {
            while (!socketChannel.finishConnect()) {
                System.out.println("客户端正在连接中，请耐心等待");
            }
        }

        ByteBuffer byteBuffer = ByteBuffer.wrap("mikechen的互联网架构".getBytes());
        socketChannel.write(byteBuffer);
        socketChannel.close();
    }
}
