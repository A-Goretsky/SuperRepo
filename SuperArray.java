//Team Pip-Boys: Shariar Kabir, Anton Goretsky
//APCS1 PD5
//HW #42: Array of Titanium
//2015-12-1

/*****************************
  * SKELETON for
  * class SuperArray --  A wrapper class for an array. 
  * Maintains functionality:
  *  access value at index
  *  overwrite value at index
  *  report number of meaningful items
  * Adds functionality to std Java array:
  *  resizability
  *  ability to print meaningfully
  *  add item (at end)
  *  insert item
  *  remove item (while maintaining "left-justification")
  *****************************/

public class SuperArray {
  
  //~~~~~INSTANCE VARS~~~~~
  //underlying container, or "core" of this data structure:
  private Comparable[] _data;
  
  //position of last meaningful value
  private int _lastPos;
  
  //size of this instance of SuperArray
  private int _size;
  
  
  //~~~~~METHODS~~~~~
  //default constructor – initializes 10-item array
  public SuperArray() 
  { 
    _data = new Comparable[10];
    _lastPos = -1; //flag to indicate no lastpos yet
    _size = 0; 
  }
  
  
  //output array in [a,b,c] format, eg
  // {1,2,3}.toString() -> "[1,2,3]"
  public String toString() 
  { 
    String foo = "[";
    for( int i = 0; i < _size; i++ ) {
      foo += _data[i] + ",";
    }
    //shave off trailing comma
    if ( foo.length() > 1 )
      foo = foo.substring( 0, foo.length()-1 );
    foo += "]";
    return foo;
  }
  
  
  //double capacity of this SuperArray
  private void expand() 
  { 
    Comparable[] temp = new Comparable[ _data.length * 2 ];
    for( int i = 0; i < _data.length; i++ )
      temp[i] = _data[i];
    _data = temp;
  }
  
  
  //accessor -- return value at specified index
  public Comparable get( int index ) { return _data[index]; }
  
  
  //mutator -- set value at index to newVal, 
  //           return old value at index
  public Comparable set( int index, Comparable newVal ) 
  { 
    Comparable temp = _data[index];
    _data[index] = newVal;
    return temp;
  }
  
  
  // ~~~~~~~~~~~~~~ PHASE II ~~~~~~~~~~~~~~
  //adds an item after the last item
  public void add( Comparable newVal ) { //After the last meaningful index it adds it
    _lastPos+=1;
    _data[_lastPos]=newVal;
    size();
    
    
  }
  
  
  //inserts an item at index
  //shifts existing elements to the right
  public void add( int index, Comparable newVal ) { //Adds in the index, has boolean value to see if it has changed a val
    Comparable[] tempora = new Comparable[_data.length + 1];
    boolean done = false;
    for (int x =0; x < _data.length  ; x++){
      if (x!=index){tempora[x]=_data[x];}
      else if (x == index && done == false){
        tempora[index]=newVal;
        x-=1;
        done = true;       
      }
    }
    _data=tempora;
    size(); 
  }
  
  
  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index ) { //It removes it, but resets x and then adds the rest back. 
    if (index < _size) {
        for (int i=index; i<_lastPos;i++) {
            _data[i]=_data[i+1];
        }
    _size--;
    _lastPos--;
    }
  }
  
  
  //return number of meaningful items in _data
  public int size() {  //returns all non 0 ints
      return _size;
  }
    
    
    //is sorted method
    public boolean isSorted(){
	   for (int i = 1; i < _size; i++) {
           if ( _data[i].compareTo(_data[i-1]) < 0 )
               return false;
       }
        return true;
    }
    
    //lin search method
    public int linSearch(Comparable target) {
        for (int i = 0; i < _size; i++) {
            if (target.equals( get(i) )) return i;
        }
        return -1;
    }

  
  //main method for testing
  public static void main( String[] args ) 
  {
    
        SuperArray mayfield = new SuperArray();
        Binary b = new Binary(67);
        Binary c = new Binary("10010");
     	Hexadecimal h1 = new Hexadecimal(21);
     	Hexadecimal h2 = new Hexadecimal("5F3");
     	Rational r1 = new Rational(50,2);
     	Rational r2 = new Rational(38,2);
     	Rational r3 = new Rational(44,2);
     	mayfield.add(h2);
     	mayfield.add(r2);
     	mayfield.add(b);
     	mayfield.add(h1);
     	mayfield.add(r3);
     	mayfield.add(r1);
     	System.out.println(mayfield);
     	System.out.println(mayfield.linSearch(b));
     	System.out.println(mayfield.linSearch(r3));
     	System.out.println(mayfield.isSorted());
      
      

     

  }//end main
  
}//end class