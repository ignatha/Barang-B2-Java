/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package barang;
import java.util.*;

/**
 *
 * @author ignatha
 */

    
    /**
 *Exception to indicate that LinkedList is empty.
 */

 
/**
 *Node class, which holds data and contains next which points to next Node.
 */
class Node {
    public int jumlah;
    public int harga;// data in Node.
    public Node next; // points to next Node in list.
 
    /**
     * Constructor
     */
    public Node(int jumlah,int harga){
           this.harga = harga;
           this.jumlah = jumlah;
    }
 
    /**
     * Display Node's data
     */
   
}

class Laba {
    public int harga;
    public Laba next; // points to next Node in list.
 
    /**
     * Constructor
     */
    public Laba(int harga){
           this.harga = harga;
           
    }
 
 }

/**
 *Node class, which holds data and contains next which points to next Node.
 */




class listLaba{
    // ref to first link on list
    
 
private Laba first;
    /**
     * LinkedList constructor
     */
    public listLaba(){
           first = null;
    }
    
    public void labaFirst(int harga) {
           Laba newNode = new Laba(harga); //Creation of New Node.
           newNode.next = first;   //newLink ---> old first
           first = newNode;  //first ---> newNode
    }
    
   public int hitungLaba(){
   Laba hitung = first; // start at the beginning of linkedList
   int laba=0;
           while (hitung != null){
               // Executes until we don't find end of list.
           laba += hitung.harga;
           hitung = hitung.next; // move to next Node
           
           }
           return laba;     
   }

}

/***------------------------------------------------- stack operate --------------*/
 
/**
 * LinkedList class
 */
class LinkedList {
    
    listLaba labaLinkedList=new listLaba();
    
    private Node first; // ref to first link on list
 
    /**
     * LinkedList constructor
     */
    public LinkedList(){
           first = null;
    }
 
    /**
     * Insert New Node at first position
     */
    public void insertFirst(int jumlah, int harga) {
           Node newNode = new Node(jumlah,harga); //Creation of New Node.
           newNode.next = first;   //newLink ---> old first
           first = newNode;  //first ---> newNode
    }
 
    /**
     * Deletes first Node
     */
       
   public int hitungstock(){
   Node hitung = first; // start at the beginning of linkedList
   int stock=0;
           while (hitung != null){
               // Executes until we don't find end of list.
           stock += hitung.jumlah;
           hitung = hitung.next; // move to next Node
           
           }
           return stock;     
   }
   
   public int hitunglabastock(){
   Node hitung = first; // start at the beginning of linkedList
   int laba=0;
           while (hitung != null){
               // Executes until we don't find end of list.
           laba += hitung.jumlah*hitung.harga;
           hitung = hitung.next; // move to next Node
           
           }
           return laba;     
   }
   
   
    
   void beli(int jumlah, int harga)
            
    {
         int coba = hitungstock();
         if(coba-jumlah>=0){
         if(first!=null){  //means LinkedList in empty, throw exception.              
                  
           
          int laba=0;
           int kurangan = jumlah;
           do{             
               Node tempNode = first;
               if(tempNode.jumlah-kurangan>0){
                   laba += (harga-tempNode.harga)*kurangan;
                   
               tempNode.jumlah = tempNode.jumlah-kurangan;    
               kurangan=0;
               }else if(tempNode.jumlah-kurangan<=0){
                   
               laba += (harga-tempNode.harga)*tempNode.jumlah;
               kurangan-=tempNode.jumlah;
               //stackLinkedList.pop();
               first = first.next;
               }
               
                   
           }while(kurangan!=0);
           //stackUntung.push(laba);
           labaLinkedList.labaFirst(laba);
           //st.push(st, laba);
           
           }else{System.out.println("Stock Kosong");}
           // save reference to first Node in tempNode- so that we could return saved reference
           // delete first Node (make first point to second node)
           // return tempNode (i.e. deleted Node)
         }else{System.out.println("Stock Tidak Cukup");}
    }
   
   public int getUntung(){
   
   return labaLinkedList.hitungLaba();
   
   }
    
           
   
 
}



class StackLinkedList{
    
    LinkedList linkedList = new LinkedList(); // creation of Linked List
    listLaba labaList = new listLaba();
    
    /**
     * Push items in stack, it will put items on top of Stack.
     */
    public void push(int jumlah,int harga){
           linkedList.insertFirst(jumlah,harga);
    }
    
    
 
    /**
     * Pop items in stack, it will remove items from top of Stack.
     */
    
    
    public void beli(int jumlah, int harga) {
           linkedList.beli(jumlah,harga);
    }
 
    /**
     * Display stack.
     */
    
    
    
    public void getStock() {
          int coba = linkedList.hitungstock();
          
           System.out.print(coba);
    }
    
    public void getlabastock() {
          int coba = linkedList.hitunglabastock();
          
           System.out.print(coba);
    }
   
