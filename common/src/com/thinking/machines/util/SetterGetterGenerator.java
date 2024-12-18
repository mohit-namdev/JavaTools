package com.thinking.machines.util;
import java.lang.reflect.*;
import java.io.*;
public class SetterGetterGenerator
{
public static void main(String gg[])
{
if(gg.length!=1 && gg.length!=2)
{
System.out.println("Usage: java -classpath path_of_jar_file;. com.thinking.machines.util.SetterGetterGenerator name_of_class");
System.out.println("       java -classpath path_of_jar_file;. com.thinking.machines.util.SetterGetterGenerator name_of_class constructor=true/false");
return;
}
if(gg.length==2)
{
if(gg[1].equalsIgnoreCase("constructor=true")==false && gg[1].equalsIgnoreCase("constructor=false")==false)
{
System.out.println("Usage: java -classpath path_of_jar_file;. com.thinking.machines.util.SetterGetterGenerator name_of_class");
System.out.println("       java -classpath path_of_jar_file;. com.thinking.machines.util.SetterGetterGenerator name_of_class constructor=true/false");
return;
}
}
String className=gg[0];
try
{
Class c=Class.forName(className);
Field fields[];
fields=c.getDeclaredFields();
Field field;
TMList<String> list=new TMArrayList<String>();
String fieldName;
Class fieldType;
String line;
String tmp;
String setterName;
String getterName;
if(gg.length==1 || (gg.length==2 && gg[1].equalsIgnoreCase("constructor=true")))
{
line="public "+c.getSimpleName()+"()";
list.add(line);;
list.add("{");
for(int e=0;e<fields.length;e++)
{
field=fields[e];
line="this."+field.getName()+"="+getDefaultValue(field.getType())+";";
list.add(line);
}
list.add("}");
}
for(int e=0;e<fields.length;e++)
{
field=fields[e];
fieldName=field.getName();
fieldType=field.getType();
if(fieldName.charAt(0)>=97 && fieldName.charAt(0)<=122)
{
tmp=fieldName.substring(0,1).toUpperCase()+fieldName.substring(1);
}
else
{
tmp=fieldName;
}
setterName="set"+tmp;
getterName="get"+tmp;
line="public void "+setterName+"("+fieldType.getName()+" "+fieldName+")";
list.add(line);
list.add("{");
line="this."+fieldName+"="+fieldName+";";
list.add(line);
list.add("}");
line="public "+fieldType.getName()+" "+getterName+"()";
list.add(line);
list.add("{");
line="return this."+fieldName+";";
list.add(line);
list.add("}");
}
File file=new File("tmp.tmp");
if(file.exists())file.delete();
RandomAccessFile randomAccessFile;
randomAccessFile=new RandomAccessFile(file,"rw");
TMIterator<String> iterator=list.iterator();
while(iterator.hasNext())
{
line=iterator.next();
randomAccessFile.writeBytes(line+"\r\n");
}
randomAccessFile.close();
System.out.println("setter getter for all properties of "+className+" is generated in file named as tmp.tmp");
}catch(ClassNotFoundException classNotFoundException)
{
System.out.println("Unable to load class, classpath is missing");
}
catch(IOException ioException)
{
System.out.println(ioException.getMessage());
}
}

private static String getDefaultValue(Class p)
{
String fieldTypeClassName=p.getName();
if(fieldTypeClassName.equals("java.lang.Long") || fieldTypeClassName.equals("long")) return "0";
if(fieldTypeClassName.equals("java.lang.Integer") || fieldTypeClassName.equals("int")) return "0";
if(fieldTypeClassName.equals("java.lang.Short") || fieldTypeClassName.equals("short")) return "0";
if(fieldTypeClassName.equals("java.lang.Byte") || fieldTypeClassName.equals("byte")) return "0";
if(fieldTypeClassName.equals("java.lang.Double") || fieldTypeClassName.equals("double")) return "0.0";
if(fieldTypeClassName.equals("java.lang.Float") || fieldTypeClassName.equals("float")) return "0.0f";
if(fieldTypeClassName.equals("java.lang.Character") || fieldTypeClassName.equals("char")) return "''";
if(fieldTypeClassName.equals("java.lang.Boolean") || fieldTypeClassName.equals("boolean")) return "false";
if(fieldTypeClassName.equals("java.lang.String")) return "\"\"";
return "null";
}

}