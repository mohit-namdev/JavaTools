import com.thinking.machines.util.*;
class TMLinkedListTestCase
{
public static void main(String gg[])
{
TMLinkedList list1=new TMLinkedList();
for(int i=0;i<20;i++)list1.add(i);
System.out.println("data of list 1: ");
for(int i=0;i<list1.size();i++) System.out.print(list1.get(i)+" ");
System.out.print("\n");
list1.insert(9,100);
System.out.println("After insertion at index 9: ");
for(int i=0;i<list1.size();i++) System.out.print(list1.get(i)+" ");
System.out.println("\nsize of list 1: "+list1.size());
System.out.println("removing data at index: "+list1.removeAt(8));
System.out.println("After removing at index 8: ");
for(int i=0;i<list1.size();i++) System.out.print(list1.get(i)+" ");
System.out.print("\n");
list1.update(8,8);
System.out.println("After updation at index 8: ");
for(int i=0;i<list1.size();i++) System.out.print(list1.get(i)+" ");
System.out.print("\n");
TMLinkedList list2=new TMLinkedList();
for(int i=100;i<120;i++)list2.add(i);
System.out.println("data of list 2: ");
for(int i=0;i<list2.size();i++) System.out.print(list2.get(i)+" ");
System.out.print("\n");
System.out.println("After copying list 2 to list 1, data of list 1: ");
list1.copyFrom(list2);
for(int i=0;i<list1.size();i++) System.out.print(list1.get(i)+" ");
System.out.print("\n");
TMLinkedList list3=new TMLinkedList();
for(int i=25;i<50;i++)list3.add(i);
System.out.println("data of list 3: ");
for(int i=0;i<list3.size();i++) System.out.print(list3.get(i)+" ");
System.out.print("\n");
list3.copyTo(list2);
System.out.println("After copying list 2,data of list 3: ");
for(int i=0;i<list3.size();i++) System.out.print(list3.get(i)+" ");
System.out.print("\n");
list1.appendTo(list3);
System.out.println("After appending list 1,data of list 3: ");
for(int i=0;i<list3.size();i++) System.out.print(list3.get(i)+" ");
System.out.print("\n");
list1.appendFrom(list3);
System.out.println("After appending list 3,data of list 1: ");
for(int i=0;i<list1.size();i++) System.out.print(list1.get(i)+" ");
System.out.print("\n");
}
}