    public void getLaba() {
          int coba = linkedList.getUntung();
          System.out.print(coba);
    }
    
    public void getTotal() {
          int coba = linkedList.getUntung()+linkedList.hitunglabastock();
          System.out.print(coba);
    }
    
}

/*---------------------end of stack -------------------------------------------*/
/*---------------------queue operate -------------------------------------------*/

/**
 * LinkedList class
 */
class QueList {
    private Node first; // ref to first link on list
       listLaba labaLinkedList=new listLaba();
    /**
     * LinkedList constructor
     */
    public QueList(){
           first = null;
    }
 
    public int hitungstock(){
   Node hitung = first; // start at the beginning of linkedList
   int stock=0;
           while (hitung != null){
               // Executes until we don't find end of list.
           stock += hitung.jumlah;
           hitung = hitung.next; // move to next Node
           
           }
           return stock;     
   }
        
    /**
     * Inserts new Node at last of LinkedList.
     */
    public void insertLast(int jumlah, int harga){
           Node newNode = new Node(jumlah,harga); //Creation of New Node.
           
           if(first==null){  //means LinkedList is empty, make first point to new Node.
                  first=newNode;    //first ---> newNode
                  return;
           }
           
           Node tempNode = first; // save reference to first Node in tempNode- so that we could return saved reference.
           while(tempNode.next!=null){ //Executes until we don't find last Node of LinkedList.
                                                           //If next of some Node is pointing to null, that means it's a last Node.
                  tempNode=tempNode.next; //move to next Node.
           }
           tempNode.next=newNode;  //make last's Node next point to new Node
    }
    
    
 
 
    /**
     * Deletes first Node
     */
    void jualq(int jumlah, int harga)
            
    {
         int coba = hitungstock();
         if(coba-jumlah>=0){
         if(first!=null){  //means LinkedList in empty, throw exception.              
                  
           
          int laba=0;
           int kurangan = jumlah;
           do{             
               Node tempNode = first;
               if(tempNode.jumlah-kurangan>0){
                   laba += (harga-tempNode.harga)*kurangan;
                   
               tempNode.jumlah = tempNode.jumlah-kurangan;    
               kurangan=0;
               }else if(tempNode.jumlah-kurangan<=0){
                   
               laba += (harga-tempNode.harga)*tempNode.jumlah;
               kurangan-=tempNode.jumlah;
               //stackLinkedList.pop();
               first = first.next;
               }
               
                   
           }while(kurangan!=0);
           //stackUntung.push(laba);
           labaLinkedList.labaFirst(laba);
           //st.push(st, laba);
           
           }else{System.out.println("Stock Kosong");}
           // save reference to first Node in tempNode- so that we could return saved reference
           // delete first Node (make first point to second node)
           // return tempNode (i.e. deleted Node)
         }else{System.out.println("Stock Tidak Cukup");}
    }
   
    public int hitunglabastock(){
   Node hitung = first; // start at the beginning of linkedList
   int laba=0;
           while (hitung != null){
               // Executes until we don't find end of list.
           laba += hitung.jumlah*hitung.harga;
           hitung = hitung.next; // move to next Node
           
           }
           return laba;     
   }
    
    public int getUntung(){
   
   return labaLinkedList.hitungLaba();
   
   }
 
    
        
 
}
 
 
/**
 * For implementing queue using using LinkedList- This QueueLinkedList
 * class internally maintains LinkedList reference in java.
 */
 
class QueueLinkedList{
    
    QueList linkedList = new QueList(); // creation of Linked List
    
    /**
     * Insert element at rear in Queue
     */
    public void enque(int jumlah,int harga){
           linkedList.insertLast(jumlah,harga);
    }
 
    /**
     * Removes elements from front of Queue 
     */
    public void jual(int jumlah, int harga) {
           linkedList.jualq(jumlah,harga);
    }
 
    /**
     * Display queue.
     */
    
    public void getStock() {
          int coba = linkedList.hitungstock();
          
           System.out.print(coba);
    }
    
    public void getlabastock() {
          int coba = linkedList.hitunglabastock();
          
           System.out.print(coba);
    }
   
    public void getLaba() {
          int coba = linkedList.getUntung();
          System.out.print(coba);
    }
    
    public void getTotal() {
          int coba = linkedList.getUntung()+linkedList.hitunglabastock();
          System.out.print(coba);
    }
    
 
    
}

/*---------------------end of queue -------------------------------------------*/



public class Barang {
    
