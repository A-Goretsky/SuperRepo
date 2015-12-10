//Anton Goretsky
//APCS1 pd5
//HW44 - This or That or Fourteen Other Things
//2015-12-8

public class Hexadecimal implements Comparable {
    
//instance vars
    private final static String HEXDIGITS = "0123456789ABCDEF";
    public int _decNum;
    public String _hexNum;

//default constructor
    public Hexadecimal() {
        _hexNum = "";
        _decNum = 0;
    }

//overloaded constructor for dec input
    public Hexadecimal(int n) {
        _hexNum = decToHex(n);
        _decNum = n;
    }
    
//overloaded constructor for hex input
    public Hexadecimal(String s) {
        _hexNum = s;
        _decNum = hexToDec(s);
    }
    
//toString method
    public String toString() {
        return _hexNum;
    }

//decimal to hex, iteratively
    public static String decToHex(int n) {
        if (n == 0)
            return "0";
        String ans ="";
        while (n != 0) {
            ans = HEXDIGITS.charAt(n % 16) + ans;
			n /= 16;
		}
		return ans;    
    }
    
//decimal to hex, recursively
    public static String decToHexR(int n) {
		String ans = "";
		if (n != 0) {
			ans += decToHexR(n / 16) + HEXDIGITS.charAt(n % 16);
		}
        if (n == 0 && ans.length() == 0)
            return "0";
		return ans;
    }

//hex to decimal, iteratively
    public static int hexToDec(String s) {
        int ans = 0;
		for (int x = s.length() - 1; x >= 0; x--) {
			ans += (int) (HEXDIGITS.indexOf(s.charAt(0)) * Math.pow(16, x));
			s = s.substring(1);
		}
		return ans;
    }
  
//hex to decimal, recursively
    public static int hexToDecR(String s) {
		int ans = 0;
		if (s.length() != 0) {
			ans += ((int) (HEXDIGITS.indexOf(s.charAt(0)) * Math.pow(16, s.length() - 1))) + hexToDecR(s.substring(1));
		}
		return ans;
    }
	
//equals override
	public boolean equals(Object other) {
		return (this == other || this.compareTo(other) == 0);
	}
	
//compareTo method
	public int compareTo(Object other) {
        if (other == null)
            throw new NullPointerException();
		if (!(other instanceof Hexadecimal))
			throw new ClassCastException("\n Error: compareTo() input was not of class Hexadecimal!");
        return _decNum - ((Hexadecimal) other)._decNum;
	}
    
	
	//main method for testing
    public static void main( String[] args ) {
	//Hexadecimal h1 = new Hexadecimal("10FFD"); //69629
	System.out.println(hexToDec("10FD")); //4349

	System.out.println();
	System.out.println( "Testing ..." );

	Hexadecimal h1 = new Hexadecimal(26);
	Hexadecimal h2 = new Hexadecimal(26);
	Hexadecimal h3 = h1; // new Hexdecimal(5)
	Hexadecimal h4 = new Hexadecimal("10FFD"); //69629
	//System.out.println(hexToDec("10FD")); //4349

	System.out.println( h1 );//1A
	System.out.println( h2 );//1A
	System.out.println( h3 );//1A
	System.out.println( h4 );//10FFD
	System.out.println( "\n==..." );
	System.out.println( h1 == h2 ); //should be false
	System.out.println( h1 == h3 ); //should be true

	System.out.println( "\n.equals()..." );
	System.out.println( h1.equals(h2) ); //should be true
	System.out.println( h1.equals(h3) ); //should be true
	System.out.println( h3.equals(h1) ); //should be true
	System.out.println( h4.equals(h2) ); //should be false
	System.out.println( h1.equals(h4) ); //should be false

	System.out.println( "\n.compareTo..." );
	System.out.println( h1.compareTo(h2) ); //should be 0
	System.out.println( h1.compareTo(h3) ); //should be 0
	System.out.println( h1.compareTo(h4) ); //should be neg
	System.out.println( h4.compareTo(h1) ); //should be pos*/
        
    //null object test
    Object bla = null;
    System.out.println(h1.equals(bla));

	//invalid object test
	Object stuff = new Object();
	System.out.println(h1.equals(stuff)); //should return new error.
	}
}