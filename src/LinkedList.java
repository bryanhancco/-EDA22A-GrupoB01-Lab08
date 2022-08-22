public class LinkedList<E>{
  Node<E> first;

  public LinkedList(){
    this.first = null;
  }

  public void insertFirst(E data){
    this.first = new Node<>(data,this.first);
  }

  public boolean isEmty(){
    return this.first == null;
  }

  public E search(E data){
    if(this.first == null) return null;
    else{
      for (Node<E> i = this.first; i != null; i = i.next) {
        if(i.data = data) return data;
      }
    }
    return null;
  }

  public E remove(E data){
    if(this.first == null) return null;
    else if(this.first.data = data){
      this.first = this.first.next;
      return data;
    } 
    else{
      for (Node<E> i = this.first; i != null; i = i.next) {
        if(i.next != null && i.next.data == data){
          i.next = i.next.next; 
          return data;
        } 
      }
      return null;
    }
  }

  public String toString(){
    String str = "";
    for (Node<E> i = this.first; i != null; i = i.next) {
      str =  i.data + " , " + str;
    }
    return str;
  }



}

