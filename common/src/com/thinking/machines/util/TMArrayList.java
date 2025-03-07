package com.thinking.machines.util;
//TMArrayList
public class TMArrayList<T> implements TMList<T>
{
private Object collection[];
private int size;
public class TMArrayListIterator<T> implements TMIterator<T> //inner class
{
private int index;
public TMArrayListIterator()
{
this.index=0;
}
public boolean hasNext()
{
return index!=size;
}
public T next()
{
if(index==size)throw new InvalidIteratorException("Iterator has no more elements");
T data=(T)get(index);
index++;
return data;
}
}
public TMIterator<T> iterator()
{
return new TMArrayListIterator<T>();
}
public TMArrayList()
{
this.collection=new Object[10];
this.size=0;
}
public void add(T data)
{
if(this.size==collection.length)
{
Object tmp[];
tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++)tmp[e]=this.collection[e];
this.collection=tmp;
}
this.collection[this.size]=data;
this.size++;
}
public void add(int index, T data)
{
if(index<0 || index>this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
if(this.size==collection.length)
{
Object tmp[];
tmp=new Object[this.size+10];
for(int e=0;e<this.size;e++) tmp[e]=this.collection[e];
this.collection=tmp;
}
for(int e=this.size;e>index;e--) this.collection[e]=this.collection[e-1];
this.collection[index]=data;
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
}
public int size()
{
return this.size;
}
public T get(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);  
return (T)this.collection[index];
}
public T removeAt(int index)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
T data=(T) this.collection[index];
int ep=this.size-2;
for(int e=index;e<=ep;e++)this.collection[e]=this.collection[e+1];
this.size--;
return data;
}
public void update(int index, T data)
{
if(index<0 || index>=this.size) throw new IndexOutOfBoundsException("Invalid index: "+index);
this.collection[index]=data;
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
for(int e=0;e<this.size;e++) a.accept((T)collection[e]);
}

}