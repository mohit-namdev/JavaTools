package com.thinking.machines.util;
public class TMLinkedList<T> implements TMList<T>
{
class TMNode<T>
{
public T data;
public TMNode<T> next;
TMNode()
{
this.data=null;
this.next=null;
}
}
public class TMLinkedListIterator<T> implements TMIterator<T> //inner class
{
private TMNode<T> ptr; 
public TMLinkedListIterator(TMNode<T> ptr)
{
this.ptr=ptr;
}
public boolean hasNext()
{
return this.ptr!=null;
}
public T next()
{
if(ptr==null)throw new InvalidIteratorException("Iterator has no more elements");
T data=this.ptr.data;
this.ptr=this.ptr.next;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMLinkedListIterator<T>(this.start);
}

private TMNode<T> start,end;
private int size;
public TMLinkedList()
{
this.start=null;
this.end=null;
this.size=0;
}
public void add(T data)
{
TMNode<T> t=new TMNode<T>();
t.data=data;
if(this.start==null)
{
this.start=t;
this.end=t;
}
else
{
this.end.next=t;
this.end=t;
}
this.size++;
}
public void add(int index, T data)
{
if(index<0) throw new IndexOutOfBoundsException("Invalid index: "+index);
if(index>=size)
{
add(data);
return;
}
TMNode<T> g=new TMNode<T>();
g.data=data;
if(index==0)
{
g.next=this.start;
this.start=g;
}
else{
TMNode<T> t,j;
t=this.start;
j=null;
int x=0;
while(x<index)
{
j=t;
t=t.next;
x++;
}
j.next=g;
g.next=t;
}
this.size++;
}
public void insert(int index, T data)
{
add(index,data);
}
public void removeAll()
{
clear(); 
}
public void clear()
{
this.size=0;
this.start=null;
this.end=null;
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
TMNode<T> t;
t=start;
int x;
for(x=0;x<index;x++) t=t.next;
return t.data;
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
T data;
if(this.start==this.end)
{
data=this.start.data;
this.start=null;
this.end=null;
this.size=0;
return data;
}
if(index==0)
{
data=this.start.data;
start=start.next; 
}
else{
TMNode<T> t,j;
t=this.start;
j=null;
int x=0;
while(x<index)
{
j=t;
t=t.next;
x++;
}
data= t.data;
j.next=t.next;
if(this.end==t) this.end=j;
}
this.size--;
return data;
}
public void update(int index, T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
if(index==0)//if first node to be updated
{
this.start.data=data;
return;
}
if(index==this.size-1)//if last node to be updated
{
this.end.data=data;
return;
}
TMNode<T> t;
t=this.start;
int x=0;
while(x<index)
{
t=t.next;
x++;
}
t.data=data;
}
public void copyTo(TMList<T> other)
{
if(other==null)throw new NullPointerException("Cannot copy to: "+other);
other.clear();
for(int e=0;e<this.size();e++)other.add(this.get(e)); 
}
public void copyFrom(TMList<T> other)
{
if(other==null)throw new NullPointerException("Cannot copy from: "+other);
this.clear();
for(int e=0;e<other.size();e++)this.add(other.get(e));
}
public void appendTo(TMList<T> other)
{
if(other==null)throw new NullPointerException("Cannot append to: "+other);
for(int e=0;e<this.size();e++)other.add(this.get(e));
}
public void appendFrom(TMList<T> other)
{
if(other==null)throw new NullPointerException("Cannot append from: "+other);
for(int e=0;e<other.size();e++)this.add(other.get(e));
}

public void forEach(TMListItemAcceptor<T> a)
{
if(a==null)return;
TMNode<T> t;
for(t=start;t!=null;t=t.next)a.accept(t.data);
}


}