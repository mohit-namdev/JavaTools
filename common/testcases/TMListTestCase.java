import com.thinking.machines.util.*;
class TMListTestCase
{
public static void main(String gg[])
{
TMArrayList list1=new TMArrayList();
for(int i=0;i<20;i++)list1.add(i);
for(int i=0;i<list1.size();i++) System.out.println(list1.get(i));
}
}