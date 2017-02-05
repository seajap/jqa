package icom.jessieray.jqa.yh.web.utils;


import org.springframework.stereotype.Component;

import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

/**
 * 缓存手机验证码
 */
@Component
public class SessionCache {
	private static final CacheManager cacheManager = new CacheManager();
	
	public SessionCache() {
	}

	private Ehcache getCache() {
	    return cacheManager.getEhcache("sessionCache");
	}
	
	 public Object getAttr(String key) {
		 Element elem = getCache().get(key);
		 return elem != null ? elem.getValue() : null;
	}

	public void setAttr(String key,Object value){
		Element element = new Element(key, value);
		getCache().put(element);
	}
	
	public void removeAttr(String key){
		getCache().remove(key);
	}
}
