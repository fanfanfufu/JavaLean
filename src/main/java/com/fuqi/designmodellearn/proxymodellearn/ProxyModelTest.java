package com.fuqi.designmodellearn.proxymodellearn;

/**
 * @Description: 代理模式的学习1
 * @Author 傅琦
 * @Date 2019/6/18 17:02
 * @Version V1.0
 */
public class ProxyModelTest {
    public static void main(String[] args) {
        Server server = new Server();
        ProxyServer proxyServer = new ProxyServer(server);

        // 结果：
        //      联网之前的检查操作
        //      服务器访问网络
        proxyServer.communicate();
    }
}

interface NetWork{
    public void communicate();
}

/**
 * 被代理类
 */
class Server implements NetWork{
    @Override
    public void communicate() {
        System.out.println("服务器访问网络");
    }
}

/**
 * 代理类
 */
class ProxyServer implements NetWork{

    private NetWork netWork;

    public ProxyServer(NetWork netWork) {
        this.netWork = netWork;
    }

    private void check(){
        System.out.println("联网之前的检查操作");
    }

    @Override
    public void communicate() {
        check();
        netWork.communicate();
    }
}