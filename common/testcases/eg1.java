import com.thinking.machines.util.*;
class psp
{
public static void main(String gg[])
{
TMArrayList<String> list1 =new TMArrayList<String>();
list1.add("shivpuri");
list1.add("ujjain");
list1.add("gwalior");
list1.forEach((p)->{System.out.println(p);});
TMLinkedList<Float> list2 =new TMLinkedList<Float>();
list2.add(2.2f);
list2.add(3.2f);
list2.add(4f);
list2.forEach((p)->{System.out.println(p);});
}
}