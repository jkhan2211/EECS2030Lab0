package lab0package;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.Timeout;





public class lab0test {
	
	

	@Rule
	public Timeout globalTimeout = Timeout.seconds(1);
	
	
	@Test
	public void test00_one() {
		assertEquals(1, lab0.one());
	}
	
	//[Question 1]
	@Test
	public void test01_isDivisible() {
		
		
		assertEquals("isDivisible (3, 5) is not implemented correclty", false,
				lab0.isDivisible(3, 5));
		assertEquals("isDivisible (5, 21) is not implemented correclty", false,
				lab0.isDivisible(5, 21));
		assertEquals("isDivisible ( 5,10 ) is not implemented correclty", true,
				lab0.isDivisible(5, 10));
		assertEquals("isDivisible(64, 512) is not implemented correclty", true,
				lab0.isDivisible(64, 512));
		assertEquals("isDivisible is not implemented correclty", true,
				lab0.isDivisible(64, -512));
		assertEquals("isDivisible is not implemented correclty", true,
				lab0.isDivisible(2, 2));
		
	}
	
	
	
	
	
	//[Question 2]
	
	@Test
	public void test02_isPrime() {
		
		
		
		assertEquals("isPrime ( 81) is not implemented correclty", false,
				lab0.isPrime ( 81));
		assertEquals("isPrime ( 24) is not implemented correclty", false,
				lab0.isPrime ( 6));
		assertEquals("isPrime ( -8)  is not implemented correclty", false,
				lab0.isPrime ( -8));
		assertEquals("isPrime (29) is not implemented correclty ", true,
				lab0.isPrime ( 29));
		assertEquals("isPrime ( 13) is not implemented correclty ", true,
				lab0.isPrime ( 13));
	}
	

	@Test //Ques. 3
	public void test03_gaussian() {
		final double[] x = {  -3.0, -1.0, 0, 1.0, 3.0};
		final double[] exp = {0,    0.1468,   0.3989,   0.1468,   0 };
		int sigma=1;
		for (int i = 0; i < x.length; i++) {
			String error = String.format("normal(%s) failed\n", x[i]);
			assertEquals(error, exp[i], lab0.gaussian(x[i], sigma), 1e-1);
	}
	}
	
	

	 
	
	//[Question 4] 
	 
	  @Test
		public void test04() {
			
			/////////////////////////////////////////////////////////////////////////  
			System.out.println("===Array contains the Required Element (a) or not?===");
	        int[] ia1 = {3, 6, 2, 5};
	        int a=3;
	       // System.out.println("ia1 contains (a)?" + lab0.contains(ia1,a));
			
			assertEquals(true, lab0.contains(ia1,a));
			assertEquals(false, lab0.contains(ia1,43));
			
			 int[] aa = {3}; 
			 assertEquals(true, lab0.contains(aa,3)); 
			 assertEquals(false, lab0.contains(aa,43));
		}
		
	//[Question 5]/////////////////////////////////////////////////////////////////////////  

		@Test
		public void test05() {
			System.out.println("===Maximum Value of an Array===");
	        int[] my_array = {25, 14, 56, 15, 36, 56, 77, 189, 29, 49};
	        int Result;
	        Result=lab0.maximum(my_array);
	        System.out.println(" Original Array: "+printArray(my_array));
	        System.out.println(" Maximum value for the above array = " + Result);
	        assertEquals(189, Result);
	        int[] my_array2 = {25};
            assertEquals(25, lab0.maximum(my_array2));
	     
		}
		
		
		//[Question 6]/////////////////////////////////////////////////////////////////////////  
	    @Test	
	    public void test06() {
	    	 int[] ia6 = {3, 4, 5};
	         
	         System.out.println("===Reverse  an Array===");
	         System.out.println("{3, 4, 5} should return {5, 4, 3} : "
	         						+ printArray(lab0.reverseOf(ia6)));
	         
	         
	        int[] result= {5,4,3};
	         assertArrayEquals(result, lab0.reverseOf(ia6));
	         int[] ia = {3};
             int[] result1= {3};
             assertArrayEquals(result1, lab0.reverseOf(ia));

			
		}
		