    public static void stackproses(){

// TODO code application logic here
        StackLinkedList stackLinkedList=new StackLinkedList();

        
        Scanner masukan = new Scanner (System.in);
        int menu,jumlah,harga;
        
        
        // TODO code application logic here
        int loop=1;
        char opsi1='y';
        char opsi2='y';
        while(loop==1){
        System.out.print("Pilih Menu : \n\n1. Beli produk \n2. Jual produk\n3. Transaksi selesai\nMasukkan Nomor Pilihan : ");        
        menu = masukan.nextInt();
        if(menu == 1){
            do{
                  System.out.print("Masukkan Jumlah \t: ");
                  jumlah = masukan.nextInt();
                  System.out.print("Masukkan Harga \t\t: ");
                  harga= masukan.nextInt();
                  stackLinkedList.push(jumlah,harga);
                  System.out.print("\nStock Barang \t\t: " );
                  stackLinkedList.getStock();
                  System.out.print("\n\n" + "Ingin membeli lagi (y/n) :");
                  opsi1=masukan.next().charAt(0);
            }while(opsi1=='y');
            loop=1;
         } else if(menu == 2){
             do{
                  System.out.print("Masukkan Jumlah \t: ");
                  int jumlah_beli = masukan.nextInt();
                  System.out.print("Masukkan Harga \t\t: ");
                  int harga_beli= masukan.nextInt();
                  stackLinkedList.beli(jumlah_beli,harga_beli);
                  System.out.print("\nStock Barang \t\t: " );
                  stackLinkedList.getStock();
                  System.out.print("\n\n" + "Ingin menjual lagi (y/n) :");
                  opsi2=masukan.next().charAt(0);
            }while(opsi2=='y');
            loop=1;
         }else if(menu == 3){
             
             System.out.print("\n-----------------------------------\n\n");
             System.out.print("Stock barang di gudang \t: ");
             stackLinkedList.getStock();
             System.out.print("\n");
             System.out.print("Kekayaan dari gudang \t: ");
             stackLinkedList.getlabastock();
             System.out.print("\n");
             System.out.print("Laba Penjualan \t\t: ");
             stackLinkedList.getLaba();
             System.out.print("\n");
             System.out.print("Jumlah Kekayaan \t: ");
             stackLinkedList.getTotal();
             System.out.print("\n");
             loop=0;
             
         }
        
        }while(loop==1); 

}
    
 public static void queueproses(){
            // TODO code application logic here
        QueueLinkedList stackLinkedList=new QueueLinkedList();

        
        Scanner masukan = new Scanner (System.in);
        int menu,jumlah,harga;
        
        
        // TODO code application logic here
        int loop=1;
        char opsi1='y';
        char opsi2='y';
        while(loop==1){
        System.out.print("Pilih Menu : \n\n1. Beli produk \n2. Jual produk\n3. Transaksi selesai\nMasukkan Nomor Pilihan : ");        
        menu = masukan.nextInt();
        if(menu == 1){
            do{
                  System.out.print("Masukkan Jumlah \t: ");
                  jumlah = masukan.nextInt();
                  System.out.print("Masukkan Harga \t\t: ");
                  harga= masukan.nextInt();
                  stackLinkedList.enque(jumlah,harga);
                  System.out.print("\nStock Barang \t\t: " );
                  stackLinkedList.getStock();
                  System.out.print("\n\n" + "Ingin membeli lagi (y/n) :");
                  opsi1=masukan.next().charAt(0);
            }while(opsi1=='y');
            loop=1;
         } else if(menu == 2){
             do{
                  System.out.print("Masukkan Jumlah \t: ");
                  int jumlah_beli = masukan.nextInt();
                  System.out.print("Masukkan Harga \t\t: ");
                  int harga_beli= masukan.nextInt();
                  stackLinkedList.jual(jumlah_beli,harga_beli);
                  System.out.print("\nStock Barang \t\t: " );
                  stackLinkedList.getStock();
                  System.out.print("\n\n" + "Ingin menjual lagi (y/n) :");
                  opsi2=masukan.next().charAt(0);
            }while(opsi2=='y');
            loop=1;
         }else if(menu == 3){
             
             System.out.print("\n-----------------------------------\n\n");
             System.out.print("Stock barang di gudang \t: ");
             stackLinkedList.getStock();
             System.out.print("\n");
             System.out.print("Kekayaan dari gudang \t: ");
             stackLinkedList.getlabastock();
             System.out.print("\n");
             System.out.print("Laba Penjualan \t\t: ");
             stackLinkedList.getLaba();
             System.out.print("\n");
             System.out.print("Jumlah Kekayaan \t: ");
             stackLinkedList.getTotal();
             System.out.print("\n");
             loop=0;
             
         }
        
        }while(loop==1); 
     
 
 
 }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
         
       Scanner masukan = new Scanner (System.in);
       
       System.out.print("Pilih Menu : \n\n1. Operasi Stack \n2. Operasi Queue\n\nMasukkan Nomor Pilihan : ");
       int menu = masukan.nextInt(); 
       switch(menu){
           case 1:
               stackproses();           
            break;
           case 2:
               queueproses();
            break;
            
       }
       
       
    }
    
}
