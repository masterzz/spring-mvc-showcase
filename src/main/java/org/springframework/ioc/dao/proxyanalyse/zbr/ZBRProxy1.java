package org.springframework.ioc.dao.proxyanalyse.zbr;

import org.springframework.ioc.dao.proxyanalyse.dao.LubanDaoImpl;

import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

public class ZBRProxy1 {

    public static Object newInstance(Object target) {
        Object proxy = null;
        int[] a = {1, 2, 3, 4};
        Class targetInterface = target.getClass().getInterfaces()[0];
        Method[] methods = targetInterface.getMethods();
        String line = "\n";
        String space = " ";
        String tab = "\t";
        String content = "import " + targetInterface.getName() + ";" + line;
        content += "public class $Proxy implements " + targetInterface.getName();
        content += space + "{" + line;
        content += tab + "private " + targetInterface.getSimpleName() + space + "target;" + line;
        content += tab + "public $Proxy(" + targetInterface.getSimpleName() + " target) {" + line;
        content += tab + tab + "this.target = target;" + line;
        content += tab + "}" + line;
        content += "    public void query(){\n" +
                "        System.out.println(\"luban\");\n" +
                "    }" + line;
        content += "}";

        System.out.println("Method name:" + methods[0].getName() + "-------");
        for (Method method : methods) {
            System.out.println("name : " + method.getName());
            System.out.println("return type : " + method.getReturnType());
            System.out.println("return modifiers : " + method.getModifiers());
        }


        File dir = new File("E:\\com\\google");
        File file = new File("E:\\com\\google\\$Proxy.java");
        //用bio实现写出代理类
        //创建代理文件
        try {
            if (!dir.exists())
                dir.mkdirs();
            if (!file.exists())
                file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(fileOutputStream));
            bufferedWriter.write(content);
            bufferedWriter.flush();
            //这个放在finally，简化
            bufferedWriter.close();
            fileOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        //编译该类
        JavaCompiler compiler = ToolProvider.getSystemJavaCompiler();
        System.out.println(file.getPath());
        //这句就能执行编译
        compiler.run(null, null, null, file.getPath());
        URL[] urls = new URL[0];
        try {
            //这里写目录即可
            urls = new URL[]{new URL("file:\\E:\\com\\google\\")};
            URLClassLoader classLoader = new URLClassLoader(urls);
            Class c = classLoader.loadClass("$Proxy");
            Constructor constructor = c.getConstructor(targetInterface);
            proxy = constructor.newInstance(target);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return proxy;
    }
}
