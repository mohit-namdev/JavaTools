import com.thinking.machines.util.*;
class forEachTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
list1.add(1000);
list1.forEach((p)->{System.out.println(p);});
System.out.println("****************************");
TMArrayList list2=new TMArrayList();
list2.add(100);
list2.add(200);
list2.add(300);
list2.add(400);
list2.add(1000);
list2.forEach((p)->{System.out.println(p);});
}
}