		/**
		 *  <p> <strong> Helper Method: do not change.</strong></p>
		 * The method creates a string containing all element of the input array of integer 
		 * @param inputarray  input array of integer to print  
		 * @return string contains the input array elements  
		 */
		static String printArray(int[] inputarray) {
		    String s = "";
		    s += "{";
		    for(int i = 0; i < inputarray.length; i ++) {
		        s += inputarray[i];
		        if(i < inputarray.length - 1) {
		            s += ", ";
		        }
		    }
		    s += "}";
		    return s;
		}

	  
		
		//[Question 7]
	 
	  @Test
	  public void test07_contains1() {
	 
	    for (int i = 0; i < 100; i++) {
	      int min = 100 - 50;
	      int max = min + i;
	      this.testOutsideRange(min, max);
	      this.testInsideRange(min, max);
	    }
	  }
	  
	  private void testOutsideRange(int min, int max) {
	    final double[] X = {Double.NEGATIVE_INFINITY,
	        min - 100.0,
	        min - 1.0,
	        Math.nextAfter(min, min - 1.0),
	        min,
	        max,
	        Math.nextAfter(max, max + 1.0),
	        max + 1.0,
	        max + 100.0,
	        Double.POSITIVE_INFINITY
	    };
	    Range r = new Range(min, max);
	    for (double x : X) {
	      String error = String.format("lab0.contains(%f, r) failed\n" +
	          "where r = %s\n", x, r);
	      assertEquals(error, 0, lab0.contains1(x, r));
	    }
	  }

	  private void testInsideRange(int min, int max) {
	    if (min == max) {
	      return;
	    }
	    double xStart = Math.nextAfter(min, min + 1.0);
	    double xEnd = Math.nextAfter(max, max - 1.0);
	    double step = (xEnd - xStart) / 10;
	    double[] X = new double[10];
	    X[0] = xStart;
	    X[9] = xEnd;
	    for (int i = 1; i < 9; i++) {
	      X[i] = X[i - 1] + step;
	    }
	    Range r = new Range(min, max);
	    for (double x : X) {
	      String error = String.format("lab0.contains(%f, r) failed\n" +
	          "where r = %s\n", x, r);
	      assertEquals(error, 1, lab0.contains1(x, r));
	    }
	  }
	  
	  

		//[Question 8]
	  @Test
	  public void test08_compareTo() {
	    //rng.setSeed(14);
	    for (int i = 0; i < 100; i++) {
	      int min = 100 - 50;
	      Range skinny = new Range(min, min + 1);
	      min = 200 - 50;
	      Range skinny2 = new Range(min, min + 1);
	      min = 300 - 50;
	      Range wide = new Range(min, min + 2);
	      String error = 
	          String.format("lab0.compareTo(r1, r2) failed for r1 = %s, r2 = %s",
	          skinny, skinny);
	      assertEquals(error, 0, lab0.compareTo(skinny, skinny));
	      
	      error = 
	          String.format("lab0.compareTo(r1, r2) failed for r1 = %s, r2 = %s",
	          skinny, skinny2);
	      assertEquals(error, 0, lab0.compareTo(skinny, skinny2));
	      
	      error = 
	          String.format("lab0.compareTo(r1, r2) failed for r1 = %s, r2 = %s",
	          skinny, wide);
	      assertEquals(error, -1, lab0.compareTo(skinny, wide));
	      
	      error = 
	          String.format("lab0.compareTo(r1, r2) failed for r1 = %s, r2 = %s",
	          wide, skinny);
	      assertEquals(error, 1, lab0.compareTo(wide, skinny));
	    }
	  }

	  

