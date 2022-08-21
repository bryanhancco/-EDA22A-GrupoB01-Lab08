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

  public String toString(){
    String str = "";
    return str;
  }



}

