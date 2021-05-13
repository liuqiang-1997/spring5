package jdktest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

public class JdkProxy {
    public static void main(String[] args) {
        // 1 创建接口实现类的代理对象
        Class[] interfaces = {UserDao.class};  // 代理对象所代理的实现类实现的接口
//        Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new InvocationHandler() {
//            @Override
//            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
//                return null;
//            }
//        });

        UserDaoImpl userDao = new UserDaoImpl();
        UserDao dao = (UserDao) Proxy.newProxyInstance(JdkProxy.class.getClassLoader(), interfaces, new UserDaoProxy(userDao));

        int add = dao.add(1, 3);
        System.out.println(add);

        String id = dao.update("12");
        System.out.println(id);
    }
}

// 创建代理对象代码
class UserDaoProxy implements InvocationHandler{

    // 1.创建的谁的代理对象就传递谁
    // 有参构造传递
    private Object obj;

    public UserDaoProxy(Object obj){
        this.obj = obj;
    }

    // 增强的逻辑
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
       // 方法之前
        System.out.println("方法之前执行"+method.getName()+":传递的参数"+ Arrays.toString(args));

        // 被增强的方法执行
        Object res = method.invoke(obj, args);

        // 方法之后
        System.out.println("方法之后执行，，，"+obj);

        return res;
    }
}