		//[Question 9]
	  @Test
	  public void test09_hasValidLengthAndSeparator() {
	    final String[] VALID = {"01:30", "ab:cd", "29:99"};
	    for (int i = 0; i < VALID.length; i++) {
	      String s = VALID[i];
	      String error = 
	          String.format("lab0.hasValidLengthAndSeparator(s) returned false for s = %s", s);
	      assertTrue(error, lab0.hasValidLengthAndSeparator(s));
	    }
	    final String[] NOT_VALID = {"", "1:30", "01,23", "29:9"};
	    for (int i = 0; i < NOT_VALID.length; i++) {
	      String s = NOT_VALID[i];
	      String error = 
	          String.format("lab0.hasValidLengthAndSeparator(s) returned true for s = %s", s);
	      assertFalse(error, lab0.hasValidLengthAndSeparator(s));
	    }
	  }


	 
	//[Question 10]
	  @Test
	  public void test10a_sort2() {
	    ArrayList<Integer> t = new ArrayList<>();
	    String error = "lab0.sort2(t) failed to throw an IllegalArgumentException";
	    try {
	      lab0.sort2(t);
	      fail(error);
	    }
	    catch (IllegalArgumentException x) {
	      // do nothing
	    }
	    catch (Exception x) {
	      fail("lab0.sort2(t) threw the wrong kind of exception");
	    }
	    
	    t.add(1);
	    try {
	      lab0.sort2(t);
	      fail(error);
	    }
	    catch (IllegalArgumentException x) {
	      // do nothing
	    }
	    catch (Exception x) {
	      fail("lab0.sort2(t) threw the wrong kind of exception" + x);
	    }
	    
	    t.add(2);
	    t.add(3);
	    try {
	      lab0.sort2(t);
	      fail(error);
	    }
	    catch (IllegalArgumentException x) {
	      // do nothing
	    }
	    catch (Exception x) {
	      fail("lab0.sort2(t) threw the wrong kind of exception");
	    }
	  }

	  @Test
	  public void test10A_sort2() {
	    List<Integer> t = new ArrayList<>();
	    t.add(-1000);
	    t.add(1000);
	    
	    ArrayList<Integer> u = new ArrayList<>(t);
	    String error = 
	        String.format("lab0.sort2(t) failed for t = %s", u.toString());
	    lab0.sort2(u);
	    assertEquals(error, t, u);
	    
	    u.clear();
	    u.add(t.get(1));
	    u.add(t.get(0));
	    error = 
	        String.format("lab0.sort2(t) failed for t = %s", u.toString());
	    lab0.sort2(u);
	    assertEquals(error, t, u);
	  }
	  
	  @SuppressWarnings("unchecked")
	  @Test
	  public void test10b_toRadians() {
	    ////rng.setSeed(20);
	    ArrayList<Double> deg = new ArrayList<>();
	    ArrayList<Double> degCopy = new ArrayList<>();
	    ArrayList<Double> rad = new ArrayList<>();
	    
	    String error = 
	        String.format("lab0.toRadians(t) failed for t = %s", deg.toString());
	    lab0.toRadians(degCopy);
	    assertEquals(error, rad, degCopy);

	    for (int i = 0; i < 100; i++) {
	      double angDeg = 2880 - 1440;
	      double angRad = Math.toRadians(angDeg);
	      deg.add(angDeg);
	      degCopy = (ArrayList<Double>) deg.clone();
	      rad.add(angRad);
	      error = 
	          String.format("lab0.toRadians(t) failed for t = %s", deg.toString());
	      lab0.toRadians(degCopy);
	      assertEquals(error, rad, degCopy);
	    }
	  }

	  
	  @Test
	  public void test16_toString() {
	    
	    for (int i = 0; i < 10; i++) {
	      double min = (100 - 0.5) * 1000;
	      double max = min + 100 * 1000;
	      Range r = new Range(min, max);
	      String error = 
	          String.format("lab0.toString(r) failed for r = %s", r.toString());
	      String exp = r.toString();
	      exp = exp.replace('[', '(');
	      exp = exp.replace(']', ')');
	      assertEquals(error, exp, lab0.toString(r));
	    }
	  }
	  
	  @Test
	  public void test25_q14() 
	  {
		  List<Character> aList = Arrays.asList('h', 'o', 'r', 's', 'e', '.');
	      aList = lab0.shuffle(aList);
	      List<Character> bList = Arrays.asList('h', 's', 'o', 'e', 'r', '.');
	      assertEquals(bList, aList);
	  }

	  
	  
}

