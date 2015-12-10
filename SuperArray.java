public class SuperArray  {

    private Comparable[] _data;
    private int _lastPos;//position of last meaningful value
    private int _size;//size of this instance of SuperArray

    //constructor
    public SuperArray() {
        _data = new Comparable[10];
        _lastPos=-1;
        _size = 0; 
    }

    //toString method, printing SuperArray
    public String toString() {
        String retS="[";
        for (int i=0; i<_size;i++) {
            retS+=_data[i]+ ",";
        }
        if (retS.length()>1) {
            retS=retS.substring(0, retS.length()-1);
        }
        retS+="]";
        return retS;
    }

    //double the size of the array
    private void expand() {
        Comparable[] _data2 = new Comparable[_data.length * 2];
        for (int i = 0; i < _data.length; i++) {
            _data2[i] = _data[i];
        }   
        _data=_data2;
    }

    //return specific Comparable within SuperArray
    public Comparable get(int index) {
        return _data[index];
    }

    //set a specific index as a specific Comparable
    public Comparable set(int index, Comparable newVal) {
        Comparable temp = _data[index];
        _data[index] = newVal;
        return temp;
    }

    //add a Comparable at the end of the SuperArray
    public void add(Comparable val) {
        add_at_index(_size, val);
    }
    
    //inserts a Comparable at a specific index
    public void add_at_index(int index, Comparable newVal) {
        if (index > _size) {
            System.out.println("Error");
        }
        else {
            if (_size + 1 >_data.length) {
                expand();
            }
            Comparable temp = newVal;
            for (int i = _size; i >= index; i--) {
                temp=set(index, temp);
            }
        _size++;
        _lastPos++;
        }
    }

  //removes a Comparable at specific index
  //shifts elements left to fill in newly-empted slot
    public void remove(int index) {
        if (index < _size) {
            for (int i = index; i < _lastPos; i++) {
                _data[i] = _data[i + 1];
            }
            _data[_lastPos] = new Hexadecimal(0);
            _size--;
            _lastPos--;
        }
    }

  //return number of meaningful items in _data
    public int size() {
        return _size;
    }

    public int linSearch(Comparable target) {
        for (int i = 0; i < _size; i++) {
            if (target.equals(get(i))) 
                return i;
        }
        return -1;
    }

    public boolean isSorted(){
        for (int i = 1; i < _size; i++) {
           if (_data[i].compareTo(_data[i-1]) < 0)
               return false;
        }
        return true;
    }


    public static void main( String[] args ) {
        System.out.println("Testing numerous Binaries, Rationals, and Hex's...");
        SuperArray  a = new SuperArray();
     	Binary b = new Binary(67);
        Binary b2 = new Binary("1001101");
     	Hexadecimal h1 = new Hexadecimal(32);
     	Hexadecimal h2 = new Hexadecimal(18);
        Hexadecimal h3 = new Hexadecimal("2EF3");
     	Rational r1 = new Rational(50,4);
     	Rational r2 = new Rational(33,7);
     	Rational r3 = new Rational(48,2);
        a.add(b2);
        a.add(h3);
     	a.add(h2);
     	a.add(r2);
     	a.add(b);
     	a.add(h1);
     	a.add(r3);
     	a.add(r1);
     	System.out.println(a);
        System.out.println("Testing linSearch...");
     	System.out.println(a.linSearch(b));
     	System.out.println(a.linSearch(r3));
        System.out.println(a.linSearch(h3));
        System.out.println("Testing Complete.");
       }//end main

}//end class
 