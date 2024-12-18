import com.thinking.machines.util.*;
class TMIteratorTestCase
{
public static void main(String gg[])
{
TMLinkedList<Integer> list1=new TMLinkedList<Integer>();
list1.add(10);
list1.add(20);
list1.add(30);
list1.add(40);
TMArrayList<Integer> list2=new TMArrayList<Integer>();
list2.add(1000);
list2.add(2000);
list2.add(3000);
System.out.println("Iterating on linked list");
TMIterator<Integer> iterator1= list1.iterator();
int x;
while(iterator1.hasNext())
{
x=iterator1.next();
System.out.println(x);
}
System.out.println("Iterating on Array list");
TMIterator<Integer> iterator2= list2.iterator();
while(iterator2.hasNext())
{
x=iterator2.next();
System.out.println(x);
}
}
}