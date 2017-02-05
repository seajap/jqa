package icom.jessieray.jqa.yh.web.validators;

public enum CheckType {
	EMAIL, PHONE, MOBILE, INTEGER, INTEGER_NEGATIVE, INTEGER_POSITIVE, DOUBLE, DOUBLE_NEGATIVE, DOUBLE_POSITIVE, AGE, CODE, URL, IDCARD, JIGOU_CODE, StrisNull, MONEY, LENGTH(
			1, 10), DAY, DAYSTR, MONTHSTR, PayChanel, CARDID;

	private int min;
	private int max;

	public int getMin() {
		return min;
	}

	public void setMin(int min) {
		this.min = min;
	}

	public int getMax() {
		return max;
	}

	public void setMax(int max) {
		this.max = max;
	}

	private CheckType() {
	}

	CheckType(int min, int max) {
		this.min = min;
		this.max = max;
	}

}
