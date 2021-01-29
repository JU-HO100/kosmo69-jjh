package design.di;

public class MyCalcLogic {
	public double account(String oper, String first, String second) {
		double result = 0.0;
		double dfirst = Double.parseDouble(first);
		double dsecond = Double.parseDouble(second);
		if("+".equals(oper)) {
			result = dfirst+dsecond;
		}
		else if("-".equals(oper)) {
			result = dfirst-dsecond;
		}
		else if("*".equals(oper)) {
			result = dfirst*dsecond;
		}
		else if("/".equals(oper)) {
			result = dfirst/dsecond;
		}
		return result;
	}
}
