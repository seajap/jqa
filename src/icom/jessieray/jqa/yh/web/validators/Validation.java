package icom.jessieray.jqa.yh.web.validators;

import java.util.HashMap;
import java.util.Map;

import icom.jessieray.jqa.yh.web.utils.CodeMsg;

public class Validation {

	private boolean flag = true;
	
	private Map<String,Object[]> map = new HashMap<>();
	
	private Map<String,String> errors = new HashMap<>();
	
	private CodeMsg codeMsg = new CodeMsg();
	
	private String code;
	
	private String msg;
	
	public String getCode() {
		return code;
	}

	public String getMsg() {
		return msg;
	}

	public boolean flag(){
		return flag;
	}
	
	public Map<String,String> errors(){
		return errors;
	}
	
	public Validation ValidationAdd(String paramCode,String paramValue, CheckType checkMethod){
		map.put(paramCode, new Object[]{paramValue,checkMethod});
		return this;
	}
	
	public Validation validator(){
		for(Map.Entry<String, Object[]> entry : map.entrySet()){
			String key = entry.getKey();
			Object os[] = entry.getValue();
			if(!validator(key, os[0]+"", (CheckType)os[1]))
				break;
		}
		return this;
	}
	
	private boolean validator(String paramCode, String paramVal, CheckType checkMethod){
		switch (checkMethod) {
		case StrisNull:
			if(RegexUtil.StrisNull(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case MOBILE:
			if(!RegexUtil.isMobile(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case EMAIL:
			if(!RegexUtil.isEmail(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case MONEY:
			if(!RegexUtil.isMoney(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case INTEGER_NEGATIVE:
			if(!RegexUtil.isINTEGER_NEGATIVE(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case LENGTH:
			if(!RegexUtil.isLength(paramVal, CheckType.LENGTH.getMin(), CheckType.LENGTH.getMax())){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case DAYSTR:
			if(!RegexUtil.isDayStr(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case MONTHSTR:
			if(!RegexUtil.isMonthStr(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case PayChanel:
			if(!RegexUtil.isPayChanel(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		case CARDID:
			if(!RegexUtil.isCardId(paramVal)){
				this.code = paramCode;
				this.msg = codeMsg.getProperty(paramCode);
				errors.put("code", this.code);
				errors.put("msg", this.msg);
				flag = false;
			}
			break;
		default:
			break;
		}
		return flag;
	}
	
}

