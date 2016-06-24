
public class AllPermutations {
	
	char[] I;
	
	public AllPermutations(String I)
	{
		this.I = I.toCharArray();
	}
	
	private void swap(char[]temp,int i,int j)
	{
		char ctemp;
		ctemp = temp[i];
		temp[i] = temp[j];
		temp[j] = ctemp;	
	}
	
	private int permutations(char[] temp,int i)
	{
		if (i == I.length-1)
			{
				for(int j = 0;j<temp.length;j++)
					System.out.print(temp[j]);
				System.out.println();
				return 1;
			}
		else
		{
			int perms = 0;
			for (int j = i;j<I.length;j++)
			{
				swap(temp,i,j);		
				perms += permutations(temp,i+1);
				swap(temp,i,j); // undo the above changes, to get back to the original arrangement.
			}
			return perms;
		}
	}
	
	public int getPermutations()
	{
		return permutations(I,0);
	}
	
	public static void main(String[] args)
	{
		String I = "ABC";
		AllPermutations X = new AllPermutations(I);
		System.out.println(X.getPermutations());
	}

}
