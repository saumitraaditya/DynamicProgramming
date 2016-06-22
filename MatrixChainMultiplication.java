
public class MCM {
	
	int[] I;
	int size;
	public MCM(int[] I,int size)
	{
		this.I = I;
		this.size = size;
	}
	
	private int calcOperations(int[] seq,int size)
	{
		if (size <= 3)
			return seq[0]*seq[1]*seq[2];
		else
		{
			//select one of the triplet, process it--
			// each ordered triplet represents multiplication
			// of two matrices.
			int min = Integer.MAX_VALUE;
			int operations = 0;
			for (int i = 0;i< size-2;i++)
			{
				operations = seq[i]*seq[i+1]*seq[i+2];
				// Process seq as input for next recursion
				// Since this multiplication is carried out
				// sequence must be modified to account for the 
				// product.
				int[] result = new int[size-1];
				// copy elements from original seq
				for (int j = 0,k =0;j<size-1 && k<size;j++,k++)
				{
					if (j <=i)
						result[j] = seq[k];
					else
					{
						if (j == i+1)
							{
								k++; // don't copy this one
							}
						result[j] = seq[k];
					}
				}
				operations += calcOperations(result,size-1);
				if (operations < min)
					min = operations;
			}
			return min;
		}
	}
	
	public int MinOperations()
	{
		return calcOperations(this.I,this.size);
	}
	
	public static void main(String[] args)
	{
		int[] I = {40, 20, 30, 10, 30};
		MCM M = new MCM(I,5);
		System.out.println(M.MinOperations());
	}
}
