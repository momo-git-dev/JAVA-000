package com.momo;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.io.IOException;

public class MyClassLoader extends ClassLoader{
	
	public static void main(String[] args) {
		try {
			Class<?> hello = new MyClassLoader().findClass("com.momo.Hello");
			Method helloMethod = hello.getDeclaredMethod("hello");
			helloMethod.setAccessible(true);
			helloMethod.invoke(hello.newInstance());
		} catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException | InstantiationException |
		ClassNotFoundException | NoSuchMethodException | SecurityException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	protected Class<?> findClass(String name) throws ClassNotFoundException {
		FileInputStream inputStream = null;
		byte[] content = null;
		try {
			File file = new File("Hello.class");
			content = new byte[(int) file.length()];
			inputStream = new FileInputStream(file);
			inputStream.read(content);
			inputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return defineClass(name, content, 0, content.length);
	}
}
