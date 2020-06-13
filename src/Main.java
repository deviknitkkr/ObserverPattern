import java.util.*;

public class Main
{
	public static void main(String[] args)
	{
		Scanner sc=new Scanner(System.in);
		 MyDataType mMyDataType=new MyDataType("vikas");
		 mMyDataType.setOnChangeListener(new MyDataType.OnChangeListener(){

				@Override
				public void onChange(String str)
				{
					System.out.println("data changed to:"+str);
				}
			});
		
		for(int i=0;i<10;i++)
		{
			System.out.print("enter new data:");
			mMyDataType.setData(sc.nextLine());
		}
	}
}

class MyDataType
{
	String s;
	public MyDataType(String str){
		s=str;
	}
	
	interface OnChangeListener
	{
		public void onChange(String str);
	}
	
	OnChangeListener mOnChangeListener=null;
	
	public void setOnChangeListener(OnChangeListener mOnChangeListener)
	{
		this.mOnChangeListener=mOnChangeListener;
	}
	
	public void setData(String s)
	{
		if(!this.s.equals(s))
		{
			this.s=s;
			mOnChangeListener.onChange(s);
		}	
	}
}
