package com.livtech.demo.matrix;

public class DigitalClocK {

	public static void main(String[] args) {

		final int[][] lcd_segment =
		    {
		        { 1, 1, 1, 0, 1, 0, 0, 1, 0, 1, 1, 1 }, // 0
		        { 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0 }, // 1
		        { 1, 1, 0, 0, 1, 1, 1, 1, 0, 0, 1, 1 }, // 2
		        { 1, 1, 0, 0, 1, 1, 1, 0, 0, 1, 1, 1 }, // 3
		        { 0, 0, 1, 0, 1, 1, 1, 0, 0, 1, 0, 0 }, // 4
		        { 1, 1, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1 }, // 5
		        { 1, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 1 }, // 6
		        { 1, 1, 0, 0, 1, 0, 0, 0, 0, 1, 0, 0 }, // 7
		        { 1, 1, 1, 0, 1, 1, 1, 1, 0, 1, 1, 1 }, // 8
		        { 1, 1, 1, 0, 1, 1, 1, 0, 0, 1, 1, 1 }, // 9
		    };

		    final char[] segment_c = "--|||--|||--".toCharArray();
		    final char[] segment_x = { 1, 3, 0, 2, 4, 1, 3, 0, 2, 4, 1, 3 };
		    final char[] segment_y = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 3, 4, 4 };

		    char[][] display =new char[5][5];

		    for (int digit = 0; digit < 10; digit++)
		    {
		    	 for (int y = 0; y < 5; y++)
			        {
			            for (int x = 0; x < 5; x++)
			                display[y][x]=' ';
			           
			        }
		    	
		        for (int segnum = 0; segnum < 12; segnum++)
		        {
		            if (lcd_segment[digit][segnum] == 1)
		            {
		                int x = segment_x[segnum];
		                int y = segment_y[segnum];
		                display[y][x] = segment_c[segnum];
		            }
		        }
		        for (int y = 0; y < 5; y++)
		        {
		            for (int x = 0; x < 5; x++)
		                System.out.print(display[y][x]);
		            System.out.print("\n");
		        }
		    }
	}

}
