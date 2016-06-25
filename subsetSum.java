import java.util.ArrayList;
public class subsetSum {
	
	private int[]seq;
	private int target;
	private ArrayList<Integer> subset= new ArrayList<Integer>();
	
	public subsetSum(int[] seq, int target)
	{
		this.seq = seq;
		this.target = target;
	}
	
	private void getSubset(int start, int sum,ArrayList<Integer> set)
	{
		if (start >= seq.length)
		{
			return;
		}
		sum = sum + seq[start];
		set.add(seq[start]);
		if (sum == target)
		{
			StringBuilder S = new StringBuilder();
			for (int i = 0;i<set.size();i++)
				S.append(String.format("%d\t",set.get(i)));
			System.out.println(S);
			set.remove(set.size()-1); // remove the added element from the set
			return;
		}
		else if (sum > target)
			{
				set.remove(set.size()-1); // remove the added element from the set
				return; // no need to go further this path
			}
			
		else
		{
			
			for (int j = start+1; j< seq.length;j++)
			{
				getSubset(j,sum,set);				
			}
			set.remove(set.size()-1); // remove the added element from the set
			return;	
		}
	}
	
	public void getSumSet()
	{
		for (int i = 0;i<seq.length;i++)
			getSubset(i,0,subset);
	}
	
	public static void main(String[] args)
	{
		int weights[] = {10, 7, 5, 18, 12, 20, 15};
		subsetSum S = new subsetSum(weights,35);
		S.getSumSet();
	}

}
