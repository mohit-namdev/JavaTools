import java.lang.reflect.*;
class Analyser
{
public static void main(String gg[])
{
try
{
Class c=Class.forName("Keyboard");
System.out.println("Name: "+c.getName());
System.out.println("Name: "+c.getSimpleName());
}catch(ClassNotFoundException cnfe)
{
System.out.println("class: "+cnfe.getMessage() + ", not found");
}
}
}