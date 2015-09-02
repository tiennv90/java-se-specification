package com.java.spec.tiennv.java.lang;

public class UsingClassLoaderMain {
	
	public void loadExternalClass() throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		Class clazz = this.getClass();
		if (clazz != null) {
			System.out.println("Class not null. Trying to load External Class...");
			ClassLoader classLoader = clazz.getClassLoader();
			Object externalClass = classLoader.loadClass("com.java.spec.tiennv.java.lang.UsingClassLoeader").newInstance();
			System.out.println("Class was loaded sucessfully!");
		}
	}
	
	public static void main(String args[]) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
		
		UsingClassLoaderMain u = new UsingClassLoaderMain();
		u.loadExternalClass();
	}

}
